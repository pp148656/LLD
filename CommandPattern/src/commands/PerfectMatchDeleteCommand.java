package commands;

import reciever.PerfectMatchDeleter;
import reciever.TagInserter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectMatchDeleteCommand implements Command {
    private final List<String> deletedTags;
    private PerfectMatchDeleter deleter;
    private String name;
    private TagInserter inserter;
    public PerfectMatchDeleteCommand(PerfectMatchDeleter deleter, String name, TagInserter inserter) {
        this.deleter = deleter;
        this.inserter = inserter;
        this.deletedTags = new ArrayList<>();
        this.name= name;

    }
    public void execute() {
        List<String> tags= deleter.delete(name);
        this.deletedTags.addAll(tags);

    }
    public void undo() {
        for(String tag : deletedTags) {
            inserter.insert(tag);
        }
    }
}
