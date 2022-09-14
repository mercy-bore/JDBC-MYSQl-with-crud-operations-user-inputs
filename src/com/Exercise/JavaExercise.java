package com.Exercise;
import java.util.*;

public class JavaExercise {
//    Write a Java program to copy all elements of Java HashSet to an Object Array. (3 mks)
    public static void JavaHashset(){
        Set<Integer> hs = new HashSet<>();
        hs.add(15);
        hs.add(71);
        hs.add(82);
        hs.add(89);
        hs.add(91);
        hs.add(93);
        hs.add(97);
        hs.add(99);
        System.out.println("Elements in set = "+hs);
        System.out.println("Copying all elements...");
        Object[] obArr = hs.toArray();
        for (Object ob : obArr)
            System.out.println(ob);

    }

//    Write a Java program to get the size of a tree set. (2 mk)
    public static void FindSize(){
        // Creating an empty TreeSet
        TreeSet<String> tree = new TreeSet<>();

        // Use add() method to add elements into the Set
        tree.add("Welcome");
        tree.add("To");
        tree.add("Java");
        tree.add("4");
        tree.add("Geeks");
        tree.add("TreeSet");

        // Displaying the TreeSet
        System.out.println("TreeSet: " + tree);

        // Displaying the size of the set
        System.out.println("The size of the set is: " + tree.size());


    }
//    Write a Java program to get the lowest and the highest values from a tree set (2 mks)
    public static void LowHighValue(){
        // Create a TreeSet and populate it with elements
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(9);
        treeSet.add(11);
        treeSet.add(7);
        treeSet.add(4);

        // Object first() returns the lowest value in the TreeSet
        System.out.println("Lowest value in TreeSet is : "  + treeSet.first());

        // Object last() returns the highest value in the TreeSet
        System.out.println("Highest value in TreeSet is : " + treeSet.last());


    }
//    Write a Java program to check if a particular value exist in a hashmap (2 mk)
    public boolean  ValueInHashmap(int valueToBeChecked){
        {

            // initializing the HashMap
            HashMap<String, Integer> hashMap = new HashMap<>();

            // filling up the HashMap with
            // Key-Value pairs
            hashMap.put("key1", 1);
            hashMap.put("key2", 2);
            hashMap.put("key3", 3);
            hashMap.put("key4", 4);

            // for each loop
            // all the entries in the HashMap are
            // stored in the Map
            for (Map.Entry<String, Integer> mapEntries :
                    hashMap.entrySet()) {

                // fetching the values of the HashMap
                // one at a time and comparing with
                // the value to be checked
                if (mapEntries.getValue() == valueToBeChecked)
                    return true;
            }
            return false;

        }

    }
//    Write a Java program to iterate keys of hashmap (2 mks)
    public static void iterateHashmap(){
        Map<String, String> foodTable = new HashMap<>();

        // Inserting elements to the adobe HashMap
        // Elements Key value pairs using put() method
        foodTable.put("A", "Angular");
        foodTable.put("J", "Java");
        foodTable.put("P", "Python");
        foodTable.put("H", "Hibernate");

        // Iterating HashMap through for loop
        for (Map.Entry<String, String> set :
                foodTable.entrySet()) {

            // Printing all elements of a Map
            System.out.println(set.getKey() + " = "
                    + set.getValue());
        }

    }
//    Write a Java program to add an element at a specific index of an ArrayList (2 mk)
    public static void addElementToArraylist(){
        // Creating an ArrayList
        ArrayList<String> list = new ArrayList<>();

        // Adding elements to ArrayList
        // using add method for String ArrayList
        list.add("A");
        list.add("B");
        list.add("C");

        /* Index is zero based */

        // 3 gets added to the 1st position
        list.add(1, "D");

        // 4 gets added to the 2nd(position)
        list.add(2, "E");

        // Displaying elements in ArrayList
        System.out.println(list);

    }


    public static void main(String[] args) {
        JavaExercise ob = new JavaExercise();
        System.out.println("Quiz 1");
        System.out.println(ob.ValueInHashmap(2));
        System.out.println();

        System.out.println("Quiz 2");
        JavaHashset();
        System.out.println();

        System.out.println("Quiz 3");
        FindSize();
        System.out.println();

        System.out.println("Quiz 4");
        LowHighValue();
        System.out.println();

        System.out.println("Quiz 5");
        iterateHashmap();
        System.out.println();


        System.out.println("Quiz 6");
        addElementToArraylist();
        System.out.println();

    }
}
