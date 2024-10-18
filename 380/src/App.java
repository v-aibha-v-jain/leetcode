import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }
}


class RandomizedSet {
    List<Integer> l; // to store the elements
    HashMap<Integer,Integer> hash; // to store the index of the elements
    public RandomizedSet() {
        hash=new HashMap<>();
        l=new ArrayList<>();
    }
    public boolean insert(int val) {
        if(hash.containsKey(val)) return false; // if the element is already present
        l.add(val);
        hash.put(val,l.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hash.containsKey(val)) return false; // if the element is not present
        int pos=hash.get(val);
        Collections.swap(l,pos,l.size()-1); // swap the element with the last element
        hash.put(l.get(pos),pos); // update the index of the swapped element
        l.remove(l.size()-1);  // remove the last element
        hash.remove(val); // remove the element from the hash map
        return true;
    }
    
    public int getRandom() {
        Random r=new Random();
        int n=r.nextInt(l.size()); // generate random number between 0 and size of the list
        return l.get(n);
    }
}