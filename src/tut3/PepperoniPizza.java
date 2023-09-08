package tut3;

public class PepperoniPizza extends Pizza {
    public PepperoniPizza(String size, int cheeseToppings, int pepperoniToppings) {
        super(size, cheeseToppings, pepperoniToppings, 0);
        this.name = "PepperoniPizza";
    }

    public String getDescription() {
        return "PepperoniPizza is a pizza with pepperoni toppings";
    }
}
