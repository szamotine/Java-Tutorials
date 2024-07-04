package Codex;

import Codex.A.MyHashMap;

public class Main {

    public static void main(String[] args)
    {
        MyHashMap<String, Integer>  hashA = new MyHashMap<>();

        Codex.B.MyHashMap<String, Integer> hashB = new Codex.B.MyHashMap<>();

        int val1 = 15;
        int val2 = 26;

        String key1 = "doctor";
        String key2 = "lawyer";

        String [] keys = {key1, key2};



        hashA.put(key1, val1);
        hashA.put(key2, val2);

        hashB.put(key1, val1);
        hashB.put(key2, val2);


        System.out.println("Hash A:");
        for(String item: keys){
            System.out.println("The value for key[" + item + "] is: " + hashA.get(item).toString());
        }

        System.out.println("Hash B:");
        for(String item: keys){
            System.out.println("The value for key[" + item + "] is: " + hashB.get(item).toString());
        }

    }
}
