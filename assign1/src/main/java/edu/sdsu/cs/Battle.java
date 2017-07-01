
package edu.sdsu.cs;
import java.io.*;
import java.util.*;
import java.util.ArrayList;


public class Battle {
    public static void main (String[] args) throws IOException {

        String fileName = "Pokemon.csv";
        String wf = args[1];
        File writeFile = new File("test.txt");
        FileWriter fw = new FileWriter(writeFile);
        BufferedWriter bw = new BufferedWriter(fw);

        File CSVfile = new File("src/main/resources/Pokemon.csv");
        java.util.ArrayList<Pokemon> Pokemen = new java.util.ArrayList<Pokemon>();



        try (Scanner inputStream = new Scanner(CSVfile)) {
            inputStream.nextLine();
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] Stats = data.split(",");

                String strName = Stats[1];
                String strType1 = Stats[2];
                String strType2 = Stats[3];
                String strTotal = Stats[4];
                String strHp = Stats[5];
                String strAtk = Stats[6];
                String strDef = Stats[7];
                String strSpatk = Stats[8];
                String strSpdef = Stats[9];
                String strSpeed = Stats[10];
                String strGen = Stats[11];
                String strLeg = Stats[12];

                Pokemon StreamPoke = new Pokemon();

                StreamPoke.setName(strName);
                StreamPoke.setType1(strType1);
                StreamPoke.setType2(strType2);

                String tTotal = strTotal;
                StreamPoke.setTotal(tTotal);

                int tHP = Integer.parseInt(strHp);
                StreamPoke.setHP(tHP);

                int tAtk = Integer.parseInt(strAtk);
                StreamPoke.setAtk(tAtk);

                int tDef = Integer.parseInt(strDef);
                StreamPoke.setDef(tDef);

                int tSpatk = Integer.parseInt(strSpatk);
                StreamPoke.setSpatk(tSpatk);

                int tSpdef = Integer.parseInt(strSpdef);
                StreamPoke.setSpdef(tSpdef);

                int tSpeed = Integer.parseInt(strSpeed);
                StreamPoke.setSpeed(tSpeed);

                int tGen = Integer.parseInt(strGen);
                StreamPoke.setGen(tGen);

                Boolean tLeg = Boolean.getBoolean(strLeg);
                StreamPoke.setLeg(tLeg);


                Pokemen.add(StreamPoke);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        java.util.ArrayList<Pokemon> Vanquished = new java.util.ArrayList<Pokemon>();
        java.util.ArrayList<Pokemon> Winners = new ArrayList<Pokemon>();

        int roundnum = 1;


            int count=0;
            do {
                bw.flush();
                String Rnd = "Round " + roundnum + ":";
                String Cmbts = "Combatants:" + Pokemen.size();
                String Ldr = "- Leaders -";
                Collections.sort(Pokemen, Pokemon.iTotalComparator);
                bw.write(Rnd);
                bw.newLine();
                bw.write(Cmbts);
                bw.newLine();
                bw.write(Ldr);
                bw.newLine();


                if (Pokemen.size() > 5) {
                    for (int i = 0; i < 5; i++) {
                        Pokemon p = Pokemen.get(i);
                        bw.write(p.toString());
                        bw.newLine();
                    }
                } else {
                    for (int i = 0; i < Pokemen.size(); i++) {
                        Pokemon p = Pokemen.get(i);
                        bw.write(p.toString());
                        bw.newLine();
                    }
                }


                bw.newLine();
                bw.write("Begin!");
                bw.newLine();
                if (!(Pokemen.size() % 2 == 0)) {
                    Pokemon by = Pokemen.get(0);
                    Pokemen.remove(0);
                    Winners.add(by);
                }



                do {

                    Pokemon pokemon1;
                    Pokemon pokemon2;
                    boolean p1winner = false;
                    boolean p2winner = false;
                    int rndm = (int) (Math.random() * Pokemen.size());
                    pokemon1 = Pokemen.get(rndm);
                    Pokemen.remove(rndm);
                    int rndm2 = (int) (Math.random() * Pokemen.size());
                    pokemon2 = Pokemen.get(rndm2);
                    Pokemen.remove(rndm2);


                    if (pokemon1.CombatScore() < pokemon2.CombatScore()) {
                        Grow(pokemon2, pokemon1);
                        p2winner = true;
                        Vanquished.add(pokemon1);
                        Winners.add(pokemon2);
                        bw.write(pokemon2.getName() + " defeats " + pokemon1.getName() + ".");
                        bw.newLine();

                    } else if (pokemon1.CombatScore() > pokemon2.CombatScore()) {
                        Grow(pokemon1, pokemon2);
                        p1winner = true;
                        Vanquished.add(pokemon2);
                        Winners.add(pokemon1);
                        bw.write(pokemon1.getName() + " defeats " + pokemon2.getName() + ".");
                        bw.newLine();
                    } else {
                        int compT = pokemon1.getTotal().compareTo(pokemon2.getTotal());
                        if (compT < 0) {
                            Grow(pokemon2, pokemon1);
                            p2winner = true;
                            Vanquished.add(pokemon1);
                            Winners.add(pokemon2);
                            bw.write(pokemon2.getName() + " defeats " + pokemon1.getName() + ".");
                            bw.newLine();
                        } else if (compT > 0) {
                            p1winner = true;
                            Grow(pokemon1, pokemon2);
                            Vanquished.add(pokemon2);
                            Winners.add(pokemon1);
                            bw.write(pokemon1.getName() + " defeats " + pokemon2.getName() + ".");
                            bw.newLine();
                        } else {
                            int comp = pokemon1.getName().compareTo(pokemon2.getName());
                            if (comp < 0) {
                                p2winner = true;
                                Grow(pokemon2, pokemon1);
                                Vanquished.add(pokemon1);
                                Winners.add(pokemon2);
                                bw.write(pokemon2.getName() + " defeats " + pokemon1.getName() + ".");
                                bw.newLine();
                            } else {
                                Grow(pokemon1, pokemon2);
                                p1winner = true;
                                Vanquished.add(pokemon2);
                                Winners.add(pokemon1);
                                bw.write(pokemon1.getName() + " defeats " + pokemon2.getName() + ".");
                                bw.newLine();
                            }
                        }
                    }
                if (!pokemon1.getLeg()){

                }
                else if (pokemon1.getLeg() && pokemon1.defeats>2 && !p1winner) {

                } else if (pokemon1.getLeg() && p1winner){

                }else {
                    Winners.add(pokemon1);
                }


                if (!pokemon2.getLeg()){

                }
                else if (pokemon2.getLeg()&& pokemon2.defeats>2 && !p2winner) {

                } else if(pokemon2.getLeg() && p2winner){

                } else{
                    Winners.add(pokemon2);
                }

                } while (Pokemen.size() > 0);

                bw.newLine();
                bw.write("Round Complete!");
                bw.newLine();
                bw.newLine();

                Pokemen.clear();
                for (Pokemon P : Winners
                        ) {
                    Pokemen.add(P);
                }
                roundnum++;
                Winners.clear();
                count++;
            } while (Pokemen.size() > 1);

            bw.flush();
            Pokemon Champion = Pokemen.get(0);
            String winner = Champion.toString();
            bw.newLine();
            bw.write("The Champion is:" + winner);
            bw.close();
    }



    public static void Grow(Pokemon Winner, Pokemon Loser){
        Winner.setAtk(Winner.getAtk()+(Loser.getiTotal()/2));
        Winner.setDef(Winner.getDef()+(Loser.getiTotal()/2));
        Winner.victories++;
        Loser.defeats++;
        if (Winner.victories>2){
            Winner.setLeg(true);
        }
    }


    }











