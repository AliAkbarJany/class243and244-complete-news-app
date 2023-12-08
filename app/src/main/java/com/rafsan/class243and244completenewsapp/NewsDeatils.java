package com.rafsan.class243and244completenewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewsDeatils extends AppCompatActivity {

    ImageView coverImage;
    TextView textTitle,textDes;
    FloatingActionButton floatButton;

    public static String TITLE  = "";
    public static String DESCRIPTION  = "";
    public static Bitmap MY_BITMAP = null;


    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_deatils);

        coverImage = findViewById(R.id.coverImage);
        textTitle = findViewById(R.id.textTitle);
        textDes = findViewById(R.id.textDes);
        floatButton = findViewById(R.id.floatButton);

        textTitle.setText(TITLE);
        textDes.setText(DESCRIPTION);

        if(MY_BITMAP != null){

            coverImage.setImageBitmap(MY_BITMAP);
        }


        //----------------TExt To Voice----------------

        textToSpeech = new TextToSpeech(NewsDeatils.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });

        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = textDes.getText().toString();

                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null,null);

            }
        });


    }
}