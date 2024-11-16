package com.example.calculadora;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class plazointeressimple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plazointeressimple);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.btnCalcular).setOnClickListener(view -> {
            EditText editTextMonto = findViewById(R.id.editTextMonto);
            EditText editTextCapital = findViewById(R.id.editTextCapital);
            EditText editTextInteres = findViewById(R.id.editTextInteres);
            TextView textViewResultado = findViewById(R.id.textViewResultado);

            double monto = Double.parseDouble(editTextMonto.getText().toString());
            double capital = Double.parseDouble(editTextCapital.getText().toString());
            double interes = Double.parseDouble(editTextInteres.getText().toString());

            double plazo = (monto / capital - 1) / interes;

            textViewResultado.setText(String.format("Resultado: %.2f", plazo));
        });
        // Configurar el botón para ir al menú
        Button btnMenu = findViewById(R.id.Menu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(plazointeressimple.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        // Configurar el botón para regresar
        Button btnRegresar = findViewById(R.id.Regresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(plazointeressimple.this, menuinteressimple.class);
                startActivity(intent);
            }
        });
    }
}
