import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    String getStatus() {
        return marks >= 40 ? "Pass" : "Fail";
    }
}

public class StudentManager {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Grade Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter marks: ");
        double marks = scanner.nextDouble();

        students.add(new Student(name, marks));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }

        System.out.printf("%-15s %-10s %-10s\n", "Name", "Marks", "Status");
        for (Student s : students) {
            System.out.printf("%-15s %-10.2f %-10s\n", s.name, s.marks, s.getStatus());
        }
    }
}
