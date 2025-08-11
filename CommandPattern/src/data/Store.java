package data;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<String> tags;
    public static List<String> getTags() {
        return tags;
    }
    public Store(){
        tags = new ArrayList<>();
    }
    public static void insert(String tag){
        tags.add(tag);
    }

    public static void delete(String tag){
        tags.remove(tag);
    }

}
