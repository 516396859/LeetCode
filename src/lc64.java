import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class lc64 {
    int res;
    int sum;
    int visit[][];

//    public void dfs(int[][] grid,int i,int j,int summ){
//
//        if(i==(grid.length-1) && j==grid[0].length-1){
//            res = Math.min(res,summ);
//        }
//
//        //下走
//        if((i+1)<grid.length && visit[i+1][j]==0){
//            visit[i+1][j]=1;
//            dfs(grid,i+1,j,summ+grid[i+1][j]);
//            visit[i+1][j]=0;
//        }
//
//        //右走
//        if((j+1)<grid[0].length && visit[i][j+1]==0){
//            visit[i][j+1]=1;
//            dfs(grid,i,j+1,summ+grid[i][j+1]);
//            visit[i][j+1]=0;
//        }
//
//    }


//    public void dfs(int[][] grid,int i,int j ){
//        if(i==(grid.length-1) && j==grid[0].length-1){
//            res = Math.min(res,sum);
//        }
//
//        //下走
//        if((i+1)<grid.length && visit[i+1][j]==0){
//            visit[i+1][j]=1;
//            int temp = sum;
//            sum += grid[i+1][j];
//            dfs(grid,i+1,j );
//            visit[i+1][j]=0;
////            sum = temp; // 还原sum;
//            sum -= grid[i+1][j];
//        }
//
//        //右走
//        if((j+1)<grid[0].length && visit[i][j+1]==0){
//            visit[i][j+1]=1;
//            int temp = sum;
//            sum += grid[i][j+1];
//            dfs(grid,i,j+1 );
//            visit[i][j+1]=0;
////            sum = temp;// 还原sum;
//            sum -= grid[i][j+1];
//
//        }
//
//    }

    int mem[][];
    public int arrive(int[][] grid,int i,int j){
        if(i==0 && j==0){
            return grid[i][j];
        }

        int v1 = Integer.MAX_VALUE;
        int v2 = Integer.MAX_VALUE;

        if((i-1)>=0 && j>=0 ) {
            if(mem[i-1][j]==-1){
                v1 = arrive(grid,i-1,j);
                mem[i-1][j] = v1;
            }else {
                v1 = mem[i-1][j];
            }

        }
        if((j-1>=0) && i>=0){
            if (mem[i][j-1]==-1){
                v2 = arrive(grid,i,j-1);
                mem[i][j-1] = v2;
            }else{
                v2 = mem[i][j-1];
            }
        }
        return Math.min(v1,v2)+grid[i][j];

    }

    public int minPathSum(int[][] grid) {
//        visit = new int[grid.length][grid[0].length];
//        res = Integer.MAX_VALUE;
//        sum = grid[0][0] ;
//        dfs(grid,0,0 );
//        return res;


        //动态规划
        mem = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                mem[i][j] = -1;
            }
        }
        mem[0][0] = grid[0][0];
        return arrive(grid,grid.length-1,grid[0].length-1);

    }

    @Test
    public void test(){
        lc64 lc = new lc64();
        int i = lc.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
        System.out.println(i);
    }
}
