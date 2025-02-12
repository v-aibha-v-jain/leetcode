import java.util.Collections;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
class MedianFinder {
    private PriorityQueue<Double> small; // max-heap for the smaller half
    private PriorityQueue<Double> large; // min-heap for the larger half

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        large = new PriorityQueue<>(); // min-heap
    }

    public void addNum(int num) {
        if (small.isEmpty() || small.peek() >= num) { // if small is empty or num is less than or equal to max of small
            small.add((double) num); // add num to small
        } else {
            large.add((double) num); // add num to large
        }
        if (small.size() > large.size() + 1) { // if small has more than one extra element
            large.add(small.poll()); // move the max of small to large
        } else if (large.size() > small.size()) { // if large has more elements
            small.add(large.poll()); // move the min of large to small
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) { // if both heaps are of equal size
            return (large.peek() + small.peek()) / 2; // median is the average of max of small and min of large
        }
        return small.size() > large.size() ? small.peek() : large.peek(); // median is the max of small or min of large
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */