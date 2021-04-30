package com.javaprojects.DynamicProgramming;

public class Main {

    public static void main(String[] args) {
        System.out.println("TESTING DIVISOR GAME...");
        //Test cases:
        int n = 2;
        DivisorGame divisorGame;
        divisorGame = new DivisorGame();
        System.out.println(divisorGame.divisorGame(n));
        System.out.println(divisorGame.divisorGame(3));
        System.out.println("");
        System.out.println("TESTING WHERE WILL THE BALL FALL...");
        //[[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
        WhereWillTheBallFall findTheBall;
        findTheBall = new WhereWillTheBallFall();
        int[][] grid = {{-1}};
        System.out.println(findTheBall.findBall(grid));
        System.out.println("END OF TESTING...");

    }
}
