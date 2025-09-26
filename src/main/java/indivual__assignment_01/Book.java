
package indivual__assignment_01;

public class Book {
    private final String title;
    private final String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true; 
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isAvailable() {
        return available;
    }
    public void borrow() {
        this.available = false;
    }
    public void returnBook() {
        this.available = true;
    }
    @Override
    public String toString() {
        return title +  " by "  + author +  "\nAvailable: " + (available ? "Yes" : "No");
    }
}
