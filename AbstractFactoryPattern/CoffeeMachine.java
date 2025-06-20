package AbstractFactoryPattern;

public class CoffeeMachine {
    private final IngredientFactory ingredientFactory;

    public CoffeeMachine(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    //our coffee machine and make coffee function just depends on the abstract factory and abstract products
    public String makeCoffee(){
        Bean bean= this.ingredientFactory.getBean();
        Milk milk = this.ingredientFactory.getMilk();
        Sugar sugar= this.ingredientFactory.getSugar();
        return "Coffee with " + bean.getType() + ", " + milk.getType() + ", and " + sugar.getType();
    }
}
