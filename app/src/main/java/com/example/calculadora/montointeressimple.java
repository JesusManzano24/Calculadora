package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class montointeressimple extends AppCompatActivity {

    private EditText editTextCapital, editTextInteres, editTextTiempo;
    private Button btnCalcular, Menu, Regresar;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_montointeressimple);

        // Referenciar los elementos en el diseño XML
        editTextCapital = findViewById(R.id.editTextCapital);
        editTextInteres = findViewById(R.id.editTextInteres);
        editTextTiempo = findViewById(R.id.editTextTiempo);
        btnCalcular = findViewById(R.id.btnCalcular);
        Menu = findViewById(R.id.Menu);
        Regresar = findViewById(R.id.Regresar);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Configurar el botón para calcular el monto final
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
                Intent intent = new Intent(montointeressimple.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        // Configurar el botón para regresar
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(montointeressimple.this, menuinteressimple.class);
                startActivity(intent);
            }
        });
    }

    private void calcularMonto() {
        // Obtener los valores ingresados por el usuario
        String capitalStr = editTextCapital.getText().toString();
        String interesStr = editTextInteres.getText().toString();
        String tiempoStr = editTextTiempo.getText().toString();

        // Validar que los campos no estén vacíos
        if (!capitalStr.isEmpty() && !interesStr.isEmpty() && !tiempoStr.isEmpty()) {
            double capital = Double.parseDouble(capitalStr);
            double interes = Double.parseDouble(interesStr);
            double tiempo = Double.parseDouble(tiempoStr);

            // Calcular el monto usando la fórmula M = C(1 + in)
            double monto = capital * (1 + (interes * tiempo));

            // Mostrar el resultado formateado
            textViewResultado.setText(String.format("Resultado: M = %.2f", monto));
        } else {
            // Mostrar un mensaje de error si algún campo está vacío
            textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
        }
    }
}



