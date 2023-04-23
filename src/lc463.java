import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class lc463 {

    public List<int[]> getNeighbors(int i, int j, int[][] visit){

        int m = visit.length;
        int n = visit[0].length;
        ArrayList<int[]> neighbors = new ArrayList<>();
        if( (i + 1) <= m - 1 && visit[i + 1][j] == 0){
            neighbors.add(new int[]{i+1,j});
        }

        if((i - 1) >= 0 && visit[i - 1][j]==0){
            neighbors.add(new int[]{i-1,j});
        }

        if ((j + 1) <= n - 1 && visit[i][j + 1] == 0){
            neighbors.add(new int[]{i,j+1});
        }
        if( (j - 1) >= 0 && visit[i][j - 1] == 0){
            neighbors.add(new int[]{i,j-1});
        }
        return neighbors;
    }



    public int islandPerimeter(int[][] grid) {
        int length = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] visit = new int[grid.length][grid[0].length];
        int[][] board = new int[grid.length][grid[0].length];

        queue.addLast(new int[]{0,0});
        visit[0][0] = 1;

        while (!queue.isEmpty()){
            int[] ints = queue.pollFirst();
            int i = ints[0];
            int j = ints[1];

            for (int[] a :getNeighbors(i,j,visit)){
                if (visit[a[0]][a[1]] == 1) {
                    continue;
                }
                i = a[0];
                j = a[1];

                if(grid[i][j]==1){
                    if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                        if(board[i-1][j]==0){
                            length++;
                            board[i-1][j] = 1;
                        }
                    }

                    if(i+1<=grid.length-1 && grid[i+1][j]==0){
                        if(board[i+1][j]==0){
                            length++;
                            board[i+1][j] = 1;
                        }
                    }

                    if(j-1>=0 && grid[i][j-1]==0){
                        if(board[i][j-1]==0){
                            length++;
                            board[i][j-1] = 1;
                        }
                    }

                    if(j+1<=grid[0].length-1 && grid[i][j+1]==0){
                        if(board[i][j+1]==0){
                            length++;
                            board[i][j+1] = 1;
                        }
                    }
                }

               queue.add(a);
               visit[i][j] = 1;
            }
        }
        return  length;
    }

    @Test
    public void test(){
        lc463 lc = new lc463();
        int i = lc.islandPerimeter(new int[][]{{0, 0, 0}, {0, 1, 0}});
        System.out.println(i);
    }
}
