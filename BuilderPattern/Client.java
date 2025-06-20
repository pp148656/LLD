package BuilderPattern;

public class Client {
    //client side
    public static void main(String[] args) {
        User user = new User.Builder(1, "John Doe")
                .setAge(30)
                .setCountry("USA")
                .build();
        System.out.println("BuilderPattern.User ID: " + user.getId());
    }
}
