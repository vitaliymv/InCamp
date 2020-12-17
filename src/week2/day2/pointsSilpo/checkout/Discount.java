package week2.day2.pointsSilpo.checkout;

public class Discount extends Offer {

    Product product;
    final int disc;

    public Discount(Product product, int disc) {
        this.disc = disc;
        this.product = product;
    }

    @Override
    public void apply(Check check) {

    }
}
