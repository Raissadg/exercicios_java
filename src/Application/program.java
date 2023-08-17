package Application;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import Entities.employee;

public class program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		List<employee> list = new ArrayList<employee>();
		
		System.out.print("How many employees will be registered? ");
		int n = input.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ":");
			
			System.out.print("Id: ");
			int id = input.nextInt();
			input.nextLine();
			
			System.out.print("Name: ");
			String name = input.nextLine();
			
			System.out.print("Salary: ");
			double salary = input.nextDouble();
			
			list.add(new employee(name, id, salary));
		}
		
		System.out.print("Enter the employee id that will have salary incremeant: ");
		int id = input.nextInt();
		
		employee result = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if (result == null) {
			System.out.println("This id does not exist!");
		}
		
		else {
			System.out.print("Enter the percentage: ");
			double percentage = input.nextDouble();
			result.increaseSalary(percentage);
		}
		
		System.out.println("List of employees: ");
		for (employee emp : list) {
			System.out.print(emp.getId() + ", " + emp.getName() + ", " + emp.getSalary());
			System.out.println();
		}

		
		
		input.close();
	}

}
