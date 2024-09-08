package Mediumtasks;

import java.util.ArrayList;
import java.util.List;
public class GenerateParentheses {
    class Solution{
        public List<String> generateParenthesis(int n){
            List<String> result = new ArrayList<>();
            generateCombinations(result, "", n, n);
            return result;
        }
        private void generateCombinations(List<String> result, String current, int open, int close ){
            if (open ==0 && close ==0){
                result.add(current);
                return;
            }
            if (open > 0){
                generateCombinations(result, current + "(", open -1, close);
            }
            if (close > open){
                generateCombinations(result, current + ")", open, close -1);
            }
        }
    }

}
