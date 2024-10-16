public class App {

    public String longestDiverseString(int a, int b, int c) {

        StringBuilder sb = new StringBuilder(); // StringBuilder is more efficient than String concatenation
        int contA = 0, contB = 0, contC = 0;
        int total = a + b + c;
        for (int i = 0; i < total; i++) {
            if ((a >= b && a >= c && contA != 2) || ((contB == 2 || contC == 2) && a > 0)) { // if a is the biggest and we haven't used it twice
                sb.append("a");
                a--;
                contA++;
                contB = 0;
                contC = 0;
            } else if ((b >= a && b >= c && contB != 2) || ((contA == 2 || contC == 2) && b > 0)) { // if b is the biggest and we haven't used it twice
                sb.append("b");
                b--;
                contB++;
                contA = 0;
                contC = 0;
            } else if ((c >= a && c >= b && contC != 2) || ((contA == 2 || contB == 2) && c > 0)) { // if c is the biggest and we haven't used it twice
                sb.append("c");
                c--;
                contC++;
                contA = 0;
                contB = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.longestDiverseString(1, 1, 7));
    }
}
