package com.robertson.navegacaoentretelas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewCarros;
    FloatingActionButton floatingActionButtonAdd, floatingActionButtonEdit;
    EditText editTextId;
    ArrayList<Carro> arrayCarros = new ArrayList<>();
    CarrosAdapter carrosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("vida" , "onCreate");

        setTitle("Carros");

        recyclerViewCarros = findViewById(R.id.recycleViewCarros);

        Carro uno = new Carro();
        uno.setNome("Uno Quadrado");
        uno.setCilindrada("1.0");
        uno.setPlaca("ERP-3462");
        uno.setQtdPessoas("5");
        uno.setId(String.valueOf(arrayCarros.size()+1));
        arrayCarros.add(uno);

        if(savedInstanceState != null){
            arrayCarros = savedInstanceState.getParcelableArrayList("array");
        }

        mostraCarros();

        floatingActionButtonAdd = findViewById(R.id.floatingAdd);
        floatingActionButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Carro novo = criaNovoCarro();
                intent.putExtra("carro",  novo);
                startActivityForResult(intent, 1);
            }
        });

        editTextId = findViewById(R.id.editTextID);

        floatingActionButtonEdit = findViewById(R.id.floatingEdit);
        floatingActionButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strID = editTextId.getText().toString();
                strID = strID.trim();
                if(!strID.isEmpty() && (Integer.parseInt(strID) >= 1 && Integer.parseInt(strID) <= arrayCarros.size())){
                    for(Carro c : arrayCarros){
                        if(c.getId().equals(strID)){
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            intent.putExtra("carro",  c);
                            startActivityForResult(intent, 2);
                        }
                    }
                }else{
                    MainActivity.mostraSnackbar(view, "Informe um ID válido.");
                }
            }
        });

    }

    private void mostraCarros(){
        carrosAdapter = new CarrosAdapter(arrayCarros);
        recyclerViewCarros.setAdapter(carrosAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Carro carro = data.getParcelableExtra("carro");
                arrayCarros.add(carro);
                mostraCarros();
            }
        }
        if(requestCode == 2){
            if(resultCode == RESULT_OK){
                Carro carro = data.getParcelableExtra("carro");
                for(Carro c : arrayCarros){
                    if(c.getId().equals(carro.getId())){
                        c.setNome(carro.getNome());
                        c.setCilindrada(carro.getCilindrada());
                        c.setPlaca(carro.getPlaca());
                        c.setQtdPessoas(carro.getQtdPessoas());
                    }
                }
                mostraCarros();
            }
        }
    }

    private Carro criaNovoCarro(){
        Carro novo = new Carro();
        novo.setId(String.valueOf(arrayCarros.size()+1));
        return novo;
    }
    public static void mostraSnackbar(View view, String mensagem){
        Snackbar snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT);
        snackbar.setBackgroundTint(Color.WHITE);
        snackbar.setTextColor(Color.BLACK);
        snackbar.show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("array", arrayCarros);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("vida", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("vida", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("vida", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("vida", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("vida", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("vida", "onDestroy");
    }
}