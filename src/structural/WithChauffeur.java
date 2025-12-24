package structural;

import core.Rentable;

public class WithChauffeur extends CarDecorator {
    public WithChauffeur(Rentable car) {
        super(car);
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " + Private Chauffeur";
    }

    @Override
    public double getCost() {
        return super.getCost() + 500;
    }
}
