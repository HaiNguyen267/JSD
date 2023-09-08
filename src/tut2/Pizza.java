package tut2;

public class Pizza {
    protected String size;
    protected int cheeseToppings;
    protected int pepperoniToppings;
    protected int hamToppings;

    public Pizza(String size, int cheeseToppings, int pepperoniToppings, int hamToppings) {
        this.size = size;
        this.cheeseToppings = cheeseToppings;
        this.pepperoniToppings = pepperoniToppings;
        this.hamToppings = hamToppings;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCheeseToppings() {
        return cheeseToppings;
    }

    public void setCheeseToppings(int cheeseToppings) {
        this.cheeseToppings = cheeseToppings;
    }

    public int getPepperoniToppings() {
        return pepperoniToppings;
    }

    public void setPepperoniToppings(int pepperoniToppings) {
        this.pepperoniToppings = pepperoniToppings;
    }

    public int getHamToppings() {
        return hamToppings;
    }

    public void setHamToppings(int hamToppings) {
        this.hamToppings = hamToppings;
    }

    public double calculateCost() {
        double baseCost;

        switch (size) {
            case "small":
                baseCost = 10;
                break;
            case "medium":
                baseCost = 12;
                break;
            case "large":
                baseCost = 14;
                break;
            default:
                throw new IllegalArgumentException("Invalid pizza size");
        }

        return baseCost + 2 * (cheeseToppings + pepperoniToppings + hamToppings);
    }

    public String getDescription() {
        return "Pizza size: " + size +
                "\nCheese toppings: " + cheeseToppings +
                "\nPepperoni toppings: " + pepperoniToppings +
                "\nHam toppings: " + hamToppings +
                "\nTotal cost: $" + calculateCost();
    }
}

