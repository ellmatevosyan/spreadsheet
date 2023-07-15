public class Spreadsheet {
    private Cell[][] cells ;//=  new Cell[this.rows][this.columns];
    private int rows;
    private int columns;

    Spreadsheet(int row, int col){
        this.rows = row;
        this.columns = col;
        this.cells = new Cell[row][col]; //create spreadsheet
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cells[i][j] = new Cell();
            }
        }
    }


    public void printSpreadsheet() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(cells[i][j].getValue() + "\t");
            }
            System.out.println();
        }
    }



    public int getColumns(){
        return columns;
    }


    public void addColumn(int position){
        if(position < 0 || position > columns){
            throw new IllegalArgumentException("Invalid position for adding column");
        }

    else{Cell[][] newCells = new Cell[rows][columns+1];
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < columns + 1; col++){
                if(col<position){
                    newCells[row][col]= cells[row][col];
                }else if(col>position){
                    newCells[row][col]=cells[row][col-1];
                }else{
                    newCells[row][col]= new Cell();
                }
            }
        }
        cells = newCells;
        columns++;
    }}

    public void addRow(int position){
        if(position<0 || position > rows){
            throw new IllegalArgumentException("Invalid position for adding row");
        }
        else{

        Cell[][] newCells = new Cell[rows+1][columns];
        for(int row=0;row<rows+1;row++){
            for(int col=0; col<columns;col++){
                if(row<position){
                    newCells[row][col]=cells[row][col];
                }else if(row>position){
                    newCells[row][col]=cells[row][col];
                }else{
                    newCells[row][col] = new Cell();
                }
            }
        }
        cells= newCells;
        rows++;
    }}

    public void setValueAt(int row, int col, Object value){
        validateCoordinates(row,col);
        cells[row][col].setValue(value);
    }

    public Object getValueAt(int row, int col){
        validateCoordinates(row,col);
        return cells[row][col].getValue();
    }

    public void setColorAt(int row, int col, Color color){
        validateCoordinates(row,col);
        cells[row][col].setColor(color);
    }

    public Color getColorAt(int row, int col){
        validateCoordinates(row,col);
        return cells[row][col].getColor();
    }

    public void reset(){
        for(int row=0; row < rows; row++){
            for(int col = 0; col < columns; col++){
                
            }
        }
    }

    public void recetCellAt(int row, int col){
        validateCoordinates(row,col);
        cells[row][col].reset();
    }

    public int getColumnSum(int col){
        validateColumn(col);

        int sum=0;
        for(int row=0; row<rows;row++){
            Object value = cells[row][col].getValue();
            if(value instanceof Integer){
                sum += (int)value;
            }
        }
        return sum;
    }

    public int getRowSum(int row){
        validateRow(row);

        int sum=0;
        for(int col=0;col<columns;col++){
            Object value = cells[row][col].getValue();
            if(value instanceof Integer){
                sum += (int) value;
            }
        }
        return sum;
    }

    public int getAreaSum(int startRow, int startCol, int endRow, int endCol){
        int sum =0;
        for(int row = startRow; row < endRow; row++){
            for(int col = startCol; col < endCol; col++){
                Object value = cells[row][col].getValue();
                if(value instanceof Integer){
                    sum += (int)value;
                }
            }
        }
        return sum;
    }

    public double getColumnAverage(int col){
        validateColumn(col);

        int sum = getColumnSum(col);
        return (double) sum / rows;
    }

    public double getRowAverage(int row){
        validateRow(row);

        int sum = getRowSum(row);
        return (double) sum / columns;
    }

    public double getAreaAverage(int startRow, int startCol, int endRow, int endCol){
        validateArea(startRow, startCol, endRow, endCol);
        int sum = getAreaSum(startRow, startCol, endRow, endCol);
        int numberOfCells = (endRow - startRow + 1)* (endCol - startCol + 1);
        return (double) sum / numberOfCells;
    }

    private void validateCoordinates(int row, int col){
        if(row < 0 || row >= rows || col < 0 || col >= columns){
            System.out.println("row, rows, col, columns " + row + " " + rows + " " + col + " " + columns);
            throw new IllegalArgumentException("The coordinates for cell is invalid");
        }
    }

    private void validateRow(int row){
        if(row < 0 || row>=rows){
            throw new IllegalArgumentException("Invalid row");
        }
    }

    private void validateColumn(int col){
        if(col < 0 || col >= columns){
            throw new IllegalArgumentException("Invalid column");
        }
    }

    private void validateArea(int startRow, int startCol, int endRow, int endCol){
        validateCoordinates(startRow,startCol);
        validateCoordinates(endRow,endCol);
        if(startRow > endRow || startCol > endCol){
            throw new IllegalArgumentException("Invalid area coordinates");
        }
    }

}
