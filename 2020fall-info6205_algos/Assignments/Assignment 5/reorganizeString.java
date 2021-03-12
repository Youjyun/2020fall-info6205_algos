package edu.northeastern.info6205;

import java.util.Map;

class Solution {
	
    public String reorganizeString(String S) {
      // build a hashmap to store characters and its frequencies:
      Map<Character, Integer> freq_map = new HashMap<>();
      for(char c :S.toCharArray()) {
    	  freq_map.put(c, freq_map.getOrDefault(c, 0)+1);
      }
      // put the char of freq_map into the maxheap with sorting the frequencies by large->small
      PriorityQueue<Chracter> maxheap = new PriorityQueue<>(
    		  (a,b) -> freq_map.get(b) - freq_map(a)
      );
   // addAll() is adding more then one element to heap
      maxheap.addAll(freq_map.keySet());
      
      StringBuilder sb = new StringBuilder();
      while(maxheap.size()>1) {
    	  char first= maxheap.poll();
    	  char second = maxheap.poll();
    	  sb.append(first);
    	  sb.append(second);
    	  
    	  freq_map.put(first,freq_map.get(first)-1 );
    	  freq_map.put(second,freq_map.get(second)-1 );
    	  
    	  if (freq_map.get(first) > 0) {
              maxheap.offer(first);
          }
          if (freq_map.get(second) > 0) {
              maxheap.offer(second);
          }
      }
      
      if (!maxheap.isEmpty()) {
          // when there is only 1 element left in the maxheap
          // check the count, it should not be greater than 1
          // otherwise it would be impossible and should return ""
          if (freq_map.get(maxheap.peek()) > 1) {
              return "";
          }
          else {
              sb.append(maxheap.poll());
          }
      }
      
      
      
      
      
      
    }
}
