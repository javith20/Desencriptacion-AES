import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import algorithm_logic.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> all_letters = new ArrayList<String>(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n",
																		"o","p","q","r","s","t","u","v","w","x","y","z"));
		List<String> all_numbers = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
		int letter_amount = all_letters.size();
		int number_amount = all_numbers.size();
		
		combination original_structure = new combination();
		original_structure.setGroup_letters(all_letters);
		original_structure.setGroup_numbers(all_numbers);
		
		combination first_subgroup = new combination();
		first_subgroup.fill_subgroup(letter_amount, number_amount, original_structure, first_subgroup);
		//first_subgroup.print_structure(first_subgroup);
		
		combination second_subgroup = new combination();
		second_subgroup.fill_subgroup(letter_amount, number_amount, original_structure, second_subgroup);
		//second_subgroup.print_structure(second_subgroup);	
	}
	
	public String generate_key() {
		int key_length = 13;
		//fill in correct positions based on key provided by the document on the case
		/*
		Random random_index = new Random();
    	int rand_letter_index = random_index.nextInt(letter_amount);
    	int rand_number_index = random_index.nextInt(number_amount);
		 */
		
		return null;
	}

}
