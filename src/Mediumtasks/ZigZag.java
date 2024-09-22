package Mediumtasks;

public class ZigZag {
    class Solution{
        public String convert(String s, int numRows){
            if (numRows ==1 ){
                return s;
            }
            StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
            for (int i = 0; i < rows.length; i++) {
                rows[i] = new StringBuilder();
            }
            int currentRow = 0;
            boolean goingD = false;
            for (char c : s.toCharArray()){
                rows[currentRow].append(c);
                if(currentRow == 0 || currentRow == numRows -1){
                    goingD = !goingD;
                }
                currentRow+= goingD? 1: -1;
            }
            StringBuilder result = new StringBuilder();
            for (StringBuilder row : rows){
                result.append(row);
            }
            return result.toString();
        }
    }
}