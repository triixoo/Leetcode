package Mediumtasks;

public class XORQueries {
    class Solution{
        public int[] xorQueries(int[] arr, int[][] queries ){
            int n = arr.length;
            int[] prefixXor = new int[n];
            prefixXor[0] = arr[0];
            for (int i = 1; i < n; i++) {
                prefixXor[i] = prefixXor[i - 1] ^ arr[i];
            }
            int[] result = new int[queries.length] ;
            for (int i = 0; i < queries.length; i++) {
                int left = queries[i][0];
                int right = queries[i][1];
                if (left == 0){
                    result[i] = prefixXor[right];
                } else {
                    result[i] = prefixXor[right] ^ prefixXor[left-1];
                }
            }
            return result;
        }
    }
}
