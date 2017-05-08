package pe.edu.sistemas.bancomundialapp;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;
import java.util.List;

import Dao.BancoMundialDao;
import Dao.Resultado;
import DaoImpl.BancoMundialDaoImpl;
import dto.Registro;
import sql.BancoMundialSQLiteHelper;

public class TableActivity extends AppCompatActivity {
    Spinner sp_paises;
    Spinner sp_indicadores;
    Button consultar;
    String[] paises={"Argentina","Bolivia","Brasil","Chile","Colombia","Ecuador","Paraguay","Peru","Uruaguay","Venezuela"};
    String[] codigo_paises={"ARG","BOL","BRA","CHL","COL","ECU","PRY","PER","URY","VEN"};
    String[] indicadores={"Personas Mayores de 15 años,viviendo con VIH","Edad Promedio de hombres,en su primer matrimonio",
    "Edad promedio de mujeres, en su primer matrimonio","Prevalencia de diabetes(%poblacion entre 25 y 79 años)","Camas en hospital (por cada 1000 personas)",
    "Incidencia de TBC(por cada 1000 personas)","Expetativa de vida al nacer(en años)","Doctores(por cada 1000 personas)"};
    String[]codigo_indicadores={"SH.DYN.AIDS","SP.DYN.SMAM.MA","SP.DYN.SMAM.FE","SH.STA.DIAB.ZS","SH.MED.BEDS.ZS","SH.TBS.INCD","SP.DYN.LE00.IN","SH.MED.CMHW.P3"};
    String[]anios={"2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015"};//para probar
    int pais;
    int indicador;
    int[]valores={1,2,4,2,6,2,6,7,7,3,80};//para probar
    TableRow fila; // para almacenar los TextViews
    TableLayout lista; // para almacenar los Tablerow;
    ArrayList<Resultado> result=new ArrayList<Resultado>();//para probar
    Drawable d,d1; // para darle borde a los TextView del TableRow

    TextView tituloTablaTextView;

    //SQLite
    private BancoMundialSQLiteHelper bancoMundialDb;
    private SQLiteDatabase db;
    private String message;

    //PieChart
    private PieChart pieChart;
    private BarChart barChart;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        sp_paises=(Spinner) findViewById(R.id.sp_paises);
        sp_indicadores=(Spinner)findViewById(R.id.sp_indicadores);
        consultar=(Button)findViewById(R.id.btnConsultar);
        tituloTablaTextView = (TextView) findViewById(R.id.tituloTablaTextView);

        //PíeChart
        pieChart = (PieChart) findViewById(R.id.pieChart);
        barChart = (BarChart) findViewById(R.id.barChart);

        //SQLite
        bancoMundialDb = new BancoMundialSQLiteHelper(getApplicationContext());

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
        v.setWidth(350);
        v.setHeight(80);
        v.setBackground(d);
        v.setTextColor(Color.WHITE);
        fila.addView(v);
    }
    public void CargarTable()
    {
          consultar.setOnClickListener(new View.OnClickListener()
          {
            @Override
            public void onClick(View v)
            {

                pais=sp_paises.getSelectedItemPosition();//obtengo el indice para relacionarlo con su codigo en el array codigo_paises
                Log.i("Tabla", "Item paises: "+pais);
                Log.i("Tabla", "Pais "+codigo_paises[pais]);
                indicador=sp_indicadores.getSelectedItemPosition();//obtengo el indice para relacionarlo con su codigo en el array codigo indicador
                tituloTablaTextView.setText(indicadores[indicador]);
                Log.i("Tabla", "Item de indicadores: "+indicador);
                Log.i("Tabla", "Indicador: "+codigo_indicadores[indicador]);
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
                cabezera2.setText("N° de personas");
                CargarTableRow(cabezera2,d1);
                lista.addView(fila);

                //Modo lectura de la bd
                db = bancoMundialDb.getReadableDatabase();
                //Consulta a la bd
                BancoMundialDao bancoMundialDao = new BancoMundialDaoImpl();
                List<Registro> list = bancoMundialDao.bancoMundialQRY(db, codigo_paises[pais], codigo_indicadores[indicador]);

                for(int j=0;j<list.size();j++)
                {
                        fila = new TableRow(getBaseContext());
                        Taño = new TextView(getBaseContext());
                        Taño.setText(list.get(j).getAnio());
                        CargarTableRow(Taño,d);
                        Tvalor = new TextView(getBaseContext());
                        Tvalor.setText(String.valueOf(list.get(j).getValor()));
                        CargarTableRow(Tvalor,d);
                        lista.addView(fila);
                }

                dibujarPie(list);
            }
          });
    }

    public void dibujarPie(List<Registro> list){

        /*definimos algunos atributos*/
        pieChart.setHoleRadius(40f);
        pieChart.setDrawYValues(true);
        pieChart.setDrawXValues(true);
        pieChart.setRotationEnabled(true);
        pieChart.animateXY(1500, 1500);

        /*creamos una lista para los valores X*/
        ArrayList<String> valsX = new ArrayList<String>();
        /*creamos una lista para los valores Y*/
        ArrayList<Entry> valsY = new ArrayList<Entry>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getValor() > 0){
                valsX.add(list.get(i).getAnio());
                valsY.add(new Entry(list.get(i).getValor(),0));
            }
        }

 		/*creamos una lista de colores*/
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(getResources().getColor(R.color.red_flat));
        colors.add(getResources().getColor(R.color.amber_flat));
        colors.add(getResources().getColor(R.color.bluegray_flat));
        colors.add(getResources().getColor(R.color.deeporange_flat));
        colors.add(getResources().getColor(R.color.green_flat));
        colors.add(getResources().getColor(R.color.pink_flat));
        colors.add(getResources().getColor(R.color.purple_flat));
        colors.add(getResources().getColor(R.color.teal_flat));
        colors.add(getResources().getColor(R.color.indigo_flat));
        colors.add(getResources().getColor(R.color.amber_flat));

 		/*seteamos los valores de Y y los colores*/
        PieDataSet set1 = new PieDataSet(valsY, "Resultados");
        set1.setSliceSpace(3f);
        set1.setColors(colors);

		/*seteamos los valores de X*/
        PieData data = new PieData(valsX, set1);
        pieChart.setData(data);
        pieChart.highlightValues(null);
        pieChart.invalidate();

        /*Ocutar descripcion*/
        pieChart.setDescription("");
        /*Ocultar leyenda*/
        pieChart.setDrawLegend(true);
    }

    public void dibujarBar(List<Registro> list){


    }

}
