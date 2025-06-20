public class main {
    //client side
    public static void main(String[] args) {
        User user = new User.Builder(1, "John Doe")
                .setAge(30)
                .setCountry("USA")
                .build();
        System.out.println("User ID: " + user.getId());
    }
}
