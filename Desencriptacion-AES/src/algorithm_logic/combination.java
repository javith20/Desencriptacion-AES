package algorithm_logic;

public class combination {
	double success_percentage = 0.0d;
    char[] group_letters = {};
    char[] group_numbers = {};

    public combination() {
    }

    public combination(char[] _group_letters, char[] _group_numbers) {
        this.group_letters = _group_letters;
        this.group_numbers = _group_numbers;
    }

    public double getSuccess_percentage() {
        return success_percentage;
    }

    public void setSuccess_percentage(double success_percentage) {
        this.success_percentage = success_percentage;
    }

    public char[] getGroup_letters() {
        return group_letters;
    }

    public void setGroup_letters(char[] group_letters) {
        this.group_letters = group_letters;
    }

    public char[] getGroup_numbers() {
        return group_numbers;
    }

    public void setGroup_numbers(char[] group_numbers) {
        this.group_numbers = group_numbers;
    }
}
