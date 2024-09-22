package model;

public class OrderDetail {

    private Orders order;
    private Book book;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(Orders order, Book book, int quantity) {
        this.order = order;
        this.book = book;
        this.quantity = quantity;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order=" + order +
                ", book=" + book +
                ", quantity=" + quantity +
                '}';
    }
}
