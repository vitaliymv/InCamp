package week2.day2.pointsSilpo.checkout;

public class AnyGoodsOffer extends Offer {
    public final int totalCost;
    public final int points;

    public AnyGoodsOffer(int totalCost, int points) {
        this.totalCost = totalCost;
        this.points = points;
    }

    @Override
    public void apply(Check check) {
        AnyGoodsOffer agOffer = new AnyGoodsOffer(totalCost, points);
        if (agOffer.totalCost <= check.getTotalCost())
            check.addPoints(agOffer.points);
    }
}
