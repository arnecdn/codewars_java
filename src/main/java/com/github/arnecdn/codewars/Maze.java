package com.github.arnecdn.codewars;

import java.util.Objects;
import java.util.Stack;

public class Maze {
    static char KATE = 'k';
    static char WALL = '#';
    static char OPEN = ' ';

    public static boolean hasExit(String[] maze) {
        if (!isValid(maze)) {
            throw new RuntimeException("To many kates");
        }
        char[][] myMaze = toCharArray(maze);
        Stack<RouteItem> route = findKate(myMaze);
        return findExit(myMaze, route);
    }

    private static Stack<RouteItem> findKate(char[][] maze) {
        Stack<RouteItem> route = new Stack<>();

        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                if (maze[y][x] == KATE) {
                    route.push(new RouteItem(maze[y][x], y, x));
                }
            }
        }

        return route;
    }

    private static boolean findExit(char[][] maze, Stack<RouteItem> route) {
        RouteItem current = route.peek();

        if (isExit(maze, current)) {
            return true;
        }

        //left
        if (canMoveLeft(current, maze)) {
            RouteItem leftItem = new RouteItem(maze[current.yPos][current.xPos - 1], current.yPos, current.xPos - 1);
            if (moveNext(maze, route, leftItem)) {
                return true;
            }
        }
        //right
        if (canMoveRight(current, maze)) {
            RouteItem rightItem = new RouteItem(maze[current.yPos][current.xPos + 1], current.yPos, current.xPos + 1);
            if (moveNext(maze, route, rightItem)) {
                return true;
            }
        }
        //up
        if (canMoveUp(current, maze)) {
            RouteItem upItem = new RouteItem(maze[current.yPos - 1][current.xPos], current.yPos - 1, current.xPos);
            if (moveNext(maze, route, upItem)) {
                return true;
            }
        }
        //down
        if (canMoveDown(current, maze)) {
            RouteItem upItem = new RouteItem(maze[current.yPos + 1][current.xPos], current.yPos + 1, current.xPos);
            if (moveNext(maze, route, upItem)) {
                return true;
            }
        }

        return false;
    }

    static boolean isExit(char[][] maze, RouteItem item) {
        if (item.value == WALL) {
            return false;
        }

        if (item.yPos == 0 || item.yPos == maze.length - 1) {
            return true;
        }

        if (item.xPos == 0 || item.xPos == maze[item.yPos].length - 1) {
            return true;
        }

        return false;
    }

    private static boolean canMoveLeft(RouteItem current, final char[][] maze) {
        return (current.xPos > 0) && (maze[current.yPos][current.xPos - 1]) == OPEN;
    }

    private static boolean canMoveRight(RouteItem current, final char[][] maze) {
        return (current.xPos + 1 < maze[current.yPos].length) && (maze[current.yPos][current.xPos + 1]) == OPEN;
    }

    private static boolean canMoveUp(RouteItem current, final char[][] maze) {
        return (current.yPos > 0) && (maze[current.yPos - 1][current.xPos]) == OPEN;
    }

    private static boolean canMoveDown(RouteItem current, final char[][] maze) {
        return (current.yPos + 1 < maze.length) && (maze[current.yPos + 1][current.xPos]) == OPEN;
    }

    private static boolean moveNext(final char[][] maze, final Stack<RouteItem> route, final RouteItem newRouteItem) {
        if (!route.contains(newRouteItem)) {
            route.push(newRouteItem);
            boolean foundExit = findExit(maze, route);

            if (foundExit) {
                return true;
            }
            route.pop();
        }
        return false;
    }

    private static boolean isValid(final String[] maze) {
        int numOfKates = 0;

        for (String row : maze) {
            for (char c : row.toCharArray()) {
                if ((c == KATE) && (numOfKates++ > 1)) {
                    return false;
                }
            }
        }

        if (numOfKates == 0) {
            return false;
        }

        return true;
    }

    private static char[][] toCharArray(final String[] maze) {
        char[][] converted = new char[maze.length][];
        int maxLengthXDimension = 0;

        for (int y = 0; y < maze.length; y++) {
            if (maze[y].length() > maxLengthXDimension) {
                maxLengthXDimension = maze[y].length();
            }
        }

        for (int y = 0; y < maze.length; y++) {
            converted[y] = new char[maxLengthXDimension];

            for (int x = 0; x < converted[y].length; x++) {
                converted[y][x] = OPEN;
            }
        }
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length(); x++) {
                converted[y][x] = maze[y].charAt(x);
            }
        }
        return converted;
    }

    static class RouteItem {
        char value;
        int yPos;
        int xPos;

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            RouteItem routeItem = (RouteItem) o;
            return value == routeItem.value && yPos == routeItem.yPos && xPos == routeItem.xPos;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, yPos, xPos);
        }

        public RouteItem(final char value, final int yPos, final int xPos) {
            this.value = value;
            this.yPos = yPos;
            this.xPos = xPos;
        }
    }
}
