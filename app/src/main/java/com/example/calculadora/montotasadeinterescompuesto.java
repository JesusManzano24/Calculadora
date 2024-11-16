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

public class montotasadeinterescompuesto extends AppCompatActivity {
        private EditText editTextCapital, editTextInteres, editTextPeriodo;
        private Button btnCalcular, Menu, Regresar;
        private TextView textViewResultado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_montotasadeinterescompuesto);

            // Referenciar los elementos en el diseño XML
            editTextCapital = findViewById(R.id.editTextCapital);
            editTextInteres = findViewById(R.id.editTextInteres);
            editTextPeriodo = findViewById(R.id.editTextPeriodo);
            btnCalcular = findViewById(R.id.btnCalcular);
            Menu = findViewById(R.id.Menu);
            Regresar = findViewById(R.id.Regresar);
            textViewResultado = findViewById(R.id.textViewResultado);

            // Configurar el botón para calcular el monto del interés compuesto
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
                    Intent intent = new Intent(montotasadeinterescompuesto.this, MainActivity2.class);
                    startActivity(intent);
                }
            });

            // Configurar el botón para regresar
            Regresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(montotasadeinterescompuesto.this, menuinteressimple.class);
                    startActivity(intent);
                }
            });
        }

        private void calcularMonto() {
            // Obtener los valores ingresados por el usuario
            String capitalStr = editTextCapital.getText().toString();
            String interesStr = editTextInteres.getText().toString();
            String periodoStr = editTextPeriodo.getText().toString();

            // Validar que los campos no estén vacíos
            if (!capitalStr.isEmpty() && !interesStr.isEmpty() && !periodoStr.isEmpty()) {
                double capital = Double.parseDouble(capitalStr);
                double interes = Double.parseDouble(interesStr);
                double periodo = Double.parseDouble(periodoStr);

                // Calcular el monto usando la fórmula M = C * (1 + i / p)
                double monto = capital * (1 + interes / periodo);

                // Mostrar el resultado formateado
                textViewResultado.setText(String.format("Resultado: M = %.2f", monto));
            } else {
                // Mostrar un mensaje de error si algún campo está vacío
                textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
            }
        }
    }
