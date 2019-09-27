package algorithm_logic;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
								
				Combination original_structure = new Combination();
				original_structure.init_values();
				
				Combination first_subgroup = original_structure.create_new_combination(0.5);
				
				Combination second_subgroup = original_structure.create_new_combination(0.5);
				first_subgroup.try_combinations(0.50);
				second_subgroup.try_combinations(0.50);
				first_subgroup.print_structure();
				second_subgroup.print_structure();
				
			

	}
}