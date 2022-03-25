package com.robertson.trabalho1componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        String[] carrosRLGrid = {"Octane", "Fennec", "Batmobile", "Scarab"};
        int[] carrosImages =  {R.drawable.octane, R.drawable.fennec, R.drawable.batmobile, R.drawable.scarab};

        GridView gridView = findViewById(R.id.grid_view);
        GridAdapter gridAdapter = new GridAdapter(getApplicationContext(), carrosRLGrid, carrosImages);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Você clicou no carro: " + carrosRLGrid[+i],
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button button = findViewById(R.id.buttonGrid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}