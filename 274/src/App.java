import java.util.Arrays;

public class App {

    public int hIndex(int[] citations) {
        int n  = citations.length;
        Arrays.sort(citations);
        int index=0;
        for(int i=0;i<n;i++){
            int h = n-i;
            if(citations[i]>=h){
                index = h;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        int[] citations = {3,0,6,1,5};
        System.out.println(app.hIndex(citations));
    }
}
