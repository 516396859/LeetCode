import org.junit.Test;

public class lc200 {
    int visit[][];
    public void dfs(char[][] grid,int i , int j){
        if(grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0'; //摧毁

        int[][] dirc = new int[][]{{-1,0},{1,0},{0,-1},{0,1}}; //方向 上下左右

        for (int k = 0; k < dirc.length; k++) {
            int x = dirc[k][0];
            int y = dirc[k][1];
            //往x,y指定的方向走
            if((((i+x)<grid.length)&&(i+x)>=0 ) && ((j+y)<grid[0].length) && visit[i+x][j+y]==0){
                visit[i+x][j+y] = 1;
                if(grid[i+x][j+y]=='1'){
                    dfs(grid,i+x,j+y);
                }
                visit[i+x][j+y] = 0;
            }
        }

    }
    public int numIslands(char[][] grid) {
        int count = 0;
        visit = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j); //开始毁灭
                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        lc200 lc = new lc200();
        int i = lc.numIslands(new char[][]{{'1','0','1','0'},{'0','1','0','1'}});
        System.out.println(i);
    }
}
