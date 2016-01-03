package game.demo.com.x_o.model;

/**
 * Created by 41X on 02.01.2016.
 */
public class Cell {

    private boolean active;
    private Value value;


    public Cell(int number){
        active=false;
        this.value=Value.NONE;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public enum Value{
        CROSS, ZERO, NONE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return value == cell.value;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
