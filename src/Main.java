import static edu.utils.ArrayUtils.printTable;

import edu.collections.CollectionController;
import edu.utils.Randomizers.RandomString;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    private static RandomString randomString = new RandomString();

    private static CollectionController table = new CollectionController(5,5);

    public static void main(String[] args) {

        printTable(table.getTable());

        System.out.println(">>>>>>>>>> Iteration print <<<<<<<<<<<");
        table.printTable();

        int rowInd = 3;
        System.out.println(">>>>>>>>>>>> Row " + rowInd + " <<<<<<<<<<<");
        table.printTable(table.getRow(rowInd));

        int columnInd = 3;
        System.out.println(">>>>>>>>>>>> Column " + columnInd + " <<<<<<<<<<<");
        table.printTable(table.getColumn(columnInd));

        Collection insert = new ArrayList();

        for (int i = 0; i < 5; i++) {
            insert.add("__" + (i + 1) + "__");
        }

        System.out.println(">>>>>>>>>> New row inserted " + rowInd + " <<<<<<<<<<<");
        table.setRow(insert,rowInd);
        table.printTable();

        Collection insertColumn = new ArrayList(insert);
                insertColumn.add("__" + (insert.size() + 1) + "__");
        System.out.println(">>>>>>>>>> New column inserted " + columnInd + " <<<<<<<<<<<");
        table.setColumn(insertColumn,columnInd);
        table.printTable();
    }
}
