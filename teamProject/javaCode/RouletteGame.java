package com.example.teamproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteGame extends Activity {
    List<WheelItem> wheelItems ;
    LuckyWheel luckyWheel;
    String point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roulette_game);

        //변수에 담기
        luckyWheel = findViewById(R.id.luck_wheel);

        //점수판 데이터 생성
        generateWheelItems();

        //점수판 타겟 정해지면 이벤트 발생
        luckyWheel.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                WheelItem wheelItem = wheelItems.get(Integer.parseInt(point)-1);
                String money = wheelItem.text;
                Toast.makeText(RouletteGame.this, money, Toast.LENGTH_SHORT).show();
            }
        });

        Button start = findViewById(R.id.spin_btn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                point = String.valueOf(random.nextInt(6)+1); // 1 ~ 6
                luckyWheel.rotateWheelTo(Integer.parseInt(point));
            }
        });
    }
    private void generateWheelItems() {
        wheelItems = new ArrayList<>();

        Drawable d = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            d = getResources().getDrawable(R.drawable.soju5,null);
        }
        Bitmap bitmap = drawableToBitmap(d);
        wheelItems.add(new WheelItem(Color.parseColor("#F44336"), bitmap, "1 잔"));
        wheelItems.add(new WheelItem(Color.parseColor("#E91E63"), bitmap, "2 잔"));
        wheelItems.add(new WheelItem(Color.parseColor("#9C27B0"), bitmap, "3 잔"));
        wheelItems.add(new WheelItem(Color.parseColor("#3F51B5"), bitmap, "4 잔"));
        wheelItems.add(new WheelItem(Color.parseColor("#1E88E5"), bitmap, "5 잔"));
        wheelItems.add(new WheelItem(Color.parseColor("#009688"), bitmap, "한 턴 쉬기"));
        //점수판에 데이터 넣기
        luckyWheel.addWheelItems(wheelItems);
    }
    public static Bitmap drawableToBitmap (Drawable drawable) {

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

}
