package leetcode.problem_1518;

public class Solution {
   public static void main(String[] args) {
      System.out.println(new Solution().numWaterBottles(15, 4));
   }

   public int numWaterBottles(int numBottles, int numExchange) {
      int waterBottles = 0;
      int remainder = 0;

      while (numBottles != 0) {
         waterBottles += numBottles;

         int newRemainder = (numBottles + remainder) % numExchange;

         numBottles = (numBottles + remainder) / numExchange;

         remainder = newRemainder;
      }

      return waterBottles;
   }
}
