package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class plazointerescompuesto extends AppCompatActivity {

        private EditText editTextMonto, editTextCapital, editTextInteres, editTextNumeroPeriodos;
        private Button btnCalcular, Menu, Regresar;
        private TextView textViewResultado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_plazointerescompuesto);

            // Referenciar los elementos en el diseño XML
            editTextMonto = findViewById(R.id.editTextMonto);
            editTextCapital = findViewById(R.id.editTextCapital);
            editTextInteres = findViewById(R.id.editTextInteres);
            btnCalcular = findViewById(R.id.btnCalcular);
            Menu = findViewById(R.id.Menu);
            Regresar = findViewById(R.id.Regresar);
            textViewResultado = findViewById(R.id.textViewResultado);

            // Configurar el botón para calcular el plazo en interés compuesto
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
                    Intent intent = new Intent(plazointerescompuesto.this, MainActivity2.class);
                    startActivity(intent);
                }
            });

            // Configurar el botón para regresar
            Regresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(plazointerescompuesto.this, menuinteressimple.class);
                    startActivity(intent);
                }
            });
        }

        private void calcularPlazo() {
            // Obtener los valores ingresados por el usuario
            String montoStr = editTextMonto.getText().toString();
            String capitalStr = editTextCapital.getText().toString();
            String interesStr = editTextInteres.getText().toString();
            String numeroPeriodosStr = editTextNumeroPeriodos.getText().toString();

            // Validar que los campos no estén vacíos
            if (!montoStr.isEmpty() && !capitalStr.isEmpty() && !interesStr.isEmpty() && !numeroPeriodosStr.isEmpty()) {
                double monto = Double.parseDouble(montoStr);
                double capital = Double.parseDouble(capitalStr);
                double interes = Double.parseDouble(interesStr);
                double numeroPeriodos = Double.parseDouble(numeroPeriodosStr);

                // Calcular el plazo usando la fórmula n = Ln(M/C) / Ln(1 + i)
                double plazo = Math.log(monto / capital) / Math.log(1 + interes);

                // Mostrar el resultado formateado
                textViewResultado.setText(String.format("Resultado: n = %.2f", plazo));
            } else {
                // Mostrar un mensaje de error si algún campo está vacío
                textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
            }
        }
    }
