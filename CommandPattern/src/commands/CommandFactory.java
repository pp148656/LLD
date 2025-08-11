package commands;

import data.IStoreImpl;
import data.MatchType;
import reciever.PartialMatchDeleter;
import reciever.PerfectMatchDeleter;
import reciever.TagInserter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandFactory {
    private static final TagInserter tagInserter = new TagInserter();
    private static final PerfectMatchDeleter perfectMatchDeleter = new PerfectMatchDeleter(new IStoreImpl());

    public static Command getInsertTagCommand(String name) {
        return new InsertTagCommand(name, tagInserter, perfectMatchDeleter);
    }

    public static Command getPerfectMatchDeleteCmd(String name) {
        return new PerfectMatchDeleteCommand( perfectMatchDeleter, name,tagInserter);
    }

    public static Command getPartialMatchDeleteCmd(Pattern pattern) {
        return new PartialMatchDeleteCommand(pattern.toString(),new PartialMatchDeleter(pattern));
    }
}

