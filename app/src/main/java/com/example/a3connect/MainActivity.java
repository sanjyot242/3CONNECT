package com.example.a3connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //2 emptystate
    int counter=1;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winningState={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int  tappedview ;
    private TextView textView;
    private Button button;
    boolean Gameon=true;
    public void check(View view) {
        if ((counter % 2) == 0) {
                dropInX(view);
        } else {
                dropInY(view);
        }
    }


    public void dropInX(View view){
        ImageView imageView= (ImageView) view;
        tappedview=Integer.parseInt(imageView.getTag().toString());
        if(gamestate[tappedview]==2 && Gameon) {
            imageView.setTranslationY((-1500));
            imageView.setImageResource(R.drawable.zero);
            imageView.animate().translationYBy(1500).rotation(3600).setDuration(1000);
            gamestate[tappedview] = 0;
            counter++;
            check();
        }
    }

    public void dropInY(View view){
        ImageView imageView= (ImageView) view;
        tappedview=Integer.parseInt(imageView.getTag().toString());
        if(gamestate[tappedview]==2 && Gameon) {
            imageView.setTranslationY((-1500));
            imageView.setImageResource(R.drawable.cross);
            imageView.animate().translationYBy(1500).rotation(3600).setDuration(1000);
            gamestate[tappedview] = 1;
            counter++;
            check();
        }
    }

    public void check(){
        for(int[] winningState:winningState){
            if (gamestate[winningState[0]]==gamestate[winningState[1]] && gamestate[winningState[1]]==gamestate[winningState[2]] && gamestate[winningState[0]]!=2){
                Gameon=false;
                textView=findViewById(R.id.textView);
                textView.setVisibility(View.VISIBLE);
                button=findViewById(R.id.but);
                button.setVisibility(View.VISIBLE);
                //someone has won
                if((counter%2)==0){
                    textView.setText("Player X Wins");
                    Toast.makeText(this, "X wins ", Toast.LENGTH_LONG).show();
            }else{
                    textView.setText("Player Y Wins");
                    Toast.makeText(this, "0 wins", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void playAgain(View view){
        textView=findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);
        button=findViewById(R.id.but);
        button.setVisibility(View.INVISIBLE);

        try {
            GridLayout gridLayout=(GridLayout) findViewById(R.id.gridLayout);
            for (int i = 0; i < gridLayout.getChildCount(); i++) {
                ImageView imageView = (ImageView) gridLayout.getChildAt(i);
                imageView.setImageDrawable(null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for(int z=0;z<9;z++){
            gamestate[z]=2;
        }
        counter=1;
         Gameon=true;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
