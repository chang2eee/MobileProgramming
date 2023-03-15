package com.example.teamproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class YutGame extends Activity {
    int imgYut[] = {R.drawable.yut_0, R.drawable.yut_1};
    String Yut[] = {"윷", "걸", "개", "도", "모"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yut_game);
        findViewById(R.id.Button01).setOnClickListener(myButtonClick);
    }

    View.OnClickListener myButtonClick = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Random rnd = new Random();
            int n1 = 1 - rnd.nextInt(10)/6;
            int n2 = 1 - rnd.nextInt(10)/6;
            int n3 = 1 - rnd.nextInt(10)/6;
            int n4 = 1- rnd.nextInt(10)/6;
            int n = n1 + n2 + n3 + n4;

            ((ImageView)findViewById(R.id.ImageView01)).setImageResource(imgYut[n1]);
            ((ImageView)findViewById(R.id.ImageView02)).setImageResource(imgYut[n2]);
            ((ImageView)findViewById(R.id.ImageView03)).setImageResource(imgYut[n3]);
            ((ImageView)findViewById(R.id.ImageView04)).setImageResource(imgYut[n4]);
            ((TextView)findViewById(R.id.TextView05)).setText(Yut[n]);

        }
    };
}