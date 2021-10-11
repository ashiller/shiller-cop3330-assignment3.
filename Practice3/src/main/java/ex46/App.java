/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Anthony Shiller
 */

package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        ReadInputFile rf = new ReadInputFile();
        rf.readfile();
        HashMap<String, Integer> map = rf.getMap();
        PrintReport pr = new PrintReport(map);
        pr.printScreen();
    }
}
class ReadInputFile{
    private Scanner sc;
    private File file;
    private HashMap<String, Integer> map;
    public ReadInputFile() throws FileNotFoundException {
        file = new File("C:\\Users\\Ankit\\Desktop\\exercise46_input.txt");
        sc = new Scanner(file);
        map = new HashMap<String,Integer>();
    }
    public void readfile() {
        try
        {
            while( sc.hasNext() )
            {
                String input = sc.nextLine();
                String arr[] = input.split(" ");
                for(int i=0;i<arr.length;i++) {
                    String key = arr[i];
                    if(map.containsKey(key)) {
                        int value = map.get(key);
                        value++;
                        map.put(key, value);
                    }
                    else {
                        map.put(key, 1);
                    }
                }
            }
        }
        finally
        {
            sc.close();
        }
    }
    public HashMap<String, Integer> getMap(){
        return map;
    }
}
class PrintReport{
    private HashMap<String, Integer> map;
    public PrintReport( HashMap<String, Integer> map) {
        this.map = map;
    }
    public void printScreen() {
        String keys[] = new String[map.size()];
        Integer values[] = new Integer[map.size()];
        int k=0;
        for (Entry<String, Integer> entry : map.entrySet()) {
            keys[k] = entry.getKey();
            values[k++] = entry.getValue();
        }
        int tempvalues[] = new int[map.size()];
        String tempkeys[] = new String[map.size()];
        for(int i=0;i<values.length;i++) {
            tempvalues[i] = values[i];
        }
        Arrays.sort(values, Collections.reverseOrder());
        for(int i=0; i<map.size();i++) {
            int value = values[i];
            for(int j=0; j<tempvalues.length;j++) {
                if(value == tempvalues[j]) {
                    tempkeys[i] = keys[j];
                    break;
                }
            }
        }
        System.out.println();
        for(int i=0;i<map.size();i++) {
            int value = map.get(tempkeys[i]);
            System.out.print(tempkeys[i]+" : \t");
            for(int j=0; j<value; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
