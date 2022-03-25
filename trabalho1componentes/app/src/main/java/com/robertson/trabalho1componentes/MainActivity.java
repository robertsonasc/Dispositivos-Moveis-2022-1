package com.robertson.trabalho1componentes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView cars;
    ArrayList<String> carros;

    RadioButton radioButton;

    Button button1;

    TextView item8_segura;

    Button button2;
    Button button10;

    MediaPlayer sound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carros = new ArrayList<String>();

        carros.add("Octane");
        carros.add("Fennec");
        carros.add("Batmobile 2008");

        cars = findViewById(R.id.item3);
        cars.setText("");
        for (int j = 0; j < carros.size(); j++) {
            cars.append(carros.get(j) + "\n");
        }

        AutoCompleteTextView t1 = (AutoCompleteTextView) findViewById(R.id.item4);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, carros);

        t1.setThreshold(1);
        t1.setAdapter(adp);

        Spinner spnr = (Spinner) findViewById(R.id.item5);
        adp = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, carros);

        spnr.setAdapter(adp);
        final boolean[] inicio_snipper = {true};
        spnr.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        int pos = spnr.getSelectedItemPosition();
                        if(inicio_snipper[0])
                            inicio_snipper[0] = false;
                        else
                            Toast.makeText(getApplicationContext(), "Você selecionou o carro: " + carros.get(pos),
                                Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );
        button1 = (Button) findViewById(R.id.item7);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.poupup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                MainActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener method
        item8_segura = (TextView) findViewById(R.id.item8);
        item8_segura.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(), "Você segurou pelo tempo suficiente.", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        item8_segura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Você não segurou o suficiente.", Toast.LENGTH_SHORT).show();
            }
        });
        button2 = (Button) findViewById(R.id.item9);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irSegundaTela();
            }
        });
        button10 = button10 = (Button) findViewById(R.id.item10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irTabbedActivity();
            }
        });
        ArrayList<String> clubes = new ArrayList<String>();
        clubes.add("NRG");
        clubes.add("Rogue");
        clubes.add("Faze Clan");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, clubes);

        ListView listView = (ListView) findViewById(R.id.item11);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Você clicou no time: " + ((TextView) view).getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        Button grid = findViewById(R.id.item12);
        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irGridActivity();
            }
        });

        Button baroes = findViewById(R.id.item13);
        sound = MediaPlayer.create(getApplicationContext(), R.raw.baroes);
        baroes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sound.isPlaying()) {
                    sound.pause();
                }
                else
                    sound.start();
            }
        });
    }

    public void foiClicado(View view) {
        Toast.makeText(this, "ToggleButton Acionado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void RadioButton_Clicado(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.item61:
                if (checked) {
                    radioButton = findViewById(R.id.item61);
                    Toast.makeText(this, "RadioButton " + radioButton.getText() + " foi selecionado.",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.item62:
                if (checked){
                    radioButton = findViewById(R.id.item62);
                    Toast.makeText(this, "RadioButton " + radioButton.getText() + " foi selecionado.",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.item63:
                if (checked){
                    radioButton = findViewById(R.id.item63);
                    Toast.makeText(this, "RadioButton " + radioButton.getText() + " foi selecionado.",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ConstraintLayout main_v = (ConstraintLayout)findViewById(R.id.main_view);
        switch(item.getItemId()){
            case R.id.tema_claro:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_v.setBackgroundColor(Color.WHITE);
                return true;
            case R.id.tema_escuro:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_v.setBackgroundColor(Color.GRAY);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void irSegundaTela(){
        Intent intent = new Intent(this, SegundaTela.class);
        startActivity(intent);
    }
    public void irTabbedActivity(){
        Intent intent = new Intent(this, TabbedActivity.class);
        startActivity(intent);
    }

    public void irGridActivity(){
        Intent intent = new Intent(this, GridActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sound.pause();
    }
}