package edu.sdsu.cs.datastructures;

import edu.sdsu.cs.datastructures.BST;
import edu.sdsu.cs.datastructures.BasicAbstractMap;
import edu.sdsu.cs.datastructures.HashTable;

import java.io.*;
import java.util.*;

/**
 * Created by Tyler Brandt on 4/14/2017.
 */
public class Driver {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(args[1])));
        PrintStream o = new PrintStream(new File(args[1]));
        System.setOut(o);

        ArrayList<String> tokens = new ArrayList<>();

        String curLine = br.readLine();
        while (curLine != null) {
            tokens.addAll(Arrays.asList(curLine.toLowerCase().split(" ")));
            curLine = br.readLine();
        }

        HashTable<String, String> monograms = new HashTable<>();
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            monograms.put(token, token);
        }
        HashTable<String, String> bigrams = new HashTable<>();
        for (int i = 0; i < tokens.size() - 1; i++) {
            bigrams.put(tokens.get(i) + tokens.get(i + 1), tokens.get(i));
        }
        HashTable<String, String> trigrams = new HashTable<>();
        for (int i = 0; i < tokens.size() - 2; i++) {
            trigrams.put(tokens.get(i) + tokens.get(i + 1) + tokens.get(i + 2), tokens.get(i));
        }

        BST<Integer,String> mon = new BST<>();
        BST<Integer,String> bi = new BST<>();
        BST<Integer,String> tri = new BST<>();

        ArrayList<BasicAbstractMap.MapEntry<Integer,String>> freq1 = new ArrayList<>();
        monograms.frequency();
        freq1.add(monograms.freq.pollFirst());
        for(int i=0;i<freq1.size();i++){
            mon.put(freq1.get(i).getKey(),freq1.get(i).value);
        }

        ArrayList<BasicAbstractMap.MapEntry<Integer,String>> freq2 = new ArrayList<>();
        bigrams.frequency();
        freq1.add(bigrams.freq.pollFirst());
        for(int i=0;i<freq2.size();i++){
            bi.put(freq2.get(i).getKey(),freq2.get(i).value);
        }

        ArrayList<BasicAbstractMap.MapEntry<Integer,String>> freq3 = new ArrayList<>();
        trigrams.frequency();
        freq1.add(trigrams.freq.pollFirst());
        for(int i=0;i<freq3.size();i++){
            tri.put(freq3.get(i).getKey(),freq3.get(i).value);
        }

        mon.treeS(mon.root,20);
        bi.treeS(bi.root,20);
        tri.treeS(tri.root,5);

        int monOnce=0;
        for(int i=0;i<freq1.size();i++){
            if(freq1.get(i).getKey()==1){
                monOnce++;
            }
        }
        double monOnceP = monOnce/freq1.size();
        System.out.println(monOnceP+"% of words appear only once.");

        int biOnce=0;
        for(int i=0;i<freq2.size();i++){
            if(freq2.get(i).getKey()==1){
                biOnce++;
            }
        }
        double biOnceP = biOnce/freq2.size();
        System.out.println(biOnceP+"% of words appear only once.");
    }
}

