package tut2;

class PizzaDemo {
   public static void main(String[] args) {
        Pizza pizza1 = new Pizza("large", 1, 1, 2);
        Pizza pizza2 = new Pizza("medium", 2, 0, 1);
        Pizza pizza3 = new Pizza("small", 0, 3, 0);

        System.out.println("Pizza 1:\n" + pizza1.getDescription() + "\n");
        System.out.println("Pizza 2:\n" + pizza2.getDescription() + "\n");
        System.out.println("Pizza 3:\n" + pizza3.getDescription());
    }
}