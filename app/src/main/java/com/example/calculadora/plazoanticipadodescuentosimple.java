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


public class plazoanticipadodescuentosimple extends AppCompatActivity {

        private EditText editTextCapital, editTextMonto, editTextTasaDescuento;
        private Button btnCalcular, Menu, Regresar;
        private TextView textViewResultado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_plazoanticipadodescuentosimple);

            // Referenciar los elementos en el diseño XML
            editTextCapital = findViewById(R.id.editTextCapital);
            editTextMonto = findViewById(R.id.editTextMonto);
            editTextTasaDescuento = findViewById(R.id.editTextTasaDescuento);
            btnCalcular = findViewById(R.id.btnCalcular);
            Menu = findViewById(R.id.Menu);
            Regresar = findViewById(R.id.Regresar);
            textViewResultado = findViewById(R.id.textViewResultado);

            // Configurar el botón para calcular el plazo
            btnCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcularPlazo();
                }
            });

            // Configurar el botón para ir al menú
            Menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(plazoanticipadodescuentosimple.this, MainActivity2.class);
                    startActivity(intent);
                }
            });

            // Configurar el botón para regresar
            Regresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(plazoanticipadodescuentosimple.this, menuinteressimple.class);
                    startActivity(intent);
                }
            });
        }

        private void calcularPlazo() {
            // Obtener los valores ingresados por el usuario
            String capitalStr = editTextCapital.getText().toString();
            String montoStr = editTextMonto.getText().toString();
            String tasaDescuentoStr = editTextTasaDescuento.getText().toString();

            // Validar que los campos no estén vacíos
            if (!capitalStr.isEmpty() && !montoStr.isEmpty() && !tasaDescuentoStr.isEmpty()) {
                double capital = Double.parseDouble(capitalStr);
                double monto = Double.parseDouble(montoStr);
                double tasaDescuento = Double.parseDouble(tasaDescuentoStr);

                // Calcular el plazo usando la fórmula n = (1 - P/M) / d
                double plazo = (1 - capital / monto) / tasaDescuento;

                // Mostrar el resultado formateado
                textViewResultado.setText(String.format("Resultado: n = %.2f", plazo));
            } else {
                // Mostrar un mensaje de error si algún campo está vacío
                textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
            }
        }
    }
