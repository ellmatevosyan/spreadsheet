public class Cell {
    private Object value;
    private Color color;
    private Type type;

    //Constructor
    Cell(){
        this.color=Color.WHITE;
    }

    public Object getValue(){
        return value;
    }

    public void setValue(Object value){
        this.value=value;
    }

    public Type getType(){
        return type;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color=color;
    }

    void reset(){
        this.value=null;
        this.color=Color.WHITE;
    }
}
