class Test {

    public static void main(String[] args) throws Exception {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 3, 5}; // Initialize an array with repeated elements
        Test t = new Test();
        System.out.println(t.removeDuplicates(nums)); // Call the removeDuplicates method and print the result
    }

    public int removeDuplicates(int[] nums) {
        int arrlen = 0; // Initialize a variable to track the length of the modified array
        int count = 0; // Initialize a variable to count occurrences of the current value
        int value = nums[0]; // Store the first element of the array

        for (int val : nums) { // Iterate through each element in the array
            if (value == val) { // If the current element is equal to the stored value
                count++;
            } else { // If the current element is different from the stored value
                count = 1; // Reset the count to 1
                value = val; // Update the stored value
            }

            if (count <= 2) { // If the count of occurrences is less than or equal to 2
                nums[arrlen++] = val; // Add the current element to the modified array and increment the length
            }
        }

        return arrlen;
    }
}