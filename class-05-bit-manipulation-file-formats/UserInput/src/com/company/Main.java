package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 5;
        int y = 5;

        int treeX = (int) Math.floor(10 * Math.random());
        int treeY = (int) Math.floor(10 * Math.random());

        boolean isRunning = true;
        while (isRunning) {
            System.out.print("enter movement: ");
            Scanner input = new Scanner(System.in);
            String movement = input.nextLine();
            if (movement.equals("left") || movement.equals("a")) {
                x--;
            } else if (movement.equals("right") || movement.equals("d")) {
                x++;
            } else if (movement.equals("up") || movement.equals("w")) {
                y--;
            } else if (movement.equals("down") || movement.equals("s")) {
                y++;
            } else {
                System.out.println("I don't understand.");
            }
            System.out.println("You are at " + x + " " + y);

            int distance = distance(x, y, treeX, treeY);
            if (distance < 2) {
                System.out.println("HOT");
            } else if (distance < 5) {
                System.out.println("warm");
            } else if (distance < 7) {
                System.out.println("cold");
            } else {
                System.out.println("FREEZING");
            }

            if (x == treeX && y == treeY) {
                isRunning = false;
                System.out.println("You found the tree!");
            }
        }
    }

    public static int distance(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);
        return dx + dy;
    }
}
