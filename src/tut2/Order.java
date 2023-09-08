package tut2;

public class Order {
    private Pizza[] pizzas;

    public Order() {
        pizzas = new Pizza[3];
    }

    public void setPizza1(Pizza pizza) {
        pizzas[0] = pizza;
    }

    public Pizza getPizza1() {
        return pizzas[0];
    }

    public void setPizza2(Pizza pizza) {
        pizzas[1] = pizza;
    }

    public Pizza getPizza2() {
        return pizzas[1];
    }

    public void setPizza3(Pizza pizza) {
        pizzas[2] = pizza;
    }

    public Pizza getPizza3() {
        return pizzas[2];
    }

    public String getOrderDescription() {
        StringBuilder orderDescription = new StringBuilder("Order:\n");
        for (int i = 0; i < pizzas.length; i++) {
            if (pizzas[i] != null) {
                orderDescription.append("Pizza ").append(i + 1).append(":\n").append(pizzas[i].getDescription()).append("\n\n");
            }
        }
        return orderDescription.toString();
    }

     public static void main(String[] args) {
          Pizza pizza1 = new Pizza("large", 1, 1, 2);
          Pizza pizza2 = new Pizza("medium", 2, 0, 1);
          Pizza pizza3 = new Pizza("small", 0, 3, 0);
  
          Order order = new Order();
          order.setPizza1(pizza1);
          order.setPizza2(pizza2);
          order.setPizza3(pizza3);
  
          System.out.println(order.getOrderDescription());
      }
}
