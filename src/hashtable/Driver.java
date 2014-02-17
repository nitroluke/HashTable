/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author nitroluke
 */
public class Driver {

//    Scanner in;
    public Driver() throws FileNotFoundException {
//        this.in = new Scanner(new FileReader(""));
    }

    public static void main(String[] args) throws FileNotFoundException {
        int key = 0;
        String data;
        Scanner in = new Scanner(new FileReader("C://Users/nitroluke/desktop/values.txt"));
        HashTable HT = new HashTable();
        while (in.hasNext()) {
            key = in.nextInt();
            data = in.next();   
            System.out.println("trying to add " + key + " " + data);
            HT.add(key, data,HT.table);  

//            int i = 0;
//            for (HashTableData table : HT.table) {
//                if (table == null) {
//                    System.out.println("Position " + i + " is null");
//                } else {
//                    System.out.println("in position " + i + " is " + table.getData() + "(" + table.getKey() + ")");
//                    i++;
//                }
//            }
        }
    }

}


