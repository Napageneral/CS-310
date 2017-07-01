package edu.sdsu.edu.datastructures;
import java.util.*;
public class ArrayList<E> extends AbstractList<E> {
    private int N = 10;
    private int size=0;
    private Object[] storage = {};

    public ArrayList(){
        storage = new Object[N];
        size = N;
    }
    public ArrayList(int n){
        if(n<=0){
            storage = new Object[N];
        }
        storage = new Object[n];
        size=n;
    }
    public ArrayList(Collection c){
        storage = c.toArray();
        size = storage.length;
        if (size != 0) {
            if (storage.getClass() != Object[].class)
                storage = Arrays.copyOf(storage, size, Object[].class);
        } else {
            new ArrayList();
        }
    }
    public Object[] toArray(){
        return Arrays.copyOf(storage, size);
    }

    public void sort(List<E> list, Comparator<? super E> c){
        Arrays.sort((E[]) storage, 0, size, c);

    }
    public boolean isEmpty(){
        return size == 0;
    }

    public E get(int index) {
        if(index>=size || index<0){
            throw new IndexOutOfBoundsException();
        }
        return (E) storage[index];
    }

    public int size() {
        return size;
    }

    public void grow(){
        storage = Arrays.copyOf(storage, storage.length*2);
    }

    public void shrink(){
        storage = Arrays.copyOf(storage, storage.length/2);
    }

    public void add( int index, E data){
        if(index>=size || index <0){
            throw new IndexOutOfBoundsException();
        }
        if(size/storage.length >= .8){
            grow();
        }
        System.arraycopy(storage,index,storage, index+1,size-index);
        storage[index] = data;
        size++;
    }

    public void addFirst(E data){
        add(0,data);
    }

    public E remove( int index){
        if(index < size && index>=0){
            E oldValue = get(index);
            while(index<size){
                storage[index]= storage[index+1];
                storage[index+1]=null;
                index++;
            }
            size--;
            if(size/storage.length<=.3){
                shrink();
            }
            return oldValue;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public E set( int index, E data){
        E oldValue = get(index);
        storage[index] = data;
        return oldValue;
    }
}
