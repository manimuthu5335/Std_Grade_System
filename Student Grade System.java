import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private String grade;
    private int age;


    public Student(int id, String name, String grade , int age) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.age = age;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
    
    public int getAge() {
        return age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

public class StudentGradeSystem {
    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public void createStudent(String name, String grade , int age) {
        students.add(new Student(nextId, name, grade,age));
        nextId++;
    }

    public Student readStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void updateGrade(int id, String newGrade) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setGrade(newGrade);
                return;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Grade: " + student.getGrade()+ ", Age: " + student.getAge());
        }
    }

    public static void main(String[] args) {
        StudentGradeSystem gradeSystem = new StudentGradeSystem();
        Scanner scanner = new Scanner(System.in);

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("\n1. Add Student\n2. Update Grade\n3. Delete Student\n4. View All Students\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    
                    System.out.print("Enter student Age: ");
                    int age = scanner.nextInt();
                    
                    gradeSystem.createStudent(name, grade, age);
                    System.out.println("Student added successfully!");
                    break;
                    
                case 2:
                    System.out.print("Enter student ID to update grade: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();
                    gradeSystem.updateGrade(id, newGrade);
                    System.out.println("Grade updated successfully!");
                    break;
                    
                case 3:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    gradeSystem.deleteStudent(deleteId);
                    System.out.println("Student deleted successfully!");
                    break;
                    
                case 4:
                    gradeSystem.displayAllStudents();
                    break;
                    
                case 5:
                    keepRunning = false;
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}