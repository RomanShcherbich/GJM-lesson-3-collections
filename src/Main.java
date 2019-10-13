import edu.collections.CollectionController;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    private static CollectionController table = new CollectionController(5,5);
    
    private static void print(Collection collection) {
        table.printTable(collection);
    }

    private static void print() {
        table.printTable();
    }
    
    public static void main(String[] args) {

        System.out.println(">>>>>>>>>> Iteration print <<<<<<<<<<<");
        print();

        int rowInd = 3;
        System.out.println(">>>>>>>>>>>> Row " + rowInd + " <<<<<<<<<<<");
        print(table.getRow(rowInd));

        int columnInd = 3;
        System.out.println(">>>>>>>>>>>> Column " + columnInd + " <<<<<<<<<<<");
        print(table.getColumn(columnInd));

        Collection insert = new ArrayList();

        for (int i = 0; i < 5; i++) {
            insert.add("__" + (i + 1) + "__");
        }

        System.out.println(">>>>>>>>>> New row inserted " + rowInd + " <<<<<<<<<<<");
        table.setRow(insert,rowInd);
        print();

        Collection insertColumn = new ArrayList(insert);
                insertColumn.add("__" + (insert.size() + 1) + "__");
        System.out.println(">>>>>>>>>> New column inserted " + columnInd + " <<<<<<<<<<<");
        table.setColumn(insertColumn,columnInd);
        print();
    }
}
