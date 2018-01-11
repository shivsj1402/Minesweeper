package com.example.shiv.minesweeper;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import beans.GridItemIdentifier;
import ca.dal.controller.MainController;


public class MainActivity extends AppCompatActivity {
    public GridView gv;

    Button Start,basic,intermediate,advanced;
    TextView time;
    TextView mCount;
    CountDownTimer timer = null;
    int count =0;
    int Mine =9;
    final MainController mc = new MainController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gv = (GridView) this.findViewById(R.id.mygrid);
        Start= (Button) findViewById(R.id.button1);
        basic= (Button) findViewById(R.id.button2);
        intermediate= (Button) findViewById(R.id.button3);
        advanced= (Button) findViewById(R.id.button4);
        time= (TextView) findViewById(R.id.time);
        mCount=(TextView)findViewById(R.id.mcount);
        final AppCompatActivity temp = this;

        Toast.makeText(getApplicationContext(),"Select Difficulty",Toast.LENGTH_SHORT).show();
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                if(timer != null){
                    timer.cancel();
                }
                timer = new CountDownTimer(999000,1000) {
                    @Override
                    public void onTick(long l) {
                        count++;
                        time.setText(Integer.toString(count));
                    }

                    @Override
                    public void onFinish() {
                        time.setText("00");
                        Toast.makeText(getApplicationContext(), "Game Over",Toast.LENGTH_SHORT).show();
                        count=0;
                    }
                }.start();
                mc.initialize(temp, Mine);
            }
        });

        basic.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Mine = 9;
               mCount.setText("09");

               Toast.makeText(getApplicationContext(),"Select Start to Start/Reset the game",Toast.LENGTH_SHORT).show();
           }
       });
        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mine = 25;
                mCount.setText("25");
                Toast.makeText(getApplicationContext(),"Select Start to Start/Reset the game",Toast.LENGTH_SHORT).show();
            }
        });
        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mine = 40;
                mCount.setText("40");
                Toast.makeText(getApplicationContext(),"Select Start to Start/Reset the game",Toast.LENGTH_SHORT).show();
            }
        });

        gv.setLongClickable(true);
        gv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                GridItemIdentifier gid = new GridItemIdentifier();
                gid.setxIndex(position/9);
                gid.setyIndex(position%9);

                mc.setflag(temp, gid);

                return false;
            }
        });
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                GridItemIdentifier gid = new GridItemIdentifier();
                gid.setxIndex(position/9);
                gid.setyIndex(position%9);
                Log.d("App Logs", String.valueOf(gid.getxIndex()) + "  " + String.valueOf(gid.getyIndex()));
                mc.buttonClicked(temp, gid);
            }
        });

    }


}
