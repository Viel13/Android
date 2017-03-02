package com.example.logonrm.splash;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Splash extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

    class Tempo implements Runnable {
        @Override
        public void run(){
            try {
                Thread.sleep(5000);
                Intent i = new Intent(Splash.this,MainActivity.class);
                startActivity(i);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
