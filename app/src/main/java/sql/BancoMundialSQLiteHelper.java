package sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by HP on 4/30/2017.
 */
public class BancoMundialSQLiteHelper extends SQLiteOpenHelper {

    private String sqlCreate = "CREATE TABLE tp_bancoMundial (" +
            "  idtp_bancoMundial       int(11) NOT NULL AUTO_INCREMENT, " +
            "  codigoPais      varchar(15) NOT NULL, " +
            "  codigoIndicador         varchar(15) NOT NULL, " +
            "  anio                    int(4) NOT NULL, " +
            "  valor                  int(10) NOT NULL, " +
            "  PRIMARY KEY (idtp_bancoMundial) " +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    public BancoMundialSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS tp_bancoMundial");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }



}
