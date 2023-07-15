
public class Main {
    public static void main(String[] args) {

        /*//Create a cell object
        Cell cell = new Cell();

        //Create a spreadsheet object
        Spreadsheet sh = new Spreadsheet(3,3);


        //Set value and color of the cell
        cell.setValue(11);
        cell.setColor(Color.YELLOW);

        //Print cell value and color
        System.out.println("Cell value " + cell.getValue());
        System.out.println("Cell color " + cell.getColor());

        cell.reset();

        System.out.println("Cell value "+ cell.getValue());
        System.out.println("Cell color " + cell.getColor());

        System.out.println("Before adding a column:");
        System.out.println("Num of columns " + sh.getColumns());
        //Add a column at position 1
        sh.addColumn(0);
        System.out.println("After adding column:");
        System.out.println("Number of columns " + sh.getColumns());

        sh.setValueAt(1,1,"12");
        System.out.println("The value is "+ sh.getValueAt(1,1));*/


        Spreadsheet sh = new Spreadsheet(3, 3);

        sh.setValueAt(0, 0, 10);
        sh.setValueAt(0, 1, 20);
        sh.setValueAt(0, 2, 30);
        sh.setValueAt(1, 0, 40);
        sh.setValueAt(1, 1, 50);
        sh.setValueAt(1, 2, 60);
        sh.setValueAt(2, 0, 70);
        sh.setValueAt(2, 1, 80);
        sh.setValueAt(2, 2, 90);
        sh.printSpreadsheet();
        sh.addColumn(0);
        sh.printSpreadsheet();

        System.out.println("Value at (1,1): " + sh.getValueAt(1, 1));
        System.out.println("Sum of column 2: " + sh.getColumnSum(2));
        System.out.println("Average of row 0: " + sh.getRowAverage(0));
        System.out.println("Sum of Area (0,0) to (1,2): " + sh.getAreaSum(0, 0, 1, 2));
        System.out.println("Average of Area (1,0) to (2,1): " + sh.getAreaAverage(1, 0, 2, 1));


    }
}
