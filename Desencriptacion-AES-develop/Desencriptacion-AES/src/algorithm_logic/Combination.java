package pruebas;

import java.util.*;

public class Combination {

    private double success_percentage = 0.0d;
    private ArrayList<String> group_letters = new ArrayList<String>();
    private ArrayList<String> group_numbers = new ArrayList<String>();

    public Combination() {
    }

    //Carga los valores iniciales de numeros y letras
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

    public void fill_subgroup(int letter_amount, int number_amount, Combination original_structure, Combination current_structure) {
        Random random_index = new Random();
        for (int letter_index = 0; letter_index < letter_amount; letter_index++) {
            int rand_letter_index = random_index.nextInt(letter_amount);
            current_structure.group_letters.add(original_structure.group_letters.get(rand_letter_index));
        }
        for (int number_index = 0; number_index < number_amount; number_index++) {
            int rand_number_index = random_index.nextInt(number_amount);
            current_structure.group_numbers.add(original_structure.group_numbers.get(rand_number_index));
            //current_structure.group_numbers[number_index] = original_structure.group_numbers[rand_number_index];
        }
    }

    //Tantea posibles soluciones con un porcentaje de intentos, guarda la cantidad de aciertos??
    public void try_combinations(double _percentage) {
        final String txt_encrypted = "xZwM7BWIpSjYyGFr9rhpEa+cYVtACW7yQKmyN6OYSCv0ZEg9jWbc6lKzzCxRSSIvOvlimQZBMZOYnOwiA9yy3YU8zk4abFSItoW6Wj0ufQ0=";
        final String[] txt_key_incomplete = {"29dh120", "dk1", "3"};
        Random random_index = new Random();
        int trys = (int) (this.getGroup_letters().size() * _percentage);
        int hits = 0;
        while (trys > 0) {
            int letter_rand_index = random_index.nextInt(this.getGroup_letters().size() - 1);
            int numbers_rand_index = random_index.nextInt(this.getGroup_numbers().size() - 1);
            String posible_key = txt_key_incomplete[0] + this.getGroup_letters().get(letter_rand_index);
            posible_key += txt_key_incomplete[1] + this.getGroup_numbers().get(numbers_rand_index) + txt_key_incomplete[2];
            if (AES.decrypt(txt_encrypted, posible_key) != null) {
                hits++;
            }
            trys--;

        }
        this.success_percentage = hits;
    }
    public boolean validate_string(String _string){
        
        //for(int index =0 ;index<_string.length();index++)
          //  if(_string[0]<31)
          return false;
    }
    public String brute_force() {
        final String txt_encrypted = "xZwM7BWIpSjYyGFr9rhpEa+cYVtACW7yQKmyN6OYSCv0ZEg9jWbc6lKzzCxRSSIvOvlimQZBMZOYnOwiA9yy3YU8zk4abFSItoW6Wj0ufQ0=";
        final String[] txt_key_incomplete = {"29dh120", "dk1", "3"};
        int trys=0;
        for (String letter : this.group_letters) {
            for (String number : this.group_numbers) {
                trys++;
                String posible_key = txt_key_incomplete[0] + letter + txt_key_incomplete[1] + number + txt_key_incomplete[2];
                String decry = AES.decrypt(txt_encrypted, posible_key);
                System.out.println(letter+number);
                if (decry != null) {
                    System.out.println(trys);
                    return decry;
                }
            }
        }
        System.out.println(trys);
        return null;
    }

    //toma los valores de la combinacion actual(padre) y genera un hijo en base a este, 
    //_percentage es el porcionto de valores a tomar
    public Combination create_new_combination(double _percentage) {
        ArrayList<String> aux_group_letters = new ArrayList<>();
        ArrayList<String> aux_group_numbers = new ArrayList<>();
        int posicion = 0;
        double total = (this.getGroup_letters().size()) * _percentage;

        while (aux_group_letters.size() <= total) {
            posicion = (int) (Math.random() * this.getGroup_letters().size());
            aux_group_letters.add(this.getGroup_letters().get(posicion));
            this.getGroup_letters().remove(posicion);
        }
        total = (this.getGroup_numbers().size()) * _percentage;

        while (aux_group_numbers.size() <= total) {
            posicion = (int) (Math.random() * this.getGroup_numbers().size());
            aux_group_numbers.add(this.getGroup_numbers().get(posicion));
            this.getGroup_numbers().remove(posicion);
        }
        return new Combination(group_letters, group_numbers);
    }

    public void print_structure(Combination current_structure) {
        System.out.println(" ");
        for (int i = 0; i < current_structure.group_letters.size(); i++) {
            System.out.print(current_structure.group_letters.get(i));
        }
        System.out.print(" ");
        for (int i = 0; i < current_structure.group_numbers.size(); i++) {
            System.out.print(current_structure.group_numbers.get(i));
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
        this.group_letters = group_letters;
    }

    public ArrayList<String> getGroup_numbers() {
        return group_numbers;
    }

    public void setGroup_numbers(ArrayList<String> group_numbers) {
        this.group_numbers = group_numbers;
    }
}
