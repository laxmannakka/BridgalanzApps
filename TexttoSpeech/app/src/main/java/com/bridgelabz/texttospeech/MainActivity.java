package com.bridgelabz.texttospeech;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech tobj;
    EditText editdata;
    Button ok;
    Button next,blootooth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editdata = (EditText) findViewById(R.id.edittext);
        ok = (Button) findViewById(R.id.button);
        next =(Button)findViewById(R.id.intent);
        blootooth= (Button) findViewById(R.id.blootooth);
        tobj = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {

                    int result = tobj.setLanguage(Locale.US);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "This Language is not supported");
                    } else {

                    }

                } else {
                    Log.e("TTS", "Initilization Failed!");
                }

            }



        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editdata.getText().toString();
                tobj.speak(data,TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadimage = new Intent(MainActivity.this,LoadImage.class);
                startActivity(loadimage);
            }
        });
        blootooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bloototh = new Intent(MainActivity.this,Blutooth.class);
                startActivity(bloototh);
            }
        });



    }
    public void onPause(){
        if(tobj !=null){
            tobj.stop();
            tobj.shutdown();
        }
        super.onPause();
    }
}
