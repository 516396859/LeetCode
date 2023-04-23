import org.junit.Test;

import java.util.Arrays;

public class lc47 {
    int[][] mem;
    public int value(int[][] grid,int i ,int j){
        if(i==0 && j==0){
            return grid[0][0];
        }
        int left = 0;
        int up = 0;

        //从左边过来的
        if(j-1>=0){
            if(mem[i][j-1]==-1){
                left = value(grid,i,j-1 );
                mem[i][j-1] = left;
            }else {
                left = mem[i][j-1];
            }

        }
        //从上面过来的
        if(i-1>=0){
            if(mem[i-1][j]==-1){
                up = value(grid,i-1, j );
                mem[i-1][j] = up;
            }else {
                up = mem[i-1][j];
            }

        }
        return Math.max(left,up)+grid[i][j];
    }

    public int maxValue(int[][] grid) {
        //动态规划
        mem = new int[grid.length][grid[0].length];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i],-1);
        }

        return value(grid,grid.length-1,grid[0].length-1);
    }


    @Test
    public void test(){
        lc47 lc = new lc47();
        int i = lc.maxValue(new int[][]{{1, 3}, {2, 5}});
        System.out.println(i);
    }
}
