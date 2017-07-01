package edu.sdsu.cs.datastructures;

import java.util.*;


public  class ArrayList<E> extends AbstractList<E> implements List<E> {
    private static final int Default_Capacity = 10;
    private final Object[] EMPTY_ELEMENTDATA = {};
    private final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private int size;
    transient Object[] elementData;
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    E elementData(int index) {
        return (E) elementData[index];
    }
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }



    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    private void grow(int minCapacity) {

        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);

        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(Default_Capacity, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    public int count(Object o){
        int c = 0;
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    c++;
        }
        return c;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size-1; i >= 0; i--)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    public void clear() {
        modCount++;


        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }

    public void add(int index, E element){
        rangeCheckForAdd(index);

        ensureCapacityInternal(size + 1);  // Increments modCount!!
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = element;
        size++;
    }


    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    public E get(int index) {
        rangeCheck(index);

        return elementData(index);
    }

    public int size() {
        return size;
    }

    public E set(int index, Object element){
        rangeCheck(index);

        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    public E remove(int index){
        rangeCheck(index);

        modCount++;
        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }

    public ArrayList(){
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayList(Collection<? extends E> c){
        elementData = c.toArray();
        if ((size = elementData.length) != 0) {

            if (elementData.getClass() != Object[].class)
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {

            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    public void sort(List<E> list, Comparator<? super E> c){
        final int expectedModCount = modCount;
        Arrays.sort((E[]) elementData, 0, size, c);
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        modCount++;

    }
}

