package algorithm_logic;

public class main {

	public static void main(String[] args) {												
			Combination original_structure = new Combination();
			original_structure.init_values();
			int total_tests=0;
			
			String final_answer =find_son(original_structure,0).brute_force();
			while(null==final_answer) {
				final_answer=find_son(original_structure,0).brute_force();
				
				total_tests++;
				}
			System.out.println(final_answer);
			
			System.out.println("\nTotal de pruebas fallidas: "+total_tests);
			
			

	}
	public static Combination find_son(Combination _father,int trys) {
		
		double initial_test_percentage = 0.5;
		double subsequent_tests_percentage = 0.3;
		if(_father.amount_is_satisfactory(8)||trys>20) {
			return _father;
		}
		
		
		Combination first_subgroup = _father.create_new_combination(initial_test_percentage);
		Combination second_subgroup = _father.create_new_combination(initial_test_percentage);
		first_subgroup.try_combinations(subsequent_tests_percentage);
		second_subgroup.try_combinations(subsequent_tests_percentage);
		
		if(first_subgroup.getSuccess_percentage()!=0&&first_subgroup.getSuccess_percentage()!=0) {
			return find_son(first_subgroup.obtain_common_elements(second_subgroup),0);
		}
		if(obtain_highest_success_rate(first_subgroup, second_subgroup).getSuccess_percentage()==0) {
			
			return find_son(_father,++trys);
		}
		else {
			return find_son(obtain_highest_success_rate(first_subgroup, second_subgroup),++trys);
			
		}
			
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