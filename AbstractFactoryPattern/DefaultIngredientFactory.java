package AbstractFactoryPattern;

public class DefaultIngredientFactory implements IngredientFactory {
    @Override
    public Milk getMilk(){
        return new CowMilk();
    }
    @Override
    public Bean getBean(){
        return new AmericanBean();
    }
    @Override
    public Sugar getSugar(){
        return new WhiteSugar();
    }
}
