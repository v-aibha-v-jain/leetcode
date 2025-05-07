public class App {
    public static void main(String[] args) throws Exception {
        StockSpanner stockSpanner = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        for (int price : prices) {
            System.out.println("Price: " + price + ", Span: " + stockSpanner.next(price));
        }
    }
}

class StockSpanner {
    private static class Node {
        Node next; // Pointer to the next node in the stack
        int height; // Stock price
        int count; // Span count for the stock price
        static Node LAST = new Node(); // Sentinel node for the stack
        static {
            LAST.height = 0x7FFF_FFFF; // Set sentinel node height to max value
            LAST.count = 0; // Sentinel node count is 0
        }
    }

    private Node head = Node.LAST; // Initialize stack with the sentinel node

    private void insert(int height) {
        if (height == head.height) // If the current price equals the top of the stack
            head.count += 1; // Increment the span count
        else {
            Node n = new Node(); // Create a new node for the current price
            n.height = height; // Set the price
            n.count = 1; // Initialize span count to 1
            while (n.height >= head.height) { // Merge spans while the current price is greater or equal
                n.count += head.count; // Add the span count of the top node
                head = head.next; // Move to the next node
            }
            n.next = head; // Link the new node to the stack
            head = n; // Update the head to the new node
        }
    }

    public StockSpanner() {
    }

    public int next(int price) {
        insert(price); // Insert the price into the stack
        return head.count; // Return the span count for the current price
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */