public class Book {
    String title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut;
    int dayCheckedOut = -1;

    //Constructor
    public Book(String BookTitle, int bookPageCount, int ISBN) {
        this.title = BookTitle;
        this.pageCount = bookPageCount;
        this.ISBN = ISBN;
        isCheckedOut = false;
    }

    //Getters & Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public boolean getIsCheckedOut() {
        return this.isCheckedOut;
    }

    public void setIsCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut) {
        this.isCheckedOut = newIsCheckedOut;
        setDayCheckedOut(currentDayCheckedOut);
    }

    public int getDayCheckedOut() {
        return dayCheckedOut;
    }

    public void setDayCheckedOut(int day) {
        this.dayCheckedOut = day;
    }
}
