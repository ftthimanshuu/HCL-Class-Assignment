import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee e = null;
		ArrayList<Employee> list = new ArrayList<>();
		HashMap<String, HashSet<Employee>> map = new HashMap<>();

		System.out.println("Welcome to Employee Management System");

		int choice;

		while (true) {
			System.out.println("Enter your choice:");
			System.out.println("1. Add Employee");
			System.out.println("2. Display all Employee");
			System.out.println("3. Display Project-Wise Employee");
			System.out.println("4. Display Unique Department");
			System.out.println("5. Display Java Department Employee");
			System.out.println("6. Search Employee");
			System.out.println("7. Exit");

			choice = sc.nextInt();

			switch (choice) {
				case 1:
					System.out.println("Enter employee ID");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter employee name");
					String name = sc.nextLine();
					System.out.println("Enter employee's department");
					String department = sc.nextLine();
					System.out.println("Enter project name");
					String project = sc.nextLine();
					e = new Employee(id, name, department, project);
					map.computeIfAbsent(e.projectName, k -> new HashSet<>()).add(e);
					System.out.println("Employee added successfully");
					list.add(e);
					break;

				case 2:
					for (Employee employee : list) {
						System.out.println("Employee ID:" + employee.employeeID);
						System.out.println("Employee Name:" + employee.employeeName);
						System.out.println("Employee Department:" + employee.department);
						System.out.println("Current Project:" + employee.projectName);
						System.out.println("");
					}
					break;

				case 3:

					for (Map.Entry<String, HashSet<Employee>> entry : map.entrySet()) {
						System.out.println("Project: " + entry.getKey());
						for (Employee emp : entry.getValue()) {
							System.out.println(emp.employeeName + " ");
						}
					}
					break;

				case 4:
					HashSet<String> set = new HashSet<>();
					for (Employee employee : list) {
						set.add(employee.department);
					}

					for (String dept : set) {
						System.out.println(dept);
					}
					break;

				case 5:
					for (Employee employee : list) {
						if ("java".equalsIgnoreCase(employee.department)) {
							System.out.println(employee.employeeName);
						}
					}
					break;

				case 6:
					System.out.println("Enter the Employee ID you want to search:");
					int employeeID = sc.nextInt();
					for (Employee employee : list) {
						if (employee.employeeID == employeeID) {
							System.out.println("Employee ID:" + employee.employeeID);
							System.out.println("Employee Name:" + employee.employeeName);
							System.out.println("Employee Department:" + employee.department);
							System.out.println("Current Project:" + employee.projectName);
						}
					}
					break;

				case 7:
					System.out.println("Thank You !!!");
					sc.close();
					;
					return;

				default:
					System.out.println("Invalid Input. Select any number between 1 to 7");
					break;

			}

		}

	}
}
