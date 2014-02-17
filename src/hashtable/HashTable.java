package hashtable;
import java.util.Iterator;

/**
 *
 * @author nitroluke
 */
public class HashTable {
    public final int dummy = -99;
    public int size = 5;
    private int count = 0;
    public  HashTableData[] table = new HashTableData[size];

    public int code(int key) {
        return Math.abs(key % size);
    }

    public boolean add(int key, String data, HashTableData[] array) {
        int hashCode = code(key);  // finding the hash value for placement
        int finder;
        
        if((count/array.length) >= .8){
            finder = -1;
            System.out.println("We need to reHash the array");
            System.out.println("The current Array size is " + array.length);
            count = 0;
            reHash(array);
        }
        else if (array[hashCode] == null) { // the array spot is empty insert it
            System.out.println(key + " and " + data + " was placed in position " + hashCode);
            array[hashCode] = new HashTableData(key, data);
            count = count + 1;
            finder = -1;
        } else { 
            if (hashCode == (table.length - 1)) {// initialize finder to the next spot in the array
                System.out.println("We are at the end of the array, going back to position 0");
                finder = 0;
            } else {
                finder = hashCode++;
            }
        }
        while(finder != -1){
//        while ((finder != -1) && (finder != hashCode)) {
            System.out.println("finder = " + finder);
            if ((array[finder] == null)) { //if the spot is empty add the data
                array[finder] = new HashTableData(key, data);
                count++;
                System.out.println(key + " and " + data + " was placed in position " + finder);
                finder = -1;
            } else { // go to the next item
                if (finder == (array.length - 1)) {  // if we are at the end of the array
                    System.out.println("We have reached the end of the array");
                    finder = 0;
                } else { //increment finder and keep doing the loop
                    System.out.print("You cannot place at position " + finder + " the new finder number = ");
                    finder++;
                    System.out.println(finder);
                }
            }
            
        }
        if (finder != -1) { // the data was not stored
//            System.out.println("The data was not stored");
            return false;
        } else { // the data was stored
//            System.out.println("The data was stored");
            return true;
        }
        
    }
    
    public String search(int key){
        int finder;
        int hashCode = code(key);
        
        if(table[hashCode] == null){
            return null;
        }else if(table[hashCode].getKey() == key){
            return table[hashCode].getData();
        }else{
            if(hashCode == (table.length - 1)){  // if you are at the end of the array go back to the beginning
                finder = 0;
            }else{ // go to the next spot in the array
                finder = hashCode++;
            }
        }
        
        while((finder != -1) && (finder != hashCode)){
            if(table[finder] == null){ // if the position is empty, return
                return null;
            }else if(table[finder].getKey() == key){  // if the position holds the value return the data
                return table[finder].getData();
            }else{ // else go to the next position in the array
                if(finder == (table.length - 1)){
                    finder = 0;
                }else{
                    finder++;
                }
            }
        }
        System.out.println("The data you are looking for does not exist");
        return null; 
    }
    
    public void remove(int key){
        int finder;   // iterator
        // use the dummy 
        int hashCode = code(key); // find the position in the array to find it
        
        if(table[hashCode] == null){ // there is nothing to delete
            System.out.println("You cannot delete a value that is not there");
        }else if(table[hashCode].getKey() == key){  // you found the value, replace the value in there with a placeholder
            table[hashCode] = new HashTableData(dummy, "");
        }else{ // keep looking for the value
            if(hashCode == (table.length - 1)){ // you are at the end of the array
                finder = 0;
            }else{
                finder = hashCode++;
            }
                // possibly add another while loop in here
        }
    }

    
    public void reHash(HashTableData[] array){
        size *= 2;
        HashTableData[] reHashTable = new HashTableData[size];
        for(int i = 0; i < table.length/2; i++){
            if(array[i] == null){
                i++;
            }else{
                add(array[i].getKey(),array[i].getData(),reHashTable);
            }
            i++;
        }
        table = reHashTable;
        
    }
}
