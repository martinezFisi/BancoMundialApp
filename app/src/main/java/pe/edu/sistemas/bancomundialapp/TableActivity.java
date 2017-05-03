package pe.edu.sistemas.bancomundialapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import Dao.Resultado;

public class TableActivity extends AppCompatActivity {
    Spinner sp_paises;
    Spinner sp_indicadores;
    Button consultar;
    String[] paises={"Argentina","Bolivia","Brasil","Chile","Colombia","Ecuador","Paraguay","Peru","Uruaguay","Venezuela"};
    String[] codigo_paises={"Arg","Bol","Bra","Chi","Col","Ecu","Par","Per","Uru","Ven"};
    String[] indicadores={"Personas Mayores de 15 años,viviendo con VIH","Edad Promedio de hombres,en su primer matrimonio",
    "Edad promedio de mujeres, en su primer matrimonio","Prevalencia de diabetes(%poblacion entre 25 y 79 años)","Camas en hospital (por cada 1000 personas)",
    "Incidencia de TBC(por cada 1000 personas)","Expetativa de vida al nacer(en años)","Doctores(por cada 1000 personas)"};
    String[]codigo_indicadores={"SH.DYN.AIDS","SP.DYN.SMAM.MA","SP.DYN.SMAM.FE","SH.STA.DIAB.ZS","SH.MED.BEDS.ZS","SH.TBS.INCD","SP.DYN.LEOO.IN","SH.MED.CMHW.P3"};
    String[]anios={"2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015"};//para probar
    int pais;
    int indicador;
    int[]valores={1,2,4,2,6,2,6,7,7,3,8};//para probar
    TableRow fila; // para almacenar los TextViews
    TableLayout lista; // para almacenar los Tablerow;
    ArrayList<Resultado> result=new ArrayList<Resultado>();//para probar

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        sp_paises=(Spinner) findViewById(R.id.sp_paises);
        sp_indicadores=(Spinner)findViewById(R.id.sp_indicadores);
        consultar=(Button)findViewById(R.id.btnConsultar);
        CargarPaises();
        CargarIndicadores();
        CargarTable();
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

    public void CargarTable()
    {

            for (int j = 0; j < 11; j++) { // este for solo para q me llene el arraylist de resultados
                Resultado r = new Resultado();
                r.setAño(anios[j]);
                r.setValor(valores[j]);
                result.add(r);
            }


          consultar.setOnClickListener(new View.OnClickListener()
          {
            @Override
            public void onClick(View v)
            {
                pais=sp_paises.getSelectedItemPosition();//obtengo el indice para relacionarlo con su codigo en el array codigo_paises
                indicador=sp_indicadores.getSelectedItemPosition();//obtengo el indice para relacionarlo con su codigo en el array codigo indicador
                lista=(TableLayout)findViewById(R.id.tablaConsultas);
                lista.removeAllViews();// para borrar los datos de la tabla y mostrar los datos de la nueva consulta
                TextView Taño;
                TextView Tvalor;
                for(int j=0;j<11;j++)
                {
                    fila = new TableRow(getBaseContext());
                        Taño = new TextView(getBaseContext());
                        Taño.setGravity(Gravity.CENTER_VERTICAL);
                        Taño.setPadding(15, 15, 15, 15);
                        Taño.setBackgroundResource(R.color.colorPrimary);
                        Taño.setText(result.get(j).getAño());
                        Taño.setTextColor(Color.WHITE);
                        fila.addView(Taño);
                        Tvalor = new TextView(getBaseContext());
                        Tvalor.setGravity(Gravity.CENTER_VERTICAL);
                        Tvalor.setPadding(15, 15, 15, 15);
                        Tvalor.setBackgroundResource(R.color.colorPrimary);
                        Tvalor.setText(String.valueOf(result.get(j).getValor()));
                        Tvalor.setTextColor(Color.WHITE);
                        fila.addView(Tvalor);
                    lista.addView(fila);
                }
            }
          });

    }
}
