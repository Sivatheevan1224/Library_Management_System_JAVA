package indivual__assignment_01;
import java.util.Scanner;
public class LibraryMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagementSystem library = new LibraryManagementSystem();
        // Adding some initial books
        library.addBook("Java Programming", "John Doe");
        library.addBook("Python for Beginners", "Jane Smith");
        library.addBook("Data Structures and Algorithms", "Alan Turing");

        while (true) {
            System.out.println();
            System.out.println("\t\t  **********    **********     *********   ***    ***");
            System.out.println("\t\t  **********    **********     *********   ***    ***");
            System.out.println("\t\t  ***    ***    **********     *********   ***  ***");
            System.out.println("\t\t  **********    ***    ***     ***   ***   ******");
            System.out.println("\t\t  **********    ***    ***     ***   ***   *****");
            System.out.println("\t\t  ***    ***    ***    ***     ***   ***   ******");
            System.out.println("\t\t  **********    **********     *********   ***  ***");
            System.out.println("\t\t  **********    **********     *********   ***    ***");
            System.out.println("\t\t  **********    **********     *********   ***    ***");
            System.out.println("\t\t\t\tLibrary Management System");
            System.out.println("\t\t\t\t*************************");
            System.out.println("\nWELCOME TO OUR LIBRARY.");
            System.out.println("\nONCE YOU LEARN TO READ , YOU WILL BE FOREVER FREE.\n");
            System.out.println("1. Add Student");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Display Available Books");
            System.out.println("6. Display Registered Students");
            System.out.println("7. Exit");
            System.out.print("\nEnter your choice: ");

            int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }
            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student ID/Entrollment Number Last 3 Digit: ");
                   int studentId;
                    try {
                    studentId = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }
                    scanner.nextLine(); 
                    library.addStudent(studentName, studentId);
                    System.out.println("\nStudent added: " + studentName);
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String bookAuthor = scanner.nextLine();
                    library.addBook(bookTitle, bookAuthor);
                    System.out.println("\nBook added: " + bookTitle + " by " + bookAuthor);
                    break;
                case 3:
                    System.out.print("Enter the title of the book you want to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;
                case 4:
                    System.out.print("Enter the title of the book you want to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 5:
                    library.displayAvailableBooks();
                    break;
                case 6:
                    library.displayStudents();
                    break;
                case 7:
                    System.out.println("Exiting Library Management System. Goodbye!!!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
