package game.demo.com.x_o;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import game.demo.com.x_o.model.Cell;

public class MainActivity extends AppCompatActivity
    implements OnClickListener {

    public static final String LOG_TAG="Log_Debug";

    private static final int CELL_AMOUNT=9;
    private static int [][] lines = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6},
                                     {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    private boolean player1;
    private List<Cell> field;
    private int count;

    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        status = (TextView) findViewById(R.id.status);

        //setting onclick listener to layout
        setListeners();

        //Setting cell params
        setCellGrid();

    }

    private void setListeners(){

        Button b = (Button) findViewById(R.id.newGameButton);
        b.setOnClickListener(this);

        LinearLayout cel1=(LinearLayout) findViewById(R.id.cel1);
        LinearLayout cel2=(LinearLayout) findViewById(R.id.cel2);
        LinearLayout cel3=(LinearLayout) findViewById(R.id.cel3);
        LinearLayout cel4=(LinearLayout) findViewById(R.id.cel4);
        LinearLayout cel5=(LinearLayout) findViewById(R.id.cel5);
        LinearLayout cel6=(LinearLayout) findViewById(R.id.cel6);
        LinearLayout cel7=(LinearLayout) findViewById(R.id.cel7);
        LinearLayout cel8=(LinearLayout) findViewById(R.id.cel8);
        LinearLayout cel9=(LinearLayout) findViewById(R.id.cel9);

        cel1.setOnClickListener(this);
        cel2.setOnClickListener(this);
        cel3.setOnClickListener(this);
        cel4.setOnClickListener(this);
        cel5.setOnClickListener(this);
        cel6.setOnClickListener(this);
        cel7.setOnClickListener(this);
        cel8.setOnClickListener(this);
        cel9.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_exit) {
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        ImageView imView = null;
        switch (v.getId()) {

            case R.id.newGameButton: //start new Game
                Log.d(LOG_TAG, "debug button11");
                setCellGrid();
                clearGrid();
                return;
            case R.id.cel1:
                if(!checkField(0)){
                    return;
                }
                prepareCell(0);
                imView =(ImageView) findViewById(R.id.imgCel1);
                break;
            case R.id.cel2:
                if(!checkField(1)){
                    return;
                }
                prepareCell(1);
                imView =(ImageView) findViewById(R.id.imgCel2);
                break;
            case R.id.cel3:
                if(!checkField(2)){
                    return;
                }
                prepareCell(2);
                imView =(ImageView) findViewById(R.id.imgCel3);
                break;
            case R.id.cel4:
                if(!checkField(3)){
                    return;
                }
                prepareCell(3);
                imView =(ImageView) findViewById(R.id.imgCel4);
                break;
            case R.id.cel5:
                if(!checkField(4)){
                    return;
                }
                prepareCell(4);
                imView =(ImageView) findViewById(R.id.imgCel5);
                break;
            case R.id.cel6:
                if(!checkField(5)){
                    return;
                }
                prepareCell(5);
                imView =(ImageView) findViewById(R.id.imgCel6);
                break;
            case R.id.cel7:
                if(!checkField(6)){
                    return;
                }
                prepareCell(6);
                imView =(ImageView) findViewById(R.id.imgCel7);
                break;
            case R.id.cel8:
                if(!checkField(7)){
                    return;
                }
                prepareCell(7);
                imView =(ImageView) findViewById(R.id.imgCel8);
                break;
            case R.id.cel9:
                if(!checkField(8)){
                    return;
                }
                prepareCell(8);
                imView =(ImageView) findViewById(R.id.imgCel9);
                break;
        }

        String imageName;
        if (player1) {
            imageName = "cross";
            player1=false;
            status.setText("Player 2 Move");
        } else {
            imageName = "zero";
            player1=true;
            status.setText("Player 1 Move");
        }

        int res = getResources().getIdentifier(imageName, "drawable", getPackageName());

        imView.setImageResource(res);
        if(count>4){
            if(checkLines()){
                finishGame();
            }
        }
    }

    private void setCellGrid(){
        count=0;
        player1=true;
        status.setText("Player1 Move");
        field = new ArrayList<>();
        for (int i=0; i<CELL_AMOUNT; i++) {
            field.add(new Cell(i));
        }

    }

    private void prepareCell(int number){
        field.get(number).setActive(true);
        if(player1){
            field.get(number).setValue(Cell.Value.CROSS);
        } else {
            field.get(number).setValue(Cell.Value.ZERO);
        }
    }

    private boolean checkLines(){

        int lineNumber = 1;
        for (int[] line: lines) {

            if (field.get(line[0]).equals(field.get(line[1])) &&
                    field.get(line[0]).equals(field.get(line[2])) &&
                    !field.get(line[0]).getValue().equals(Cell.Value.NONE)){

                setLineBackground(lineNumber);
                return true;
            }
            lineNumber++;
        }
        return false;
    }

    private void setLineBackground(int i) {
        ImageView imView1 =(ImageView) findViewById(R.id.imgCel1);
        imView1.setBackgroundColor(Color.parseColor("#3F51B5"));
    }

    private void finishGame(){
        if(player1){
            status.setText("Player2 Win!");
        } else {
            status.setText("Player1 Win!");
        }
        for (Cell cell: field) {
            cell.setActive(true);
        }

    }





    private boolean checkField(int number){
        if(field.get(number).isActive()){
            Toast.makeText(this, "Field is already filled", Toast.LENGTH_SHORT).show();
            return false;
        }
        count++;
        return true;
    }

    private void clearGrid(){
        ImageView imView1 =(ImageView) findViewById(R.id.imgCel1);
        ImageView imView2 =(ImageView) findViewById(R.id.imgCel2);
        ImageView imView3 =(ImageView) findViewById(R.id.imgCel3);
        ImageView imView4 =(ImageView) findViewById(R.id.imgCel4);
        ImageView imView5 =(ImageView) findViewById(R.id.imgCel5);
        ImageView imView6 =(ImageView) findViewById(R.id.imgCel6);
        ImageView imView7 =(ImageView) findViewById(R.id.imgCel7);
        ImageView imView8 =(ImageView) findViewById(R.id.imgCel8);
        ImageView imView9 =(ImageView) findViewById(R.id.imgCel9);

        imView1.setImageDrawable(null);
        imView2.setImageDrawable(null);
        imView3.setImageDrawable(null);
        imView4.setImageDrawable(null);
        imView5.setImageDrawable(null);
        imView6.setImageDrawable(null);
        imView7.setImageDrawable(null);
        imView8.setImageDrawable(null);
        imView9.setImageDrawable(null);

        imView1.setBackgroundColor(Color.TRANSPARENT);
    }
}
