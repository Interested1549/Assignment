import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

    private ArrayList<Student> studentList;
    private Scanner scanner;

    // Constructor
    public StudentController() {
        studentList = new ArrayList<Student>();
        scanner = new Scanner(System.in);
    }

    // Read a number safely
    private double readNumber(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please try again.");
            }
        }
    }

    // Read a GPA between 0.0 and 4.0
    private double readGpa() {
        while (true) {
            double gpa = readNumber("Enter GPA (0.0 - 4.0): ");

            if (gpa >= 0.0 && gpa <= 4.0) {
                return gpa;
            }

            System.out.println("GPA must be between 0.0 and 4.0!");
        }
    }

    // Find a student by ID
    private Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }

    // 1. Add a student
    public void addStudent() {
        System.out.println("\n--- ADD NEW STUDENT ---");

        System.out.print("Enter student ID: ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("Student ID cannot be empty!");
            return;
        }

        if (findStudentById(id) != null) {
            System.out.println("This student ID already exists!");
            return;
        }

        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine().trim();

        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine().trim();

        double gpa = readGpa();

        Student student = new Student(
                id, fullName, email, phone, gpa
        );

        studentList.add(student);

        System.out.println("Student added successfully!");
    }

    // 2. Display all students
    public void printStudentList() {
        System.out.println("\n--- STUDENT LIST ---");

        if (studentList.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.printf("%-12s %-25s %-25s %-15s %s%n",
                "ID", "Full Name", "Email", "Phone", "GPA");

        for (Student student : studentList) {
            student.displayData();
        }
    }

    // 3. Search students by name
    public void searchStudentByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        boolean found = false;

        for (Student student : studentList) {
            if (student.getFullName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                if (!found) {
                    System.out.printf("%-12s %-25s %-25s %-15s %s%n",
                            "ID", "Full Name", "Email", "Phone", "GPA");
                }

                student.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching student found.");
        }
    }

    // 4. Update GPA by student ID
    public void updateStudentGpa() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine().trim();

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Current GPA: " + student.getGpa());

        double newGpa = readGpa();

        student.setGpa(newGpa);

        System.out.println("GPA updated successfully!");
    }

    // 5. Delete a student by ID
    public void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine().trim();

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        studentList.remove(student);

        System.out.println("Student deleted successfully!");
    }

    // 6. Sort students by GPA, highest first
    public void sortStudentsByGpaDescending() {
        for (int i = 0; i < studentList.size() - 1; i++) {

            for (int j = i + 1; j < studentList.size(); j++) {

                if (studentList.get(i).getGpa()
                        < studentList.get(j).getGpa()) {

                    Student temp = studentList.get(i);

                    studentList.set(i, studentList.get(j));

                    studentList.set(j, temp);
                }
            }
        }

        System.out.println("Students sorted by GPA (descending).");

        printStudentList();
    }

    // Close the scanner when the program ends
    public void close() {
        scanner.close();
    }
}