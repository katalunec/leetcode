package leetcode.problem_1189;

import java.util.HashMap;
import java.util.Map;

class Solution {
   public static void main(String[] args) {
      System.out.println(new Solution().maxNumberOfBalloons("lloo"));
   }

   public int maxNumberOfBalloons(String text) {
      String term = "balloon";
      Map<Character, Integer> termLetters = new HashMap<>();

      for (int i = 0; i < term.length(); i++) {
         char letter = term.charAt(i);

         Integer occurrences = termLetters.get(letter);

         if (occurrences == null) {
            occurrences = 0;
         }

         occurrences++;

         termLetters.put(letter, occurrences);
      }

      Map<Character, Integer> textLetters = new HashMap<>();

      for (int i = 0; i < text.length(); i++) {
         char letter = text.charAt(i);

         if (!termLetters.containsKey(letter)) {
            // skip the letters in which we are not interested.
            continue;
         }

         Integer occurrences = textLetters.get(letter);

         if (occurrences == null) {
            occurrences = 0;
         }

         occurrences++;

         textLetters.put(letter, occurrences);
      }

      int termOccurrences = Integer.MAX_VALUE;

      for (char letter : termLetters.keySet()) {
         Integer textLetterOccurrences = textLetters.get(letter);

         if (textLetterOccurrences == null || textLetterOccurrences == 0) {
            termOccurrences = 0;
            break;
         }

         int termLetterOccurrences = termLetters.get(letter);

         int temp = textLetterOccurrences / termLetterOccurrences;

         if (temp < termOccurrences) {
               termOccurrences = temp;
         }
      }

      return termOccurrences;
   }
}
