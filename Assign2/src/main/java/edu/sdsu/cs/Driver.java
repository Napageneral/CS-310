package edu.sdsu.cs;

import edu.sdsu.cs.datastructures.ArrayDeque;
import edu.sdsu.cs.datastructures.ListDeque;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Tyler Brandt on 3/12/2017.
 */
public class Driver {
        public static void main(String[] args) throws IOException {

        String wf = args[0];
        File writeFile = new File(wf);
        FileWriter fw = new FileWriter(writeFile);
        BufferedWriter bw = new BufferedWriter(fw);

        int n = 2048;
        if (args.length > 1) {
            n = Integer.parseInt(args[1]);
        }

        String input = "Desu";
        ArrayDeque<String> ATestDeq = new ArrayDeque<String>();
        ListDeque<String> LTestDeq = new ListDeque<String>();


        //addfirst
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            ATestDeq.addFirst(input);
        }
        long endTime = System.currentTimeMillis();
        long aaf1 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 2; i++) {
            ATestDeq.addFirst(input);
        }
        endTime = System.currentTimeMillis();
        long aaf2 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 4; i++) {
            ATestDeq.addFirst(input);
        }
        endTime = System.currentTimeMillis();
        long aaf3 = startTime - endTime;

        //addlast
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            ATestDeq.addLast(input);
        }
        endTime = System.currentTimeMillis();
        long aal1 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 2; i++) {
            ATestDeq.addLast(input);
        }
        endTime = System.currentTimeMillis();
        long aal2 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 4; i++) {
            ATestDeq.addLast(input);
        }
        endTime = System.currentTimeMillis();
        long aal3 = startTime - endTime;

        //peekfirst
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            ATestDeq.peekFirst();
        }
        endTime = System.currentTimeMillis();
        long apf1 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 2; i++) {
            ATestDeq.peekFirst();
        }
        endTime = System.currentTimeMillis();
        long apf2 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 4; i++) {
            ATestDeq.peekFirst();
        }
        endTime = System.currentTimeMillis();
        long apf3 = startTime - endTime;

        //peeklast
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            ATestDeq.peekLast();
        }
        endTime = System.currentTimeMillis();
        long apl1 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 2; i++) {
            ATestDeq.peekLast();
        }
        endTime = System.currentTimeMillis();
        long apl2 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 4; i++) {
            ATestDeq.peekLast();
        }
        endTime = System.currentTimeMillis();
        long apl3 = startTime - endTime;

        //pollfirst
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            ATestDeq.pollFirst();
        }
        endTime = System.currentTimeMillis();
        long apof1 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 2; i++) {
            ATestDeq.pollFirst();
        }
        endTime = System.currentTimeMillis();
        long apof2 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 4; i++) {
            ATestDeq.pollFirst();
        }
        endTime = System.currentTimeMillis();
        long apof3 = startTime - endTime;

        //polllast
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            ATestDeq.pollLast();
        }
        endTime = System.currentTimeMillis();
        long apol1 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 2; i++) {
            ATestDeq.pollLast();
        }
        endTime = System.currentTimeMillis();
        long apol2 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 4; i++) {
            ATestDeq.pollLast();
        }
        endTime = System.currentTimeMillis();
        long apol3 = startTime - endTime;

        //llistdeq
        //addfirst
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            LTestDeq.addFirst(input);
        }
        endTime = System.currentTimeMillis();
        long laf1 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 2; i++) {
            LTestDeq.addFirst(input);
        }
        endTime = System.currentTimeMillis();
        long laf2 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 4; i++) {
            LTestDeq.addFirst(input);
        }
        endTime = System.currentTimeMillis();
        long laf3 = startTime - endTime;

        //addlast
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            LTestDeq.addLast(input);
        }
        endTime = System.currentTimeMillis();
        long lal1 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 2; i++) {
            LTestDeq.addLast(input);
        }
        endTime = System.currentTimeMillis();
        long lal2 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 4; i++) {
            LTestDeq.addLast(input);
        }
        endTime = System.currentTimeMillis();
        long lal3 = startTime - endTime;

        //peekfirst
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            LTestDeq.peekFirst();
        }
        endTime = System.currentTimeMillis();
        long lpf1 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 2; i++) {
            LTestDeq.peekFirst();
        }
        endTime = System.currentTimeMillis();
        long lpf2 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 4; i++) {
            LTestDeq.peekFirst();
        }
        endTime = System.currentTimeMillis();
        long lpf3 = startTime - endTime;

        //peeklast
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            LTestDeq.peekLast();
        }
        endTime = System.currentTimeMillis();
        long lpl1 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 2; i++) {
            LTestDeq.peekLast();
        }
        endTime = System.currentTimeMillis();
        long lpl2 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 4; i++) {
            LTestDeq.peekLast();
        }
        endTime = System.currentTimeMillis();
        long lpl3 = startTime - endTime;

        //pollfirst
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            LTestDeq.pollFirst();
        }
        endTime = System.currentTimeMillis();
        long lpof1 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 2; i++) {
            LTestDeq.pollFirst();
        }
        endTime = System.currentTimeMillis();
        long lpof2 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 4; i++) {
            LTestDeq.pollFirst();
        }
        endTime = System.currentTimeMillis();
        long lpof3 = startTime - endTime;

        //polllast
        startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            LTestDeq.pollLast();
        }
        endTime = System.currentTimeMillis();
        long lpol1 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 2; i++) {
            LTestDeq.pollLast();
        }
        endTime = System.currentTimeMillis();
        long lpol2 = startTime - endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < n * 4; i++) {
            LTestDeq.pollLast();
        }
        endTime = System.currentTimeMillis();
        long lpol3 = startTime - endTime;

        bw.write("ArrayDeque");
        bw.newLine();
        bw.write("method,time,n");
        bw.newLine();
        bw.write("addFirst,"+-aaf1+","+n);
        bw.newLine();
        bw.write("addFirst,"+-aaf2+","+n*2);
        bw.newLine();
        bw.write("addFirst,"+-aaf3+","+n*4);
        bw.newLine();
        bw.write("addLast,"+-aal1+","+n);
        bw.newLine();
        bw.write("addLast,"+-aal2+","+n*2);
        bw.newLine();
        bw.write("addLast,"+-aal3+","+n*4);
        bw.newLine();
        bw.write("peekFirst,"+-apf1+","+n);
        bw.newLine();
        bw.write("peekFirst,"+-apf2+","+n*2);
        bw.newLine();
        bw.write("peekFirst,"+-apf3+","+n*4);
        bw.newLine();
        bw.write("peekLast,"+-apl1+","+n);
        bw.newLine();
        bw.write("peekLast,"+-apl2+","+n*2);
        bw.newLine();
        bw.write("peekLast,"+-apl3+","+n*4);
        bw.newLine();
        bw.write("pollFirst,"+-apof1+","+n);
        bw.newLine();
        bw.write("pollFirst,"+-apof2+","+n*2);
        bw.newLine();
        bw.write("pollFirst,"+-apof3+","+n*4);
        bw.newLine();
        bw.write("pollLast,"+-apol1+","+n);
        bw.newLine();
        bw.write("pollLast,"+-apol2+","+n*2);
        bw.newLine();
        bw.write("pollLast,"+-apol3+","+n*4);
        bw.flush();
        bw.newLine();
        bw.write("ListDeque");
        bw.newLine();
        bw.write("method,time,n");
        bw.newLine();
        bw.write("addFirst,"+-laf1+","+n);
        bw.newLine();
        bw.write("addFirst,"+-laf2+","+n*2);
        bw.newLine();
        bw.write("addFirst,"+-laf3+","+n*4);
        bw.newLine();
        bw.write("addLast,"+-lal1+","+n);
        bw.newLine();
        bw.write("addLast,"+-lal2+","+n*2);
        bw.newLine();
        bw.write("addLast,"+-lal3+","+n*4);
        bw.newLine();
        bw.write("peekFirst,"+-lpf1+","+n);
        bw.newLine();
        bw.write("peekFirst,"+-lpf2+","+n*2);
        bw.newLine();
        bw.write("peekFirst,"+-lpf3+","+n*4);
        bw.newLine();
        bw.write("peekLast,"+-lpl1+","+n);
        bw.newLine();
        bw.write("peekLast,"+-lpl2+","+n*2);
        bw.newLine();
        bw.write("peekLast,"+-lpl3+","+n*4);
        bw.newLine();
        bw.write("pollFirst,"+-lpof1+","+n);
        bw.newLine();
        bw.write("pollFirst,"+-lpof2+","+n*2);
        bw.newLine();
        bw.write("pollFirst,"+-lpof3+","+n*4);
        bw.newLine();
        bw.write("pollLast,"+-lpol1+","+n);
        bw.newLine();
        bw.write("pollLast,"+-lpol2+","+n*2);
        bw.newLine();
        bw.write("pollLast,"+-lpol3+","+n*4);
        bw.close();
    }
}
