public class User {
    //
    private final int id;
    private final String name;
    private final int age;
    private final String country;

    User(int id, String name, int age, String country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCountry() {
        return country;
    }

    public static class Builder {
        private int id;
        private String name;
        private int age;
        private String country;

       public Builder(int id , String name){
           this.id= id;
           this.name = name;
       }
       public Builder setAge(int age){
           this.age=age;
           return this;
       }
       public Builder setCountry(String country){
           this.country=country;
           return this;
       }
       public User build(){
           return new User(id, name, age, country);
       }

    }




}
