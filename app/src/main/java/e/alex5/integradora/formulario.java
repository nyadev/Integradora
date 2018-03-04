package e.alex5.integradora;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class formulario extends Activity {

    private CheckBox oficina,casa,deporte;
    private Spinner lista, FrutaFood, VerduraFood, LacteoFood, CarneFood;
    private TextView nombre,edad,estatura,masa;
    private String name,sex,tipoper, actividad;
    private Double stat, mas, SumaCalorias, age;
    private Double A,B,C, caloriaspropias;

    //Arreglos para llenar los spinners
    String [] datos={"Sedentario","Activo"};
    String [] Frutas = {"Arandanos", "kiwi"};
    String [] Verduras = {"Aceitunas negras", "Aceitunas verdes"};
    String [] Lacteos = {"Flan de huevo", "Flan de vainilla"};
    String [] Carnes = {"Chuleta de cerdo","Higado de cerdo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        getActionBar().hide();
        //Tipo de persona
        lista= (Spinner)findViewById(R.id.tipopersona);
        //Spinner de frutas
        FrutaFood = (Spinner)findViewById(R.id.FrutaFood);
        //Spinner de verduras
        VerduraFood = (Spinner)findViewById(R.id.VerdurasFood);
        //Spinner de lácteos
        LacteoFood = (Spinner)findViewById(R.id.LacteosFood);
        //Spinner de carnes
        CarneFood = (Spinner)findViewById(R.id.CarnesFood);
        //INFORMACIÓN PERSONAL
        nombre= (TextView) findViewById(R.id.Nombre);
        edad= (TextView) findViewById(R.id.Edad);
        estatura= (TextView) findViewById(R.id.Estatura);
        masa= (TextView) findViewById(R.id.Masa);
        actividad = "";
        SumaCalorias = 0.0;

        //Para el tipo de persona
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
        lista.setAdapter(adapter);

        //Para llenar el spinner de frutas
        ArrayAdapter<String> FrutaAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Frutas);
        FrutaFood.setAdapter(FrutaAdapter);

        //Para llenar el spinner de verduras
        ArrayAdapter<String> VerduraAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Verduras);
        VerduraFood.setAdapter(VerduraAdapter);

        //Para llenar el spinner de lácteos
        ArrayAdapter<String> LacteoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Lacteos);
        LacteoFood.setAdapter(LacteoAdapter);

        //Para llenar el spinner de carnes
        ArrayAdapter<String> CarneAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Carnes);
        CarneFood.setAdapter(CarneAdapter);


        //Visualizamos la información del Spinner de tipo de persona
        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        tipoper="Sedentario";
                        break;
                    case 1:
                        tipoper="Activo";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Visualizamos la información del tipo de fruta.
        FrutaFood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        SumaCalorias = SumaCalorias + 41.0;
                        break;
                    case 1:
                        SumaCalorias = SumaCalorias + 51.0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Visualizamos la información del tipo de verdura
        VerduraFood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        SumaCalorias = SumaCalorias + 349.0;
                        break;
                    case 1:
                        SumaCalorias = SumaCalorias + 132.0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Visualizamos la información del tipo de lácteo
        LacteoFood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        SumaCalorias = SumaCalorias + 126.0;
                        break;
                    case 1:
                        SumaCalorias = SumaCalorias + 102.0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Visualizamos la información dle tipo de carne
        CarneFood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        SumaCalorias = SumaCalorias + 330.0;
                        break;
                    case 1:
                        SumaCalorias = SumaCalorias + 153.0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    //PARA LOS RADIO BOTONES
    public void onRadioButtonClicked(View view) {
        boolean marcado = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.Masculino:
                if (marcado) {
                    sex="Masculino";
                }
                break;
            case R.id.Femenino:
                if (marcado) {
                    sex="femenino";
                }
                break;
        }
    }

    //PARA LOS CHECKBOX

    public void registrar(View view) {
        // Inicializamos los valores de los campos
        name = nombre.getText().toString();
        age = Double.parseDouble(edad.getText().toString());
        stat = Double.parseDouble(estatura.getText().toString());
        mas = Double.parseDouble(masa.getText().toString());

        //Para calcular las calorías que debe consumir

        A = mas*9.99;
        B = stat*100*6.25;
        C = age*4.92;
        caloriaspropias = A + B + C;

        //ES MOMENTO DE ENVIAR TODA LA INFORMACIÓNA OTRA ACTIVITY
        String Mensaje = "";

        if(SumaCalorias > caloriaspropias)
        {
            Mensaje = "!Te estás pasando¡ Deberías reducir la cantidad de calorías que consumes." +
                " Te recomentamos comer más frutas y verduras que carnes y lacteos";
        }
        else
        {
            Mensaje = "Deberías agregar un poco más de calorías a tu dieta. Deberías probar alguna" +
                    " carne o lácteo en baja medida";
        }

        //APLICAMOS EL INTENT
        Intent EnviarInfo = new Intent(this, resultado.class);
        EnviarInfo.putExtra("Nombre", name);
        EnviarInfo.putExtra("Edad", age.toString());
        EnviarInfo.putExtra("CaloriasPropias", caloriaspropias.toString());
        EnviarInfo.putExtra("CaloriasElegidas", SumaCalorias.toString());
        EnviarInfo.putExtra("Actividad", actividad);
        EnviarInfo.putExtra("Mensaje", Mensaje);

        startActivity(EnviarInfo);
    }

    public void CheckBoxMethod(View view) {
        boolean seleccionado = ((CheckBox) view).isChecked();

        switch (view.getId())
        {
            case R.id.oficina:
                if(seleccionado)
                {
                    actividad = "Usted trabaja en una oficina";
                }

                break;
            case R.id.casa:
                if(seleccionado)
                {
                    actividad = "Usted se la pasa en casa";
                }

                break;

            case R.id.deporte:
                if(seleccionado)
                {
                    actividad = "Usted hace deporte";
                }

                break;
        }
    }
}
