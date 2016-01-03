package game.demo.com.x_o.model;

/**
 * Created by 41X on 02.01.2016.
 */
public class Cell {

    //int number;
    private boolean active;

    public Cell(int number){
        //this.number=number;
        active=false;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
