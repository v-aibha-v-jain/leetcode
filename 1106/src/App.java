import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.parseBoolExpr("&(|(f))"));
    }
}
class Solution {
    public boolean parseBoolExpr(String expression) {
    Stack<Character> st = new Stack<>(); // stack to store the characters
    char temp = ' ', op = ' '; // temp to store the result of the expression, op to store the operator  

    for(char ch : expression.toCharArray())
    {
      if(ch=='(' || ch==',') // ignore the brackets and commas
        continue; 
      if(ch=='t' || ch=='f' || ch=='!' || ch=='&' || ch=='|') // push the characters into the stack
        st.push(ch);
      else if (ch==')'){ // if we get the closing bracket
        boolean hasTrue = false, hasFalse=false; 
        while(st.peek()!='!' && st.peek()!='&' && st.peek()!='|') // pop the characters until we get the operator
        {
           char val = st.pop();
           if(val=='t')hasTrue = true;     
           if(val=='f')hasFalse=true;     
        }
        if(!st.isEmpty())
            op = st.pop();
        if(op=='!'){ // if the operator is not
            if(hasTrue)
                temp = 'f';
            else
                temp = 't';
        }
        else if(op=='&'){ // if the operator is and
            if(hasTrue==true && hasFalse==false)
                temp = 't';
            else temp = 'f';
        }  
        else if(op=='|'){ // if the operator is or
            if(hasTrue==true)
                temp = 't';
            else temp = 'f';
        }
        st.push(temp);
      } 
    }   
    return st.peek()=='t';
    }
}