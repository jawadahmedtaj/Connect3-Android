package com.example.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0 = yellow and 1 = red
    int activePlayer = 0;
    //2 means unplayed state
    int[] gameState= {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPostitions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropIn(View view){

        ImageView counter = (ImageView) view;
        //counter.setTranslationY(-1000f);
        counter.setAlpha(0f);
        System.out.println(counter.getTag().toString());
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2){
            gameState[tappedCounter] = activePlayer;

        if (activePlayer==0){
            counter.setImageResource(R.drawable.yellow);
            activePlayer = 1;
        }

        else{
            counter.setImageResource(R.drawable.red);
            activePlayer = 0;
        }
        }
        //counter.setTranslationY(1000f);


        counter.animate().alpha(1f).setDuration(300);
        for (int[]winningPostitions: winningPostitions){
            if (gameState[winningPostitions[0]] == gameState[winningPostitions[1]] &&
                    gameState[winningPostitions[1]] == gameState[winningPostitions[2]] &&
                        gameState[winningPostitions[0]] != 2)
            {
                Toast.makeText(this, gameState[winningPostitions[0]], Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
