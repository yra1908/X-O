package game.demo.com.x_o.model;

/**
 * Created by 41X on 02.01.2016.
 */
public class Player {

    Player(){
        this.active=false;
        Type=Type.NONE;
    }

    public enum Type{
        CROSS, ZERO, NONE
    }

    private boolean active;
}
