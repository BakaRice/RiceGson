package com.ricemarch.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/**
 * A map of comparable keys to values. Unlike TreeMap, this class uses insertion order for iteration order.
 * Comparison order is only used as an optimization for efficient insertion and removal.
 * <p>
 * This implementation was derived from Android 4.1's TreeMap class
 *
 * @author tanwentao
 * @since 2021/9/16
 */

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    @SuppressWarnings({"unchecked", "rawtypes"}) // to avoid Comparable<Comparable<Comparable<...>>>
    private static final Comparator<Comparable> NATURAL_ORDER = Comparator.naturalOrder();

    Comparator<? super K> comparator;
    Node<K, V> root;
    int size = 0;
    int modCount = 0;

    /**
     * Used to preserve iteration order
     */
    final Node<K, V> header = new Node<K, V>();

    @SuppressWarnings("unchecked")
    public LinkedTreeMap() {
        this((Comparator<? super K>) NATURAL_ORDER);
    }

    /**
     * Create a tree map ordered by {@code comparator}. This map's keys may only
     * be null if {@code comparator} permits.
     *
     * @param comparator the comparator to order elements with, or {@code null} to
     *                   use the natural ordering.
     */
    @SuppressWarnings({"unchecked", "rawtypes"}) // unsafe! if comparator is null, this assumes K is comparable
    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator != null ? comparator : (Comparator) NATURAL_ORDER;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(Object key) {
        Node<K, V> node = findByObject(key);
        return node != null ? node.value : null;
    }

    private Node<K, V> findByObject(Object key) {
        try {
            return key != null ? find((K) key, false) : null;
        } catch (ClassCastException e) {
            return null;
        }
    }

    /**
     * Returns the node at or adjacent to the given key, creating it if requested.
     *
     * @throws ClassCastException if {@code key} and the tree's keys aren't
     *                            mutually comparable.
     */
    private Node<K, V> find(K key, boolean create) {
        Comparator<? super K> comparator = this.comparator;
        return null;
    }

    static final class Node<K, V> implements Entry<K, V> {
        Node<K, V> parent;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> next;
        Node<K, V> prev;

        final K key;
        V value;
        int height;

        // create the header entry
        Node() {
            key = null;
            next = prev = this;
        }

        //create a regular entry
        Node(Node<K, V> parent, K key, Node<K, V> next, Node<K, V> prev) {
            this.parent = parent;
            this.key = key;
            this.height = 1;
            this.next = next;
            this.prev = prev;
            this.next = this;
            next.prev = this;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @SuppressWarnings("rawtypes")
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Entry) {
                Entry other = (Entry) obj;
                //compare the entry,if have the same key and value return true else false
                return (key == null ? other.getKey() == null : key.equals(other.getKey()))
                        && (value == null ? other.getValue() == null : value.equals(other.getValue()));
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode());
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        /**
         * Returns the first node in this subtree.
         */
        public Node<K, V> first() {
            Node<K, V> node = this;
            Node<K, V> child = node.left;
            while (child != null) {
                node = child;
                child = node.left;
            }
            return node;
        }

        /**
         * Returns the last node in this subtree.
         */
        public Node<K, V> last() {
            Node<K, V> node = this;
            Node<K, V> child = node.right;
            while (child != null) {
                node = child;
                child = node.right;
            }
            return node;
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
