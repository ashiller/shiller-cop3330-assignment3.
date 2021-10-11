/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Anthony Shiller
 */

package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.print("\nEnter the output file : ");
        String outputfile = s.next();
        ReadFile rf = new ReadFile();
        rf.readile();
        ArrayList<String> list = rf.getdata();
        WriteFile wr = new WriteFile(outputfile, list);
        wr.writefile();
        System.out.println("\nThe Number of Modifications are : "+wr.getModification());
    }
}
class ReadFile{
    private ArrayList<String> list;
    private Scanner sc;
    public ReadFile() throws FileNotFoundException {
        list = new ArrayList<String>();
        File file = new File("C:\\Users\\Ankit\\Desktop\\exercise45_input.txt");
        sc = new Scanner(file);
    }
    public void readile() {
        try
        {
            int i=0;
            while( sc.hasNext() )
            {
                String filedata = sc.nextLine();
                list.add(filedata);
            }
        }
        finally
        {
            sc.close();
        }
    }
    public ArrayList<String> getdata() {
        return list;
    }
}
class WriteFile{
    private FileWriter writer;
    private int count_Modification;
    private ArrayList<String> list;
    public WriteFile(String name, ArrayList<String> list) throws IOException {
        writer = new FileWriter("C:\\Users\\Ankit\\Desktop\\"+name);
        this.list = list;
    }
    public void writefile() throws IOException {
        for(int i=0;i<list.size();i++) {
            String temp = list.get(i);
            String str = "utilize";
            int index = 0;
            while (true)
            {
                index = temp.indexOf(str, index);
                if (index != -1)
                {
                    count_Modification ++;
                    index += str.length();
                }
                else {
                    break;
                }
            }
            temp = temp.replaceAll("utilize", "use");
            writer.write(temp+"\n");
        }
        writer.close();
    }
    public int getModification() {
        return count_Modification;
    }
}
