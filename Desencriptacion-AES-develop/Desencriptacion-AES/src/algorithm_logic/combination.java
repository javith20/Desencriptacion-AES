package algorithm_logic;
import java.util.*;

public class combination {
	double success_percentage = 0.0d;
    List<String> group_letters = new ArrayList<String>();
    List<String> group_numbers = new ArrayList<String>();

    public combination() {
    }

    public combination(List<String> _group_letters, List<String> _group_numbers) {
        this.group_letters = _group_letters;
        this.group_numbers = _group_numbers;
    }
    
    public void fill_subgroup(int letter_amount, int number_amount, combination original_structure, combination current_structure) {
    	Random random_index = new Random();
    	for(int letter_index=0; letter_index < letter_amount; letter_index++) {
    		int rand_letter_index = random_index.nextInt(letter_amount);
    		current_structure.group_letters.add(original_structure.group_letters.get(rand_letter_index));
    	} 
    	for(int number_index=0; number_index < number_amount; number_index++) {
    		int rand_number_index = random_index.nextInt(number_amount);
    		current_structure.group_numbers.add(original_structure.group_numbers.get(rand_number_index));
    		//current_structure.group_numbers[number_index] = original_structure.group_numbers[rand_number_index];
    	}
    }
    
    public void print_structure(combination current_structure) {
    	for(int i = 0; i < current_structure.group_letters.size(); i++) {
    		System.out.print(current_structure.group_letters.get(i)+"\t");
    	}
    	for(int i = 0; i < current_structure.group_numbers.size(); i++) {
    		System.out.print(current_structure.group_numbers.get(i)+"\t");
    	}
    }

    public double getSuccess_percentage() {
        return success_percentage;
    }

    public void setSuccess_percentage(double success_percentage) {
        this.success_percentage = success_percentage;
    }

    public List<String> getGroup_letters() {
        return group_letters;
    }

    public void setGroup_letters(List<String> group_letters) {
        this.group_letters = group_letters;
    }

    public List<String> getGroup_numbers() {
        return group_numbers;
    }

    public void setGroup_numbers(List<String> group_numbers) {
        this.group_numbers = group_numbers;
    }
}