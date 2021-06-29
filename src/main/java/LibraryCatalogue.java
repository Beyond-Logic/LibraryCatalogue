import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {

    Map<String,Book> bookCollection = new HashMap<>();
    int currentDay = 0;
    int lengthOfCheckedOutPeriod = 7;
    double initialLateFee = 0.50;
    double feePerLateDay = 1.00;

    public LibraryCatalogue(Map<String, Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    public LibraryCatalogue(Map<String, Book> bookCollection, int currentDay, int lengthOfCheckedOutPeriod, double initialLateFee, double feePerLateDay) {
        this.bookCollection = bookCollection;
        this.currentDay = currentDay;
        this.lengthOfCheckedOutPeriod = lengthOfCheckedOutPeriod;
        this.initialLateFee = initialLateFee;
        this.feePerLateDay = feePerLateDay;
    }

    //Getters
    public Map<String, Book> getBookCollection() {
        return bookCollection;
    }

    public Book getBook(String bookTitle) {
       return getBookCollection().get(bookTitle);
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public int getLengthOfCheckedOutPeriod() {
        return lengthOfCheckedOutPeriod;
    }

    public double getInitialLateFee() {
        return initialLateFee;
    }

    public double getFeePerLateDay() {
        return feePerLateDay;
    }

    //Setters
    public void setBookCollection(Map<String, Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    public void nextDay(){
        currentDay++;
    }
    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public void setLengthOfCheckedOutPeriod(int lengthOfCheckedOutPeriod) {
        this.lengthOfCheckedOutPeriod = lengthOfCheckedOutPeriod;
    }

    public void setInitialLateFee(double initialLateFee) {
        this.initialLateFee = initialLateFee;
    }

    //Instance Method
    public void setFeePerLateDay(double feePerLateDay) {
        this.feePerLateDay = feePerLateDay;
    }

    public void checkOutBook(String title){
            Book book = getBook(title);
            if(book.getIsCheckedOut()){
                sorryBookAlreadyCheckedOut(book);
            } else {
                book.setIsCheckedOut(true, currentDay);
                System.out.println("You just check out " + title  + ". it is due on day " + (getCurrentDay() +
                        getLengthOfCheckedOutPeriod()) + "." );
            }
    }

    public void returnBook (String title){
     Book book = getBook(title);
     int daysLate  = currentDay - (book.getDayCheckedOut() + getLengthOfCheckedOutPeriod());
     if(daysLate > 0) {
         System.out.println("You owe the library $" + (getInitialLateFee() + daysLate * getFeePerLateDay()) +
                 " because your book is " + daysLate + " days overdue;");
     } else {
         System.out.println("Book Returned. Thank You");

     }
     book.setIsCheckedOut(false, -1);
    }

    public void sorryBookAlreadyCheckedOut(Book book){
        System.out.println("Sorry, " + book.getTitle() + " is already checked out. " +
                "It should be back on day" +  (book.getDayCheckedOut() + getLengthOfCheckedOutPeriod()) +
                ".");
    }

    public static void main(String[] args) {

        Map<String, Book> bookCollection = new HashMap<String, Book>();
        Book harry = new Book("Harry Potter", 8680, 678);
        bookCollection.put("Harry Potter", harry);
        LibraryCatalogue libraryCatalogue = new LibraryCatalogue(bookCollection);
        libraryCatalogue.checkOutBook("Harry Potter");
        libraryCatalogue.nextDay();
        libraryCatalogue.nextDay();
        libraryCatalogue.checkOutBook("Harry Potter");
        libraryCatalogue.setCurrentDay(17);
        libraryCatalogue.returnBook("Harry Potter");
        libraryCatalogue.checkOutBook("Harry Potter");

    }
}
