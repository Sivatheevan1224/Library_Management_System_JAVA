package indivual__assignment_01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private final List<Book> books;
    private final List<Student> students;
    private static final String STUDENT_FILE = "Students.txt";

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

   
    public void addStudent(String name, int id) {
        Student student = new Student(name, id);
        students.add(student);
        writeStudentToFile(student);
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.borrow();
                System.out.println("\nYou have borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("\nBook not available or does not exist.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.returnBook();
                System.out.println("\nYou have returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("\nBook not borrowed or does not exist.");
    }

    public void displayAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void displayStudents() {
        System.out.println("\nRegistered Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void writeStudentToFile(Student student) {
        try (FileWriter writer = new FileWriter(STUDENT_FILE, true)) {
            writer.write(student.getName() + "," + student.getId() + "\n");
            System.out.println("\nStudent details written to file: " + STUDENT_FILE);
        } catch (IOException e) {
            System.err.println("Error writing student details to file: " + e.getMessage());
        }
    }
}
