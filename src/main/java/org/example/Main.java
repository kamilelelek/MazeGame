package org.example;

import org.example.model.Maze;
import org.example.model.Move;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        int startX = 0;
        int startY = 0;
        int x1 = 9;
        int y1 = 9;

        final Logger LOGGER = Logger.getLogger(Main.class.getName());
        Maze maze = new Maze(10, 10);
        PriorityQueue<Move> pq = new PriorityQueue<>();

        int startH = Move.dynamicDistance(startX, startY, x1, y1);
        Move startMove = new Move(startX, startY, 0, startH, null);
        pq.add(startMove);
        maze.markAsVisited(startX, startY);

        Move finalMove = null;

        while (!pq.isEmpty()) {
            startMove = pq.poll();

            if (startMove.getX() == x1 && startMove.getY() == y1) {
                LOGGER.log(Level.INFO, "dotarłem do mety: " + startMove.getX() + ", " + startMove.getY());
                finalMove = startMove;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = startMove.getX() + maze.getDx()[i];
                int nextY = startMove.getY() + maze.getDy()[i];

                if (!maze.isWall(maze.getMaze(), nextX, nextY) && !maze.hasBeenVisited(nextX, nextY)) {
                    maze.markAsVisited(nextX, nextY);
                    int nextH = Move.dynamicDistance(nextX, nextY, x1, y1);
                    Move nextMove = new Move(nextX, nextY, startMove.getG() + 1, nextH, startMove);
                    pq.add(nextMove);
                }
            }
        }

        LinkedList<Move> path = new LinkedList<>();

        if (finalMove != null) {
            Move current = finalMove;
            while (current != null) {
                path.addFirst(current);
                current = current.getLastMove();
            }
            System.out.println("sciezka do mety:");
            for (Move move : path) {
                maze.getMaze()[move.getX()][move.getY()] = 2;
                System.out.println("-> (" + move.getX() + ", " + move.getY() + ")");
            }
        }
        maze.showMaze(maze.getMaze());
    }
}