// CREATIONAL PATTERN

// Defer the creation of the object to sub class
// Relies on inheritance and polymorphism

// Cannot override static methods in java

abstract class Plan {
    protected double rate;

    abstract void getRate();

    public void calculateBill(int units) {
        System.out.println(units * rate);
    }
}

class DomesticPlan extends Plan {
    @Override
    public void getRate() {
        rate = 3.50;
    }
}

class CommercialPlan extends Plan {
    @Override
    public void getRate() {
        rate = 7.50;
    }
}

// Sub class
class GetPlanFactory {
    public Plan getPlan(String planType) {
        if (planType == null) {
            return null;
        }

        if (planType.equalsIgnoreCase("DOMESTICPLAN")) {
            return new DomesticPlan();
        } else if (planType.equalsIgnoreCase("COMMERCIALPLAN")) {
            return new CommercialPlan();
        }

        return null;
    }
}

public class _1_factory {
    public static void main(String args[]) {
        GetPlanFactory planFactory = new GetPlanFactory();
        Plan p = planFactory.getPlan("DOMESTICPLAN");

        p.getRate();
        p.calculateBill(10);
    }

}