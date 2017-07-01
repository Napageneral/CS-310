package edu.sdsu.cs.datastructures;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Created by Tyler Brandt on 3/12/2017.
 */
public class ListDeque<E> extends AbstractQueue<E> implements IBasicDeque<E> {

    public SinglyLinkedList<E> myList = new SinglyLinkedList<E>();

    public Iterator<E> iterator() {
        return null;
    }

    public ListDeque() {

    }

    public ListDeque(Collection<E> c){
        Object[] storage = c.toArray();
        for(int i = 0; i<storage.length; i++){
            myList.add(i, (E) storage[i]);
        }
    }

    public void clear(){
        myList.clear();
    }

    public int size(){
        return myList.size();
    }

    public boolean isEmpty(){
        return myList.size() == 0;
    }


    public void addFirst(E item){
        if (item ==null){throw new NullPointerException();}
        myList.add(0,item);
    }

    public void addLast(E item){
        if (item ==null){throw new NullPointerException();}
        myList.add(myList.size()-1,item);
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

    public boolean offer(E e) {
        throw new UnsupportedOperationException();
    }

    public E remove() {
        throw new UnsupportedOperationException();
    }

    public E poll() {
        throw new UnsupportedOperationException();
    }

    public E element() {
        throw new UnsupportedOperationException();
    }

    public E peek() {
        throw new UnsupportedOperationException();
    }
}
