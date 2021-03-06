package week2.day2.pointsSilpo.checkout;

public class Product {

    final int price;
    final String name;
    Category category;
    Trademark trademark;

    public Product(int price, String name, Category category) {
        this.price = price;
        this.name = name;
        this.category = category;
    }

    public Product(int price, String name) {
        this(price, name, null);
    }

    public Product(int price, String name, Category category, Trademark trademark) {
        this.price = price;
        this.name = name;
        this.category = category;
        this.trademark = trademark;
    }
}
