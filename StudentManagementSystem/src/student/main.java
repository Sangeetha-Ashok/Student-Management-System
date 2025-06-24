package student;
import java.util.*;
public class main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.print("Age: ");
                        int age = scanner.nextInt();
                        System.out.print("Course: ");
                        scanner.nextLine();
                        String course = scanner.nextLine();
                        dao.addStudent(new Student(name, age, course));
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        System.out.print("Student ID to update: ");
                        int idToUpdate = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("New Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("New Age: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("New Course: ");
                        String newCourse = scanner.nextLine();
                        dao.updateStudent(new Student(idToUpdate, newName, newAge, newCourse));
                        System.out.println("Student updated successfully.");
                        break;
                    case 3:
                        System.out.print("Student ID to delete: ");
                        int idToDelete = scanner.nextInt();
                        dao.deleteStudent(idToDelete);
                        System.out.println("Student deleted successfully.");
                        break;
                    case 4:
                        List<Student> students = dao.getAllStudents();
                        System.out.println("\n--- Student List ---");
                        for (Student s : students) {
                            System.out.println(s.getId() + ". " + s.getName() + " | " + s.getAge() + " | " + s.getCourse());
                        }
                        break;
                    case 5:
                        System.out.print("Enter Student ID: ");
                        int searchId = scanner.nextInt();
                        Student s = dao.getStudentById(searchId);
                        if (s != null) {
                            System.out.println("Found: " + s.getName() + " | " + s.getAge() + " | " + s.getCourse());
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
