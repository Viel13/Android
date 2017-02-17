package com.example.logonrm.jogotabuada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class Tabuada extends AppCompatActivity {

    private TextView txtNum1;
    private TextView txtNum2;
    private TextView resp;
    private ImageView[]garrafa = new ImageView[4];

    private int num1, num2;
    private int pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabuada);


        txtNum1 = (TextView) findViewById(R.id.num1);
        txtNum2 = (TextView) findViewById(R.id.num2);
        resp = (EditText) findViewById(R.id.edtResp);
        garrafa[0] = (ImageView) findViewById(R.id.garrafa1);
        garrafa[1] = (ImageView) findViewById(R.id.garrafa2);
        garrafa[2] = (ImageView) findViewById(R.id.garrafa3);
        garrafa[3] = (ImageView) findViewById(R.id.garrafa4);


    }



    private void sortear() {

        Random r = new Random();
        num1 = r.nextInt(9);
        num2 = r.nextInt(9);

        txtNum1.setText(String.valueOf(num1));
        txtNum2.setText(String.valueOf(num2));
        resp.setText("");

    }



    public void conferir(View v){
    String resposta = resp.getText().toString();

        if(resposta.equals(String.valueOf(num1 * num2))){
            marcaPonto();
        }
        if (pontos == (garrafa.length - 1)){
            Toast.makeText(this, R.string.msgVencedor, Toast.LENGTH_SHORT).show();

            this.garrafa[pontos].setImageResource(android.R.drawable.screen_background_light_transparent);
            this.pontos =0;
            this.garrafa[pontos].setImageResource(R.drawable.garrafa);
        }

sortear();

    }

    private void marcaPonto(){
        this.garrafa[pontos].setImageResource(android.R.drawable.screen_background_light_transparent);
        this.pontos++;
        this.garrafa[pontos].setImageResource(R.drawable.garrafa);
    }
}
