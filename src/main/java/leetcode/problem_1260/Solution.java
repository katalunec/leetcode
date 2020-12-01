package leetcode.problem_1260;

import java.util.ArrayList;
import java.util.List;

public class Solution {
   public static void main(String[] args) {
      int[][] grid = new int[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 7 }, { 6 }, { 5 } };
      System.out.println(new Solution().shiftGrid(grid, 23));
   }

   public List<List<Integer>> shiftGrid(int[][] grid, int k) {

      int m = grid.length;
      int n = grid[0].length;

      List<List<Integer>> result = new ArrayList<>(m);

      for (int[] cols : grid) {
         List<Integer> resultCols = new ArrayList<>();
         for (int col : cols) {
            resultCols.add(col);
         }
         result.add(resultCols);
      }

      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            int offset = j + k;
            int newCol = offset % n;
            int newRow = (offset / n + i) % m;

            int value = grid[i][j];

            List<Integer> cols = result.get(newRow);
            cols.set(newCol, value);
         }
      }

      return result;
   }
}
