package AbstractFactoryPattern;

public class OrganicBean implements Bean{
    @Override
    public String getType() {
        return "Organic Bean";
    }
}
