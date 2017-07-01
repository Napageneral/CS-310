package edu.sdsu.edu;
import edu.sdsu.edu.datastructures.ArrayList;
import edu.sdsu.edu.datastructures.CircArrayList;

import java.io.*;
public class Driver {
    public static void main(String[] args) throws IOException {
        String wf = args[0];
        File writeFile = new File(wf);
        PrintStream o = new PrintStream(writeFile);
        System.setOut(o);

        int n = 2048;
        if (args.length > 1) {
            n = Integer.parseInt(args[1]);
        }

        CircArrayList<String> circle = new CircArrayList<>();
        ArrayList<String> array = new ArrayList<>();

        String in = "lol";

        System.out.println("Structure,method,time,n");

        long sTime;
        long eTime;

        for(int p = 1; p<=3;p++){
            sTime = System.nanoTime();
            for(int i = 0; i<n; i++){
                circle.addFirst(in);
            }
            eTime = System.nanoTime();
            long total = (eTime-sTime)/100000000;
            System.out.println("CircArrayList,addFirst,0."+total+n*p);
        }
        for(int p = 1; p<=3;p++){
            sTime = System.nanoTime();
            for(int i = 0; i<n; i++){
                circle.removeFirst();
            }
            eTime = System.nanoTime();
            long total = (eTime-sTime)/100000000;
            System.out.println("CircArrayList,removeFirst,0."+total+n*p);
        }
        for(int p = 1; p<=3;p++){
            sTime = System.nanoTime();
            for(int i = 0; i<n; i++){
                array.addFirst(in);
            }
            eTime = System.nanoTime();
            long total = (eTime-sTime)/100000000;
            System.out.println("ArrayList,addFirst,0."+total+n*p);
        }
        for(int p = 1; p<=3;p++){
            sTime = System.nanoTime();
            for(int i = 0; i<n; i++){
                array.remove(1);
            }
            eTime = System.nanoTime();
            long total = (eTime-sTime)/100000000;
            System.out.println("ArrayList,removeFirst,0."+total+n*p);
        }
    }
}
