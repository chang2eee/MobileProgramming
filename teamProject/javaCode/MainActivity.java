package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnYut = (Button) findViewById(R.id.btnYut);
        btnYut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentYut = new Intent(getApplicationContext(), YutGame.class);
                startActivity(intentYut);
            }
        });

        Button btnSpinBottle = (Button) findViewById(R.id.btnSpinBottle);
        btnSpinBottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSpinBottle = new Intent(getApplicationContext(), SpinningBottleGame.class);
                startActivity(intentSpinBottle);
            }
        });

        Button btnRoulette = (Button) findViewById(R.id.btnRoulette);
        btnRoulette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRoulette = new Intent(getApplicationContext(), RouletteGame.class);
                startActivity(intentRoulette);
            }
        });

        Button btnRollDice = (Button) findViewById(R.id.btnRollDice);
        btnRollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRollDice = new Intent(getApplicationContext(), DiceGame.class);
                startActivity(intentRollDice);
            }
        });

        Button btnFlipCoin = (Button) findViewById(R.id.btnFlipCoin);
        btnFlipCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFlipCoin = new Intent(getApplicationContext(), FlipCoinGame.class);
                startActivity(intentFlipCoin);
            }
        });

        Button btnRockPaperScissors = (Button) findViewById(R.id.btnRockPaperScissors);
        btnRockPaperScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRockPaperScissors = new Intent(getApplicationContext(), RockPaperScissorsGame.class);
                startActivity(intentRockPaperScissors);
            }
        });
        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.mainmusic);
        mediaPlayer.start();

    }


}