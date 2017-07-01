package edu.sdsu.edu.datastructures;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
public class CircArrayList<E> extends AbstractList<E> implements List<E> {
    private class Node<E> {
        Node next;
        E data;

        public Node(E data){
            this(data, null);
        }

        public Node(E data, Node next){
            this.next = next;
            this.data = data;
        }

        public E getData(){
            return this.data;
        }

        public void setData(E data){
            this.data = data;
        }

        public Node next(){
            return this.next;
        }

        public void setNext(Node nextNode){
            this.next = nextNode;
        }
    }
    private Node<E> tail;
    private int count;

    public CircArrayList(){
        tail = null;
        count = 0;
    }
    @Override
    public int size() {
        return count;
    }
    @Override
    public E get(int index) {
        return null;
    }
    public void addFirst(E data){
        Node<E> temp = new Node<>(data);
        if(tail == null){
            tail = temp;
            tail.setNext(tail);
        } else {
            temp.setNext(tail.next());
            tail.setNext(temp);
        }
        count++;
    }
    public E removeFirst(){
        Node<E> temp = tail.next();
        if(tail == tail.next()){
            tail=null;
        } else {
            tail.setNext(temp.next());
            temp.setNext(null);
        }
        count--;
        return temp.getData();
    }
}
