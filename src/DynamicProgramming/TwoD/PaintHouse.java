package DynamicProgramming.TwoD;

/*
There are n houses in a row,
 and each house can be painted with one of three colors: red, blue, or green.
 The cost of painting each house with a certain color is different.
 You have to paint all the houses such that no two adjacent houses have the same color,
 and you want to minimize the total cost of painting.

 rows-> house
columns -> color(R, G, B)
 cost = [
  [17, 2, 17],
  [16,16, 5],
  [14, 3,19]
]

 */
public class PaintHouse {

    static void main() {
        int [][] cost = {
                {17,  2, 17},
                {16, 16,  5},
                {14,  3, 19}
        };

        int redCost = cost[0][0];
        int greenCost = cost[0][1];
        int blueCost = cost[0][2];
        for(int i = 1; i<cost.length; i++) {
           int red = cost[i][0] + Math.min( greenCost, blueCost);
           int green = cost[i][1] + Math.min( redCost, blueCost);
           int blue = cost[i][2] + Math.min( redCost, greenCost);

            redCost = red;
            greenCost = green;
            blueCost = blue;
        }
        int minCost = Math.min(redCost, Math.min(greenCost, blueCost));
        System.out.println("Minimum cost to paint all houses: " + minCost);
    }
}
