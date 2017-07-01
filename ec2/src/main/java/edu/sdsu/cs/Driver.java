package edu.sdsu.cs;
import edu.sdsu.cs.datastructures.SelfOrgList;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Tyler Brandt on 4/9/2017.
 */
public class Driver {
    public static void main(String[] args) throws IOException {

        String wf = args[0];
        File writeFile = new File(wf);
        PrintStream o = new PrintStream(writeFile);
        System.setOut(o);

        String[] names = {"Zero","One", "Two", "Three", "Four", "Five", "Six","Seven","Eight","Nine"};
        ArrayList<String> name = new ArrayList<String>(Arrays.asList(names));


        SelfOrgList<Integer> numbers = new SelfOrgList();
        for(int i= 0; i<10;i++){
            numbers.add(0,i);
        }

        numbers.toString();
        numbers.contains(1);
        numbers.toString();
        numbers.get(4);
        numbers.toString();

        System.out.println();
        System.out.println();

       SelfOrgList<String> strings = new SelfOrgList(name);

       strings.toString();
       strings.contains("One");
       strings.toString();
       strings.get(4);
       strings.toString();
    }

}
