package Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import dto.Registro;

/**
 * Created by HP on 4/30/2017.
 */
public interface BancoMundialDao {

    public List<Registro> bancoMundialQRY(SQLiteDatabase db, String codigoPais, String codigoIndicador);
    public String getMessage();
}
