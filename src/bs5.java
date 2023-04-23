import java.util.Scanner;

public class bs5 {
        static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右四个方向

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                matrix[i] = line.toCharArray();
            }
            boolean[][] visited = new boolean[n][m];
            int real_count = 0; // 真实的连通块数量
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j]) {
                        dfs(matrix, visited, i, j);
                        real_count++;
                    }
                }
            }

            //将绿色变成蓝色
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[i][j] = false;
                    if(matrix[i][j]=='G'){
                        matrix[i][j]='B';
                    }
                }
            }

            int fake_count = 0; // 色盲连通块数量
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j]) {
                        dfs(matrix, visited, i, j);
                        fake_count++;
                    }
                }
            }
            System.out.println(real_count-fake_count);
        }

        private static void dfs(char[][] matrix, boolean[][] visited, int x, int y) {
            visited[x][y] = true;
            for (int[] d : direction) {
                int nextX = x + d[0];
                int nextY = y + d[1];
                if (nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length
                        && !visited[nextX][nextY] && matrix[nextX][nextY] == matrix[x][y]) {
                    dfs(matrix, visited, nextX, nextY);
                }
            }
        }
    }
