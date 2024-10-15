package Mediumtasks;

public class MinimumSteps {
     class Solution{
         public long minSteps(String s) {
            var i = 0;
            var result = 0L;

            for (var j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '0'){
                    result+= j - i;
                    i++;
                }
            }
            return result;
         }
     }
}
