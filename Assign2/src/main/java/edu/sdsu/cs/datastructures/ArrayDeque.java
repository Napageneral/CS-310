package edu.sdsu.cs.datastructures;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * Created by Tyler Brandt on 3/12/2017.
 */
public class ArrayDeque<E> extends AbstractQueue<E> implements IBasicDeque<E> {

    private ArrayList<E> myList = new ArrayList<E>();

    public ArrayDeque(){

    }

    public ArrayDeque(Collection<E> c){
        myList.addAll(c);
    }

    public void clear(){
        myList.clear();
    }

    public void addFirst(E item){
        if (item ==null){throw new NullPointerException();}
        myList.add(0,item);
    }

    public void addLast(E item){
        if (item ==null){throw new NullPointerException();}
        myList.add(item);
    }


    public E peekFirst() {
        if (isEmpty()){
            return null;
        }
        return myList.get(0);
    }

    public E peekLast() {
        if (isEmpty()){
            return null;
        }
        return myList.get(myList.size()-1);
    }

    public E pollFirst(){
        if(isEmpty()){
            return null;
        }
        return myList.remove(0);

    }

    public E pollLast(){
        if(isEmpty()){
            return null;
        }
        return myList.remove(myList.size()-1);

    }

    public int size() {
        return myList.size();
    }


    public Iterator iterator() {
        return null;
    }

    public boolean offer(Object o) {
        throw new UnsupportedOperationException();
    }

    public E poll() {
        throw new UnsupportedOperationException();
    }

    public E peek() {
        throw new UnsupportedOperationException();
    }
}
