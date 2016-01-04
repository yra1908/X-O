package game.demo.com.x_o;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.demo.com.x_o.model.Cell;

public class SecondActivity extends AppCompatActivity
    implements OnClickListener {

    private List<Cell> field;
    private List<ImageView> imageList;
    private int count;
    private int resCross;
    private int resDroid;

    TextView status;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imView =(ImageView) findViewById(R.id.imageView2);
        resCross = getResources().getIdentifier("cross", "drawable", getPackageName());
        resDroid = getResources().getIdentifier("droid", "drawable", getPackageName());
        imView.setImageResource(resDroid);

        status = (TextView) findViewById(R.id.status);
        status.setText("Player1 Move!");

        //setting onclick listener to layout
        setListeners();

        //add image Views to List
        fillImageViewList();

        //Setting cell params
        setCellGrid();

    }

    /**
     * Setting Onclick listener for all Linear layouts
     * grid fields
     */
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

    /**
     * Fill imageView List with
     */
    private void fillImageViewList(){
        ImageView imView1 =(ImageView) findViewById(R.id.imgCel1);
        ImageView imView2 =(ImageView) findViewById(R.id.imgCel2);
        ImageView imView3 =(ImageView) findViewById(R.id.imgCel3);
        ImageView imView4 =(ImageView) findViewById(R.id.imgCel4);
        ImageView imView5 =(ImageView) findViewById(R.id.imgCel5);
        ImageView imView6 =(ImageView) findViewById(R.id.imgCel6);
        ImageView imView7 =(ImageView) findViewById(R.id.imgCel7);
        ImageView imView8 =(ImageView) findViewById(R.id.imgCel8);
        ImageView imView9 =(ImageView) findViewById(R.id.imgCel9);

        imageList = new ArrayList<>();

        imageList.add(imView1);     imageList.add(imView2);
        imageList.add(imView3);     imageList.add(imView4);
        imageList.add(imView5);     imageList.add(imView6);
        imageList.add(imView7);     imageList.add(imView8);
        imageList.add(imView9);
    }

    /**
     * Mane inflater for page
     * @param menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //menu.findItem(R.id.action_1player).setEnabled(false);
        return true;
    }

    /**
     * Onlick Listener fot menu items
     * @param item menu selected
     * @return parent constructor
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_exit:
                Log.d(MainActivity.LOG_TAG, "debug button11");
                System.exit(0);
                break;
            case R.id.action_2players:
                Intent mainActivity = new Intent(this, MainActivity.class);
                startActivity(mainActivity);
                break;
            case R.id.action_1player:

                break;
            case R.id.action_about:
                showPopUpWindow();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Method for saving data when device orientation changes
     * and setting Screen orientation - Portrait
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * OnClick Listener for Grid field
     * Control game flow
     * @param v View item
     */
    @Override
    public void onClick(View v) {
        ImageView imView = null;
        switch (v.getId()) {

            case R.id.newGameButton: //start new Game
                Log.d(MainActivity.LOG_TAG, "debug button11");
                setCellGrid();
                clearGrid();
                return;
            case R.id.cel1:
                if(!checkField(0)){
                    return;
                }
                prepareCellCross(0);
                imView = imageList.get(0);
                break;
            case R.id.cel2:
                if(!checkField(1)){
                    return;
                }
                prepareCellCross(1);
                imView =imageList.get(1);
                break;
            case R.id.cel3:
                if(!checkField(2)){
                    return;
                }
                prepareCellCross(2);
                imView =imageList.get(2);
                break;
            case R.id.cel4:
                if(!checkField(3)){
                    return;
                }
                prepareCellCross(3);
                imView =imageList.get(3);
                break;
            case R.id.cel5:
                if(!checkField(4)){
                    return;
                }
                prepareCellCross(4);
                imView =imageList.get(4);
                break;
            case R.id.cel6:
                if(!checkField(5)){
                    return;
                }
                prepareCellCross(5);
                imView =imageList.get(5);
                break;
            case R.id.cel7:
                if(!checkField(6)){
                    return;
                }
                prepareCellCross(6);
                imView =imageList.get(6);
                break;
            case R.id.cel8:
                if(!checkField(7)){
                    return;
                }
                prepareCellCross(7);
                imView =imageList.get(7);
                break;
            case R.id.cel9:
                if(!checkField(8)){
                    return;
                }
                prepareCellCross(8);
                imView =imageList.get(8);
                break;
        }

        status.setText("Player 1 Move");

        imView.setImageResource(resCross);

        if(checkLines()){
            finishGame();
            status.setText("Player1 Win!");
            return;
        } else if (count==9){
            status.setText("Deuce!");
        } else {

            int number;

            Log.d(MainActivity.LOG_TAG, "attack return"+attackStrategy());
            Log.d(MainActivity.LOG_TAG, "defence return="+defenceStrategy());

            if(attackStrategy()!=-1){
                number = attackStrategy();
                Log.d(MainActivity.LOG_TAG, "attack="+number);
            } else if(defenceStrategy()!=-1){
                number = defenceStrategy();
                Log.d(MainActivity.LOG_TAG, "defence="+number);
            } else {
                number = new Random().nextInt(8);
            }

            Log.d(MainActivity.LOG_TAG, "random="+number);

            while (!checkField(number)){
                number = new Random().nextInt(8);
                Log.d(MainActivity.LOG_TAG, "random="+number);
            }
            Log.d(MainActivity.LOG_TAG, "final random="+number);
            prepareCellDroid(number);
            ImageView imViewDroid=imageList.get(number);
            imViewDroid.setImageResource(resDroid);
            count++;
        }

        if(checkLines()){
            finishGame();
            status.setText("Droid Win!");
        }
    }

    /**
     * Setting start params for Game
     */
    private void setCellGrid(){
        count=0;
        status.setText("Player1 Move");
        field = new ArrayList<>();
        for (int i=0; i< MainActivity.CELL_AMOUNT; i++) {
            field.add(new Cell(i));
        }

    }

    /**
     * Fill Cell after it was selected
     * @param number
     */
    private void prepareCellCross(int number){
        field.get(number).setActive(true);
        field.get(number).setValue(Cell.Value.CROSS);
    }
    private void prepareCellDroid(int number){
        field.get(number).setActive(true);
        field.get(number).setValue(Cell.Value.ZERO);
    }

    /**
     * Check lines if smbd win
     * @return true if smbd wins
     */
    private boolean checkLines(){

        for (int[] line : MainActivity.lines) {

            if (field.get(line[0]).equals(field.get(line[1])) &&
                    field.get(line[0]).equals(field.get(line[2])) &&
                    !field.get(line[0]).getValue().equals(Cell.Value.NONE)){
                for (int index: line) {
                    imageList.get(index).setBackgroundColor(Color.parseColor(MainActivity.CELL_WIN_COLOR));
                }
                return true;
            }
        }
        return false;
    }

    private int defenceStrategy(){

        int loop=0;

        for (int[] line : MainActivity.lines) {
            if(Cell.Value.CROSS.equals(field.get(line[0]).getValue())){
                if(Cell.Value.CROSS.equals(field.get(line[1]).getValue())){
                    Log.d(MainActivity.LOG_TAG, "def" + MainActivity.lines[loop][2]);
                    return MainActivity.lines[loop][2];
                }
            }

            if(Cell.Value.CROSS.equals(field.get(line[1]).getValue())){
                if(Cell.Value.CROSS.equals(field.get(line[2]).getValue())){
                    Log.d(MainActivity.LOG_TAG, "def" + MainActivity.lines[loop][0]);
                    return MainActivity.lines[loop][0];
                }
            }

            if(Cell.Value.CROSS.equals(field.get(line[0]).getValue())){
                if(Cell.Value.CROSS.equals(field.get(line[2]).getValue())){
                    Log.d(MainActivity.LOG_TAG, "def" + MainActivity.lines[loop][1]);
                    return MainActivity.lines[loop][1];
                }
            }
            loop++;
        }

        return -1;
    }

    private int attackStrategy(){

        int loop=0;

        for (int[] line : MainActivity.lines) {

            if(Cell.Value.ZERO.equals(field.get(line[0]).getValue())){
                if(Cell.Value.ZERO.equals(field.get(line[1]).getValue())){
                    Log.d(MainActivity.LOG_TAG, "att" + MainActivity.lines[loop][2]);
                    return MainActivity.lines[loop][2];
                }
            }

            if(Cell.Value.ZERO.equals(field.get(line[1]).getValue())){
                if(Cell.Value.ZERO.equals(field.get(line[2]).getValue())){
                    Log.d(MainActivity.LOG_TAG, "att" + MainActivity.lines[loop][0]);
                    return MainActivity.lines[loop][0];
                }
            }

            if(Cell.Value.ZERO.equals(field.get(line[0]).getValue())){
                if(Cell.Value.ZERO.equals(field.get(line[2]).getValue())){
                    Log.d(MainActivity.LOG_TAG, "att" + MainActivity.lines[loop][1]);
                    return MainActivity.lines[loop][1];
                }
            }
            loop++;
        }
        return -1;
    }

    /**
     * Finish game. Setting status message
     * Blocking cells from filing until new Game starts
     */
    private void finishGame(){
        for (Cell cell: field) {
            cell.setActive(true);
        }

    }

    /**
     * Checking if Cell is already filled
     * @param number cell number
     * @return true if cell filled
     */
    private boolean checkField(int number){
        if(field.get(number).isActive()){
            Toast.makeText(this, "Field is already filled", Toast.LENGTH_SHORT).show();
            return false;
        }
        count++;
        return true;
    }

    /**
     * Clear all Cells for New Game
     */
    private void clearGrid(){
        for (ImageView view: imageList) {
            view.setImageDrawable(null);
            view.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    /**
     * Show PopUp window with info about application
     */
    private void showPopUpWindow() {
        Log.d(MainActivity.LOG_TAG, "show popup");
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View popupView = layoutInflater.inflate(R.layout.pop_up, null);

        popupWindow = new PopupWindow(popupView,
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
        //popupWindow.showAtLocation
        // (this.findViewById(R.id.ScrollView01), Gravity.CENTER, 0, 0);

        //popupWindow .setTouchable(true);
        //popupWindow .setFocusable(true);

        Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);

        btnDismiss.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

}
