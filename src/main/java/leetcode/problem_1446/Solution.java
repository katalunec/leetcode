package leetcode.problem_1446;

public class Solution {
   public static void main(String[] args) {
      System.out.println(new Solution().maxPower("tourist"));
   }

   public int maxPower(String s) {

      Character lastLetter = null;
      int occurrences = 0;
      int power = 1;

      for (int i = 0; i < s.length(); i++) {
         Character letter = s.charAt(i);
         occurrences++;

         if (letter == lastLetter) {
            if (occurrences >= power) {
               power = occurrences;
            }
         } else {
            occurrences = 1;
         }

         lastLetter = letter;
      }

      return power;
   }
}
