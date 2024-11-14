package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button button1 = findViewById(R.id.Comprar);
        Button button2 = findViewById(R.id.Cambiar);
        Button button3 = findViewById(R.id.consultar);
        Button button4 = findViewById(R.id.Eliminar);
        Button button5 = findViewById(R.id.Inicio);
        TextView textoSaludo = findViewById(R.id.textoSaludo);



        // Determinar el saludo adecuado
        String saludo;
        if (MODE_APPEND >= 6 && MODE_APPEND < 12) {
            saludo = "Buenos días";
        } else if (MODE_APPEND >= 12 && MODE_APPEND < 18) {
            saludo = "Buenas Tardes";
        } else {
            saludo = "Buenas Noches";
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}