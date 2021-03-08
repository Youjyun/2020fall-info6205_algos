package edu.northeastern.info6205;

public class Solution {
    /**
     * @param array: an integer array
     * @return: nothing
     */
    public List<Integer> pancakeSort(int[] array) {
        
    	 int len = A.length;
         List<Integer> res = new ArrayList<>();
         for(int end=len-1;end>0;end--){
             int k = findMaxIndex(A,end) + 1;
             res.add(k);
             fan(A,end);
             res.add(end+1);
         }
         return res;
     }
     void fan(int[] A,int k){
         int temp = 0;
         for(int i=0,j=k;i<j;i++,j--){
             temp = A[i];
             A[i] = A[j];
             A[j] = temp;
         }
     }
     int findMaxIndex(int[] A,int end){
         int maxi = 0;
         for(int i=0;i<=end;i++){
             maxi = A[maxi]<A[i]?i:maxi;
         }
         fan(A,maxi);
         return maxi;
     }
    }
}