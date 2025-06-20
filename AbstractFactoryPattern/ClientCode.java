package AbstractFactoryPattern;

public class ClientCode {
    public static void main(String[] args) {
        // Create an instance of the OrganicFactory
        IngredientFactory healthyIngredientFactory = new HealthyIngredientFactory();
        // healthy or default?
       CoffeeMachine machine= new CoffeeMachine(healthyIngredientFactory);
       System.out.println(machine.makeCoffee());
    }
}
