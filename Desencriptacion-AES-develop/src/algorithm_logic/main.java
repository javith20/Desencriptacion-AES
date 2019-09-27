package algorithm_logic;

public class main {

	public static void main(String[] args) {												
			Combination original_structure = new Combination();
			original_structure.init_values();
			Combination first_subgroup = original_structure.create_new_combination(0.5);
			Combination second_subgroup = original_structure.create_new_combination(0.5);
			first_subgroup.try_combinations(0.50);
			second_subgroup.try_combinations(0.50);
			first_subgroup.print_structure();
			second_subgroup.print_structure();
			
			System.out.println("\n"+obtain_highest_success_rate(first_subgroup, second_subgroup).getSuccess_percentage());
			

	}
	public static Combination obtain_highest_success_rate(Combination combination1, Combination combination2) {
		boolean first_is_higher = combination1.getSuccess_percentage()>=combination2.getSuccess_percentage();
		if(first_is_higher) {
			return combination1;
		}
		else {
			return combination2;
		}
	}
}