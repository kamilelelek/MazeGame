package org.example.model;

public class Maze {
    private int rows;
    private int cols;
    private int[][] maze = {
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, // wiersz 0
            {0, 0, 0, 0, 0, 1, 0, 1, 1, 0}, // wiersz 1
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0}// wiersz 2
    };
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public boolean[][] visited;

    public boolean isWall(int[][] maze, int x, int y) {
        if (x > 9 || x < 0 || y > 9 || y < 0) {
            return true;
        }
        if (maze[x][y] == 1) {
            return true;
        }
        return false;
    }

    public int[][] getMaze() {
        return maze;
    }

    public int[] getDy() {
        return dy;
    }

    public int[] getDx() {
        return dx;
    }

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.visited = new boolean[rows][cols];
    }

    public void showMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean hasBeenVisited(int x, int y) {
        return visited[x][y];
    }

    public boolean markAsVisited(int x, int y) {
        return visited[x][y] = true;
    }

}
