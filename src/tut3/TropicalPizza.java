package tut3;

public class TropicalPizza extends Pizza {
    public TropicalPizza(String size, int cheeseToppings, int pepperoniToppings, int hamToppings) {
        super(size, cheeseToppings, pepperoniToppings, hamToppings);
        this.name = "TropicalPizza";
    }

    public String getDescription() {
        return "TropicalPizza is a pizza with cheese, pepperoni and ham toppings";
    }
}
