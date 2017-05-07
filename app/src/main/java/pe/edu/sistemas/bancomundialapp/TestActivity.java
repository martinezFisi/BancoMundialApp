package pe.edu.sistemas.bancomundialapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import Dao.BancoMundialDao;
import DaoImpl.BancoMundialDaoImpl;
import dto.Registro;
import sql.BancoMundialSQLiteHelper;

public class TestActivity extends AppCompatActivity {

    BancoMundialSQLiteHelper bancoMundialDb;
    SQLiteDatabase db;
    private TextView textView;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        textView = (TextView)findViewById(R.id.textView);

        this.deleteDatabase("BANCOMUNDIAL");
        bancoMundialDb = new BancoMundialSQLiteHelper(getApplicationContext());
        db = bancoMundialDb.getReadableDatabase();

        BancoMundialDao bancoMundialDao = new BancoMundialDaoImpl();
        List<Registro> list = bancoMundialDao.bancoMundialQRY(db, "ARG", "SH.DYN.AIDS");

        if(list == null){
            message = bancoMundialDao.getMessage();
            textView.setText("Error: "+message);
        } else {
            String cadena = "";
            for (Registro r : list) {
                cadena = cadena + r.getAnio() + ", " + r.getValor() + "\n";
            }

            textView.setText(cadena);
        }

    }

}
