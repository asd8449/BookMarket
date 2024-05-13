package bookmarket.model;

public class CartItem {
    private int quantity;
    private Book book;

    public CartItem(Book book) {
        this.book = book;
        this.quantity = 1;
    }
    public int getQuantity() {
        return quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
    @Override
    public String toString() {
        return getBook() + ", " + book.getTitle() + ", " + quantity + "권";
    }
}
