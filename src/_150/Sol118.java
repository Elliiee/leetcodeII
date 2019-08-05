package _150;

import java.util.ArrayList;
import java.util.List;

public class Sol118 {
    /*
    118. Pascal's Triangle
    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
     */

    /*
    Approach 1: Dynamic Programming
    Intuition: If we have a row of Pascal's triangle, we can easily compute the next row by each
    pair of adjacent values.
    Algorithm:
    Although the algorithm is very simple, the iterative approach to constructing Pascal's
    triangle can be classified as dynamic programming because we construct each row based on the
    previous row.
    1. we generate the overall triangle list, which will store each row as a sublist.
    2. Then, we check for the special case of 0, as we would otherwise return [1].
    3. If numRows > 0, then we initialize triangle with [1] as its first row, and proceed to fill
    the rows as follows.
     */
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        //1. first base case, if user requests zero rows, they get zero rows.
        if (numRows == 0){
            return triangle;
        }

        //2. second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // the first row element is always 1.
            row.add(1);

            for (int j = 1; j < rowNum; j++){
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // the last row element is always 1
            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }
}
