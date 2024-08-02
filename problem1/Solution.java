package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of flights:");
        int n=scanner.nextInt();
        scanner.nextLine();
        
        List<int[][]> flights = new ArrayList<>();
        
        // Read input for 3 flights
        for (int i = 0; i < n; i++) {
            System.out.println("Enter coordinates for Flight " + (i + 1) + " (format: x1,y1 x2,y2 x3,y3):");
            String input = scanner.nextLine();
            String[] points = input.split(" ");
            int[][] flight = new int[points.length][2];
            for (int j = 0; j < points.length; j++) {
                String[] coords = points[j].split(",");
                flight[j][0] = Integer.parseInt(coords[0]);
                flight[j][1] = Integer.parseInt(coords[1]);
            }
            flights.add(flight);
        }
        
        // Determine the size of the grid
        int maxX = 0, maxY = 0;
        for (int[][] flight : flights) {
            for (int[] point : flight) {
                if (point[0] > maxX) maxX = point[0];
                if (point[1] > maxY) maxY = point[1];
            }
        }
        
        // Create the grid
        char[][] grid = new char[maxY + 1][maxX + 1];
        for (int i = 0; i <= maxY; i++) {
            for (int j = 0; j <= maxX; j++) {
                grid[i][j] = '.';
            }
        }
        
        // Mark the flight paths on the grid
        char[] flightMarkers = {'1', '2', '3'};
        for (int i = 0; i < flights.size(); i++) {
            int[][] flight = flights.get(i);
            for (int[] point : flight) {
                grid[point[1]][point[0]] = flightMarkers[i];
            }
        }
        
        // Print the grid
        System.out.println("Flight paths:");
        for (int i = 0; i <= maxY; i++) {
            for (int j = 0; j <= maxX; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}