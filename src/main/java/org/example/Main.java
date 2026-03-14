package org.example;

import org.example.model.Maze;
import org.example.model.Move;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int startX = 0;
        int startY = 0;
        int x1 = 9;
        int y1 = 9;
        int h = 0;
        int f = 0;

        final Logger LOGGER = Logger.getLogger(Main.class.getName());
        Maze maze = new Maze(10, 10);
        PriorityQueue<Move> pq = new PriorityQueue<>();
        int startH = Move.dynamicDistance(startX, startY, x1, y1);
        Move startMove = new Move(startX, startY, 0, startH, null);
        pq.add(startMove);
        maze.markAsVisited(startX, startY);
        LinkedList<Move> lastMoves = new LinkedList<>();
        Move finalMove = null;
        while (!pq.isEmpty()) {
            startMove = pq.poll();
            if (startMove.getX() == x1 && startMove.getY() == y1) {
                Logger.getLogger(Main.class.getName()).log(Level.INFO, "Move from " + startMove.getX() + " to " + startMove.getY());
            }
            for (int i = 0; i < 4; i++) {
                int nextX = startMove.getX() + maze.getDx()[i];
                int nextY = startMove.getY() + maze.getDy()[i];
                if (!maze.isWall(maze.getMaze(), nextX, nextY) && !maze.hasBeenVisited(nextX, nextY)) {
                    maze.markAsVisited(nextX, nextY);
                    int nextH = Move.dynamicDistance(nextX, nextY, x1, y1);
                    Move nextMove = new Move(nextX, nextY, startMove.getG() + 1, nextH, startMove);
                    lastMoves.add(startMove);
                    pq.add(nextMove);
                }
            }

        }
    }
}