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

public class montodescuentsimple extends AppCompatActivity {

        private EditText editTextCapital, editTextTiempo, editTextTasaDescuento;
        private Button btnCalcular, Menu, Regresar;
        private TextView textViewResultado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_montodescuentsimple);

            // Referenciar los elementos en el diseño XML
            editTextCapital = findViewById(R.id.editTextCapital);
            editTextTiempo = findViewById(R.id.editTextTiempo);
            editTextTasaDescuento = findViewById(R.id.editTextTasaDescuento);
            btnCalcular = findViewById(R.id.btnCalcular);
            Menu = findViewById(R.id.Menu);
            Regresar = findViewById(R.id.Regresar);
            textViewResultado = findViewById(R.id.textViewResultado);

            // Configurar el botón para calcular el monto del descuento
            btnCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcularMonto();
                }
            });

            // Configurar el botón para ir al menú
            Menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(montodescuentsimple.this, MainActivity2.class);
                    startActivity(intent);
                }
            });

            // Configurar el botón para regresar
            Regresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(montodescuentsimple.this, menuinteressimple.class);
                    startActivity(intent);
                }
            });
        }

        private void calcularMonto() {
            // Obtener los valores ingresados por el usuario
            String capitalStr = editTextCapital.getText().toString();
            String tiempoStr = editTextTiempo.getText().toString();
            String tasaDescuentoStr = editTextTasaDescuento.getText().toString();

            // Validar que los campos no estén vacíos
            if (!capitalStr.isEmpty() && !tiempoStr.isEmpty() && !tasaDescuentoStr.isEmpty()) {
                double capital = Double.parseDouble(capitalStr);
                double tiempo = Double.parseDouble(tiempoStr);
                double tasaDescuento = Double.parseDouble(tasaDescuentoStr);

                // Calcular el monto usando la fórmula M = P / (1 - n * d)
                double monto = capital / (1 - tiempo * tasaDescuento);

                // Mostrar el resultado formateado
                textViewResultado.setText(String.format("Resultado: M = %.2f", monto));
            } else {
                // Mostrar un mensaje de error si algún campo está vacío
                textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
            }
        }
    }
