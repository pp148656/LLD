package tag;

import commands.Command;

import java.util.List;
import java.util.Stack;


//Treat requests as objects
//To decouple the object that issues a request from the one that knows how to execute it eg. sender and reciever
//when u want to track down or log or implement undo on requests
public class TagManager {
    Stack<Command> previousCommands;
    public TagManager() {
        previousCommands = new Stack<>();
    }

    public void changeTags(Command command){
        command.execute();
        previousCommands.push(command);
    }
    public void undo(){
        Command command= previousCommands.peek();
        command.undo();
        previousCommands.pop();
    }
}
