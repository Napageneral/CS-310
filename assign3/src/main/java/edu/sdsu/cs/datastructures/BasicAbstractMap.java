package edu.sdsu.cs.datastructures;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/**
 * Created by Tyler Brandt on 4/18/2017.
 */
public abstract class BasicAbstractMap<K,V> implements Map<K,V> {

    Set<Entry<K,V>> keyset = new TreeSet<>();
    Set<K> keys = new TreeSet<>();
    Collection<V> values = new TreeSet<>();
    int size;

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size() == 0;
    }



    public abstract V put(K key, V value);

    public void putAll(Map<? extends K, ? extends V> map) {
        for(Entry<? extends K,? extends V> entry : map.entrySet()){
            put(entry.getKey(), entry.getValue());
        }
    }

    public abstract Set<Entry<K,V>> entrySet();


    public static class MapEntry<K,V> implements Map.Entry<K,V>{

        public K key;
        public V value;



        public MapEntry(K key, V value){
            if(key==null){
                throw new NullPointerException();
            }
            this.key = key;
            this.value = value;
        }

        public MapEntry() {
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V old = this.value;
            this.value=value;
            return old;
        }
    }
}
