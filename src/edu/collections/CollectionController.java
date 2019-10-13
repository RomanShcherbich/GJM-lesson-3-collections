package edu.collections;

import edu.utils.Randomizers.RandomArray;
import edu.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionController {

    private String[][] table;
    private Collection tableCol;
    private RandomArray randomArray = new RandomArray();
    private ArrayUtils arrayUtils = new ArrayUtils();

    public CollectionController(String[][] table) {
        this.table = table;
        arrayTableToCollection(table);
    }

    public CollectionController(int columnCount, int rowCount) {
        setRandomTable(columnCount, rowCount);
        arrayTableToCollection(table);
    }

    public CollectionController() {
        setRandomTable(5, 5);
        arrayTableToCollection(table);
    }

    public String[][] getTable() {
        return table;
    }

    public void setTable(String[][] table) {
        this.table = table;
        arrayTableToCollection(table);
    }

    public void printTable() {
        printTable(tableCol);
    }

    public void printTable(Collection collection) {
        for (Iterator it = collection.iterator(); it.hasNext(); ) {
            Collection rows = ((ArrayList) it.next());
            System.out.print("|  ");
            for (Iterator rowsIt = rows.iterator(); rowsIt.hasNext(); ) {
                String cell = (String) rowsIt.next();
                System.out.print(cell + "  |  ");
            }
            System.out.println();
        }
    }

    private void setRandomTable(int columnCount, int rowCount) {
        this.table = randomArray.getRandomArray(columnCount,rowCount);
    }

    private void arrayTableToCollection(String[][] table) {
        this.tableCol = arrayUtils.arrayToCollection(table);
    }
    
    public Collection<Collection> getColumn(int columnInd) {

        Collection<Collection> table = new ArrayList();

        for (Iterator it = tableCol.iterator(); it.hasNext() ;) {
            Collection col = new ArrayList();
            col.add(((ArrayList)it.next()).get(columnInd - 1));
            table.add(col);
        }
        return table;
    }

    public void setColumn(Collection column, int columnInd) {
        if (columnInd > getColumnCount()) throw new IllegalArgumentException();
        if (column.size() != getRowCount()) throw new IllegalArgumentException();

        ArrayList table = (ArrayList)tableCol;
        Collection<Collection> newTable = new ArrayList();

        int index = 0;
        for (Iterator it = column.iterator(); it.hasNext() ; index++) {

            String newCell = (String)it.next();

            ArrayList newRow = (ArrayList)table.get(index);
            newRow.add(columnInd - 1,newCell);
            newTable.add(newRow);

            if(index == column.size()){
                break;
            }
        }

        this.tableCol = newTable;
    }

    public Collection<Collection> getRow(int rowInd) {

        Collection<Collection> table = new ArrayList();
        /*Question: how to avoid i before loop?*/
        int i = 1;
        for (Iterator it = tableCol.iterator(); it.hasNext() ;) {

            if (i == rowInd){
            table.add((Collection)it.next());
                break;
            }
            it.next();
            i++;
        }
        return table;
    }

    public void setRow(Collection row,int rowInd) {
        if (rowInd > getRowCount()) throw new IllegalArgumentException();
        if (row.size() != getColumnCount()) throw new IllegalArgumentException();

        Collection<Collection> table = new ArrayList();

        int i = 1;
        for (Iterator it = tableCol.iterator(); it.hasNext() ;) {
            if (i == rowInd){
                table.add(row);
            }
            table.add((Collection)it.next());
            i++;
        }
        this.tableCol = table;
    }

    private int getColumnCount() {
        return ((ArrayList)((ArrayList)tableCol).get(0)).size();
    }

    private int getRowCount() {
        return tableCol.size();
    }
}
