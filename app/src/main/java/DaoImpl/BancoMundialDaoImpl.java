package DaoImpl;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import Dao.BancoMundialDao;
import dto.Registro;
import sql.BancoMundialSQLiteHelper;

/**
 * Created by HP on 4/30/2017.
 */
public class BancoMundialDaoImpl implements BancoMundialDao {

    String message="";

    @Override
    public List<Registro> bancoMundialQRY(
            SQLiteDatabase db,
            String codPais,
            String codIndicador) {

        List<Registro> list = null;
        Log.i("BD", "Entraste a bancoMundialQRY");
        try{
            String campos[] = new String[]{"anio","valor"};
            String selection = "codigoPais = ? and codigoIndicador = ?";
            String selectionArgs[] = new String[]{codPais,codIndicador};
            Cursor c = db.query( "tp_bancoMundial", campos, selection, selectionArgs, null, null, null );

            Log.i("BD", "Se ejecutó el select: "+c.getCount());

            //Nos aseguramos de que existe al menos un registro
            if (c.moveToFirst()) {
                list = new LinkedList<>();
                //Recorremos el cursor hasta que no haya más registros
                do {
                    Registro r = new Registro();
                    r.setAnio(c.getString(0));
                    r.setValor(c.getInt(1));

                    list.add(r);
                } while(c.moveToNext());
                Log.i("BD", "Se leyeron los registros");
            }
        }catch(Exception e){
            message = e.getMessage();
            Log.i("BD", "Excepcion: "+message);
        }


        return list;
    }

    public String getMessage(){
        return message;
    }



}
