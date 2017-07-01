package edu.sdsu.cs.datastructures;

import java.util.*;

/**
 * Created by Tyler Brandt on 4/18/2017.
 */
public class BST<K,V> extends BasicAbstractMap<K,V> {

    public Node<K,V> root;
    private int size = 0;

    public BST(){
        root = null;
        size=0;
    }

    static class Node<K, V> extends MapEntry<K,V> {

        Node<K,V> left;
        Node<K,V> right;

        public Node(K freq, V value) {
            super(freq, value);
        }

        public int hashCode(){
            return Objects.hashCode(key);
        }

        public int vHash(){
            return Objects.hashCode(value);
        }
    }

    public int size(){
        return size;
    }


    @Override
    public boolean containsKey(Object key) {
        int search = Objects.hashCode(key);
        Node<K, V> current = root;
        while(current!=null) {
            if (current.vHash() == search) {
                return true;
            }
            if (current.vHash() > search) {
                current = current.right;

            }
            if (current.vHash() < search) {
                current = current.left;

            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        int search = Objects.hashCode(value);
        Node<K, V> current = root;
        while(current!=null) {
            if (current.vHash() == search) {
                return true;
            }
            if (current.vHash() > search) {
                current = current.right;

            }
            if (current.vHash() < search) {
                current = current.left;

            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int rem = Objects.hashCode(key);
        Node<K,V> current = root;
        while(current.hashCode()!= rem){
            if(current.hashCode()>rem){
                current=current.left;
            } else {
                current= current.right;
            }
            if(current==null){
                return null;
            }
        }
        return current.value;
    }

    @Override
    public V put(K key, V value) {
        if(key==null){
            throw new NullPointerException();
        }
        Node<K, V> add = new Node<>(key, value);
        if (root == null) {
            root = add;
            size++;
            return add.value;
        }
        Node<K, V> current = root;
        while (true) {
            if (add.hashCode() < current.hashCode()) {
                if (current.left == null) {
                    current.left = add;
                    size++;
                    return add.value;
                }
                current = current.left;
            }
            if (add.hashCode() > current.hashCode()) {
                if (current.right == null) {
                    current.right = add;
                    size++;
                    return add.value;
                }
                current = current.right;
            }
        }
    }

    @Override
    public V remove(Object key) {
        int rem = Objects.hashCode(key);
        V removed;
        Node<K,V> current = root;
        Node<K,V> parent = root;
        boolean isLeft = false;
        while(current.hashCode()!= rem){
            parent = current;
            if(current.hashCode()>rem){
                isLeft=true;
                current=current.left;
            } else {
                isLeft=false;
                current= current.right;
            }
            if(current==null){
                return null;
            }
        }
        removed = current.value;
        if(current.left==null && current.right == null){
            if(current==root){
                root = null;
            }
            if(isLeft ){
                parent.left = null;
            } else{
                parent.right = null;
            }
        }
        else if(current.right==null){
            if (current == root) {
                root=current.left;
            }else if(isLeft ){
                parent.left=current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left == null){
            if(current==root){
                root = null;
            } else if(isLeft){
                parent.left = current.right;
            } else{
                parent.right = current.right;
            }
        }
        else {
            Node<K, V> suc = getSuc(current);
            if(current==root){
                root=suc;
            } else if(isLeft ){
                parent.left = suc;
            } else {
                parent.right = suc;
            }
            suc.left = current.left;
        }
        size--;
        return removed;
    }

    public Node<K, V> getSuc(Node<K, V> del){
        Node<K, V> s= null;
        Node<K, V> sParent = null;
        Node<K, V> cur = del.right;
        while(cur!=null){
            sParent = s;
            s=cur;
            cur= cur.left;
        }
        if(s!=del.right){
            sParent.left=s.right;
            s.right = del.right;
        }
        return s;
    }

    @Override
    public void clear() {
        root = null;
    }

    public void tree(Node<K, V> root){
        if(root!=null) {
            tree(root.right);
            System.out.println("'" + root.getValue() + "'" + " +>"+root.getKey());
            tree(root.left);
        }
    }

    public void treeS(Node<K,V> root, int t){
        int i = 0;
        while(i<t) {
            if (root != null) {
                tree(root.right);
                System.out.println("'" + root.getValue() + "'" + " +>" + root.getKey());
                i++;
                tree(root.left);
            }
        }
    }

    public void treeKS(Node<K,V> root){
        if(root!=null){
            treeKS(root.left);
            keyset.add(root);
            treeKS(root.right);
        }
    }
    public void treeK(Node<K,V> root){
        if(root!=null){
            treeK(root.left);
            keys.add(root.key);
            treeK(root.right);
        }
    }
    public void treeV(Node<K,V> root){
        if(root!=null){
            treeV(root.left);
            values.add(root.value);
            treeV(root.right);
        }
    }

    @Override
    public Set<K> keySet() {
        treeK(root);
        return keys;
    }

    @Override
    public Collection<V> values() {
        treeV(root);
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        treeKS(root);
        return keyset;
    }

}
