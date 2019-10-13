package edu.utils;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayUtils {

    public static void printTable(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.print("|  ");
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + (j != table[i].length ? "  |  " : ""));
            }
            System.out.println("");
        }
    }

    public Collection<Collection> arrayToCollection(String[][] table) {
        Collection collection = new ArrayList();

        for (int i = 0; i < table.length; i++) {
            Collection rows = new ArrayList();
            for (int j = 0; j < table[0].length; j++) {
                rows.add(table[i][j]);
            }
            collection.add(rows);
        }
        return collection;
    }
}
