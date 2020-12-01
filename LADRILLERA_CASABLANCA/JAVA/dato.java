
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC-ARROCERAGELVEZ
 */
public class dato {
    
    private int id;
    private double consumo;
    private short año;
    private byte mes;
    byte dia;
    byte hora;
    byte min;

    public int getId() {
        return id;
    }

    public double getConsumo() {
        return consumo;
    }

    public short getAño() {
        return año;
    }

    public byte getMes() {
        return mes;
    }

    public byte getDia() {
        return dia;
    }

    public byte getHora() {
        return hora;
    }

    public byte getMin() {
        return min;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public void setAño(short año) {
        this.año = año;
    }

    public void setMes(byte mes) {
        this.mes = mes;
    }

    public void setDia(byte dia) {
        this.dia = dia;
    }

    public void setHora(byte hora) {
        this.hora = hora;
    }

    public void setMin(byte min) {
        this.min = min;
    }

    
    public double dato(double consumo){
    double dato= getConsumo()-consumo;
    return dato;
    }
}
