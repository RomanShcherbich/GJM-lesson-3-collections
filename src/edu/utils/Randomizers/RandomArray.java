package edu.utils.Randomizers;

import edu.utils.Randomizers.RandomString;

public class RandomArray {

    private static RandomString randomString = new RandomString();

    public String[][] getRandomArray(int columnCount, int rowCount) {
        String[][] randomTable = new String[columnCount][rowCount];

        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                randomTable[i][j] = randomString.get();
            }
        }

        return randomTable;
    }
}
