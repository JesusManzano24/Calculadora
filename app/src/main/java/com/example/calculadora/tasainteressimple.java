package com.example.calculadora;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class tasainteressimple extends AppCompatActivity {

    private EditText editTextMonto, editTextCapital, editTextTiempo;
    private Button btnCalcular, btnMenu, btnRegresar;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasainteressimple);

        // Referenciar los elementos en el diseño XML
        editTextMonto = findViewById(R.id.editTextMonto);
        editTextCapital = findViewById(R.id.editTextCapital);
        editTextTiempo = findViewById(R.id.editTextTiempo);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnMenu = findViewById(R.id.Menu);
        btnRegresar = findViewById(R.id.Regresar);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Configurar el botón para calcular la tasa de interés
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTasaInteres();
            }
        });

        // Configurar el botón para ir al menú
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tasainteressimple.this, menuinteressimple.class);
                startActivity(intent);
            }
        });

        // Configurar el botón para regresar a la actividad anterior
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad actual y regresa a la anterior
            }
        });
    }

    private void calcularTasaInteres() {
        // Obtener los valores ingresados por el usuario
        String montoStr = editTextMonto.getText().toString();
        String capitalStr = editTextCapital.getText().toString();
        String tiempoStr = editTextTiempo.getText().toString();

        // Validar que los campos no estén vacíos
        if (!montoStr.isEmpty() && !capitalStr.isEmpty() && !tiempoStr.isEmpty()) {
            double monto = Double.parseDouble(montoStr);
            double capital = Double.parseDouble(capitalStr);
            double tiempo = Double.parseDouble(tiempoStr);

            // Validar que el capital y el tiempo no sean cero
            if (capital != 0 && tiempo != 0) {
                // Calcular la tasa de interés usando la fórmula i = (M - C) / (C * N)
                double interes = (monto / capital)-1 / tiempo;

                // Mostrar el resultado formateado
                textViewResultado.setText(String.format("Resultado: i = %.2f Años", interes));
            } else {
                // Mostrar error si capital o tiempo son cero
                textViewResultado.setText("Error: Capital y tiempo deben ser mayores a cero.");
            }
        } else {
            // Mostrar un mensaje de error si algún campo está vacío
            textViewResultado.setText("Por favor, ingrese todos los valores correctamente.");
        }
    }
}
