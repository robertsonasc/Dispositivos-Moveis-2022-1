package com.robertson.trabalho1componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaTela extends AppCompatActivity {
    Button button22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        button22 = (Button)findViewById(R.id.item99);
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mudarActivity();
            }
        });
    }
    public void mudarActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}