package e.alex5.integradora;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ocultamos el toolbar
        getActionBar().hide();
    }

    public void ComenzarActividad(View view) {
        Intent IniciarActividad = new Intent(this, formulario.class);
        startActivity(IniciarActividad);
    }
}
