/**
 * Created by Tyler Brandt on 1/31/2017.
 */
package edu.sdsu.cs;


import java.io.*;
import java.lang.reflect.Array;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadTextfile{
    public static void main (String[] args) throws FileNotFoundException {
        ArrayList<String> Tokens = new ArrayList<String>();

        String readFile = args[0];
        String outFile = args[1];

        //File inFile = new File(args[0]);
        //File outFile = new File(args[1]);
        String pToken = args[2];
        String fileRead;


        try{

            BufferedReader br = new BufferedReader( new FileReader(readFile));
            fileRead = br.readLine();
            while(fileRead !=null){
                String[] tokenize = fileRead.split(" ");
                String tempItem = tokenize[0];
                tempItem.toLowerCase();
                Tokens.add(tempItem);
                fileRead = br.readLine();
            }
            br.close();
            int numtokens = Array.getLength(Tokens);
            int Findex = 0;
            int Lindex = 0;
            int pCount = 0;
            int i = 0;
            do{
                boolean b = Tokens.get(i).equals(pToken);

                if(b || Findex==0){
                    Findex = i;
                }
                if(b) {
                    Lindex=i;
                    pCount++;
                }

                i++;
            }
            while(Tokens.get(i)!=null);



            FileWriter fw = new FileWriter(outFile);
            if(pCount==0){
                fw.write("Tyler Brandt");
                fw.write("Tokens in file:"+ numtokens);
                fw.write("No matching tokens.");
            }
            else {
                fw.write("Tyler Brandt");
                fw.write("\n Tokens in file:" + numtokens);
                fw.write("\n First index:" + Findex);
                fw.write("\n Last index:" + Lindex);
                fw.write("\n Count:" + pCount);
                fw.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

