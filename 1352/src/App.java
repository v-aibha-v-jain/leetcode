import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ProductOfNumbers obj = new ProductOfNumbers();
        obj.add(3);
        obj.add(0);
        obj.add(2);
        obj.add(5);
        obj.add(4);
        System.out.println(obj.getProduct(2));
        System.out.println(obj.getProduct(3));
        System.out.println(obj.getProduct(4));
        obj.add(8);
        System.out.println(obj.getProduct(2));
    }
}
class ProductOfNumbers {
    ArrayList<Integer> list; // list to store the cumulative product
    int prod = 1; // variable to store the current product

    public ProductOfNumbers() {
        list = new ArrayList<>(); // initialize the list
    }
    
    public void add(int num) {
        if(num == 0){
            list = new ArrayList<>(); // reset the list if num is 0
            prod = 1; // reset the product if num is 0
            return;
        }
        prod = prod * num; // update the product
        list.add(prod); // add the current product to the list
    }
    
    public int getProduct(int k) {
        if(list.size() < k) return 0; // if k is greater than the size of the list, return 0
        int ans = list.get(list.size() - 1); // get the last element in the list
        if(list.size() == k) return ans; // if k is equal to the size of the list, return the last element
        return ans / list.get(list.size() - 1 - k); // return the product of the last k elements
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */