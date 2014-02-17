/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hashtable;

/**
 *
 * @author nitroluke
 */
public class HashTableData {
    private int key;
    private String data;
    
    HashTableData(int key, String data){
        this.key = key;
        this.data = data;
    }
    
    public int getKey(){
        return key;
    }
    
    public String getData(){
        return data;
    }
}
