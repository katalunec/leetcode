package leetcode.problem_1254;

public class Solution {
   private static int BORDER = -1;
   private static int WATER = 1;
   private static int LAND = 0;
   private static int VISITED = 2;

   public static void main(String[] args) {
      System.out.println(new Solution().closedIsland(new int[][]{
            {1,1,1,1,1,1,1,0},
            {1,0,0,0,0,1,1,0},
            {1,0,1,0,1,1,1,0},
            {1,0,0,0,0,1,0,1},
            {1,1,1,1,1,1,1,0}
      }));
   }

   public int closedIsland(int[][] grid) {
      grid = withBorder(grid);
      int m = grid.length;
      int n = grid[0].length;

      int closedIslands = 0;

      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            int value = grid[i][j];

            if (value == BORDER || value == WATER || value == VISITED) {
               continue;
            }

            if (isClosedIsland(grid, i, j)) {
               closedIslands++;
            }
         }
      }

      return closedIslands;
   }

   private boolean isClosedIsland(int[][] grid, int i, int j) {
      int value = grid[i][j];

      if (value == BORDER) {
         return false;
      }

      if (value == VISITED || value == WATER) {
         return true;
      }

      grid[i][j] = VISITED;

      boolean top = isClosedIsland(grid, i - 1, j);
      boolean down = isClosedIsland(grid, i + 1, j);
      boolean left = isClosedIsland(grid, i, j - 1);
      boolean right = isClosedIsland(grid, i, j + 1);

      return top && down && left && right;
   }

   private int[][] withBorder(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int newM = m + 2;
      int newN = n + 2;

      int[][] newGrid = new int[newM][];

      int i = 0;

      newGrid[i++] = border(newN);

      for (int[] cols : grid) {
         int j = 0;
         int[] row = new int[newN];

         row[j++] = BORDER;
         for (int col : cols) {
            row[j++] = col;
         }
         row[j] = BORDER;

         newGrid[i++] = row;
      }

      newGrid[i] = border(newN);

      return newGrid;
   }

   private int[] border(int m) {
      int[] border = new int[m];

      for (int i = 0; i < m; i++) {
         border[i] = BORDER;
      }

      return border;
   }
}
