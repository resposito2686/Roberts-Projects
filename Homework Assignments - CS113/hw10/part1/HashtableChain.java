package edu.miracosta.cs113.hw10.part1;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Hash table implementation using chaining.
 *  @author Koffman and Wolfgang
 **/
public class HashtableChain<K, V> implements Map<K, V> {

    /** The table */
    private LinkedList<Entry<K, V>>[] table;
    /** The number of keys */
    private int numKeys;
    /** The capacity */
    private static final int CAPACITY = 101;
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;

    /** Contains key-value pairs for a hash table. */
    private static class Entry<K, V> implements Map.Entry<K, V> {

        /** The key */
        private K key;
        /** The value */
        private V value;

        /**
         * Creates a new key-value pair.
         * @param key The key
         * @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Retrieves the key.
         * @return The key
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value.
         * @return The value
         */
        @Override
        public V getValue() {
            return value;
        }

        /**
         * Sets the value.
         * @param val The new value
         * @return The old value
         */
        @Override
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        public String toString()
        {
            return key + " : " + value;
        }
    }

    /** EntrySet inner class. Used to generate a map of the entry set and create an iterator for it */
    private class EntrySet extends AbstractSet<Map.Entry<K,V>>
    {

        public int size()
        {
            return numKeys;
        }

        public Iterator<Map.Entry<K, V>> iterator()
        {
            return new SetIterator();
        }
    }

    /** Iterator inner class. Used to navigate the linked lists at each index */
    private class SetIterator implements Iterator<Map.Entry<K,V>>
    {

        int i = 0;
        Entry<K,V> lastItemReturned = null;
        Iterator<Entry<K,V>> iterator = null;

        public boolean hasNext()
        {

            if (iterator != null && iterator.hasNext())
            {
                return true;
            }
            do
            {
                if (i > table.length)
                {
                    return false;
                }

                i++;
            } while (table[i] == null);

            iterator = table[i].iterator();
            return iterator.hasNext();
        }


        public Map.Entry<K, V> next()
        {
            if (iterator.hasNext())
            {
                lastItemReturned = iterator.next();
                return lastItemReturned;
            }
            else
            {
                return null;
            }
        }
    }

    // Constructor
    public HashtableChain() {
        table = new LinkedList[CAPACITY];
    }

    /*<listing chapter="7" number="9">*/
    /**
     * Method get for class HashtableChain.
     * @param key The key being sought
     * @return The value associated with this key if found;
     *         otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null; // key is not in the table.
        }
        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            if (nextItem.key.equals(key)) {
                return nextItem.value;
            }
        }

        // assert: key is not in the table.
        return null;
    }
    /*</listing>*/

    /*<listing chapter="7" number="10">*/
    /**
     * Method put for class HashtableChain.
     * @post This key-value pair is inserted in the
     *       table and numKeys is incremented. If the key is already
     *       in the table, its value is changed to the argument
     *       value and numKeys is not changed.
     * @param key The key of item being inserted
     * @param value The value for this key
     * @return The old value associated with this key if
     *         found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new LinkedList<Entry<K, V>>();
        }

        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            // If the search is successful, replace the old value.
            if (nextItem.key.equals(key)) {
                // Replace value for this key.
                V oldVal = nextItem.value;
                nextItem.setValue(value);
                return oldVal;
            }
        }

        // assert: key is not in the table, add new item.
        table[index].addFirst(new Entry<K, V>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length)) {
            reHash();
        }
        return null;
    }
    /*</listing>*/

    /** Returns true if empty */
    public boolean isEmpty()
    {
        return numKeys == 0;
    }


    void reHash()
    {
        LinkedList<Entry<K,V>>[] previous = table;
        table = new LinkedList[previous.length * 2 + 1];
        numKeys = 0;
        for (LinkedList<Entry<K, V>> list : previous)
        {
            if (list != null)
            {
                for (Entry<K,V> e : list)
                {
                    put(e.getKey(), e.getValue());
                    numKeys++;
                }
            }
        }
    }
    // Insert solution to programming project 7, chapter -1 here

    /** Clears the hashTable. */
    public void clear()
    {
        for (LinkedList<Entry<K,V>> list : table)
        {
            list = null;
        }
    }

    /** Returns the keys contained in the table */
    public Set<K> keySet()
    {
        Set<K> keySet = new HashSet<K>(size());
        for (LinkedList<Entry<K,V>> list : table)
        {
            for (Entry<K,V> e : list)
            {
                if (e != null)
                {
                    keySet.add(e.getKey());
                }
            }
        }
        return keySet;
    }

    /** Returns true if the table contains the key, false if not */
    public boolean containsKey(Object key)
    {
        int i = key.hashCode() % table.length;

        if (table[i] == null)
        {
            return false;
        }
        for (Entry<K,V> e : table[i])
        {
            if (e.getKey().equals(key))
            {
                return true;
            }
        }
        return false;
    }

    /** Abstract method. Not implemented */
    public void putAll(Map<? extends K, ? extends V> m)
    {
    }

    /** Returns the size of the table */
    public int size()
    {
        return numKeys;
    }

    /** Returns the values contained in the table */
    public Set<Map.Entry<K, V>> entrySet()
    {
        return new EntrySet();
    }

    /** Returns true if the table contains the object, false if not */
    public boolean containsValue(Object value)
    {
        for (LinkedList<Entry<K,V>> list : table)
        {
            for (Entry<K,V> e : list)
            {
                if (e.getValue().equals(value))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /** removes the key and any values associated with it */
    public V remove(Object key)
    {
        int i = key.hashCode() % table.length;

        if (i < 0)
        {
            i += table.length;
        }
        if (table[i] == null)
        {
            return null;
        }
        for (Entry<K, V> entry : table[i])
        {
            if (entry.getKey().equals(key))
            {
                V value = entry.getValue();
                table[i].remove(entry);
                numKeys--;

                if (table[i].isEmpty())
                {
                    table[i] = null;
                }
                return value;
            }
        }
        return null;
    }

    /** Abstract Method. Not implemented. */
    public Collection<V> values()
    {
        return null;
    }
}
