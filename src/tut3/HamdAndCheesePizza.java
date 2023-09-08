package tut3;


public class HamdAndCheesePizza extends Pizza {
    public HamdAndCheesePizza(String size, int cheeseToppings, int hamToppings) {
        super(size, cheeseToppings, 0, hamToppings);
        this.name = "HamANdCheesePizza";
    }

    public String getDescription() {
        return "HamAndCheesePizza is a pizza with ham and cheese toppings";
    }
}
