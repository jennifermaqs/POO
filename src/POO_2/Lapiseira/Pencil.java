package POO_2.Lapiseira;

import java.util.ArrayList;
import java.util.List;


public class Pencil {
    private float thickness;
    private Lead tip;
    private List<Lead> barrel;

    public Pencil(float thickness) {
        this.thickness = thickness;
        this.tip = null;
        this.barrel = new ArrayList<>();
    }

    public float getThickness() {
        return this.thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public boolean hasGrafite() {
        return this.tip != null;
    }

    public boolean insert(Lead grafite) {
        if (this.hasGrafite()) {
            IO.println("fail: ja existe grafite no bico");
            return false;
        }

        if (grafite.getThickness() != this.thickness) {
            IO.println("fail: calibre incompatível");
            return false;
        }

        this.barrel.add(grafite);
        return true;
    }

    public Lead remove() {
        Lead temp = this.tip;
        this.tip = null;
        return temp;
    }
    
    public boolean pull() {
        if(tip != null) {
            IO.println("fail: ja existe grafite no bico");
            return false;
        } if (barrel.isEmpty()) {
            IO.println("fail: nao existe grafite no tambor");
            return false;
        }
        tip = barrel.remove(0);
        return true;
    }

    public void writePage() {
        if (this.tip == null) {
            IO.println("fail: nao existe grafite no bico");
            return;
        }   

        int usage = this.tip.usagePerSheet();
        int size = this.tip.getSize();

       
        if(size <= 10) {
            IO.println("fail: tamanho insuficiente");
            return;
        } 
        if(size - usage < 10) {
            this.tip.setSize(10);
            IO.println("fail: folha incompleta");
            return;
        }
        
        this.tip.setSize(size - usage);
        // IO.println("pagina escrita");
    }
    
    @Override
    public String toString() {
    String tipStr;
    if(this.tip == null) {
        tipStr = "[]";
    } else {
        tipStr = "[" + this.tip.toString() + "]";
    }
    
    String barrelStr = "";
    for (Lead grafite : this.barrel) {
        barrelStr += "[" + grafite.toString() + "]";
    }
        return "calibre: " + this.thickness + ", bico: " + tipStr + ", tambor: {" + barrelStr + "}";
    }
}

