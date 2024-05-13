package bookmarket.model;

public class Book {


    public Book(int bookid, String title, String author, String publisher, int price) {
        this.bookId = bookid;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
//        this.inStock = inStock;
    }

    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private int price;
//    private int inStock;

    @Override
    public String toString(){
        return bookId + ", " + title + ", " + author + ", " + publisher + ", " + price + "원";
    }

    public int getBookid() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPrice() {
        return price;
    }

//    public int getInStock() {
//        return inStock;
//    }

    public Book(){}


}
