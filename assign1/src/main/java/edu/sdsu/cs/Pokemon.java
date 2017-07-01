package edu.sdsu.cs;

import java.util.Comparator;

public class Pokemon implements Comparable<Pokemon>{


        String Name;
        String Type1;
        String Type2;
        int HP;
        int Atk;
        int Def;
        int Spatk;
        int Spdef;
        int Speed;
        int iTotal = HP+Atk+Def+Spatk+Spdef+Speed;
        String Total = Integer.toString(iTotal);
        int Gen;
        boolean Leg;
        int victories;
        int defeats;




        public int CombatScore() {
            return ((Speed / 2) * (Atk + Spatk / 2) + (Def + Spdef / 2));
        }

        public Pokemon(){}



        public void setName(String x){
            Name = x;
        }
        public String getName(){return Name;}

        public void setType1(String x){
            Type1 = x;
        }
        public String getType1(){return Type1;}

        public void setType2(String x){
            Type2 = x;
        }
        public String getType2(){return Type2;}

        public void setTotal(String x){
            Total = x;
        }
        public String getTotal(){return Total;}
        public int getiTotal(){ return iTotal;}

        public void setHP(int x){
            HP = x;
        }
        public int getHP(){return HP;}

        public void setAtk(int x){
            Atk=x;
        }
        public int getAtk(){return Atk;}

        public void setDef(int x){
            Def=x;
        }
        public int getDef(){return Def;}

        public void setSpatk(int x){
            Spatk=x;
        }
        public int getSpatk(){return Spatk;}

        public void setSpdef(int x){
            Spdef=x;
        }
        public int getSpdef(){return Spdef;}

        public void setSpeed(int x){
            Speed=x;
        }
        public int getSpeed(){return Speed;}

        public void setGen(int x){
            Gen = x;
        }
        public int getGen(){return Gen;}

        public void setLeg(boolean x){
            Leg = x;
        }
        public boolean getLeg(){return Leg;}




        @Override
        public String toString(){
            if (getLeg()){
                return "Legendary "+ getName()+"       "+  "[Type :" + getType1()+ "/" + getType2()+"][Total:"+getTotal()+ "][HP:" + getHP()+"][Combat Score:" + CombatScore()+"]";
            }else{
            return getName()+"       "+  "[Type :" + getType1()+ "/" + getType2()+"][Total:"+getTotal()+ "][HP:" + getHP()+"][Combat Score:" + CombatScore()+"]";
        }
        }


        /*public class iTotalComp implements Comparator<Pokemon>{
            @Override
            public int compare(Pokemon p1, Pokemon p2){
                return p2.getiTotal()-p1.getiTotal();
            }
        }*/

        public static Comparator<Pokemon> iTotalComparator = (p1, p2) -> p2.getiTotal()-p1.getiTotal();





    @Override
    public int compareTo(Pokemon o) {
        return 0;
    }
}

