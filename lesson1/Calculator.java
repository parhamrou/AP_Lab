import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

	System.out.println("Enter first number, operator and 2nd number");
	System.out.println("exp: 9 * 8");
	int num1 = input.nextInt();
	char op = input.next().charAt(0);
	int num2 = input.nextInt();
        int result;

        switch(op) {
	    case '+':
		result = num1 + num2;
		break;
	    case '-':
		result = num1 - num2;
		break;
	    case '*':
		result = num1 * num2;
		break;
	    case '/':
		result = num1 / num2;
		break;
	    default:
		System.out.println("Invalid input");
		return;
	}

	System.out.println("output = " + result);
    }
}
