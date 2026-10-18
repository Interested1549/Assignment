import java.util.Scanner;

public class MainThread {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentController controller = new StudentController();
        int choice = 0;
        while (choice != 7) {
            System.out.println("\n==================================================");
            System.out.println("        HỆ THỐNG QUẢN LÝ SINH VIÊN");
            System.out.println("==================================================");
            System.out.println("1. Add student");
            System.out.println("2. Show Student list");
            System.out.println("3. Find student by name");
            System.out.println("4. Update GPA via Student ID");
            System.out.println("5. Delete student via Student ID");
            System.out.println("6. Sort the student list via GPA");
            System.out.println("7. Exit the program");
            System.out.println("==================================================");
            System.out.print("Please choose a function (1-7): ");
            try {
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {

                    case 1:
                        controller.addStudent();
                        break;

                    case 2:
                        controller.printStudentList();
                        break;

                    case 3:
                        controller.searchStudentByName();
                        break;

                    case 4:
                        controller.updateStudentGpa();
                        break;

                    case 5:
                        controller.deleteStudent();
                        break;

                    case 6:
                        controller.sortStudentsByGpaDescending();
                        break;

                    case 7:
                        System.out.println(
                                "Thanks for using our program!"
                        );
                        break;

                    default:
                        System.err.println(
                                "Invalid choice, please choose a number from 1 to 7."
                        );
                }

            } catch (NumberFormatException e) {
                System.err.println(
                        "Error, please enter an integer from 1 to 7!"
                );
            }
        }
        controller.close();
        input.close();
    }
}
