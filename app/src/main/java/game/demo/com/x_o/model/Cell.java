package game.demo.com.x_o.model;

/**
 * Created by 41X on 02.01.2016.
 */
public class Cell {

    int number;
    private Player player;
    boolean active;

    Cell(int number){
        this.number=number;
        active=false;
    }

}
