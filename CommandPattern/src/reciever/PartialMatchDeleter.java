package reciever;

import data.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PartialMatchDeleter {
    private final Pattern regex;
    public PartialMatchDeleter(Pattern regex) {
        this.regex = regex;
    }
    public void delete(Pattern name){
        List<String> tags = new ArrayList<>();
        Store.getTags().forEach(tag -> tags.add(tag));
        for(String tag: tags){
            if(regex.matcher(tag).find()){
                Store.delete(tag);
            }
        }
    }
}
