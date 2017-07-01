package edu.sdsu.cs.datastructures;
import java.util.ArrayList;
import java.util.Collection;

public class SelfOrgList<E> extends ArrayList<E>{

    public SelfOrgList() {super();}

    public SelfOrgList(Collection c) {
        super(c);
    }

    public E get(int index) {
        if(index>size()||index<1){
            throw new IndexOutOfBoundsException();
        }
        E b =remove(index);
        add(index-1,b);
        System.out.println("get("+index+"): "+ b);
        return b;
    }

    public String toString(){
        System.out.println("Printing contents of " + size() + " item array");
        for (E s: this){
            System.out.print(s+", ");
        }
        System.out.print("\b\b");
        System.out.print("\n");
        return null;
    }

    public boolean contains(Object data) {
        int pos  = indexOf(data);
        boolean found = pos>=0;

        if (found) {
            int i = 0;

            E a = remove(pos);

            while( i<size()){
                a = set(i, a);
                i++;
            }
            add(size(),a);
        }
        System.out.println("contains("+data+"): "+ found);

        return found;
    }
}




