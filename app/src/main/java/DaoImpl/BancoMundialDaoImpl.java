package DaoImpl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import Dao.BancoMundialDao;
import sql.BancoMundialSQLiteHelper;

/**
 * Created by HP on 4/30/2017.
 */
public class BancoMundialDaoImpl implements BancoMundialDao {

    @Override
    public List<Object[]> bancoMundialQRY(
            Context contexto,
            String codigoPais,
            String codigoIndicador) {

        //Abrir la base de datos en modo de escritura
        BancoMundialSQLiteHelper bancoMundialDb =
                new BancoMundialSQLiteHelper(contexto, "DBBancoMundial", null, 1);
        SQLiteDatabase db  = bancoMundialDb.getWritableDatabase();

        if(db != null){
            //Insertamos la data inicial
            //db.execSQL(getInserts());
        }

        String[] args = new String[] {codigoPais, codigoIndicador};
        Cursor c = db.rawQuery(
                " SELECT codigoPais, codigoIndicador, anio, valor" +
                " FROM tp_bancoMundial where codigoIndicador=? and codigoPais=?", args);



        return null;
    }

    /*private String getInserts(){
        String cadena = "" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('1', 'ARG', 'SH.DYN.AIDS', '2005', '84000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('2', 'ARG', 'SH.DYN.AIDS', '2006', '88000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('3', 'ARG', 'SH.DYN.AIDS', '2007', '93000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('4', 'ARG', 'SH.DYN.AIDS', '2008', '98000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('5', 'ARG', 'SH.DYN.AIDS', '2009', '100000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('6', 'ARG', 'SH.DYN.AIDS', '2010', '110000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('7', 'ARG', 'SH.DYN.AIDS', '2011', '110000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('8', 'ARG', 'SH.DYN.AIDS', '2012', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('9', 'ARG', 'SH.DYN.AIDS', '2013', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('10', 'ARG', 'SH.DYN.AIDS', '2014', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('11', 'ARG', 'SH.DYN.AIDS', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('12', 'ARG', 'SP.DYN.SMAM.FE', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('13', 'ARG', 'SP.DYN.SMAM.FE', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('14', 'ARG', 'SP.DYN.SMAM.FE', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('15', 'ARG', 'SP.DYN.SMAM.FE', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('16', 'ARG', 'SP.DYN.SMAM.FE', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('17', 'ARG', 'SP.DYN.SMAM.FE', '2010', '24.60');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('18', 'ARG', 'SP.DYN.SMAM.FE', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('19', 'ARG', 'SP.DYN.SMAM.FE', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('20', 'ARG', 'SP.DYN.SMAM.FE', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('21', 'ARG', 'SP.DYN.SMAM.FE', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('22', 'ARG', 'SP.DYN.SMAM.FE', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('23', 'ARG', 'SP.DYN.SMAM.MA', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('24', 'ARG', 'SP.DYN.SMAM.MA', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('25', 'ARG', 'SP.DYN.SMAM.MA', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('26', 'ARG', 'SP.DYN.SMAM.MA', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('27', 'ARG', 'SP.DYN.SMAM.MA', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('28', 'ARG', 'SP.DYN.SMAM.MA', '2010', '26.60');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('29', 'ARG', 'SP.DYN.SMAM.MA', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('30', 'ARG', 'SP.DYN.SMAM.MA', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('31', 'ARG', 'SP.DYN.SMAM.MA', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('32', 'ARG', 'SP.DYN.SMAM.MA', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('33', 'ARG', 'SP.DYN.SMAM.MA', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('34', 'ARG', 'SH.MED.CMHW.P3', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('35', 'ARG', 'SH.MED.CMHW.P3', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('36', 'ARG', 'SH.MED.CMHW.P3', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('37', 'ARG', 'SH.MED.CMHW.P3', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('38', 'ARG', 'SH.MED.CMHW.P3', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('39', 'ARG', 'SH.MED.CMHW.P3', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('40', 'ARG', 'SH.MED.CMHW.P3', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('41', 'ARG', 'SH.MED.CMHW.P3', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('42', 'ARG', 'SH.MED.CMHW.P3', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('43', 'ARG', 'SH.MED.CMHW.P3', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('44', 'ARG', 'SH.MED.CMHW.P3', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('45', 'ARG', 'SH.STA.DIAB.ZS', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('46', 'ARG', 'SH.STA.DIAB.ZS', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('47', 'ARG', 'SH.STA.DIAB.ZS', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('48', 'ARG', 'SH.STA.DIAB.ZS', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('49', 'ARG', 'SH.STA.DIAB.ZS', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('50', 'ARG', 'SH.STA.DIAB.ZS', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('51', 'ARG', 'SH.STA.DIAB.ZS', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('52', 'ARG', 'SH.STA.DIAB.ZS', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('53', 'ARG', 'SH.STA.DIAB.ZS', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('54', 'ARG', 'SH.STA.DIAB.ZS', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('55', 'ARG', 'SH.STA.DIAB.ZS', '2015', '6.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('56', 'ARG', 'SH.MED.BEDS.ZS', '2005', '4.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('57', 'ARG', 'SH.MED.BEDS.ZS', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('58', 'ARG', 'SH.MED.BEDS.ZS', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('59', 'ARG', 'SH.MED.BEDS.ZS', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('60', 'ARG', 'SH.MED.BEDS.ZS', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('61', 'ARG', 'SH.MED.BEDS.ZS', '2010', '4.50');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('62', 'ARG', 'SH.MED.BEDS.ZS', '2011', '4.50');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('63', 'ARG', 'SH.MED.BEDS.ZS', '2012', '4.70');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('64', 'ARG', 'SH.MED.BEDS.ZS', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('65', 'ARG', 'SH.MED.BEDS.ZS', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('66', 'ARG', 'SH.MED.BEDS.ZS', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('67', 'ARG', 'SH.TBS.INCD', '2005', '31.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('68', 'ARG', 'SH.TBS.INCD', '2006', '29.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('69', 'ARG', 'SH.TBS.INCD', '2007', '27.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('70', 'ARG', 'SH.TBS.INCD', '2008', '26.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('71', 'ARG', 'SH.TBS.INCD', '2009', '25.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('72', 'ARG', 'SH.TBS.INCD', '2010', '25.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('73', 'ARG', 'SH.TBS.INCD', '2011', '24.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('74', 'ARG', 'SH.TBS.INCD', '2012', '24.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('75', 'ARG', 'SH.TBS.INCD', '2013', '24.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('76', 'ARG', 'SH.TBS.INCD', '2014', '24.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('77', 'ARG', 'SH.TBS.INCD', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('78', 'ARG', 'SP.DYN.LE00.IN', '2005', '74.69');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('79', 'ARG', 'SP.DYN.LE00.IN', '2006', '74.85');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('80', 'ARG', 'SP.DYN.LE00.IN', '2007', '75.01');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('81', 'ARG', 'SP.DYN.LE00.IN', '2008', '75.17');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('82', 'ARG', 'SP.DYN.LE00.IN', '2009', '75.32');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('83', 'ARG', 'SP.DYN.LE00.IN', '2010', '75.48');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('84', 'ARG', 'SP.DYN.LE00.IN', '2011', '75.65');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('85', 'ARG', 'SP.DYN.LE00.IN', '2012', '75.82');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('86', 'ARG', 'SP.DYN.LE00.IN', '2013', '75.99');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('87', 'ARG', 'SP.DYN.LE00.IN', '2014', '76.16');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('88', 'ARG', 'SP.DYN.LE00.IN', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('89', 'BOL', 'SH.DYN.AIDS', '2005', '11000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('90', 'BOL', 'SH.DYN.AIDS', '2006', '12000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('91', 'BOL', 'SH.DYN.AIDS', '2007', '12000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('92', 'BOL', 'SH.DYN.AIDS', '2008', '13000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('93', 'BOL', 'SH.DYN.AIDS', '2009', '14000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('94', 'BOL', 'SH.DYN.AIDS', '2010', '15000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('95', 'BOL', 'SH.DYN.AIDS', '2011', '16000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('96', 'BOL', 'SH.DYN.AIDS', '2012', '16000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('97', 'BOL', 'SH.DYN.AIDS', '2013', '17000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('98', 'BOL', 'SH.DYN.AIDS', '2014', '17000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('99', 'BOL', 'SH.DYN.AIDS', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('100', 'BOL', 'SP.DYN.SMAM.FE', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('101', 'BOL', 'SP.DYN.SMAM.FE', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('102', 'BOL', 'SP.DYN.SMAM.FE', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('103', 'BOL', 'SP.DYN.SMAM.FE', '2008', '22.70');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('104', 'BOL', 'SP.DYN.SMAM.FE', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('105', 'BOL', 'SP.DYN.SMAM.FE', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('106', 'BOL', 'SP.DYN.SMAM.FE', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('107', 'BOL', 'SP.DYN.SMAM.FE', '2012', '24.10');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('108', 'BOL', 'SP.DYN.SMAM.FE', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('109', 'BOL', 'SP.DYN.SMAM.FE', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('110', 'BOL', 'SP.DYN.SMAM.FE', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('111', 'BOL', 'SP.DYN.SMAM.MA', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('112', 'BOL', 'SP.DYN.SMAM.MA', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('113', 'BOL', 'SP.DYN.SMAM.MA', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('114', 'BOL', 'SP.DYN.SMAM.MA', '2008', '25.30');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('115', 'BOL', 'SP.DYN.SMAM.MA', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('116', 'BOL', 'SP.DYN.SMAM.MA', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('117', 'BOL', 'SP.DYN.SMAM.MA', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('118', 'BOL', 'SP.DYN.SMAM.MA', '2012', '26.60');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('119', 'BOL', 'SP.DYN.SMAM.MA', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('120', 'BOL', 'SP.DYN.SMAM.MA', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('121', 'BOL', 'SP.DYN.SMAM.MA', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('122', 'BOL', 'SH.MED.CMHW.P3', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('123', 'BOL', 'SH.MED.CMHW.P3', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('124', 'BOL', 'SH.MED.CMHW.P3', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('125', 'BOL', 'SH.MED.CMHW.P3', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('126', 'BOL', 'SH.MED.CMHW.P3', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('127', 'BOL', 'SH.MED.CMHW.P3', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('128', 'BOL', 'SH.MED.CMHW.P3', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('129', 'BOL', 'SH.MED.CMHW.P3', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('130', 'BOL', 'SH.MED.CMHW.P3', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('131', 'BOL', 'SH.MED.CMHW.P3', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('132', 'BOL', 'SH.MED.CMHW.P3', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('133', 'BOL', 'SH.STA.DIAB.ZS', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('134', 'BOL', 'SH.STA.DIAB.ZS', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('135', 'BOL', 'SH.STA.DIAB.ZS', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('136', 'BOL', 'SH.STA.DIAB.ZS', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('137', 'BOL', 'SH.STA.DIAB.ZS', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('138', 'BOL', 'SH.STA.DIAB.ZS', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('139', 'BOL', 'SH.STA.DIAB.ZS', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('140', 'BOL', 'SH.STA.DIAB.ZS', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('141', 'BOL', 'SH.STA.DIAB.ZS', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('142', 'BOL', 'SH.STA.DIAB.ZS', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('143', 'BOL', 'SH.STA.DIAB.ZS', '2015', '7.50');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('144', 'BOL', 'SH.MED.BEDS.ZS', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('145', 'BOL', 'SH.MED.BEDS.ZS', '2006', '1.10');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('146', 'BOL', 'SH.MED.BEDS.ZS', '2007', '1.10');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('147', 'BOL', 'SH.MED.BEDS.ZS', '2008', '1.10');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('148', 'BOL', 'SH.MED.BEDS.ZS', '2009', '1.10');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('149', 'BOL', 'SH.MED.BEDS.ZS', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('150', 'BOL', 'SH.MED.BEDS.ZS', '2011', '1.10');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('151', 'BOL', 'SH.MED.BEDS.ZS', '2012', '1.10');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('152', 'BOL', 'SH.MED.BEDS.ZS', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('153', 'BOL', 'SH.MED.BEDS.ZS', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('154', 'BOL', 'SH.MED.BEDS.ZS', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('155', 'BOL', 'SH.TBS.INCD', '2005', '158.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('156', 'BOL', 'SH.TBS.INCD', '2006', '153.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('157', 'BOL', 'SH.TBS.INCD', '2007', '148.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('158', 'BOL', 'SH.TBS.INCD', '2008', '144.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('159', 'BOL', 'SH.TBS.INCD', '2009', '139.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('160', 'BOL', 'SH.TBS.INCD', '2010', '135.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('161', 'BOL', 'SH.TBS.INCD', '2011', '131.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('162', 'BOL', 'SH.TBS.INCD', '2012', '127.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('163', 'BOL', 'SH.TBS.INCD', '2013', '123.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('164', 'BOL', 'SH.TBS.INCD', '2014', '120.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('165', 'BOL', 'SH.TBS.INCD', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('166', 'BOL', 'SP.DYN.LE00.IN', '2005', '63.54');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('167', 'BOL', 'SP.DYN.LE00.IN', '2006', '64.11');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('168', 'BOL', 'SP.DYN.LE00.IN', '2007', '64.69');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('169', 'BOL', 'SP.DYN.LE00.IN', '2008', '65.27');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('170', 'BOL', 'SP.DYN.LE00.IN', '2009', '65.85');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('171', 'BOL', 'SP.DYN.LE00.IN', '2010', '66.41');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('172', 'BOL', 'SP.DYN.LE00.IN', '2011', '66.94');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('173', 'BOL', 'SP.DYN.LE00.IN', '2012', '67.45');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('174', 'BOL', 'SP.DYN.LE00.IN', '2013', '67.91');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('175', 'BOL', 'SP.DYN.LE00.IN', '2014', '68.34');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('176', 'BOL', 'SP.DYN.LE00.IN', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('177', 'BRA', 'SH.DYN.AIDS', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('178', 'BRA', 'SH.DYN.AIDS', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('179', 'BRA', 'SH.DYN.AIDS', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('180', 'BRA', 'SH.DYN.AIDS', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('181', 'BRA', 'SH.DYN.AIDS', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('182', 'BRA', 'SH.DYN.AIDS', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('183', 'BRA', 'SH.DYN.AIDS', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('184', 'BRA', 'SH.DYN.AIDS', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('185', 'BRA', 'SH.DYN.AIDS', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('186', 'BRA', 'SH.DYN.AIDS', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('187', 'BRA', 'SH.DYN.AIDS', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('188', 'BRA', 'SP.DYN.SMAM.FE', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('189', 'BRA', 'SP.DYN.SMAM.FE', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('190', 'BRA', 'SP.DYN.SMAM.FE', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('191', 'BRA', 'SP.DYN.SMAM.FE', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('192', 'BRA', 'SP.DYN.SMAM.FE', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('193', 'BRA', 'SP.DYN.SMAM.FE', '2010', '29.70');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('194', 'BRA', 'SP.DYN.SMAM.FE', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('195', 'BRA', 'SP.DYN.SMAM.FE', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('196', 'BRA', 'SP.DYN.SMAM.FE', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('197', 'BRA', 'SP.DYN.SMAM.FE', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('198', 'BRA', 'SP.DYN.SMAM.FE', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('199', 'BRA', 'SP.DYN.SMAM.MA', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('200', 'BRA', 'SP.DYN.SMAM.MA', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('201', 'BRA', 'SP.DYN.SMAM.MA', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('202', 'BRA', 'SP.DYN.SMAM.MA', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('203', 'BRA', 'SP.DYN.SMAM.MA', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('204', 'BRA', 'SP.DYN.SMAM.MA', '2010', '31.90');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('205', 'BRA', 'SP.DYN.SMAM.MA', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('206', 'BRA', 'SP.DYN.SMAM.MA', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('207', 'BRA', 'SP.DYN.SMAM.MA', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('208', 'BRA', 'SP.DYN.SMAM.MA', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('209', 'BRA', 'SP.DYN.SMAM.MA', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('210', 'BRA', 'SH.MED.CMHW.P3', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('211', 'BRA', 'SH.MED.CMHW.P3', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('212', 'BRA', 'SH.MED.CMHW.P3', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('213', 'BRA', 'SH.MED.CMHW.P3', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('214', 'BRA', 'SH.MED.CMHW.P3', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('215', 'BRA', 'SH.MED.CMHW.P3', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('216', 'BRA', 'SH.MED.CMHW.P3', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('217', 'BRA', 'SH.MED.CMHW.P3', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('218', 'BRA', 'SH.MED.CMHW.P3', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('219', 'BRA', 'SH.MED.CMHW.P3', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('220', 'BRA', 'SH.MED.CMHW.P3', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('221', 'BRA', 'SH.STA.DIAB.ZS', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('222', 'BRA', 'SH.STA.DIAB.ZS', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('223', 'BRA', 'SH.STA.DIAB.ZS', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('224', 'BRA', 'SH.STA.DIAB.ZS', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('225', 'BRA', 'SH.STA.DIAB.ZS', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('226', 'BRA', 'SH.STA.DIAB.ZS', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('227', 'BRA', 'SH.STA.DIAB.ZS', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('228', 'BRA', 'SH.STA.DIAB.ZS', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('229', 'BRA', 'SH.STA.DIAB.ZS', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('230', 'BRA', 'SH.STA.DIAB.ZS', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('231', 'BRA', 'SH.STA.DIAB.ZS', '2015', '10.40');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('232', 'BRA', 'SH.MED.BEDS.ZS', '2005', '2.40');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('233', 'BRA', 'SH.MED.BEDS.ZS', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('234', 'BRA', 'SH.MED.BEDS.ZS', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('235', 'BRA', 'SH.MED.BEDS.ZS', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('236', 'BRA', 'SH.MED.BEDS.ZS', '2009', '2.40');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('237', 'BRA', 'SH.MED.BEDS.ZS', '2010', '2.40');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('238', 'BRA', 'SH.MED.BEDS.ZS', '2011', '2.30');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('239', 'BRA', 'SH.MED.BEDS.ZS', '2012', '2.30');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('240', 'BRA', 'SH.MED.BEDS.ZS', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('241', 'BRA', 'SH.MED.BEDS.ZS', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('242', 'BRA', 'SH.MED.BEDS.ZS', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('243', 'BRA', 'SH.TBS.INCD', '2005', '51.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('244', 'BRA', 'SH.TBS.INCD', '2006', '50.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('245', 'BRA', 'SH.TBS.INCD', '2007', '49.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('246', 'BRA', 'SH.TBS.INCD', '2008', '46.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('247', 'BRA', 'SH.TBS.INCD', '2009', '49.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('248', 'BRA', 'SH.TBS.INCD', '2010', '46.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('249', 'BRA', 'SH.TBS.INCD', '2011', '47.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('250', 'BRA', 'SH.TBS.INCD', '2012', '45.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('251', 'BRA', 'SH.TBS.INCD', '2013', '45.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('252', 'BRA', 'SH.TBS.INCD', '2014', '44.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('253', 'BRA', 'SH.TBS.INCD', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('254', 'BRA', 'SP.DYN.LE00.IN', '2005', '71.84');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('255', 'BRA', 'SP.DYN.LE00.IN', '2006', '72.13');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('256', 'BRA', 'SP.DYN.LE00.IN', '2007', '72.41');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('257', 'BRA', 'SP.DYN.LE00.IN', '2008', '72.70');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('258', 'BRA', 'SP.DYN.LE00.IN', '2009', '72.98');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('259', 'BRA', 'SP.DYN.LE00.IN', '2010', '73.26');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('260', 'BRA', 'SP.DYN.LE00.IN', '2011', '73.55');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('261', 'BRA', 'SP.DYN.LE00.IN', '2012', '73.84');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('262', 'BRA', 'SP.DYN.LE00.IN', '2013', '74.12');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('263', 'BRA', 'SP.DYN.LE00.IN', '2014', '74.40');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('264', 'BRA', 'SP.DYN.LE00.IN', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('265', 'CHL', 'SH.DYN.AIDS', '2005', '25000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('266', 'CHL', 'SH.DYN.AIDS', '2006', '27000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('267', 'CHL', 'SH.DYN.AIDS', '2007', '28000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('268', 'CHL', 'SH.DYN.AIDS', '2008', '30000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('269', 'CHL', 'SH.DYN.AIDS', '2009', '31000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('270', 'CHL', 'SH.DYN.AIDS', '2010', '33000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('271', 'CHL', 'SH.DYN.AIDS', '2011', '35000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('272', 'CHL', 'SH.DYN.AIDS', '2012', '36000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('273', 'CHL', 'SH.DYN.AIDS', '2013', '38000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('274', 'CHL', 'SH.DYN.AIDS', '2014', '39000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('275', 'CHL', 'SH.DYN.AIDS', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('276', 'CHL', 'SP.DYN.SMAM.FE', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('277', 'CHL', 'SP.DYN.SMAM.FE', '2006', '26.10');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('278', 'CHL', 'SP.DYN.SMAM.FE', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('279', 'CHL', 'SP.DYN.SMAM.FE', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('280', 'CHL', 'SP.DYN.SMAM.FE', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('281', 'CHL', 'SP.DYN.SMAM.FE', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('282', 'CHL', 'SP.DYN.SMAM.FE', '2011', '27.40');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('283', 'CHL', 'SP.DYN.SMAM.FE', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('284', 'CHL', 'SP.DYN.SMAM.FE', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('285', 'CHL', 'SP.DYN.SMAM.FE', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('286', 'CHL', 'SP.DYN.SMAM.FE', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('287', 'CHL', 'SP.DYN.SMAM.MA', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('288', 'CHL', 'SP.DYN.SMAM.MA', '2006', '28.90');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('289', 'CHL', 'SP.DYN.SMAM.MA', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('290', 'CHL', 'SP.DYN.SMAM.MA', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('291', 'CHL', 'SP.DYN.SMAM.MA', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('292', 'CHL', 'SP.DYN.SMAM.MA', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('293', 'CHL', 'SP.DYN.SMAM.MA', '2011', '29.30');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('294', 'CHL', 'SP.DYN.SMAM.MA', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('295', 'CHL', 'SP.DYN.SMAM.MA', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('296', 'CHL', 'SP.DYN.SMAM.MA', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('297', 'CHL', 'SP.DYN.SMAM.MA', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('298', 'CHL', 'SH.MED.CMHW.P3', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('299', 'CHL', 'SH.MED.CMHW.P3', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('300', 'CHL', 'SH.MED.CMHW.P3', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('301', 'CHL', 'SH.MED.CMHW.P3', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('302', 'CHL', 'SH.MED.CMHW.P3', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('303', 'CHL', 'SH.MED.CMHW.P3', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('304', 'CHL', 'SH.MED.CMHW.P3', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('305', 'CHL', 'SH.MED.CMHW.P3', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('306', 'CHL', 'SH.MED.CMHW.P3', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('307', 'CHL', 'SH.MED.CMHW.P3', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('308', 'CHL', 'SH.MED.CMHW.P3', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('309', 'CHL', 'SH.STA.DIAB.ZS', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('310', 'CHL', 'SH.STA.DIAB.ZS', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('311', 'CHL', 'SH.STA.DIAB.ZS', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('312', 'CHL', 'SH.STA.DIAB.ZS', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('313', 'CHL', 'SH.STA.DIAB.ZS', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('314', 'CHL', 'SH.STA.DIAB.ZS', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('315', 'CHL', 'SH.STA.DIAB.ZS', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('316', 'CHL', 'SH.STA.DIAB.ZS', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('317', 'CHL', 'SH.STA.DIAB.ZS', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('318', 'CHL', 'SH.STA.DIAB.ZS', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('319', 'CHL', 'SH.STA.DIAB.ZS', '2015', '10.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('320', 'CHL', 'SH.MED.BEDS.ZS', '2005', '2.30');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('321', 'CHL', 'SH.MED.BEDS.ZS', '2006', '2.30');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('322', 'CHL', 'SH.MED.BEDS.ZS', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('323', 'CHL', 'SH.MED.BEDS.ZS', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('324', 'CHL', 'SH.MED.BEDS.ZS', '2009', '2.10');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('325', 'CHL', 'SH.MED.BEDS.ZS', '2010', '2.10');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('326', 'CHL', 'SH.MED.BEDS.ZS', '2011', '2.10');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('327', 'CHL', 'SH.MED.BEDS.ZS', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('328', 'CHL', 'SH.MED.BEDS.ZS', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('329', 'CHL', 'SH.MED.BEDS.ZS', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('330', 'CHL', 'SH.MED.BEDS.ZS', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('331', 'CHL', 'SH.TBS.INCD', '2005', '17.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('332', 'CHL', 'SH.TBS.INCD', '2006', '17.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('333', 'CHL', 'SH.TBS.INCD', '2007', '17.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('334', 'CHL', 'SH.TBS.INCD', '2008', '17.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('335', 'CHL', 'SH.TBS.INCD', '2009', '16.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('336', 'CHL', 'SH.TBS.INCD', '2010', '16.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('337', 'CHL', 'SH.TBS.INCD', '2011', '16.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('338', 'CHL', 'SH.TBS.INCD', '2012', '16.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('339', 'CHL', 'SH.TBS.INCD', '2013', '16.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('340', 'CHL', 'SH.TBS.INCD', '2014', '16.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('341', 'CHL', 'SH.TBS.INCD', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('342', 'CHL', 'SP.DYN.LE00.IN', '2005', '78.64');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('343', 'CHL', 'SP.DYN.LE00.IN', '2006', '78.98');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('344', 'CHL', 'SP.DYN.LE00.IN', '2007', '79.31');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('345', 'CHL', 'SP.DYN.LE00.IN', '2008', '79.64');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('346', 'CHL', 'SP.DYN.LE00.IN', '2009', '79.96');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('347', 'CHL', 'SP.DYN.LE00.IN', '2010', '80.28');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('348', 'CHL', 'SP.DYN.LE00.IN', '2011', '80.59');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('349', 'CHL', 'SP.DYN.LE00.IN', '2012', '80.89');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('350', 'CHL', 'SP.DYN.LE00.IN', '2013', '81.20');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('351', 'CHL', 'SP.DYN.LE00.IN', '2014', '81.50');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('352', 'CHL', 'SP.DYN.LE00.IN', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('353', 'COL', 'SH.DYN.AIDS', '2005', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('354', 'COL', 'SH.DYN.AIDS', '2006', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('355', 'COL', 'SH.DYN.AIDS', '2007', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('356', 'COL', 'SH.DYN.AIDS', '2008', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('357', 'COL', 'SH.DYN.AIDS', '2009', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('358', 'COL', 'SH.DYN.AIDS', '2010', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('359', 'COL', 'SH.DYN.AIDS', '2011', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('360', 'COL', 'SH.DYN.AIDS', '2012', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('361', 'COL', 'SH.DYN.AIDS', '2013', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('362', 'COL', 'SH.DYN.AIDS', '2014', '120000.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('363', 'COL', 'SH.DYN.AIDS', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('364', 'COL', 'SP.DYN.SMAM.FE', '2005', '23.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('365', 'COL', 'SP.DYN.SMAM.FE', '2006', '23.10');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('366', 'COL', 'SP.DYN.SMAM.FE', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('367', 'COL', 'SP.DYN.SMAM.FE', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('368', 'COL', 'SP.DYN.SMAM.FE', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('369', 'COL', 'SP.DYN.SMAM.FE', '2010', '22.30');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('370', 'COL', 'SP.DYN.SMAM.FE', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('371', 'COL', 'SP.DYN.SMAM.FE', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('372', 'COL', 'SP.DYN.SMAM.FE', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('373', 'COL', 'SP.DYN.SMAM.FE', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('374', 'COL', 'SP.DYN.SMAM.FE', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('375', 'COL', 'SP.DYN.SMAM.MA', '2005', '26.90');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('376', 'COL', 'SP.DYN.SMAM.MA', '2006', '26.50');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('377', 'COL', 'SP.DYN.SMAM.MA', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('378', 'COL', 'SP.DYN.SMAM.MA', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('379', 'COL', 'SP.DYN.SMAM.MA', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('380', 'COL', 'SP.DYN.SMAM.MA', '2010', '26.80');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('381', 'COL', 'SP.DYN.SMAM.MA', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('382', 'COL', 'SP.DYN.SMAM.MA', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('383', 'COL', 'SP.DYN.SMAM.MA', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('384', 'COL', 'SP.DYN.SMAM.MA', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('385', 'COL', 'SP.DYN.SMAM.MA', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('386', 'COL', 'SH.MED.CMHW.P3', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('387', 'COL', 'SH.MED.CMHW.P3', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('388', 'COL', 'SH.MED.CMHW.P3', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('389', 'COL', 'SH.MED.CMHW.P3', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('390', 'COL', 'SH.MED.CMHW.P3', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('391', 'COL', 'SH.MED.CMHW.P3', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('392', 'COL', 'SH.MED.CMHW.P3', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('393', 'COL', 'SH.MED.CMHW.P3', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('394', 'COL', 'SH.MED.CMHW.P3', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('395', 'COL', 'SH.MED.CMHW.P3', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('396', 'COL', 'SH.MED.CMHW.P3', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('397', 'COL', 'SH.STA.DIAB.ZS', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('398', 'COL', 'SH.STA.DIAB.ZS', '2006', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('399', 'COL', 'SH.STA.DIAB.ZS', '2007', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('400', 'COL', 'SH.STA.DIAB.ZS', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('401', 'COL', 'SH.STA.DIAB.ZS', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('402', 'COL', 'SH.STA.DIAB.ZS', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('403', 'COL', 'SH.STA.DIAB.ZS', '2011', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('404', 'COL', 'SH.STA.DIAB.ZS', '2012', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('405', 'COL', 'SH.STA.DIAB.ZS', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('406', 'COL', 'SH.STA.DIAB.ZS', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('407', 'COL', 'SH.STA.DIAB.ZS', '2015', '10.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('408', 'COL', 'SH.MED.BEDS.ZS', '2005', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('409', 'COL', 'SH.MED.BEDS.ZS', '2006', '1.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('410', 'COL', 'SH.MED.BEDS.ZS', '2007', '1.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('411', 'COL', 'SH.MED.BEDS.ZS', '2008', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('412', 'COL', 'SH.MED.BEDS.ZS', '2009', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('413', 'COL', 'SH.MED.BEDS.ZS', '2010', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('414', 'COL', 'SH.MED.BEDS.ZS', '2011', '1.40');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('415', 'COL', 'SH.MED.BEDS.ZS', '2012', '1.50');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('416', 'COL', 'SH.MED.BEDS.ZS', '2013', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('417', 'COL', 'SH.MED.BEDS.ZS', '2014', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('418', 'COL', 'SH.MED.BEDS.ZS', '2015', '0.00');" +
                "INSERT INTO `bancomundial`.`tp_bancoMundial` (`idtp_bancoMundial`, `codigoPais`, `codigoIndicador`, `anio`, `valor`) VALUES ('419', 'COL', 'SH.TBS.INCD', '2005', '38.00');" +
                "";

        return cadena;
    }*/


}
