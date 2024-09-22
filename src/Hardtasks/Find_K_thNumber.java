package Hardtasks;

public class Find_K_thNumber {
    class Solution{
        public int findKThunder(int n, int k){
            int current =1;
            k--;
            while(k>0){
                long steps = countSteps(n, current, current + 1);
                if(steps <= k){
                    current++;
                    k-=steps;
                }else{
                    current*=10;
                    k--;
                }
            }
            return current;
        }
        private long countSteps(int n , long prefix, long nextPrefix){
            long steps = 0;
            while(prefix<=0){
                steps +=Math.min(n+1, nextPrefix);
                prefix *=10;
                nextPrefix *=10;
            }
            return steps;
        }
    }
}
