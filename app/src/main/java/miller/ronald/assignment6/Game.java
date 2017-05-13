package miller.ronald.assignment6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {

    private boolean isGameOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_game);

        LinearLayout cardHolder = (LinearLayout) findViewById(R.id.card_holder);
        View card1 = findViewById(R.id.card1);
        View card2 = findViewById(R.id.card2);
        View card3 = findViewById(R.id.card3);

        cardHolder.removeView(card1);
        cardHolder.removeView(card2);
        cardHolder.removeView(card3);

        Random rand = new Random();

        switch (rand.nextInt(5)){
            case 0:
                cardHolder.addView(card1);
                cardHolder.addView(card2);
                cardHolder.addView(card3);
                break;
            case 1:
                cardHolder.addView(card1);
                cardHolder.addView(card3);
                cardHolder.addView(card2);
                break;
            case 2:
                cardHolder.addView(card2);
                cardHolder.addView(card3);
                cardHolder.addView(card1);
                break;
            case 3:
                cardHolder.addView(card2);
                cardHolder.addView(card1);
                cardHolder.addView(card3);
                break;
            case 4:
                cardHolder.addView(card3);
                cardHolder.addView(card1);
                cardHolder.addView(card2);
                break;
            case 5:
                cardHolder.addView(card3);
                cardHolder.addView(card2);
                cardHolder.addView(card1);
                break;
        }

        isGameOver = false;

    }

    public void flipCard1(View view){

        if(!isGameOver){
            View rootLayout = findViewById(R.id.card1);
            View cardFace = findViewById(R.id.card1Face);
            View cardBack = findViewById(R.id.cardback1);

            FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);

            if (cardFace.getVisibility() == View.GONE)
            {
                flipAnimation.reverse();
            }
            rootLayout.startAnimation(flipAnimation);
            Toast.makeText(getBaseContext(), "Congratulations! You Win!", Toast.LENGTH_LONG).show();
            isGameOver = true;
        }else{
            Toast.makeText(getBaseContext(), "Start a new game to try again!", Toast.LENGTH_LONG).show();
        }


    }

    public void flipCard2(View view){

        if(!isGameOver) {
            View rootLayout = findViewById(R.id.card2);
            View cardFace = findViewById(R.id.card2Face);
            View cardBack = findViewById(R.id.cardback2);

            FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);

            if (cardFace.getVisibility() == View.GONE)
            {
                flipAnimation.reverse();
            }
            rootLayout.startAnimation(flipAnimation);
            isGameOver = true;
            Toast.makeText(getBaseContext(), "Whoops! Game Over", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getBaseContext(), "Start a new game to try again!", Toast.LENGTH_LONG).show();
        }


    }

    public void flipCard3(View view){

        if(!isGameOver){
            View rootLayout = findViewById(R.id.card3);
            View cardFace = findViewById(R.id.card3Face);
            View cardBack = findViewById(R.id.cardback3);

            FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);

            if (cardFace.getVisibility() == View.GONE)
            {
                flipAnimation.reverse();
            }
            rootLayout.startAnimation(flipAnimation);
            isGameOver = true;
            Toast.makeText(getBaseContext(), "Whoops! Game Over", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getBaseContext(), "Start a new game to try again!", Toast.LENGTH_LONG).show();
        }

    }

    public void startNewGame(View view){
        finish();
        startActivity(getIntent());
    }
}
