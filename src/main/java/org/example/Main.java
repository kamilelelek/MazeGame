package org.example;

import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /*
       Co wiemy:
       -punkt startowy
       -punkt koncowy
       -gdzie są ściany
       Problemy:
       -ruszanie sie
       -znajdowanie najkrotszej drogi
       Plan;
       1. okreslenie granic (1 sciana)
       2.ruch


        */
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0}
        };
        int currentRow = 9;
        int currentColumn = 8;
        int endRow = 2;
        int endColumn = 2;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        while(currentRow!=endRow||currentColumn!=endColumn){


        }


    }

    public boolean isWall(int maze[][], int currentRow, int currentColumn) {
        if (currentRow > 10 || currentRow < 0 || currentColumn > 10 || currentColumn < 0) {
            return true;
        }
        if (maze[currentRow][currentColumn] == 1) {
            return true;
        }
        return false;
    }

    //w tym momencie ruch ma dwa warunki, nie moze byc to scianka, ruch musi zmniejszac dystans.
    public int[][] move(int[][] maze, int currentRow, int currentColumn, int distance, int endRow, int endColumn) {
        int[][] move;
        int nextRow = currentRow;
        int nextColumn = currentColumn;
        //chce porownywac opcje z kazdego ifa ktory jest najlepszy wiec dodaje zmienna ktora bedzie przechowwywac najlepsza opcje
        int bufor = 99;
        if (!isWall(maze, currentRow - 1, currentColumn) && maze[currentRow - 1][currentColumn] == 0) {//sprawdzam czy nie ma scianki
            int d = dynamicDistance(currentRow - 1, currentColumn, endRow, endColumn);
            if (d < bufor) {
                bufor = d;
                nextRow = currentRow - 1;
                nextColumn = currentColumn;
            }
        }

        if (!isWall(maze, currentRow + 1, currentColumn) && maze[currentRow + 1][currentColumn] == 0) {
            int d = dynamicDistance(currentRow + 1, currentColumn, endRow, endColumn);
            if (d < bufor) {
                bufor = d;
                nextRow = currentRow + 1;
                nextColumn = currentColumn;
            }
        }

        if (!isWall(maze, currentRow, currentColumn - 1) && maze[currentRow][currentColumn - 1] == 0) {
            int d = dynamicDistance(currentRow, currentColumn-1, endRow, endColumn);
            if (d < bufor) {
                bufor = d;
                nextRow = currentRow;
                nextColumn = currentColumn - 1;
            }
        }

        if (!isWall(maze, currentRow, currentColumn + 1) && maze[currentRow][currentColumn + 1] == 0) {
            int d = dynamicDistance(currentRow, currentColumn+1, endRow, endColumn);
            if (d < bufor) {
                bufor = d;
                nextRow = currentRow;
                nextColumn = currentColumn+1;
            }
        }
        if(nextRow!=currentRow||nextColumn!=currentColumn){
            maze[currentRow][currentColumn] = 2; // 2 oznacza ze juz tu bylismy
            currentRow = nextRow;
            currentColumn = nextColumn;
        }

        return maze;
    }

    public int dynamicDistance(int currentRow, int currentColumn, int endRow, int endColumn) {
        return Math.abs(currentRow - endRow) + Math.abs(currentColumn - endColumn);
    }
}