package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class interes extends AppCompatActivity {

    private EditText editTextMonto, editTextCapital;
    private Button btnCalcular, Menu, Regresar;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interes);

        // Referenciar los elementos en el diseño XML
        editTextMonto = findViewById(R.id.editTextMonto);
        editTextCapital = findViewById(R.id.editTextCapital);
        btnCalcular = findViewById(R.id.btnCalcular);
        Menu = findViewById(R.id.Menu);
        Regresar = findViewById(R.id.Regresar);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Configurar el botón para calcular el interés
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularInteres();
            }
        });

        // Configurar el botón para ir al menú
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(interes.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        // Configurar el botón para regresar
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(interes.this, menuinteressimple.class);
                startActivity(intent);
            }
        });
    }

    private void calcularInteres() {
        // Obtener los valores ingresados por el usuario
        String montoStr = editTextMonto.getText().toString();
        String capitalStr = editTextCapital.getText().toString();

        // Validar que los campos no estén vacíos
        if (!montoStr.isEmpty() && !capitalStr.isEmpty()) {
            double monto = Double.parseDouble(montoStr);
            double capital = Double.parseDouble(capitalStr);

            // Calcular el interés usando la fórmula I = M - C
            double interes = monto - capital;

            // Mostrar el resultado formateado
            textViewResultado.setText(String.format("Resultado: I = %.2f", interes));
        } else {
            // Mostrar un mensaje de error si algún campo está vacío
            textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
        }
    }
}
