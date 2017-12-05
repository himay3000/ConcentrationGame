package com.example.monic_000.concentrationgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SizeActivity extends AppCompatActivity {

    private Button mFourCardsButton;
    private Button mSixCardsButton;
    private Button mEightCardsButton;
    private Button mTenCardsButton;
    private Button mTwelveCardsButton;
    private Button mFourteenCardsButton;
    private Button mSixteenCardsButton;
    private Button mEighteenCardsButton;
    private Button mTwentyCardsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);

        mFourCardsButton = (Button) findViewById(R.id.four_cards_button);
        mFourCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SizeActivity.this, GameActivity.class);
                i.putExtra("amount", 4);
                startActivity(i);
            }
        });
        mSixCardsButton = (Button) findViewById(R.id.six_cards_button);
        mSixCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SizeActivity.this, GameActivity.class);
                i.putExtra("amount", 6);
                startActivity(i);
            }
        });
        mEightCardsButton = (Button) findViewById(R.id.eight_cards_button);
        mEightCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SizeActivity.this, GameActivity.class);
                i.putExtra("amount", 8);
                startActivity(i);
            }
        });
        mTenCardsButton = (Button) findViewById(R.id.ten_cards_button);
        mTenCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SizeActivity.this, GameActivity.class);
                i.putExtra("amount", 10);
                startActivity(i);
            }
        });
        mTwelveCardsButton = (Button) findViewById(R.id.twelve_cards_button);
        mTwelveCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SizeActivity.this, GameActivity.class);
                i.putExtra("amount", 12);
                startActivity(i);
            }
        });
        mFourteenCardsButton = (Button) findViewById(R.id.fourteen_cards_button);
        mFourteenCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SizeActivity.this, GameActivity.class);
                i.putExtra("amount", 14);
                startActivity(i);
            }
        });
        mSixteenCardsButton = (Button) findViewById(R.id.sixteen_cards_button);
        mSixteenCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SizeActivity.this, GameActivity.class);
                i.putExtra("amount", 16);
                startActivity(i);
            }
        });
        mEighteenCardsButton = (Button) findViewById(R.id.eighteen_cards_button);
        mEighteenCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SizeActivity.this, GameActivity.class);
                i.putExtra("amount", 18);
                startActivity(i);
            }
        });
        mTwentyCardsButton = (Button) findViewById(R.id.twenty_cards_button);
        mTwentyCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SizeActivity.this, GameActivity.class);
                i.putExtra("amount", 20);
                startActivity(i);
            }
        });
    }
}
