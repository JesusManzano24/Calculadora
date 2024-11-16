package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class capitalinteressimple extends AppCompatActivity {

    private EditText editTextMonto, editTextInteres, editTextTiempo;
    private Button btnCalcular, Menu, Regresar;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capitalinteressimple);

        // Referenciar los elementos en el diseño XML
        editTextMonto = findViewById(R.id.editTextMonto);
        editTextInteres = findViewById(R.id.editTextInteres);
        editTextTiempo = findViewById(R.id.editTextTiempo);
        btnCalcular = findViewById(R.id.btnCalcular);
        Menu = findViewById(R.id.Menu);
        Regresar = findViewById(R.id.Regresar);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Configurar el botón para calcular el capital
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
                Intent intent = new Intent(capitalinteressimple.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        // Configurar el botón para regresar
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(capitalinteressimple.this, menuinteressimple.class);
                startActivity(intent);
            }
        });
    }

    private void calcularCapital() {
        // Obtener los valores ingresados por el usuario
        String montoStr = editTextMonto.getText().toString();
        String interesStr = editTextInteres.getText().toString();
        String tiempoStr = editTextTiempo.getText().toString();

        // Validar que los campos no estén vacíos
        if (!montoStr.isEmpty() && !interesStr.isEmpty() && !tiempoStr.isEmpty()) {
            double monto = Double.parseDouble(montoStr);
            double interes = Double.parseDouble(interesStr);
            double tiempo = Double.parseDouble(tiempoStr);

            // Calcular el capital usando la fórmula C = M / (1 + i * n)
            double capital = monto / (1 + (interes * tiempo));

            // Mostrar el resultado formateado
            textViewResultado.setText(String.format("Resultado: C = %.2f", capital));
        } else {
            // Mostrar un mensaje de error si algún campo está vacío
            textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
        }

    }
}