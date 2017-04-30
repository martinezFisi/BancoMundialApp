package Dao;

import android.content.Context;

import java.util.List;

/**
 * Created by HP on 4/30/2017.
 */
public interface BancoMundialDao {

    public List<Object[]> bancoMundialQRY(Context context, String codigoPais, String codigoIndicador);

}
