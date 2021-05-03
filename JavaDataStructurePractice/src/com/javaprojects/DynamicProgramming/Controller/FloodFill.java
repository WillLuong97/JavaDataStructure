package com.javaprojects.DynamicProgramming.Controller;
/* An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.

Note:
The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].

*  */

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //keeping track of the current color
        int current_color = image[sr][sc];
        if(current_color == newColor){
            return image;
        }
        image[sr][sc] = newColor;
        //paint the starting pixel color and then branch out and paint its neighbor
        return dfs(image, sr, sc, current_color);
    }

    //helper method to run dfs through the graph
    public int[][] dfs(int[][] image, int sr, int sc, int current_color){
        //getting the valid moves to branch out to the right neighbor:
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        for(int i = 0; i < dx.length; i++){
            int new_sr = sr + dx[i];
            int new_sc = sc + dy[i];
            //the current color is the same as the current color but it has not been painted, then we
            //will want to paint it with a new color
            if(new_sr >= 0 && new_sr < image.length && new_sc >= 0 && new_sc < image[0].length){
                //check to see if the current node has the same color as the previous node:
                if(image[new_sr][new_sc] == current_color){
                    image[new_sr][new_sc] = image[sr][sc];
                    image = dfs(image, new_sr, new_sc,current_color);
                }
            }
        }
        return image;
    }

}//end of program
