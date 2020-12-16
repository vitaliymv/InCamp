package week2.day2.pointsSilpo.checkout;

public class CheckoutService {

    private Check check;

    public void openCheck() {
        check = new Check();
    }

    public void addProduct(Product product) {
        if (check == null) {
            openCheck();
        }

        check.addProduct(product);
    }


    public Check closeCheck() {
        Check closedCheck = check;
        check = null;
        return closedCheck;
    }

}
