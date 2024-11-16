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

public class tasadedescuentodescuentosimple extends AppCompatActivity {

        private EditText editTextCapital, editTextMonto, editTextTiempo;
        private Button btnCalcular, Menu, Regresar;
        private TextView textViewResultado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tasadedescuentodescuentosimple);

            // Referenciar los elementos en el diseño XML
            editTextCapital = findViewById(R.id.editTextCapital);
            editTextMonto = findViewById(R.id.editTextMonto);
            editTextTiempo = findViewById(R.id.editTextTiempo);
            btnCalcular = findViewById(R.id.btnCalcular);
            Menu = findViewById(R.id.Menu);
            Regresar = findViewById(R.id.Regresar);
            textViewResultado = findViewById(R.id.textViewResultado);

            // Configurar el botón para calcular la tasa de descuento
            btnCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcularTasaDescuento();
                }
            });

            // Configurar el botón para ir al menú
            Menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(tasadedescuentodescuentosimple.this, MainActivity2.class);
                    startActivity(intent);
                }
            });

            // Configurar el botón para regresar
            Regresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(tasadedescuentodescuentosimple.this, menuinteressimple.class);
                    startActivity(intent);
                }
            });
        }

        private void calcularTasaDescuento() {
            // Obtener los valores ingresados por el usuario
            String capitalStr = editTextCapital.getText().toString();
            String montoStr = editTextMonto.getText().toString();
            String tiempoStr = editTextTiempo.getText().toString();

            // Validar que los campos no estén vacíos
            if (!capitalStr.isEmpty() && !montoStr.isEmpty() && !tiempoStr.isEmpty()) {
                double capital = Double.parseDouble(capitalStr);
                double monto = Double.parseDouble(montoStr);
                double tiempo = Double.parseDouble(tiempoStr);

                // Calcular la tasa de descuento usando la fórmula d = (1 - P/M) / n
                double tasaDescuento = (1 - capital / monto) / tiempo;

                // Mostrar el resultado formateado
                textViewResultado.setText(String.format("Resultado: d = %.4f", tasaDescuento));
            } else {
                // Mostrar un mensaje de error si algún campo está vacío
                textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
            }
        }
    }
