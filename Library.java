import java.util.Scanner;

class CentralLibrary {
    private String[] books = new String[10];
    private int numberOfBooksInLibrary = 0;

    public void addBook(String bookName) {
        books[numberOfBooksInLibrary++] = bookName;
        System.out.println(bookName + " book is added to Library.");
    }

    public boolean isAvailable(String BookName) {
        for (int i = 0; i < numberOfBooksInLibrary; i++) {
            if (BookName.equals(books[i]))
                return true;
        }
        return false;
    }

    public void issueBook(String bookName) {
        boolean available = isAvailable(bookName);
        if (available) {
            System.out.println(bookName + " is Issued");
            // Remove the book from the list (simplified version)
            for (int i = 0; i < numberOfBooksInLibrary; i++) {
                if (books[i].equals(bookName)) {
                    books[i] = books[--numberOfBooksInLibrary];
                    books[numberOfBooksInLibrary] = null;
                    break;
                }
            }
        } else {
            System.out.println("Book is not Available");
        }
    }

    public void returnBook(String bookName) {
        if (numberOfBooksInLibrary < books.length) {
            books[numberOfBooksInLibrary++] = bookName;
            System.out.println(bookName + " has been returned.");
        } else {
            System.out.println("Library is full, cannot accept more books.");
        }
    }

    public void showAvailableBooks() {
        System.out.println("Availabe books in Library are:");
        for (int i = 0; i < numberOfBooksInLibrary; i++) {
            System.out.println(books[i]);
        }
    }

}

public class Library {
    public static void main(String[] args) {
        CentralLibrary manager = new CentralLibrary();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n1. Add Book");
            System.out.println("2. Show Available Books");
            System.out.println("3. I want a book");
            System.out.println("4. Want to return issued book");
            System.out.println("5. Exit");
            System.out.print("Enter Operation: ");
            int Operation = sc.nextByte();
            sc.nextLine();
            switch (Operation) {
                case 1:
                    System.out.print("Enter name of Book to be added: ");
                    String Bookname = sc.nextLine();
                    manager.addBook(Bookname);
                    break;
                case 2:
                    manager.showAvailableBooks();
                    break;
                case 3:
                    System.out.print("Enter name of book which you want: ");
                    String bookToIssue = sc.nextLine();
                    manager.issueBook(bookToIssue);
                    break;
                case 4:
                    System.out.print("Name of Book to return: ");
                    String bookToReturn = sc.nextLine();
                    manager.returnBook(bookToReturn);
                    break;
                case 5:
                    System.out.println("Exiting the Library.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}