package game.demo.com.x_o;

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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import game.demo.com.x_o.model.Cell;

public class MainActivity extends AppCompatActivity
    implements OnClickListener {

    public static final String LOG_TAG="Log_Debug";
    private static final int CELL_AMOUNT=9;

    private boolean player1;
    private List<Cell> field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setting onclick listener to layout
        setListeners();

        //Setting cell params
        setCellGrid();

    }

    private void setCellGrid(){
        player1=true;
        field = new ArrayList<>();
        for (int i=0; i<CELL_AMOUNT; i++) {
            field.add(new Cell(i));
        }

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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
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
                field.get(0).setActive(true);
                imView =(ImageView) findViewById(R.id.imgCel1);
                break;
            case R.id.cel2:
                if(!checkField(1)){
                    return;
                }
                field.get(1).setActive(true);
                imView =(ImageView) findViewById(R.id.imgCel2);
                break;
            case R.id.cel3:
                if(!checkField(2)){
                    return;
                }
                field.get(2).setActive(true);
                imView =(ImageView) findViewById(R.id.imgCel3);
                break;
            case R.id.cel4:
                if(!checkField(3)){
                    return;
                }
                field.get(3).setActive(true);
                imView =(ImageView) findViewById(R.id.imgCel4);
                break;
            case R.id.cel5:
                if(!checkField(4)){
                    return;
                }
                field.get(4).setActive(true);
                imView =(ImageView) findViewById(R.id.imgCel5);
                break;
            case R.id.cel6:
                if(!checkField(5)){
                    return;
                }
                field.get(5).setActive(true);
                imView =(ImageView) findViewById(R.id.imgCel6);
                break;
            case R.id.cel7:
                if(!checkField(6)){
                    return;
                }
                field.get(6).setActive(true);
                imView =(ImageView) findViewById(R.id.imgCel7);
                break;
            case R.id.cel8:
                if(!checkField(7)){
                    return;
                }
                field.get(7).setActive(true);
                imView =(ImageView) findViewById(R.id.imgCel8);
                break;
            case R.id.cel9:
                if(!checkField(8)){
                    return;
                }
                field.get(8).setActive(true);
                imView =(ImageView) findViewById(R.id.imgCel9);
                break;
        }

        String imageName;mm""
        if(player1){
            imageName = "cross";
            player1=false;
        } else {
            imageName = "zero";
            player1=true;
        }

        int res = getResources().getIdentifier(imageName, "drawable", getPackageName());

        imView.setImageResource(res);
    }

    private boolean checkField(int number){
        if(field.get(number).isActive()){
            Toast.makeText(this, "Field is already filled", Toast.LENGTH_SHORT).show();
            return false;
        }
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
    }
}
