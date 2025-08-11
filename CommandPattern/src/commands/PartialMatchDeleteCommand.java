package commands;

import reciever.PartialMatchDeleter;

import java.util.List;
import java.util.regex.Pattern;

public class PartialMatchDeleteCommand implements Command {
    private Pattern name;
    private PartialMatchDeleter deleter;
    private List<String> deletedTags;
    PartialMatchDeleteCommand(String name, PartialMatchDeleter deleter) {
        this.name = Pattern.compile(name);
        this.deleter = deleter;
    }
    public void execute(){
        this.deleter.delete(name);
    }
    public void undo(){

    }
}
