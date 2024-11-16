package com.example.calculadora;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class descuentosimpled extends AppCompatActivity {

    private EditText editTextMonto, editTextTiempo, editTextTasaDescuento;
    private Button btnCalcular, Menu, Regresar;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descuentosimpled);

        // Referenciar los elementos en el diseño XML
        editTextMonto = findViewById(R.id.editTextMonto);
        editTextTiempo = findViewById(R.id.editTextTiempo);
        editTextTasaDescuento = findViewById(R.id.editTextTasaDescuento);
        btnCalcular = findViewById(R.id.btnCalcular);
        Menu = findViewById(R.id.Menu);
        Regresar = findViewById(R.id.Regresar);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Configurar el botón para calcular el descuento
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularDescuento();
            }
        });

        // Configurar el botón para ir al menú
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(descuentosimpled.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        // Configurar el botón para regresar
        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(descuentosimpled.this, menuinteressimple.class);
                startActivity(intent);
            }
        });
    }

    private void calcularDescuento() {
        // Obtener los valores ingresados por el usuario
        String montoStr = editTextMonto.getText().toString();
        String tiempoStr = editTextTiempo.getText().toString();
        String tasaDescuentoStr = editTextTasaDescuento.getText().toString();

        // Validar que los campos no estén vacíos
        if (!montoStr.isEmpty() && !tiempoStr.isEmpty() && !tasaDescuentoStr.isEmpty()) {
            double monto = Double.parseDouble(montoStr);
            double tiempo = Double.parseDouble(tiempoStr);
            double tasaDescuento = Double.parseDouble(tasaDescuentoStr);

            // Calcular el descuento usando la fórmula D = M * N * d
            double descuento = monto * tiempo * tasaDescuento;

            // Mostrar el resultado formateado
            textViewResultado.setText(String.format("Resultado: D = %.2f", descuento));
        } else {
            // Mostrar un mensaje de error si algún campo está vacío
            textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
        }
    }
}
