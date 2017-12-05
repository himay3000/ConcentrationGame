package com.example.monic_000.concentrationgame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    Random rand = new Random();
    private Button mTryAgainButton;
    private Button mNewGameButton;


    //images used for game
    private Bitmap dogImage;
    private Bitmap boyImage;
    private Bitmap babyImage;
    private Bitmap penImage;
    private Bitmap boxImage;
    private Bitmap hatImage;
    private Bitmap towelImage;
    private Bitmap headImage;
    private Bitmap shortImage;
    private Bitmap hairImage;
    private Bitmap mImage;



    private int score = 0;
    private int numOfCards= 0;
    private LinearLayout mRow1Layout;
    private LinearLayout mRow2Layout;
    private LinearLayout mRow3Layout;
    private LinearLayout mRow4Layout;
    private LinearLayout mRow5Layout;
    private ImageButton mRow1Button1;
    private ImageButton mRow1Button2;
    private ImageButton mRow1Button3;
    private ImageButton mRow1Button4;
    private ImageButton mRow2Button1;
    private ImageButton mRow2Button2;
    private ImageButton mRow2Button3;
    private ImageButton mRow2Button4;
    private ImageButton mRow3Button1;
    private ImageButton mRow3Button2;
    private ImageButton mRow3Button3;
    private ImageButton mRow3Button4;
    private ImageButton mRow4Button1;
    private ImageButton mRow4Button2;
    private ImageButton mRow4Button3;
    private ImageButton mRow4Button4;
    private ImageButton mRow5Button1;
    private ImageButton mRow5Button2;
    private ImageButton mRow5Button3;
    private ImageButton mRow5Button4;

    ArrayList<ImageButton> buttons = new ArrayList<>();
    ArrayList<Bitmap> ima = new ArrayList<>(10);
    ArrayList<Integer> wordInd = new ArrayList<>();
    ArrayList<Integer> usedInd = new ArrayList<>();

    //store the indices of the images in the ima arraylist
    int usedWordInd = 0;
    int prevIndex = 0;
    int ID11 = 0;int ID12 = 0;int ID13 = 0;int ID14 = 0;
    int ID21 = 0;int ID22 = 0;int ID23 = 0;int ID24 = 0;
    int ID31 = 0;int ID32 = 0;int ID33 = 0;int ID34 = 0;
    int ID41 = 0;int ID42 = 0;int ID43 = 0;int ID44 = 0;
    int ID51 = 0;int ID52 = 0;int ID53 = 0;int ID54 = 0;

    //track the cards that are flipped
    int firstCard = 0;
    int secondCard =0;
    boolean match = false;
    int cardsFlipped = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        TextView sc = (TextView)findViewById(R.id.scoreDisplay) ;
        sc.setText("Score: " + score);
        Button ta = (Button)findViewById(R.id.try_again_button);
        ta.setEnabled(false);
        mImage = BitmapFactory.decodeResource(getResources(), R.drawable.questionmark_icon);
        dogImage = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        boyImage = BitmapFactory.decodeResource(getResources(), R.drawable.boy);
        babyImage = BitmapFactory.decodeResource(getResources(), R.drawable.baby);
        penImage = BitmapFactory.decodeResource(getResources(), R.drawable.pen);
        boxImage = BitmapFactory.decodeResource(getResources(), R.drawable.box);
        hatImage = BitmapFactory.decodeResource(getResources(), R.drawable.hat);
        towelImage = BitmapFactory.decodeResource(getResources(), R.drawable.towel);
        headImage = BitmapFactory.decodeResource(getResources(), R.drawable.head);
        shortImage = BitmapFactory.decodeResource(getResources(), R.drawable.small);
        hairImage = BitmapFactory.decodeResource(getResources(), R.drawable.questionmark_icon);
        mImage = Bitmap.createScaledBitmap(mImage, 220,220, true);
        mRow1Layout = (LinearLayout) findViewById(R.id.row1_layout);
        mRow2Layout = (LinearLayout) findViewById(R.id.row2_layout);
        mRow3Layout = (LinearLayout) findViewById(R.id.row3_layout);
        mRow4Layout = (LinearLayout) findViewById(R.id.row4_layout);
        mRow5Layout = (LinearLayout) findViewById(R.id.row5_layout);


        populateList();
        populateButtons();
        Intent i = getIntent();
        numOfCards = i.getIntExtra("amount", 0);
        setTiles(numOfCards);
        endGameClick();
        createGame(i.getIntExtra("amount", 0));



        mNewGameButton = (Button) findViewById(R.id.new_game_button);
        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GameActivity.this, SizeActivity.class);
                startActivity(i);
            }
        });

    }

    private void populateButtons(){
        buttons.add(mRow1Button1);buttons.add(mRow1Button2);buttons.add(mRow1Button3);buttons.add(mRow1Button4);
        buttons.add(mRow2Button1);buttons.add(mRow2Button2);buttons.add(mRow2Button3);buttons.add(mRow2Button4);
        buttons.add(mRow3Button1);buttons.add(mRow3Button2);buttons.add(mRow3Button3);buttons.add(mRow3Button4);
        buttons.add(mRow4Button1);buttons.add(mRow4Button2);buttons.add(mRow4Button3);buttons.add(mRow4Button4);
        buttons.add(mRow5Button1);buttons.add(mRow5Button2);buttons.add(mRow5Button3);buttons.add(mRow5Button4);

    }
    private void populateList(){
        ima.add(dogImage);ima.add(boyImage);ima.add(babyImage);ima.add(penImage);ima.add(boxImage);
        ima.add(hatImage);ima.add(towelImage);ima.add(headImage);ima.add(shortImage);ima.add(hairImage);
    }
    private void setTiles(int num){
        int index = 0;
        switch (num){
            case 4:
                for(int i = 0; i <2; i++){
                    index = rand.nextInt(ima.size());
                    for(int j =0; j < wordInd.size(); j++){
                        if(index == wordInd.get(j)){
                            index = rand.nextInt(ima.size());
                            j=-1;
                        }
                    }
                    wordInd.add(index);
                }
                break;
            case 6:
                for(int i = 0; i <3; i++){
                    index = rand.nextInt(ima.size());
                    for(int j =0; j < wordInd.size(); j++){
                        if(index == wordInd.get(j)){
                            index = rand.nextInt(ima.size());
                            j=-1;
                        }
                    }
                    wordInd.add(index);
                }
                break;
            case 8:
                for(int i = 0; i <4; i++){
                    index = rand.nextInt(ima.size());
                    for(int j =0; j < wordInd.size(); j++){
                        if(index == wordInd.get(j)){
                            index = rand.nextInt(ima.size());
                            j=-1;
                        }
                    }
                    wordInd.add(index);
                }
                break;
            case 10:
                for(int i = 0; i <5; i++){
                    index = rand.nextInt(ima.size());
                    for(int j =0; j < wordInd.size(); j++){
                        if(index == wordInd.get(j)){
                            index = rand.nextInt(ima.size());
                            j=-1;
                        }
                    }
                    wordInd.add(index);
                }
                break;
            case 12:
                for(int i = 0; i <6; i++){
                    index = rand.nextInt(ima.size());
                    for(int j =0; j < wordInd.size(); j++){
                        if(index == wordInd.get(j)){
                            index = rand.nextInt(ima.size());
                            j=-1;
                        }
                    }
                    wordInd.add(index);
                }
                break;
            case 14:
                for(int i = 0; i <7; i++){
                    index = rand.nextInt(ima.size());
                    for(int j =0; j < wordInd.size(); j++){
                        if(index == wordInd.get(j)){
                            index = rand.nextInt(ima.size());
                            j=-1;
                        }
                    }
                    wordInd.add(index);
                }
                break;
            case 16:
                for(int i = 0; i <8; i++){
                    index = rand.nextInt(ima.size());
                    for(int j =0; j < wordInd.size(); j++){
                        if(index == wordInd.get(i)){
                            index = rand.nextInt(ima.size());
                            i=-1;
                        }
                    }
                    wordInd.add(index);
                }
                break;
            case 18:
                for(int i = 0; i <9; i++){
                    index = rand.nextInt(ima.size());
                    for(int j =0; j < wordInd.size(); j++){
                        if(index == wordInd.get(j)){
                            index = rand.nextInt(ima.size());
                            j=-1;
                        }
                    }
                    wordInd.add(index);
                }
                break;
            case 20:
                for(int i = 0; i <10; i++){
                    index = rand.nextInt(ima.size());
                    for(int j =0; j < wordInd.size(); j++){
                        if(index == wordInd.get(j)){
                            index = rand.nextInt(ima.size());
                            j=-1;
                        }
                    }
                    wordInd.add(index);
                }
                break;
            default:
                System.out.println("Unexpected error");
                System.exit(0);

        }
    }
    private void createGame(int number) {
        if(number == 4) {
            createRow1(2);
            createRow2(2);
        }else if(number == 6) {
            createRow1(3);
            createRow2(3);
        }else if(number == 8) {
            createRow1(4);
            createRow2(4);
        }else if(number == 10) {
            createRow1(4);
            createRow2(4);
            createRow3(2);
        }else if(number == 12) {
            createRow1(4);
            createRow2(4);
            createRow3(4);
        }else if(number == 14) {
            createRow1(4);
            createRow2(4);
            createRow3(4);
            createRow4(2);
        }else if(number == 16) {
            createRow1(4);
            createRow2(4);
            createRow3(4);
            createRow4(4);
        }else if(number == 18) {
            createRow1(4);
            createRow2(4);
            createRow3(4);
            createRow4(4);
            createRow5(2);
        }else if(number == 20) {
            createRow1(4);
            createRow2(4);
            createRow3(4);
            createRow4(4);
            createRow5(4);
        }
    }

    private void reset(){
        if(usedInd.size() == wordInd.size()){
            usedInd.clear();
        }
    }

//method: checkMatch
//purpose: checks to see if cards that are flipped are a match
    private void checkMatch(){
        TextView sc = (TextView)findViewById(R.id.scoreDisplay) ;
        Button ta = (Button)findViewById(R.id.try_again_button);
        if(firstCard == secondCard){
            score++;
            match = true;
            sc.setText("Score: " + score);
            ta.setEnabled(false);
        }
        else{
            if(score == 0){
                score =0;
                sc.setText("Score: " + score);
                ta.setEnabled(true);
            }
            else{
                score -=1;
                sc.setText("Score: " + score);
                ta.setEnabled(true);
            }
        }
        cardsFlipped = 0;
    }

    private void checkNumFlipped(){
         if(cardsFlipped == 2){
            checkMatch();
        }
    }
//method: assignCards
//purpose: takes in the ID of a card and assigns it to an the proper int that will be used to compare
    private void assignCards(int cardID){
        if(cardsFlipped == 0){
            firstCard = cardID;
            cardsFlipped++;
        }
        else{
            secondCard = cardID;
            cardsFlipped++;
        }

    }

    private void endGameClick(){

        Button mEndGameButton = (Button)findViewById(R.id.end_game_button);
        mEndGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numOfCards == 4){
                    score = 0;
                    TextView sc = (TextView) findViewById(R.id.scoreDisplay);
                    sc.setText("Score: " + score);
                    Toast.makeText(GameActivity.this, "Game Ended", Toast.LENGTH_LONG).show();
                    mRow1Button1.setImageBitmap(ima.get(ID11));mRow1Button1.setClickable(false);
                    mRow1Button2.setImageBitmap(ima.get(ID12));mRow1Button2.setClickable(false);
                    mRow2Button1.setImageBitmap(ima.get(ID21));mRow2Button1.setClickable(false);
                    mRow2Button2.setImageBitmap(ima.get(ID22));mRow2Button2.setClickable(false);

                }
                else if(numOfCards == 6){
                    score = 0;
                    TextView sc = (TextView) findViewById(R.id.scoreDisplay);
                    sc.setText("Score: " + score);
                    Toast.makeText(GameActivity.this, "Game Ended", Toast.LENGTH_LONG).show();
                    mRow1Button1.setImageBitmap(ima.get(ID11));mRow1Button1.setClickable(false);
                    mRow1Button2.setImageBitmap(ima.get(ID12));mRow1Button2.setClickable(false);
                    mRow1Button3.setImageBitmap(ima.get(ID13));mRow1Button3.setClickable(false);
                    mRow2Button1.setImageBitmap(ima.get(ID21));mRow2Button1.setClickable(false);
                    mRow2Button2.setImageBitmap(ima.get(ID22));mRow2Button2.setClickable(false);
                    mRow2Button3.setImageBitmap(ima.get(ID23));mRow2Button3.setClickable(false);
                }
                else if(numOfCards == 8){
                    score = 0;
                    TextView sc = (TextView) findViewById(R.id.scoreDisplay);
                    sc.setText("Score: " + score);
                    Toast.makeText(GameActivity.this, "Game Ended", Toast.LENGTH_LONG).show();
                    mRow1Button1.setImageBitmap(ima.get(ID11));mRow1Button1.setClickable(false);
                    mRow1Button2.setImageBitmap(ima.get(ID12));mRow1Button2.setClickable(false);
                    mRow1Button3.setImageBitmap(ima.get(ID13));mRow1Button3.setClickable(false);
                    mRow1Button4.setImageBitmap(ima.get(ID14));mRow1Button4.setClickable(false);
                    mRow2Button1.setImageBitmap(ima.get(ID21));mRow2Button1.setClickable(false);
                    mRow2Button2.setImageBitmap(ima.get(ID22));mRow2Button2.setClickable(false);
                    mRow2Button3.setImageBitmap(ima.get(ID23));mRow2Button3.setClickable(false);
                    mRow2Button4.setImageBitmap(ima.get(ID24));mRow2Button4.setClickable(false);
                }
                else if(numOfCards == 10){
                    score = 0;
                    TextView sc = (TextView) findViewById(R.id.scoreDisplay);
                    sc.setText("Score: " + score);
                    Toast.makeText(GameActivity.this, "Game Ended", Toast.LENGTH_LONG).show();
                    mRow1Button1.setImageBitmap(ima.get(ID11));mRow1Button1.setClickable(false);
                    mRow1Button2.setImageBitmap(ima.get(ID12));mRow1Button2.setClickable(false);
                    mRow1Button3.setImageBitmap(ima.get(ID13));mRow1Button3.setClickable(false);
                    mRow1Button4.setImageBitmap(ima.get(ID14));mRow1Button4.setClickable(false);
                    mRow2Button1.setImageBitmap(ima.get(ID21));mRow2Button1.setClickable(false);
                    mRow2Button2.setImageBitmap(ima.get(ID22));mRow2Button2.setClickable(false);
                    mRow2Button3.setImageBitmap(ima.get(ID23));mRow2Button3.setClickable(false);
                    mRow2Button4.setImageBitmap(ima.get(ID24));mRow2Button4.setClickable(false);
                    mRow3Button1.setImageBitmap(ima.get(ID31));mRow3Button1.setClickable(false);
                    mRow3Button2.setImageBitmap(ima.get(ID32));mRow3Button2.setClickable(false);
                }
                else if(numOfCards == 12){
                    score = 0;
                    TextView sc = (TextView) findViewById(R.id.scoreDisplay);
                    sc.setText("Score: " + score);
                    Toast.makeText(GameActivity.this, "Game Ended", Toast.LENGTH_LONG).show();
                    mRow1Button1.setImageBitmap(ima.get(ID11));mRow1Button1.setClickable(false);
                    mRow1Button2.setImageBitmap(ima.get(ID12));mRow1Button2.setClickable(false);
                    mRow1Button3.setImageBitmap(ima.get(ID13));mRow1Button3.setClickable(false);
                    mRow1Button4.setImageBitmap(ima.get(ID14));mRow1Button4.setClickable(false);
                    mRow2Button1.setImageBitmap(ima.get(ID21));mRow2Button1.setClickable(false);
                    mRow2Button2.setImageBitmap(ima.get(ID22));mRow2Button2.setClickable(false);
                    mRow2Button3.setImageBitmap(ima.get(ID23));mRow2Button3.setClickable(false);
                    mRow2Button4.setImageBitmap(ima.get(ID24));mRow2Button4.setClickable(false);
                    mRow3Button1.setImageBitmap(ima.get(ID31));mRow3Button1.setClickable(false);
                    mRow3Button2.setImageBitmap(ima.get(ID32));mRow3Button2.setClickable(false);
                    mRow3Button3.setImageBitmap(ima.get(ID33));mRow3Button3.setClickable(false);
                    mRow3Button4.setImageBitmap(ima.get(ID34));mRow3Button4.setClickable(false);
                }
                else if(numOfCards == 14){
                    score = 0;
                    TextView sc = (TextView) findViewById(R.id.scoreDisplay);
                    sc.setText("Score: " + score);
                    Toast.makeText(GameActivity.this, "Game Ended", Toast.LENGTH_LONG).show();
                    mRow1Button1.setImageBitmap(ima.get(ID11));mRow1Button1.setClickable(false);
                    mRow1Button2.setImageBitmap(ima.get(ID12));mRow1Button2.setClickable(false);
                    mRow1Button3.setImageBitmap(ima.get(ID13));mRow1Button3.setClickable(false);
                    mRow1Button4.setImageBitmap(ima.get(ID14));mRow1Button4.setClickable(false);
                    mRow2Button1.setImageBitmap(ima.get(ID21));mRow2Button1.setClickable(false);
                    mRow2Button2.setImageBitmap(ima.get(ID22));mRow2Button2.setClickable(false);
                    mRow2Button3.setImageBitmap(ima.get(ID23));mRow2Button3.setClickable(false);
                    mRow2Button4.setImageBitmap(ima.get(ID24));mRow2Button4.setClickable(false);
                    mRow3Button1.setImageBitmap(ima.get(ID31));mRow3Button1.setClickable(false);
                    mRow3Button2.setImageBitmap(ima.get(ID32));mRow3Button2.setClickable(false);
                    mRow3Button3.setImageBitmap(ima.get(ID33));mRow3Button3.setClickable(false);
                    mRow3Button4.setImageBitmap(ima.get(ID34));mRow3Button4.setClickable(false);
                    mRow4Button1.setImageBitmap(ima.get(ID41));mRow4Button1.setClickable(false);
                    mRow4Button2.setImageBitmap(ima.get(ID42));mRow4Button2.setClickable(false);
                }
                else if(numOfCards == 16){
                    score = 0;
                    TextView sc = (TextView) findViewById(R.id.scoreDisplay);
                    sc.setText("Score: " + score);
                    Toast.makeText(GameActivity.this, "Game Ended", Toast.LENGTH_LONG).show();
                    mRow1Button1.setImageBitmap(ima.get(ID11));mRow1Button1.setClickable(false);
                    mRow1Button2.setImageBitmap(ima.get(ID12));mRow1Button2.setClickable(false);
                    mRow1Button3.setImageBitmap(ima.get(ID13));mRow1Button3.setClickable(false);
                    mRow1Button4.setImageBitmap(ima.get(ID14));mRow1Button4.setClickable(false);
                    mRow2Button1.setImageBitmap(ima.get(ID21));mRow2Button1.setClickable(false);
                    mRow2Button2.setImageBitmap(ima.get(ID22));mRow2Button2.setClickable(false);
                    mRow2Button3.setImageBitmap(ima.get(ID23));mRow2Button3.setClickable(false);
                    mRow2Button4.setImageBitmap(ima.get(ID24));mRow2Button4.setClickable(false);
                    mRow3Button1.setImageBitmap(ima.get(ID31));mRow3Button1.setClickable(false);
                    mRow3Button2.setImageBitmap(ima.get(ID32));mRow3Button2.setClickable(false);
                    mRow3Button3.setImageBitmap(ima.get(ID33));mRow3Button3.setClickable(false);
                    mRow3Button4.setImageBitmap(ima.get(ID34));mRow3Button4.setClickable(false);
                    mRow4Button1.setImageBitmap(ima.get(ID41));mRow4Button1.setClickable(false);
                    mRow4Button2.setImageBitmap(ima.get(ID42));mRow4Button2.setClickable(false);
                    mRow4Button3.setImageBitmap(ima.get(ID43));mRow4Button3.setClickable(false);
                    mRow4Button4.setImageBitmap(ima.get(ID44));mRow4Button4.setClickable(false);
                }
                else if(numOfCards == 18){
                    score = 0;
                    TextView sc = (TextView) findViewById(R.id.scoreDisplay);
                    sc.setText("Score: " + score);
                    Toast.makeText(GameActivity.this, "Game Ended", Toast.LENGTH_LONG).show();
                    mRow1Button1.setImageBitmap(ima.get(ID11));mRow1Button1.setClickable(false);
                    mRow1Button2.setImageBitmap(ima.get(ID12));mRow1Button2.setClickable(false);
                    mRow1Button3.setImageBitmap(ima.get(ID13));mRow1Button3.setClickable(false);
                    mRow1Button4.setImageBitmap(ima.get(ID14));mRow1Button4.setClickable(false);
                    mRow2Button1.setImageBitmap(ima.get(ID21));mRow2Button1.setClickable(false);
                    mRow2Button2.setImageBitmap(ima.get(ID22));mRow2Button2.setClickable(false);
                    mRow2Button3.setImageBitmap(ima.get(ID23));mRow2Button3.setClickable(false);
                    mRow2Button4.setImageBitmap(ima.get(ID24));mRow2Button4.setClickable(false);
                    mRow3Button1.setImageBitmap(ima.get(ID31));mRow3Button1.setClickable(false);
                    mRow3Button2.setImageBitmap(ima.get(ID32));mRow3Button2.setClickable(false);
                    mRow3Button3.setImageBitmap(ima.get(ID33));mRow3Button3.setClickable(false);
                    mRow3Button4.setImageBitmap(ima.get(ID34));mRow3Button4.setClickable(false);
                    mRow4Button1.setImageBitmap(ima.get(ID41));mRow4Button1.setClickable(false);
                    mRow4Button2.setImageBitmap(ima.get(ID42));mRow4Button2.setClickable(false);
                    mRow4Button3.setImageBitmap(ima.get(ID43));mRow4Button3.setClickable(false);
                    mRow4Button4.setImageBitmap(ima.get(ID44));mRow4Button4.setClickable(false);
                    mRow5Button1.setImageBitmap(ima.get(ID51));mRow5Button1.setClickable(false);
                    mRow5Button2.setImageBitmap(ima.get(ID52));mRow5Button2.setClickable(false);
                }
                if(numOfCards == 20) {
                    score = 0;
                    TextView sc = (TextView) findViewById(R.id.scoreDisplay);
                    sc.setText("Score: " + score);
                    Toast.makeText(GameActivity.this, "Game Ended", Toast.LENGTH_LONG).show();
                    mRow1Button1.setImageBitmap(ima.get(ID11));mRow1Button1.setClickable(false);
                    mRow1Button2.setImageBitmap(ima.get(ID12));mRow1Button2.setClickable(false);
                    mRow1Button3.setImageBitmap(ima.get(ID13));mRow1Button3.setClickable(false);
                    mRow1Button4.setImageBitmap(ima.get(ID14));mRow1Button4.setClickable(false);
                    mRow2Button1.setImageBitmap(ima.get(ID21));mRow2Button1.setClickable(false);
                    mRow2Button2.setImageBitmap(ima.get(ID22));mRow2Button2.setClickable(false);
                    mRow2Button3.setImageBitmap(ima.get(ID23));mRow2Button3.setClickable(false);
                    mRow2Button4.setImageBitmap(ima.get(ID24));mRow2Button4.setClickable(false);
                    mRow3Button1.setImageBitmap(ima.get(ID31));mRow3Button1.setClickable(false);
                    mRow3Button2.setImageBitmap(ima.get(ID32));mRow3Button2.setClickable(false);
                    mRow3Button3.setImageBitmap(ima.get(ID33));mRow3Button3.setClickable(false);
                    mRow3Button4.setImageBitmap(ima.get(ID34));mRow3Button4.setClickable(false);
                    mRow4Button1.setImageBitmap(ima.get(ID41));mRow4Button1.setClickable(false);
                    mRow4Button2.setImageBitmap(ima.get(ID42));mRow4Button2.setClickable(false);
                    mRow4Button3.setImageBitmap(ima.get(ID43));mRow4Button3.setClickable(false);
                    mRow4Button4.setImageBitmap(ima.get(ID44));mRow4Button4.setClickable(false);
                    mRow5Button1.setImageBitmap(ima.get(ID51));mRow5Button1.setClickable(false);
                    mRow5Button2.setImageBitmap(ima.get(ID52));mRow5Button2.setClickable(false);
                    mRow5Button3.setImageBitmap(ima.get(ID53));mRow5Button3.setClickable(false);
                    mRow5Button4.setImageBitmap(ima.get(ID54));mRow5Button4.setClickable(false);
                }

            }
        });
    }
    private void createRow1(int number) {
        if(number >= 1) {
            usedInd.clear();
            usedWordInd = rand.nextInt(wordInd.size());
            ID11 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow1Button1 = new ImageButton(this);
            mRow1Button1.setImageBitmap(mImage);
            mRow1Button1.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow1Button1.setTag("true");
            mRow1Button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow1Button1.getTag() == "true") {
                        mRow1Button1.setImageBitmap(ima.get(ID11));
                        assignCards(ID11);
                        checkNumFlipped();
                        mRow1Button1.setTag("false");
                    }
                    else {
                        mRow1Button1.setImageBitmap(mImage);
                        mRow1Button1.setTag("true");
                    }
                    if(match){
                        mRow1Button1.setClickable(false);
                        match = false;
                    }

                }
            });
            mRow1Layout.addView(mRow1Button1);
        }if(number >= 2) {
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID12 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow1Button2 = new ImageButton(this);
            mRow1Button2.setImageBitmap(mImage);
            mRow1Button2.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow1Button2.setTag("true");
            mRow1Button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow1Button2.getTag() == "true") {
                        mRow1Button2.setImageBitmap(ima.get(ID12));
                        assignCards(ID12);
                        checkNumFlipped();
                        mRow1Button2.setTag("false");
                    }else {
                        mRow1Button2.setImageBitmap(mImage);
                        mRow1Button2.setTag("true");
                    }
                    if(match){
                        mRow1Button2.setClickable(false);
                        match = false;
                    }
                }
            });
            mRow1Layout.addView(mRow1Button2);
        }if(number >= 3) {
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID13 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow1Button3 = new ImageButton(this);
            mRow1Button3.setImageBitmap(mImage);
            mRow1Button3.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow1Button3.setTag("true");
            mRow1Button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow1Button3.getTag() == "true") {
                        mRow1Button3.setImageBitmap(ima.get(ID13));
                        assignCards(ID13);
                        checkNumFlipped();
                        mRow1Button3.setTag("false");
                    }else {
                        mRow1Button3.setImageBitmap(mImage);
                        mRow1Button3.setTag("true");
                    }
                    if(match){
                        mRow1Button3.setClickable(false);
                    }
                }
            });
            mRow1Layout.addView(mRow1Button3);
        }if(number >= 4) {
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID14 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow1Button4 = new ImageButton(this);
            mRow1Button4.setImageBitmap(mImage);
            mRow1Button4.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow1Button4.setTag("true");
            mRow1Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow1Button4.getTag() == "true") {
                        mRow1Button4.setImageBitmap(ima.get(ID14));
                        assignCards(ID14);
                        checkNumFlipped();
                        mRow1Button4.setTag("false");
                    }else {
                        mRow1Button4.setImageBitmap(mImage);
                        mRow1Button4.setTag("true");
                    }
                    if(match){
                        mRow1Button4.setClickable(false);
                    }
                }
            });
            mRow1Layout.addView(mRow1Button4);
        }
    }

    private void createRow2(int number) {
        if(number >= 1) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID21 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow2Button1 = new ImageButton(this);
            mRow2Button1.setImageBitmap(mImage);
            mRow2Button1.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow2Button1.setTag("true");
            mRow2Button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow2Button1.getTag() == "true") {
                        mRow2Button1.setImageBitmap(ima.get(ID21));
                        assignCards(ID21);
                        checkNumFlipped();
                        mRow2Button1.setTag("false");
                    }else {
                        mRow2Button1.setImageBitmap(mImage);
                        mRow2Button1.setTag("true");
                    }
                    if(match){
                        mRow2Button1.setClickable(false);
                        match = false;
                    }
                }
            });
            mRow2Layout.addView(mRow2Button1);
        }if(number >= 2) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID22 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow2Button2 = new ImageButton(this);
            mRow2Button2.setImageBitmap(mImage);
            mRow2Button2.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow2Button2.setTag("true");
            mRow2Button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow2Button2.getTag() == "true") {
                        mRow2Button2.setImageBitmap(ima.get(ID22));
                        assignCards(ID22);
                        checkNumFlipped();
                        mRow2Button2.setTag("false");
                    }else {
                        mRow2Button2.setImageBitmap(mImage);
                        mRow2Button2.setTag("true");
                    }
                    if(match){
                        mRow2Button2.setClickable(false);
                        match = false;
                    }
                }
            });
            mRow2Layout.addView(mRow2Button2);
        }if(number >= 3) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID23 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow2Button3 = new ImageButton(this);
            mRow2Button3.setImageBitmap(mImage);
            mRow2Button3.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow2Button3.setTag("true");
            mRow2Button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow2Button3.getTag() == "true") {
                        mRow2Button3.setImageBitmap(ima.get(ID23));
                        assignCards(ID23);
                        checkNumFlipped();
                        mRow2Button3.setTag("false");
                    }else {
                        mRow2Button3.setImageBitmap(mImage);
                        mRow2Button3.setTag("true");
                    }
                    if(match){
                        mRow2Button3.setClickable(false);
                    }
                }
            });
            mRow2Layout.addView(mRow2Button3);
        }if(number >= 4) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            usedInd.add(usedWordInd);
            ID24 = wordInd.get(usedWordInd);
            mRow2Button4 = new ImageButton(this);
            mRow2Button4.setImageBitmap(mImage);
            mRow2Button4.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow2Button4.setTag("true");
            mRow2Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow2Button4.getTag() == "true") {
                        mRow2Button4.setImageBitmap(ima.get(ID24));
                        assignCards(ID24);
                        checkNumFlipped();
                        mRow2Button4.setTag("false");
                    }else {
                        mRow2Button4.setImageBitmap(mImage);
                        mRow2Button4.setTag("true");
                    }
                    if(match){
                        mRow2Button4.setClickable(false);
                    }
                }
            });
            mRow2Layout.addView(mRow2Button4);
        }
    }

    private void createRow3(int number) {
        if(number >= 1) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID31 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow3Button1 = new ImageButton(this);
            mRow3Button1.setImageBitmap(mImage);
            mRow3Button1.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow3Button1.setTag("true");
            mRow3Button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow3Button1.getTag() == "true") {
                        mRow3Button1.setImageBitmap(ima.get(ID31));
                        assignCards(ID31);
                        checkNumFlipped();
                        mRow3Button1.setTag("false");
                    }else {
                        mRow3Button1.setImageBitmap(mImage);
                        mRow3Button1.setTag("true");
                    }
                    if(match){
                        mRow3Button1.setClickable(false);
                    }
                }
            });
            mRow3Layout.addView(mRow3Button1);
        }if(number >= 2) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID32 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow3Button2 = new ImageButton(this);
            mRow3Button2.setImageBitmap(mImage);
            mRow3Button2.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow3Button2.setTag("true");
            mRow3Button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow3Button2.getTag() == "true") {
                        mRow3Button2.setImageBitmap(ima.get(ID32));
                        assignCards(ID32);
                        checkNumFlipped();
                        mRow3Button2.setTag("false");
                    }else {
                        mRow3Button2.setImageBitmap(mImage);
                        mRow3Button2.setTag("true");
                    }
                    if(match){
                        mRow3Button2.setClickable(false);
                    }
                }
            });
            mRow3Layout.addView(mRow3Button2);
        }if(number >= 3) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID33 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow3Button3 = new ImageButton(this);
            mRow3Button3.setImageBitmap(mImage);
            mRow3Button3.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow3Button3.setTag("true");
            mRow3Button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow3Button3.getTag() == "true") {
                        mRow3Button3.setImageBitmap(ima.get(ID33));
                        assignCards(ID33);
                        checkNumFlipped();
                        mRow3Button3.setTag("false");
                    }else {
                        mRow3Button3.setImageBitmap(mImage);
                        mRow3Button3.setTag("true");
                    }
                    if(match){
                        mRow3Button3.setClickable(false);
                    }
                }
            });
            mRow3Layout.addView(mRow3Button3);
        }if(number >= 4) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            usedInd.add(usedWordInd);
            ID34 = wordInd.get(usedWordInd);
            mRow3Button4 = new ImageButton(this);
            mRow3Button4.setImageBitmap(mImage);
            mRow3Button4.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow3Button4.setTag("true");
            mRow3Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow3Button4.getTag() == "true") {
                        mRow3Button4.setImageBitmap(ima.get(ID34));
                        assignCards(ID34);
                        checkNumFlipped();
                        mRow3Button4.setTag("false");
                    }else {
                        mRow3Button4.setImageBitmap(mImage);
                        mRow3Button4.setTag("true");
                    }
                    if(match){
                        mRow3Button4.setClickable(false);
                    }
                }
            });
            mRow3Layout.addView(mRow3Button4);
        }
    }

    private void createRow4(int number) {
        if(number >= 1) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID41 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow4Button1 = new ImageButton(this);
            mRow4Button1.setImageBitmap(mImage);
            mRow4Button1.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow4Button1.setTag("true");
            mRow4Button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow4Button1.getTag() == "true") {
                        mRow4Button1.setImageBitmap(ima.get(ID41));
                        assignCards(ID41);
                        checkNumFlipped();
                        mRow4Button1.setTag("false");
                    }else {
                        mRow4Button1.setImageBitmap(mImage);
                        mRow4Button1.setTag("true");
                    }
                    if(match){
                        mRow4Button1.setClickable(false);
                    }
                }
            });
            mRow4Layout.addView(mRow4Button1);
        }if(number >= 2) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID42 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow4Button2 = new ImageButton(this);
            mRow4Button2.setImageBitmap(mImage);
            mRow4Button2.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow4Button2.setTag("true");
            mRow4Button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow4Button2.getTag() == "true") {
                        mRow4Button2.setImageBitmap(ima.get(ID42));
                        assignCards(ID42);
                        checkNumFlipped();
                        mRow4Button2.setTag("false");
                    }else {
                        mRow4Button2.setImageBitmap(mImage);
                        mRow4Button2.setTag("true");
                    }
                    if(match){
                        mRow4Button2.setClickable(false);
                    }
                }
            });
            mRow4Layout.addView(mRow4Button2);
        }if(number >= 3) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID43 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow4Button3 = new ImageButton(this);
            mRow4Button3.setImageBitmap(mImage);
            mRow4Button3.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow4Button3.setTag("true");
            mRow4Button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow4Button3.getTag() == "true") {
                        mRow4Button3.setImageBitmap(ima.get(ID43));
                        assignCards(ID43);
                        checkNumFlipped();
                        mRow4Button3.setTag("false");
                    }else {
                        mRow4Button3.setImageBitmap(mImage);
                        mRow4Button3.setTag("true");
                    }
                    if(match){
                        mRow4Button3.setClickable(false);
                    }
                }
            });
            mRow4Layout.addView(mRow4Button3);
        }if(number >= 4) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            usedInd.add(usedWordInd);
            ID44 = wordInd.get(usedWordInd);
            mRow4Button4 = new ImageButton(this);
            mRow4Button4.setImageBitmap(mImage);
            mRow4Button4.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow4Button4.setTag("true");
            mRow4Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow4Button4.getTag() == "true") {
                        mRow4Button4.setImageBitmap(ima.get(ID44));
                        assignCards(ID44);
                        checkNumFlipped();
                        mRow4Button4.setTag("false");
                    }else {
                        mRow4Button4.setImageBitmap(mImage);
                        mRow4Button4.setTag("true");
                    }
                    if(match){
                        mRow4Button4.setClickable(false);
                    }
                }
            });
            mRow4Layout.addView(mRow4Button4);
        }
    }

    private void createRow5(int number) {
        if(number >= 1) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID51 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow5Button1 = new ImageButton(this);
            mRow5Button1.setImageBitmap(mImage);
            mRow5Button1.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow5Button1.setTag("true");
            mRow5Button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow5Button1.getTag() == "true") {
                        mRow5Button1.setImageBitmap(ima.get(ID51));
                        assignCards(ID51);
                        checkNumFlipped();
                        mRow5Button1.setTag("false");
                    }else {
                        mRow5Button1.setImageBitmap(mImage);
                        mRow5Button1.setTag("true");
                    }
                    if(match){
                        mRow5Button1.setClickable(false);
                    }
                }
            });
            mRow5Layout.addView(mRow5Button1);
        }if(number >= 2) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID52 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow5Button2 = new ImageButton(this);
            mRow5Button2.setImageBitmap(mImage);
            mRow5Button2.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow5Button2.setTag("true");
            mRow5Button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow5Button2.getTag() == "true") {
                        mRow5Button2.setImageBitmap(ima.get(ID52));
                        assignCards(ID52);
                        checkNumFlipped();
                        mRow5Button2.setTag("false");
                    }else {
                        mRow5Button2.setImageBitmap(mImage);
                        mRow5Button2.setTag("true");
                    }
                    if(match){
                        mRow5Button2.setClickable(false);
                    }
                }
            });
            mRow5Layout.addView(mRow5Button2);
        }if(number >= 3) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            ID53 = wordInd.get(usedWordInd);
            usedInd.add(usedWordInd);
            mRow5Button3 = new ImageButton(this);
            mRow5Button3.setImageBitmap(mImage);
            mRow5Button3.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow5Button3.setTag("true");
            mRow5Button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow5Button3.getTag() == "true") {
                        mRow5Button3.setImageBitmap(ima.get(ID53));
                        assignCards(ID53);
                        checkNumFlipped();
                        mRow5Button3.setTag("false");
                    }else {
                        mRow5Button3.setImageBitmap(mImage);
                        mRow5Button3.setTag("true");
                    }
                    if(match){
                        mRow5Button3.setClickable(false);
                    }
                }
            });
            mRow5Layout.addView(mRow5Button3);
        }if(number >= 4) {
            reset();
            usedWordInd = rand.nextInt(wordInd.size());
            for(int i =0; i < usedInd.size(); i++){
                if(usedWordInd == usedInd.get(i)){
                    usedWordInd = rand.nextInt(wordInd.size());
                    i=-1;
                }
            }
            usedInd.add(usedWordInd);
            ID54 = wordInd.get(usedWordInd);
            mRow5Button4 = new ImageButton(this);
            mRow5Button4.setImageBitmap(mImage);
            mRow5Button4.setLayoutParams(new LinearLayout.LayoutParams(240,240));
            mRow5Button4.setTag("true");
            mRow5Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mRow5Button4.getTag() == "true") {
                        mRow5Button4.setImageBitmap(ima.get(ID54));
                        assignCards(ID54);
                        checkNumFlipped();
                        mRow5Button4.setTag("false");
                    }else {
                        mRow5Button4.setImageBitmap(mImage);
                        mRow5Button4.setTag("true");
                    }
                    if(match){
                        mRow5Button4.setClickable(false);
                    }
                }
            });
            mRow5Layout.addView(mRow5Button4);
        }
    }
}
