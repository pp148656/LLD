package commands;

import reciever.PerfectMatchDeleter;
import reciever.TagInserter;

public class InsertTagCommand implements Command {

    private TagInserter tagInserter;
    private String tag;
    private PerfectMatchDeleter perfectMatchDeleter;
    public InsertTagCommand(String tag,TagInserter tagInserter, PerfectMatchDeleter perfectMatchDeleter) {
        this.tag = tag;
        this.tagInserter = tagInserter;
        this.perfectMatchDeleter = perfectMatchDeleter;
    }

    @Override
    public void execute(){
        //call reciever
        tagInserter.insert(tag);
    }
    @Override
    public void undo(){
        perfectMatchDeleter.delete(tag);
    }
}
