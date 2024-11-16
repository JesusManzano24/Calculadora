package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class menuinterescompuesto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuinterescompuesto);


        Button button1 = findViewById(R.id.Comprar);
        Button button2 = findViewById(R.id.Cambiar);
        Button button3 = findViewById(R.id.consultar);
        Button button4 = findViewById(R.id.Eliminar);
        Button button5 = findViewById(R.id.Eliminar2);
        Button button6 = findViewById(R.id.interes);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuinterescompuesto.this, montotasadeinterescompuesto.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuinterescompuesto.this, capitalinterescompuesto.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuinterescompuesto.this, periodosdecapitalizacioninterescompuesto.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuinterescompuesto.this, tasadeinterescapitalizableinterescompuesto.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuinterescompuesto.this, plazointerescompuesto.class);
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuinterescompuesto.this, interesinterescompuesto.class);
                startActivity(intent);
            }
        });

    }
}