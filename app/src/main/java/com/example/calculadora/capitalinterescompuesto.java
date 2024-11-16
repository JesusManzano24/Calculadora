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

public class capitalinterescompuesto extends AppCompatActivity {

        private EditText editTextMonto, editTextInteres, editTextPeriodo, editTextNumeroPeriodos;
        private Button btnCalcular, Menu, Regresar;
        private TextView textViewResultado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_capitalinterescompuesto);

            // Referenciar los elementos en el diseño XML
            editTextMonto = findViewById(R.id.editTextMonto);
            editTextInteres = findViewById(R.id.editTextInteres);
            editTextPeriodo = findViewById(R.id.editTextPeriodo);
            editTextNumeroPeriodos = findViewById(R.id.editTextNumeroPeriodos);
            btnCalcular = findViewById(R.id.btnCalcular);
            Menu = findViewById(R.id.Menu);
            Regresar = findViewById(R.id.Regresar);
            textViewResultado = findViewById(R.id.textViewResultado);

            // Configurar el botón para calcular el capital del interés compuesto
            btnCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcularCapital();
                }
            });

            // Configurar el botón para ir al menú
            Menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(capitalinterescompuesto.this, MainActivity2.class);
                    startActivity(intent);
                }
            });

            // Configurar el botón para regresar
            Regresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(capitalinterescompuesto.this, menuinteressimple.class);
                    startActivity(intent);
                }
            });
        }

        private void calcularCapital() {
            // Obtener los valores ingresados por el usuario
            String montoStr = editTextMonto.getText().toString();
            String interesStr = editTextInteres.getText().toString();
            String periodoStr = editTextPeriodo.getText().toString();
            String numeroPeriodosStr = editTextNumeroPeriodos.getText().toString();

            // Validar que los campos no estén vacíos
            if (!montoStr.isEmpty() && !interesStr.isEmpty() && !periodoStr.isEmpty() && !numeroPeriodosStr.isEmpty()) {
                double monto = Double.parseDouble(montoStr);
                double interes = Double.parseDouble(interesStr);
                double periodo = Double.parseDouble(periodoStr);
                double numeroPeriodos = Double.parseDouble(numeroPeriodosStr);

                // Calcular el capital usando la fórmula C = M / (1 + i / p) ^ (np)
                double capital = monto / Math.pow((1 + interes / periodo), numeroPeriodos);

                // Mostrar el resultado formateado
                textViewResultado.setText(String.format("Resultado: C = %.2f", capital));
            } else {
                // Mostrar un mensaje de error si algún campo está vacío
                textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
            }
        }
    }
