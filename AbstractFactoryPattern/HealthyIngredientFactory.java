package AbstractFactoryPattern;

public class HealthyIngredientFactory implements IngredientFactory {
    @Override
    public Milk getMilk() {
        return new AlmondMilk();
    }

    @Override
    public  Bean getBean() {
        return new OrganicBean();
    }
    @Override
    public Sugar getSugar() {
        return new BrownSugar();
    }
}
