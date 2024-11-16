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

public class periodosdecapitalizacioninterescompuesto extends AppCompatActivity {

        private EditText editTextMonto, editTextCapital, editTextInteres, editTextPagosPorPeriodo;
        private Button btnCalcular, Menu, Regresar;
        private TextView textViewResultado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_periodosdecapitalizacioninterescompuesto);

            // Referenciar los elementos en el diseño XML
            editTextMonto = findViewById(R.id.editTextMonto);
            editTextCapital = findViewById(R.id.editTextCapital);
            editTextInteres = findViewById(R.id.editTextInteres);
            editTextPagosPorPeriodo = findViewById(R.id.editTextPagosPorPeriodo);
            btnCalcular = findViewById(R.id.btnCalcular);
            Menu = findViewById(R.id.Menu);
            Regresar = findViewById(R.id.Regresar);
            textViewResultado = findViewById(R.id.textViewResultado);

            // Configurar el botón para calcular los períodos de capitalización
            btnCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcularPeriodos();
                }
            });

            // Configurar el botón para ir al menú
            Menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(periodosdecapitalizacioninterescompuesto.this, MainActivity2.class);
                    startActivity(intent);
                }
            });

            // Configurar el botón para regresar
            Regresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(periodosdecapitalizacioninterescompuesto.this, menuinteressimple.class);
                    startActivity(intent);
                }
            });
        }

        private void calcularPeriodos() {
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

                // Calcular los períodos de capitalización usando la fórmula X = np = Ln(M/C) / Ln(1 + i/p)
                double periodos = Math.log(monto / capital) / Math.log(1 + interes / pagosPorPeriodo);

                // Mostrar el resultado formateado
                textViewResultado.setText(String.format("Resultado: X = %.2f", periodos));
            } else {
                // Mostrar un mensaje de error si algún campo está vacío
                textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
            }
        }
    }
