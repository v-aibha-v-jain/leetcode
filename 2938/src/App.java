public class App {

    public long minimumSteps(String s) {
        int n = s.length();
        for(int i = 0; i < n; i++) { // Loop through each character in the string
            if(s.charAt(i) == '1') { // Check if the current character is '1'
                return i + 1; // Return the position (1-based index) of the first '1'
            }
        }
        return 0; // Return 0 if no '1' is found in the string
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        String s = "1101";
        System.out.println(app.minimumSteps(s));
    }
}
