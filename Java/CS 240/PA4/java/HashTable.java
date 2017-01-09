
 /**
 * COPYRIGHT: smanna@cpp.edu
 * CS 240 Spring 2016
 * Programming Assignment 4
 *
 * STUDENTS SHOULD COMPLETE THIS CODE.
 * You will upload this code to Blackboard.
 *
 * If you do not write enough comments, at least two points
 * will be deducted from your assignment. Also make sure you
 * follow the coding conventions.
 *
 *
 **/
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HashTable {
    public static void main(String[] args) throws Exception {
        HashTable hash = new HashTable(5);
        hash.put("Kansas city", 5.0);
        hash.put("Kansas city", 10.0);
        
        System.out.println(hash.getAverage("Kansas city"));
        System.out.println(hash.size());
    }
    // PLEASE DO NOT CHANGE THIS INNER CLASS
    // BEGIN INNER CLASS
    /**
     * Private Entry class
     * @param <K>
     * @param <V>
     */
    private class Entry<K, V> {
        private K key;
        private V value;
        private int count;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
            this.count++;
        }

        public int getCount() {
            return this.count;
        }
    }
    @SuppressWarnings("rawtypes")
    // END INNER CLASS
    LinkedList<Entry>[] HashTable;

    // TODO (student): necessary fields
    
    /**
     * Constructor to create a HashTable with desired size
     * @param tableSize         Size of the HashTable
     */
    @SuppressWarnings("unchecked")
    public HashTable(int tableSize) {
        // TODO (student): finish constructor
        HashTable = new LinkedList[tableSize];
    }

    /**
     * Put a pair of key and value into HashTable
     * @param key               Input key
     * @param value             Input value
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void put(String key, Double value) {
        // TODO (student): finish put() method
        Entry entry = new Entry(key, value);
        int code = Math.abs(key.hashCode());
        if(HashTable[code%HashTable.length] == null){
            HashTable[code%HashTable.length] = new LinkedList<Entry>();
            HashTable[code%HashTable.length].append(entry);
        }
        else {
            boolean b = true;
            for(int i = 0; i < HashTable[code%HashTable.length].size;i++) {
                Entry entry2 = HashTable[code%HashTable.length].readElemAt(i);
                if (entry2.getKey().toString().equals(key)){
                    entry2.setValue(value);
                    b = false;
                    break;
                }
            }
            if (b) {
                HashTable[code%HashTable.length].append(entry);
            }
        }
    }

    /**
     * Get the entry from HashTable via its key
     * @param key               Key of the entry
     * @return                  Entry if exist, null otherwise
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Entry<String, Double> get(String key) {
        // TODO (student): finish get() method
        Entry entry = null;
        int code = Math.abs(key.hashCode());
        if (HashTable[code%HashTable.length] == null)
            return null;
        else {
            for(int i = 0; i < HashTable[code%HashTable.length].size; i++) {
                entry = HashTable[code%HashTable.length].readElemAt(i);
                if (entry.getKey().toString().equals(key))
                    return entry;
            }
        }
        return null;
    }

    /**
     * Delete the entry via its key. Do nothing if the entry does not exist
     * @param key               Key of the entry
     */
    @SuppressWarnings("rawtypes")
    public void delete(String key) {
        // TODO (student): finish delete() method
        if(containsKey(key)){
            for(int i = 0; i < HashTable.length; i++){
                for(int j = 0; j < HashTable[i].size; j++) {
                    Entry entry = HashTable[i].readElemAt(j);
                    if (entry.getKey().toString().equals(key))
                        HashTable[i].deleteElemAt(j);
                }
            }
        }
    }

    /**
     * Check if HashTable has the entry
     * @param key               Key of the entry
     * @return                  True: entry exists; False: entry does not exist
     */
    @SuppressWarnings("rawtypes")
    public boolean containsKey(String key) {
        // TODO (student): finish containsKey() method
        if(!isEmpty()){
            for(int i = 0; i < HashTable.length; i++){
                if(HashTable[i] != null){
                    for(int j = 0; j < HashTable[i].size; j++) {
                        Entry entry = HashTable[i].readElemAt(j);
                        if (entry.getKey().toString().equals(key))
                            return true;
                    }                    
                }
            }            
        }
        return false; // make sure to make necessary changes
    }

    /**
     * Check if the HashTable is empty
     * @return                  True: is empty; False: not empty
     */
    public boolean isEmpty() {
        // TODO (student): finish isEmpty() method
        
        return size() == 0; // make sure to change this as required
    }

    /**
     * Return the number of elements in the HashTable
     * @return                  Number of elements
     */
    public int size() {
        // TODO (student): finish size() method
        int size = 0;
        for(int i = 0; i < HashTable.length; i++){
            if(HashTable[i] != null)
                size += HashTable[i].size;
        }
        return size; // make sure you change this
    }


    /**
     * Get the average score for corresponding name
     * @param key               Input key (name)
     */
    @SuppressWarnings("rawtypes")
    public Double getAverage(String key) throws Exception{
        // TODO (student): get the average score
        if (containsKey(key)) {
            Entry entry = get(key);
            double average = (Double)entry.getValue()/entry.getCount();
            return average;
        }
        return 0.0; // make sure you change this
    }

    /**
     * Parse all the files in the path folder and put the name/score
     * pair into HashTable
     * @param path Path to the name/score files
     */
    public void hashing(String path) throws IOException {
        // process all the files
        File[] files = new File(path).listFiles();
        for (File file : files) {
            FileReader fr = new FileReader(file);
            try (BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    String name = line.replaceAll("[0-9]+", "").trim();
                    String score = line.replaceAll("[a-zA-Z\\. ]+", "").trim();

                    // add score to the name
                    if (containsKey(name))
                        put(name, (get(name).getValue() + Double.valueOf(score)));
                    else
                        put(name, Double.valueOf(score));
                }
            }
        }
    }

}
