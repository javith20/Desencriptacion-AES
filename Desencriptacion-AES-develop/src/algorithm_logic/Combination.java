package algorithm_logic;

import java.util.*;
import java.util.stream.Collectors;

public class Combination {

    private double success_percentage = 0.0d;
    private ArrayList<String> group_letters = new ArrayList<String>();
    private ArrayList<String> group_numbers = new ArrayList<String>();
    private String missing_key ="";
    public Combination() {
    }
    
    public double calculate_success_percentage(int tries, int hits) {
    	int misses = tries-hits;
    	double percentage = hits-(hits*(misses/tries));
    	return percentage;
    }
    public boolean amount_is_satisfactory(int max_amount) {
    	if((this.getGroup_letters().size()+this.getGroup_numbers().size()) <= max_amount) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public Combination obtain_common_elements(Combination second_combination) {
    	Combination temp_subgroup = new Combination(this.getGroup_letters(), this.getGroup_numbers());
    	temp_subgroup.getGroup_letters().retainAll(second_combination.getGroup_letters());
    	temp_subgroup.getGroup_numbers().retainAll(second_combination.getGroup_numbers());
    	temp_subgroup.setGroup_letters((ArrayList<String>)group_letters.stream().distinct().collect(Collectors.toList()));
    	temp_subgroup.setGroup_numbers((ArrayList<String>)group_numbers.stream().distinct().collect(Collectors.toList()));
    	return temp_subgroup;
    }

    public void init_values() {
        char value = 97;
        while (value != 123) {
            group_letters.add(String.valueOf(value++));
        }
        value = 48;
        while (value != 58) {
            group_numbers.add(String.valueOf(value++));
        }
    }
    
    public Combination(ArrayList<String> _group_letters, ArrayList<String> _group_numbers) {
        this.group_letters = _group_letters;
        this.group_numbers = _group_numbers;
    }
    
    public void try_combinations(double _percentage) {
        final String txt_encrypted = "xZwM7BWIpSjYyGFr9rhpEa+cYVtACW7yQKmyN6OYSCv0ZEg9jWbc6lKzzCxRSSIvOvlimQZBMZOYnOwiA9yy3YU8zk4abFSItoW6Wj0ufQ0=";
        final String[] txt_key_incomplete = {"29dh120", "dk1", "3"};
        Random random_index = new Random();
        int trys = 0;
        int hits = 0;
        while (trys < (int) (this.getGroup_letters().size() * _percentage)) {
            int letter_rand_index = random_index.nextInt(this.getGroup_letters().size() - 1);
            int numbers_rand_index = random_index.nextInt(this.getGroup_numbers().size() - 1);
            String posible_key = txt_key_incomplete[0] + this.getGroup_letters().get(letter_rand_index);
            posible_key += txt_key_incomplete[1] + this.getGroup_numbers().get(numbers_rand_index) + txt_key_incomplete[2];
            if (AES.decrypt(txt_encrypted, posible_key) != null) {
                hits++;
            }
            trys++;

        }
       
        this.success_percentage = hits;
    }
    public boolean validate_string(String _string){
        
        for(int index =0 ;index<_string.length();index++) {
        	int letter =(int)_string.charAt(index);
        	 if(letter<32)
        		 return false;
        }
          
          return true;
    }
    public String brute_force() {
        final String txt_encrypted = "xZwM7BWIpSjYyGFr9rhpEa+cYVtACW7yQKmyN6OYSCv0ZEg9jWbc6lKzzCxRSSIvOvlimQZBMZOYnOwiA9yy3YU8zk4abFSItoW6Wj0ufQ0=";
        final String[] txt_key_incomplete = {"29dh120", "dk1", "3"};
        
        for (String letter : this.group_letters) {
            for (String number : this.group_numbers) {
                String posible_key = txt_key_incomplete[0] + letter + txt_key_incomplete[1] + number + txt_key_incomplete[2];
                String decry = AES.decrypt(txt_encrypted, posible_key);
                if (decry != null) {
                	if(validate_string(decry)) {
                		this.missing_key= letter+number;
                		return "\nRespuesta final: "+decry+"\nCaracteres faltantes: "+missing_key;
                	}
                }
            }
        }
       
        return null;
    }

    public Combination create_new_combination(double _percentage) {
        ArrayList<String> aux_group_letters = new ArrayList<>();
        ArrayList<String> aux_group_numbers = new ArrayList<>();
        int position = 0;
        Random random_index = new Random();
        double total = (this.getGroup_letters().size()) * _percentage;

        while (aux_group_letters.size() <= total) {
        	position = random_index.nextInt(this.getGroup_letters().size());
            aux_group_letters.add(this.getGroup_letters().get(position));
           
        }
        total = (this.getGroup_numbers().size()) * _percentage;

        while (aux_group_numbers.size() <= total) {
        	position = random_index.nextInt(this.getGroup_numbers().size());
            aux_group_numbers.add(this.getGroup_numbers().get(position));
            
        }
        
        return new Combination(aux_group_letters, aux_group_numbers);
    }

    public void print_structure( ) {
        System.out.println(" ");
        for (int index = 0; index < this.group_letters.size(); index++) {
            System.out.print(this.group_letters.get(index));
        }
        System.out.print(" ");
        for (int index = 0; index < this.group_numbers.size(); index++) {
            System.out.print(this.group_numbers.get(index));
        }

    }

    public double getSuccess_percentage() {
        return success_percentage;
    }

    public void setSuccess_percentage(double success_percentage) {
        this.success_percentage = success_percentage;
    }

    public ArrayList<String> getGroup_letters() {
        return group_letters;
    }

    public void setGroup_letters(ArrayList<String> group_letters) {
        this.group_letters =  group_letters;
    }

    public String getMissing_keys() {
        return this.missing_key;
    }

    
    public ArrayList<String> getGroup_numbers() {
        return group_numbers;
    }

    public void setGroup_numbers(ArrayList<String> group_numbers) {
        this.group_numbers = group_numbers;
    }
}
