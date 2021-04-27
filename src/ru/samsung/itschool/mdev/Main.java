package ru.samsung.itschool.mdev;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        TreeMap<String, TreeMap<String, Integer>> users = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] result = line.split(" ");
            String name = result[0];
            String product = result[1];
            int count = Integer.parseInt(result[2]);
            if(users.containsKey(name)) {
                if(users.get(name).containsKey(product)) {
                    Integer cnt  = users.get(name).get(product);
                    users.get(name).put(product,count+cnt);
                } else {
                    users.get(name).put(product,count);
                }
            } else {
                TreeMap<String,Integer> buff = new TreeMap<>();
                buff.put(product,count);
                users.put(name,buff);
            }

        }
        for(Map.Entry entry: users.entrySet()) {
            System.out.println(entry.getKey() + ":");
            TreeMap<String, Integer> user = (TreeMap)entry.getValue();
            for(Map.Entry e1: user.entrySet()) {
                System.out.println(e1.getKey() + " " + e1.getValue());
            }
        }
    }
}
