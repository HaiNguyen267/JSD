package tut3;

public class Pizza implements Comparable<Pizza> {
    protected String size;

    protected String name;
    protected int cheeseToppings;
    protected int pepperoniToppings;
    protected int hamToppings;

    @Override
    public int compareTo(Pizza o) {
        return Double.compare(calculateCost(), o.calculateCost());
    }


    public static class Topping {
        private String name;
        private int cost;
        private int quantity;

        public Topping(String name, int cost, int quantity) {
            this.name = name;
            this.cost = cost;
            this.quantity = quantity;
        }

        public Topping() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int calCost() {
            return cost * quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getDescription() {
            return String.format("%d@%d - %s", quantity, cost, name);
        }
    }

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

