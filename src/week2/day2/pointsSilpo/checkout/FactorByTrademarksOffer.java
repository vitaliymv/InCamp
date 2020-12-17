package week2.day2.pointsSilpo.checkout;

public class FactorByTrademarksOffer extends Offer {
    final Trademark trademark;
    final int factor;

    public FactorByTrademarksOffer(Trademark trademark, int factor) {
        this.trademark = trademark;
        this.factor = factor;
    }

    @Override
    public void apply(Check check) {
        FactorByTrademarksOffer trademarksOffer = new FactorByTrademarksOffer(trademark, factor);
        int points = check.getCostByTrademark(trademarksOffer.trademark);
        check.addPoints(points * (trademarksOffer.factor - 1));
    }
}
