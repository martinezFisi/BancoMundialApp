package pe.edu.sistemas.bancomundialapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
    int[]valores={1,2,4,2,6,2,6,7,7,3,80};//para probar
    TableRow fila; // para almacenar los TextViews
    TableLayout lista; // para almacenar los Tablerow;
    ArrayList<Resultado> result=new ArrayList<Resultado>();//para probar
    Drawable d,d1; // para darle borde a los TextView del TableRow

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


    public void CargarTableRow(TextView v,Drawable d)
    {
        v.setGravity(Gravity.CENTER_VERTICAL);
        v.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        v.setPadding(15, 15, 15, 15);
        v.setWidth(90);
        v.setHeight(45);
        v.setBackground(d);
        v.setTextColor(Color.WHITE);
        fila.addView(v);
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
                TextView cabezera1;
                TextView cabezera2;
                d= getResources().getDrawable(R.drawable.bordertabla);
                d1=getResources().getDrawable(R.drawable.mybordertabla2);
                cabezera1=new TextView(getBaseContext());
                fila=new TableRow(getBaseContext());
                cabezera1.setText("Año");
                CargarTableRow(cabezera1,d1);
                cabezera2=new TextView(getBaseContext());
                cabezera2.setText("Valor");
                CargarTableRow(cabezera2,d1);
                lista.addView(fila);

                for(int j=0;j<11;j++)
                {
                        fila = new TableRow(getBaseContext());
                        Taño = new TextView(getBaseContext());
                        Taño.setText(result.get(j).getAño());
                        CargarTableRow(Taño,d);
                        Tvalor = new TextView(getBaseContext());
                        Tvalor.setText(String.valueOf(result.get(j).getValor()));
                        CargarTableRow(Tvalor,d);
                        lista.addView(fila);
                }
            }
          });
    }
}
