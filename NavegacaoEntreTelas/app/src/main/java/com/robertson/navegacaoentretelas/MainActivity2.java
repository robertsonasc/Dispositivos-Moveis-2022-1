package com.robertson.navegacaoentretelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText editTextModelo, editTextCilindrada, editTextPlaca, editTextQtdPessoas;
    Button btnConfirmar, btnCancelar;
    Carro carro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Criar/Editar Carro");

        editTextModelo = findViewById(R.id.editTextModeloCarro);
        editTextCilindrada = findViewById(R.id.editTextCilindradaCarro);
        editTextPlaca = findViewById(R.id.editTextPlacaCarro);
        editTextQtdPessoas = findViewById(R.id.editTextNumeroPessoasCarro);
        btnCancelar = findViewById(R.id.buttonCancelarCarro);
        btnConfirmar = findViewById(R.id.buttonConfirmarCarro);

        carro = (Carro) getIntent().getParcelableExtra("carro");

        if(!carro.getNome().isEmpty()){
            editTextModelo.setText(carro.getNome());
            editTextCilindrada.setText(carro.getCilindrada());
            editTextPlaca.setText(carro.getPlaca());
            editTextQtdPessoas.setText(carro.getQtdPessoas());
        }

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strModelo = editTextModelo.getText().toString();
                String strCilindrada =  editTextCilindrada.getText().toString();
                String strPlaca = editTextPlaca.getText().toString();
                String strQtdPessoas = editTextQtdPessoas.getText().toString();
                strModelo = strModelo.trim();
                strCilindrada = strCilindrada.trim();
                strPlaca = strPlaca.trim();
                strQtdPessoas = strQtdPessoas.trim();

                if(strModelo.isEmpty() || strCilindrada.isEmpty() || strPlaca.isEmpty() || strQtdPessoas.isEmpty()){
                    MainActivity.mostraSnackbar(view, "Preencha todos os campos");
                }else{
                    carro.setNome(strModelo);
                    carro.setCilindrada(strCilindrada);
                    carro.setPlaca(strPlaca);
                    carro.setQtdPessoas(strQtdPessoas);

                    Intent intent = new Intent();
                    intent.putExtra("carro", carro);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}