import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj=new Solution();
        String[] folder={"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> result=obj.removeSubfolders(folder);
        for(String s:result){
            System.out.println(s);
        }
    }
}
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder); // sort the array
        List<String> result=new ArrayList<>();
        for(String f:folder){ // iterate through the array
            boolean doesnotExist=true; // check if the folder does not exist
            for(String c:result){ // iterate through the result
                if(f.startsWith(c) && (f.length()==c.length() || f.charAt(c.length())=='/')){ // check if the folder is a subfolder
                    doesnotExist=false;
                    break;
                }
            }
            if(doesnotExist){
                result.add(f); // if the folder does not exist, add it to the result
            }
        }
        return result;
    }
}