import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Enroll a student");
            System.out.println("2. Display student details");
            System.out.println("3. Display total number of students");
            System.out.println("4. Delete a student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Enter roll number: ");
                    String rollNumber = scanner.nextLine().trim();
                    System.out.print("Enter branch: ");
                    String branch = scanner.nextLine().trim();
                    System.out.print("Enter degree: ");
                    String degree = scanner.nextLine().trim();

                    boolean duplicate = false;
                    for (Student student : students) {
                        if (student.getRollNumber().equalsIgnoreCase(rollNumber)) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println("A student with that roll number already exists.");
                    } else {
                        students.add(new Student(name, rollNumber, branch, degree));
                        System.out.println("Student enrolled successfully.");
                    }
                    break;
                case "2":
                    System.out.print("Enter roll number: ");
                    rollNumber = scanner.nextLine().trim();
                    boolean found = false;
                    for (Student student : students) {
                        if (student.getRollNumber().equalsIgnoreCase(rollNumber)) {
                            student.displayDetails();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
                case "3":
                    System.out.println("Total students: " + students.size());
                    break;
                case "4":
                    System.out.print("Enter roll number: ");
                    rollNumber = scanner.nextLine().trim();
                    found = false;
                    for (Student student : students) {
                        if (student.getRollNumber().equalsIgnoreCase(rollNumber)) {
                            students.remove(student);
                            found = true;
                            break;
                        }
                    }
                    System.out.println(found ? "Student deleted successfully." : "Student not found.");
                    break;
                case "5":
                    System.out.println("Exiting Student Management System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose 1 to 5.");
            }
        }
    }
}