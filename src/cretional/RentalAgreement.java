package cretional;

import core.Rentable;

// [3] BUILDER -> RentalAgreement
// Karmaşık bir kira sözleşmesini adım adım oluşturur.
public class RentalAgreement {
    private String customerName;
    private Rentable car;
    private int days;
    private boolean insuranceIncluded;

    // Gizli constructor, sadece Draft (Builder) erişir
    private RentalAgreement(Draft draft) {
        this.customerName = draft.customerName;
        this.car = draft.car;
        this.days = draft.days;
        this.insuranceIncluded = draft.insuranceIncluded;
    }

    public void print() {
        System.out.println("[Agreement] Sözleşme imzalandı " + customerName +
                ". Araç: " + car.getDetails() +
                " | Gün: " + days +
                " | Sigorta: " + (insuranceIncluded ? "Evet" : "Hayır"));
    }

    // Builder Sınıfı ("Draft" = Taslak olarak isimlendirdik)
    public static class Draft {
        private String customerName;
        private Rentable car;
        private int days;
        private boolean insuranceIncluded;

        public Draft(String customerName, Rentable car, int days) {
            this.customerName = customerName;
            this.car = car;
            this.days = days;
        }

        public Draft addFullCoverage() {
            this.insuranceIncluded = true;
            return this;
        }

        public RentalAgreement sign() {
            return new RentalAgreement(this);
        }
    }
}
