package week2.day2.pointsSilpo.test;

import org.junit.jupiter.api.Test;
import week2.day2.pointsSilpo.checkout.Check;
import week2.day2.pointsSilpo.checkout.CheckoutService;
import week2.day2.pointsSilpo.checkout.Product;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;



public class CheckoutServiceTest {

    @Test
    void closeCheck__withOneProduct() {
        CheckoutService checkoutService = new CheckoutService();
        checkoutService.openCheck();

        checkoutService.addProduct(new Product(7, "Milk"));
        Check check = checkoutService.closeCheck();

        assertThat(check.getTotalCost(), is(7));
    }

    @Test
    void closeCheck__withTwoProducts() {
        CheckoutService checkoutService = new CheckoutService();
        checkoutService.openCheck();

        checkoutService.addProduct(new Product(7, "Milk"));
        checkoutService.addProduct(new Product(3, "Bred"));
        Check check = checkoutService.closeCheck();

        assertThat(check.getTotalCost(), is(10));
    }

}
