package AbstractFactoryPattern;

public interface IngredientFactory {
    public Milk getMilk();
    public Bean getBean();
    public Sugar getSugar();
}
