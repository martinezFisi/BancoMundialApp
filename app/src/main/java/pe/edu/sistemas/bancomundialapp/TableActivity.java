package pe.edu.sistemas.bancomundialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TableActivity extends AppCompatActivity {
    Spinner sp_paises;
    Spinner sp_indicadores;
    String[] paises={"Argentina","Bolivia","Brasil","Chile","Colombia","Ecuador","Paraguay","Peru","Uruaguay","Venezuela"};
    String[] codigo_paises={"Arg","Bol","Bra","Chi","Col","Ecu","Par","Per","Uru","Ven"};
    String[] indicadores={"Personas Mayores de 15 años,viviendo con VIH","Edad Promedio de hombres,en su primer matrimonio",
    "Edad promedio de mujeres, en su primer matrimonio","Prevalencia de diabetes(%poblacion entre 25 y 79 años)","Camas en hospital (por cada 1000 personas)",
    "Incidencia de TBC(por cada 1000 personas)","Expetativa de vida al nacer(en años)","Doctores(por cada 1000 personas)"};
    String[]codigo_indicadores={"SH.DYN.AIDS","SP.DYN.SMAM.MA","SP.DYN.SMAM.FE","SH.STA.DIAB.ZS","SH.MED.BEDS.ZS","SH.TBS.INCD","SP.DYN.LEOO.IN","SH.MED.CMHW.P3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        sp_paises=(Spinner) findViewById(R.id.sp_paises);
        sp_indicadores=(Spinner)findViewById(R.id.sp_indicadores);
        CargarPaises();
        CargarIndicadores();
    }

    public void CargarPaises()
    {
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,paises);
        sp_paises.setAdapter(adaptador);
    }
    public void CargarIndicadores()
    {
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,indicadores);
        sp_indicadores.setAdapter(adaptador);
    }
}
