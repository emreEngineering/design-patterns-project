package structural;

import core.Rentable;

public class WithChildSeat extends CarDecorator {
    public WithChildSeat(Rentable car) {
        super(car);
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " + Baby Seat";
    }

    @Override
    public double getCost() {
        return super.getCost() + 100;
    }
}
