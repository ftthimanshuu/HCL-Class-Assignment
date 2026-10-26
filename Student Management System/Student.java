public class Student {
    private final String name;
    private final String rollNumber;
    private final String branch;
    private final String degree;

    public Student(String name, String rollNumber, String branch, String degree) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.branch = branch;
        this.degree = degree;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll number: " + rollNumber);
        System.out.println("Branch: " + branch);
        System.out.println("Degree: " + degree);
    }
}