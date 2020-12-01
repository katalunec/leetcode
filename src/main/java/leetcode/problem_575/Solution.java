package leetcode.problem_575;

import java.util.HashSet;
import java.util.Set;

public class Solution {

   public static void main(String[] args) {
      System.out.println(new Solution().distributeCandies(new int[] {1,1,2,2,3,3}));
   }

   public int distributeCandies(int[] candyTypes) {
      int maxAllowedCandies = candyTypes.length / 2;

      Set<Integer> uniqueCandyTypes = new HashSet<>();

      for (int candyType : candyTypes) {
         uniqueCandyTypes.add(candyType);

         if (uniqueCandyTypes.size() >= maxAllowedCandies) {
            return uniqueCandyTypes.size();
         }
      }

      return Math.min(maxAllowedCandies,uniqueCandyTypes.size());
   }
}
