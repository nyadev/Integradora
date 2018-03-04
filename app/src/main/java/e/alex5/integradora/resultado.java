package e.alex5.integradora;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class resultado extends Activity {

    private TextView nombre, edad, calp, calc, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        getActionBar().hide();

        nombre = (TextView) findViewById(R.id.Nombre);
        nombre.setText(getIntent().getExtras().getString("Nombre"));

        edad = (TextView) findViewById(R.id.Edad);
        edad.setText("Edad: " + getIntent().getExtras().getString("Edad") + "años");

        calp = (TextView) findViewById(R.id.CaloriasPropias);
        calp.setText("Tus calorias son: " + getIntent().getExtras().getString("CaloriasPropias") + " calorías.");

        calc = (TextView) findViewById(R.id.CaloriasCalculadas);
        edad.setText("El total de las calorías de tus alimentos son " + getIntent().getExtras().getString("CaloriasElegidas")
        +" calorías.");

        mensaje = (TextView) findViewById(R.id.Mensaje);
        mensaje.setText(getIntent().getExtras().getString("Mensaje"));
    }
}
