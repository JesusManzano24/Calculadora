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

public class tasadeinterescapitalizableinterescompuesto extends AppCompatActivity {

        private EditText editTextMonto, editTextCapital, editTextInteres, editTextPagosPorPeriodo;
        private Button btnCalcular, Menu, Regresar;
        private TextView textViewResultado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tasadeinterescapitalizableinterescompuesto);

            // Referenciar los elementos en el diseño XML
            editTextMonto = findViewById(R.id.editTextMonto);
            editTextCapital = findViewById(R.id.editTextCapital);
            editTextInteres = findViewById(R.id.editTextInteres);
            editTextPagosPorPeriodo = findViewById(R.id.editTextPagosPorPeriodo);
            btnCalcular = findViewById(R.id.btnCalcular);
            Menu = findViewById(R.id.Menu);
            Regresar = findViewById(R.id.Regresar);
            textViewResultado = findViewById(R.id.textViewResultado);

            // Configurar el botón para calcular la tasa de interés capitalizable
            btnCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcularTasaInteres();
                }
            });

            // Configurar el botón para ir al menú
            Menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(tasadeinterescapitalizableinterescompuesto.this, MainActivity2.class);
                    startActivity(intent);
                }
            });

            // Configurar el botón para regresar
            Regresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(tasadeinterescapitalizableinterescompuesto.this, menuinteressimple.class);
                    startActivity(intent);
                }
            });
        }

        private void calcularTasaInteres() {
            // Obtener los valores ingresados por el usuario
            String montoStr = editTextMonto.getText().toString();
            String capitalStr = editTextCapital.getText().toString();
            String interesStr = editTextInteres.getText().toString();
            String pagosPorPeriodoStr = editTextPagosPorPeriodo.getText().toString();

            // Validar que los campos no estén vacíos
            if (!montoStr.isEmpty() && !capitalStr.isEmpty() && !interesStr.isEmpty() && !pagosPorPeriodoStr.isEmpty()) {
                double monto = Double.parseDouble(montoStr);
                double capital = Double.parseDouble(capitalStr);
                double interes = Double.parseDouble(interesStr);
                double pagosPorPeriodo = Double.parseDouble(pagosPorPeriodoStr);

                // Calcular la tasa de interés capitalizable usando la fórmula i = (np√M/C - 1) * p
                double tasaInteres = (Math.pow(monto / capital, 1.0 / (interes * pagosPorPeriodo)) - 1) * pagosPorPeriodo;

                // Mostrar el resultado formateado
                textViewResultado.setText(String.format("Resultado: i = %.4f", tasaInteres));
            } else {
                // Mostrar un mensaje de error si algún campo está vacío
                textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
            }
        }
    }
