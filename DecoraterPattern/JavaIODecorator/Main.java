//Decorator Pattern
import java.io.*;
//here the InputStream is base class- BufferedInputStream is pre-existing decorater, FileInputStream -CONCRETE InputStream Class.
//we create a new decorator class  LowerCaseInputStream!
public class TestInput{
    //mandatory exception catching
    public void readFileFromLowerCaseReader() {
        //Why BufferedInputStream- bcoz its faster
           int c;
         try {
             InputStream istream =new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
             while((c = istream.read()) >= 0) {
                 System.out.print((char)c);
             }
             istream.close();
         }
         catch(FileNotFoundException e){
             System.out.println("filenotfound");
             System.out.println("Working Directory = " + System.getProperty("user.dir"));
         }
         catch(IOException e){
             System.out.println("ioexception");
         }

    }
}
void main()  {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    TestInput testInput=new TestInput();
    testInput.readFileFromLowerCaseReader();

}

public class LowerCaseInputStream extends FilterInputStream{

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }
    public int read() throws IOException{
        int c=super.read();
        //System.out.println("reading 1 byte");
        return (c==-1)?c:Character.toLowerCase((char)c);
    }
    public int read(byte[] b, int offset, int len) throws IOException{
        int result=super.read(b,offset,len);
        for(int i=offset;i<offset+result;i++){
            //because its byte and shorter dont try to typecast it to int
            //we should type caste it as an int or byte right
            b[i]=(byte) Character.toLowerCase((char)b[i]);
        }
        return result;
    }
}
