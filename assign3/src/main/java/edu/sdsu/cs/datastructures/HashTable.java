package edu.sdsu.cs.datastructures;

import edu.sdsu.cs.util.Prime;

import java.util.*;

/**
 * Created by Tyler Brandt on 4/18/2017.
 */
public class HashTable<K,V> extends BasicAbstractMap<K,V> {

    public List<HashNode<K,V>>[] buckets;
    public int numBuckets;
    private int size;
    public TreeSet<MapEntry<Integer,V>> freq = new TreeSet<>();


    public HashTable(){
        buckets = new List[11];
        numBuckets = 11;
        size = 0;
        for(int curBin = 0; curBin<numBuckets; curBin++){
            buckets[curBin] = new ArrayList<>();
        }
    }

    static class HashNode<K,V> extends MapEntry<K,V>{
        public V value;
        public K key;
        HashNode<K,V> next;

        public HashNode(K key, V value) {
            super(key, value);
        }


    }

    private int getI(Object key){
        return Math.abs(Objects.hashCode(key)%numBuckets);
    }


    @Override
    public boolean containsKey(Object key) {
        return get(key)!= null;
    }

    @Override
    public boolean containsValue(Object value) {
        if(value == get(value)){
            return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int search = getI(key);
        HashNode<K,V> head =  buckets[search].get(0);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void grow(){
        List<HashNode<K,V>>[] temp = buckets;
        buckets = new List[2*size()];
        numBuckets = Prime.nearestPrimeAfter(2*numBuckets);
        for (int i = 0; i < numBuckets; i++){
            buckets[i]= new ArrayList<>();
        }
        for(int i =0; i<size();i++){
            for(int p= 0; p<temp[i].size();p++){
                buckets[i].add(temp[i].remove(p));
            }
        }
    }


    @Override
    public V put(K key, V value) {
        if(key==null){
            throw new NullPointerException();
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        int search = getI(key);
        if(buckets[search].isEmpty()){
            buckets[search].add(newNode);
            if (size() / numBuckets >= 0.75) {
                grow();
            }
            size++;
            return newNode.getValue();
        }
        HashNode<K,V> head = buckets[search].get(0);
        int track =0;
        while(head!=null){
            track++;
            head=head.next;
        }
        buckets[search].add(newNode);
        buckets[search].get(track-1).next=newNode;

        if (size() / numBuckets >= 0.75) {
            grow();
        }
        size++;
        return newNode.getValue();
    }


    @Override
    public V remove(Object key) {
        int search = getI(key);
        HashNode<K,V> head = buckets[search].get(0);
        HashNode<K,V> rem=null;
        int track=0;
        if(head==null){
            return null;
        }
        while(head!=null){
            rem=head;
            head=head.next;
            track++;
        }
        buckets[search].get(track-1).next=null;
        buckets[search].remove(track);

        if (size() / numBuckets <= 0.15) {
            List<HashNode<K,V>>[] temp = buckets;
            buckets = new List[size()/2];
            numBuckets = Prime.nearestPrimeAfter(numBuckets/2);
            for (int i = 0; i < numBuckets; i++){
                buckets[i]= new ArrayList<>();
            }
            for(int i =0; i<size();i++){
                for(int p= 0; p<temp[i].size();p++){
                    buckets[i].add(temp[i].remove(p));
                }
            }
        }
        size--;
        return rem.value;
    }

    @Override
    public void clear() {new HashTable();}

    @Override
    public Set<K> keySet() {
        for(int i =0; i<size;i++){
            for(int p= 0; p<buckets[i].size();p++){
                keys.add(buckets[i].get(i).key);
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        for(int i =0; i<size;i++){
            for(int p= 0; p<buckets[i].size();p++){
                values.add(buckets[i].get(i).value);
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        for(int i =0; i<size;i++){
            for(int p= 0; p<buckets[i].size();p++){
                keyset.add(buckets[i].get(i));
            }
        }
        return keyset;
    }

    public TreeSet<MapEntry<Integer,V>> frequency(){
        for(int i=0;i<numBuckets;i++){
            if(buckets[i].get(0)!=null) {
                MapEntry<Integer, V> count = new MapEntry<>(buckets[i].size(), buckets[i].get(0).value);
                freq.add(count);
            }
        }
        return freq;
    }
}
