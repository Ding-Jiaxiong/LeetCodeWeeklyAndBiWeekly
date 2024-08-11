package WeeklyMatch.Date_2024_08_11.矩阵中的蛇;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;

public class Main {

    public static int finalPositionOfSnake(int n, List<String> commands) {

        int[][] grid = new int[n][n];

        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                grid[i][j] = num++;
            }
        }

        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        int x = 0;
        int y = 0;

        for (String command : commands) {

            switch (command) {

                case "RIGHT":
                    y += 1;
                    break;
                case "LEFT":
                    y -= 1;
                    break;
                case "UP":
                    x -= 1;
                    break;
                case "DOWN":
                    x += 1;
                    break;
            }

//            System.out.print(x + " " + y + "\n");

        }

        return grid[x][y];

    }

    public static void main(String[] args) {

        int n = 3;

        List<String> commands = new ArrayList<String>() {{
            add("DOWN");
            add("RIGHT");
            add("UP");
        }};

        System.out.println(finalPositionOfSnake(n, commands));
    }
}
