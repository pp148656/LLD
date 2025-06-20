package AbstractFactoryPattern;

public class CowMilk implements Milk{
    @Override
    public String getType() {
        return "Cow Milk";
    }
}
