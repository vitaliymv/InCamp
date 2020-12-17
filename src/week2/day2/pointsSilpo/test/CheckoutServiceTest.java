package week2.day2.pointsSilpo.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week2.day2.pointsSilpo.checkout.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;



public class CheckoutServiceTest {

    private Product milk_7;
    private CheckoutService checkoutService;
    private Product bred_3;
    private Product chips_10;
    private Product chocolate_8;

    @BeforeEach
    void setUp() {
        checkoutService = new CheckoutService();
        checkoutService.openCheck();
        chips_10 = new Product(10, "chips", Category.CHIPS, Trademark.LAYS);
        chocolate_8 = new Product(8, "chocolate", Category.CHOCOLATE, Trademark.MILKA);
        milk_7 = new Product(7, "milk", Category.MILK);
        bred_3 = new Product(3, "bred", Category.BRED);
    }

    @Test
    void closeCheck__withOneProduct() {
        checkoutService.addProduct(milk_7);
        Check check = checkoutService.closeCheck();

        assertThat(check.getTotalCost(), is(7));
    }

    @Test
    void closeCheck__withTwoProducts() {
        checkoutService.addProduct(milk_7);
        checkoutService.addProduct(bred_3);
        Check check = checkoutService.closeCheck();

        assertThat(check.getTotalCost(), is(10));
    }

    @Test
    void addProduct__whenCheckIsClosed__opensNewCheck() {
        checkoutService.addProduct(milk_7);
        Check milkCheck = checkoutService.closeCheck();
        assertThat(milkCheck.getTotalCost(), is(7));

        checkoutService.addProduct(bred_3);
        Check bredCheck = checkoutService.closeCheck();
        assertThat(bredCheck.getTotalCost(), is(3));
    }

    @Test
    void closeCheck__calcTotalPoints() {
        checkoutService.addProduct(milk_7);
        checkoutService.addProduct(bred_3);
        Check check = checkoutService.closeCheck();

        assertThat(check.getTotalPoints(), is(10));
    }

    @Test
    void useOffer__addOfferPoints() {
        checkoutService.addProduct(milk_7);
        checkoutService.addProduct(bred_3);

        checkoutService.useOffer(new AnyGoodsOffer(6, 2));
        Check check = checkoutService.closeCheck();

        assertThat(check.getTotalPoints(), is(12));
    }

    @Test
    void useOffer__whenCostLessThanRequired__doNothing() {
        checkoutService.addProduct(bred_3);

        checkoutService.useOffer(new AnyGoodsOffer(6, 2));
        Check check = checkoutService.closeCheck();

        assertThat(check.getTotalPoints(), is(3));
    }

    @Test
    void useOffer__factorByCategory() {
        checkoutService.addProduct(milk_7);
        checkoutService.addProduct(milk_7);
        checkoutService.addProduct(bred_3);

        checkoutService.useOffer(new FactorByCategoryOffer(Category.MILK, 2));
        Check check = checkoutService.closeCheck();

        assertThat(check.getTotalPoints(), is(31));
    }

    @Test
    void useOffer__factorByCategory__whenCheckNotClosed() {
        checkoutService.addProduct(milk_7);
        checkoutService.addProduct(milk_7);
        checkoutService.useOffer(new FactorByCategoryOffer(Category.MILK, 2));
        Check check = checkoutService.closeCheck();
        assertThat(check.getTotalPoints(), is(28));
    }

    @Test
    void useOffer__factorByTwoCategory() {
        checkoutService.addProduct(milk_7);
        checkoutService.addProduct(milk_7);
        checkoutService.addProduct(bred_3);
        checkoutService.addProduct(bred_3);
        checkoutService.useOffer(new FactorByCategoryOffer(Category.BRED, 3));
        checkoutService.useOffer(new FactorByCategoryOffer(Category.MILK, 2));
        Check check = checkoutService.closeCheck();

        assertThat(check.getTotalPoints(), is(46));
    }

    @Test
    void userOffer__factorByTrademark() {
        checkoutService.addProduct(milk_7);
        checkoutService.addProduct(chips_10);
        checkoutService.addProduct(chocolate_8);

        checkoutService.useOffer(new FactorByTrademarksOffer(Trademark.LAYS, 2));
        checkoutService.useOffer(new FactorByTrademarksOffer(Trademark.MILKA, 5));
        Check check = checkoutService.closeCheck();
        assertThat(check.getTotalPoints(), is(67));
    }

    @Test
    void useOffer__factorByTrademarkWithCategory() {
        checkoutService.addProduct(chips_10);
        checkoutService.addProduct(chocolate_8);
        checkoutService.addProduct(bred_3);
        checkoutService.addProduct(bred_3);

        checkoutService.useOffer(new FactorByCategoryOffer(Category.BRED, 3));
        checkoutService.useOffer(new FactorByTrademarksOffer(Trademark.LAYS, 2));
        checkoutService.useOffer(new FactorByTrademarksOffer(Trademark.MILKA, 5));

        Check check = checkoutService.closeCheck();
        assertThat(check.getTotalPoints(), is(78));
    }

}
