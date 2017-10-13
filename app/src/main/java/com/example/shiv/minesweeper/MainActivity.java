package com.example.shiv.minesweeper;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import beans.GridItem;
import ca.dal.controller.MainController;
import services.RendererService;

public class MainActivity extends AppCompatActivity {
    public GridView gv;

    Button Start;
    TextView time;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gv = (GridView) this.findViewById(R.id.mygrid);
        Start= (Button) findViewById(R.id.button);
        time= (TextView) findViewById(R.id.time);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new CountDownTimer(999000,1000) {
                    @Override
                    public void onTick(long l) {
                        count++;
                        time.setText(Integer.toString(count));
                        // SStart.setText(Integer.toString(count));
                    }

                    @Override
                    public void onFinish() {
                        time.setText("00");
                        Toast.makeText(getApplicationContext(), "Game Over",Toast.LENGTH_SHORT).show();
                        count=0;
                    }
                }.start();
            }
        });

        MainController.initialize(this);

    }


}
