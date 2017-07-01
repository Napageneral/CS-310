package edu.sdsu.cs.datastructures;

import java.util.*;

/**
 * Created by Tyler Brandt on 3/12/2017.
 */
public class SinglyLinkedList<E> extends AbstractCollection<E> implements IBasicList<E>{

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

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

        public Node getNext(){
            return this.next;
        }

        public void setNext(Node nextNode){
            this.next = nextNode;
        }
    }

    private Node getNode(int index){
        Node current = head;
        for (int i=1; i<index; i++){
            current = current.getNext();
        }
        return current;
    }

    public Iterator<E> iterator(){
        return new LLIterator();
    }

    private class LLIterator implements Iterator<E>{

        private Node<E> nextNode;
        public LLIterator(){
            nextNode=head;
        }
        public boolean hasNext(){
            return nextNode != null;
        }
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }
        public void remove(){
           throw new UnsupportedOperationException();
        }
    }

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public SinglyLinkedList(Collection<E> c){
        Object[] storage = c.toArray();
        for(int i = 0; i<storage.length; i++){
            add(i, (E) storage[i]);
            size++;
        }
    }

    public void add(int index, E element){
        if (index >size || index <0){
            throw new IndexOutOfBoundsException();
        } else {
            Node temp = new Node(element);
            Node current = getNode(index);

            if(index == 0){
                temp.setNext(head);
                head = temp;
                tail = head;
            } else {
                temp.setNext(current.getNext());
                current.setNext(temp);
            }

            if( index == size-1){
                tail.setNext(temp);
                tail = temp;
            }
        }
        this.size++;
    }

    public E set(int index, E element){
        if (index >size || index <0){
            throw new IndexOutOfBoundsException();
        } else {Node remove = getNode(index);

        remove.getData();
        getNode(index).setData(element);
        return (E) remove.getData();
    }}

    public E remove(int index){
        if (index >size || index <0){
            throw new IndexOutOfBoundsException();
        } else {
        Node remove = getNode(index);
        if(index == 0 ){
            head = head.getNext();

        } else{
            getNode(index).setNext(getNode(index).getNext().getNext());
        }
        this.size--;
        return (E) remove.getData();
    }}

    public E get(int index){
        if (index >size || index <0){
            throw new IndexOutOfBoundsException();
        } else {
        return (E) getNode(index).getData();
    }}


    public int size(){
        return this.size;
    }




}
