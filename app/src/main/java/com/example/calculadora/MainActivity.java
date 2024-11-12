package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Cargar imagen en ImageView
        logo = findViewById(R.id.Logo);
        logo.setImageResource(R.drawable.logo); // Asegúrate de que "logo" esté en res/drawable

        // Configurar el botón para navegar a otra actividad
        Button myButton = findViewById(R.id.my_button);
        myButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, .class);
            startActivity(intent);
        });
    }
}

