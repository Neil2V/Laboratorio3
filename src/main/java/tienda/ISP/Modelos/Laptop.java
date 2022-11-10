
package tienda.ISP.Modelos;

import org.bson.types.ObjectId;
import tienda.models.Producto;

public class Laptop extends Producto{
    
    private String serie;
    private double peso;
    private int a�o;


    
    public Laptop(String marca, double peso, int a�o) {
        this.serie = marca;
        this.peso = peso;
        this.a�o = a�o;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
 
    
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }


    public int getA�o() {
        return a�o;
    }

    public void setA�o(int a�o) {
        this.a�o = a�o;
    }

    @Override
    public String toString() {
        return "Laptop{" + "serie=" + serie + ", peso=" + peso + ", a�o lanzamiento=" + a�o + '}';
    }
    
    
    
}
