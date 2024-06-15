package com.company;
class Vachnalay{
    private String[] books = new String[10];
    private int numberOfBooksInLibrary = 0;

    public void addBook(String bookName){
        books[++numberOfBooksInLibrary] = bookName;
        System.out.println(bookName+" book is added to Library.");
    }

    public boolean Available(String BookName){
        for (int i = 1; i <= numberOfBooksInLibrary; i++) {
            if(BookName.equals(books[i])) return true;
        }
        return false;
    }

    public void issueBooks(String BookName){
        boolean a = Available(BookName);
        if (a) {
            System.out.println(BookName+" is Issued");
        }
        else {
            System.out.println("Book is not Available");
        }
    }

    public void showAvailableBooks(){
        System.out.println("Availabe books in Library are:");
        for (int i = 1; i <= numberOfBooksInLibrary; i++) {
            System.out.println(books[i]);
        }
    }

}
public class Library {
    public static void main(String[] args) {
        Vachnalay kartik = new Vachnalay();
        kartik.addBook("Physics");
        kartik.addBook("Chemistry");
        kartik.addBook("Maths");
        kartik.showAvailableBooks();
        kartik.issueBooks("Maths");
    }
}