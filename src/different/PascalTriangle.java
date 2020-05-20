package different;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        List<Integer> first = new ArrayList<>();

        first.add(1);
        triangle.add(first);

        List<Integer> prevLevel, currentLevel;

        for (int l = 1; l < numRows; l++) {
            currentLevel = new ArrayList<>();
            prevLevel = triangle.get(l - 1);

            currentLevel.add(1);

            for (int i = 1; i < l; i++) {
                if (i < prevLevel.size()) {
                    currentLevel.add(prevLevel.get(i - 1) + prevLevel.get(i));
                }
            }

            currentLevel.add(1);
            triangle.add(currentLevel);
        }

        return triangle;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();

        if (rowIndex < 0)
            return list;

        for (int i = 0; i <= rowIndex; i++) {
            list.add(0, 1);

            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }

        return list;
    }



    public static void main(String[] args) {
        // List<List<Integer>> triangle = new PascalTriangle().generate(5);
       List<Integer> row = new PascalTriangle().getRow(13);
    }
}
