package Dao;

/**
 * Created by PC on 2/05/2017.
 */
public class Resultado
{
     int valor;
     String año;

    public Resultado()
    {

    }
    public Resultado(int valor,String año)
    {
        this.setValor(valor);
        this.setAño(año);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
}
