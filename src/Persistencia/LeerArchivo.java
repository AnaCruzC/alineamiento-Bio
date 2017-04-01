/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Leonardo
 */
public class LeerArchivo {
    protected BufferedReader BufferArchivo ;
    protected FileReader ArchivoLee;
    protected FileWriter ArchivoEsc;
    protected PrintWriter Salida;
    
    String Descripcion1;
    String Descripcion2;
    String Cadena1;
    String Cadena2;

    public String getDescripcion1() {
        return Descripcion1;
    }

    public void setDescripcion1(String Descripcion1) {
        this.Descripcion1 = Descripcion1;
    }

    public String getDescripcion2() {
        return Descripcion2;
    }

    public void setDescripcion2(String Descripcion2) {
        this.Descripcion2 = Descripcion2;
    }

    public String getCadena1() {
        return Cadena1;
    }

    public void setCadena1(String Cadena1) {
        this.Cadena1 = Cadena1;
    }

    public String getCadena2() {
        return Cadena2;
    }

    public void setCadena2(String Cadena2) {
        this.Cadena2 = Cadena2;
    }
    
    
    
    public String leerDatos(String archivo) throws IOException{
        ArchivoLee=new FileReader(archivo);
        BufferArchivo = new BufferedReader(ArchivoLee);
        String Contenido="";
        String datos="";
        int count=0;
        String linea = this.BufferArchivo.readLine();
        while (linea != null) {
            Contenido+=linea+"\n";
            String encabezado = linea.substring(0, 1);
            if (encabezado.equals(">")){
                    count+=1;
                    if (count == 1){
                        this.setDescripcion1(linea);
                    }
                    else {
                        this.setDescripcion2(linea);
                        datos = "";
                    }
                }
            else{
                //datos+=linea+"\n";
                datos+=linea;
                if (count == 1){
                    this.setCadena1(datos);
                }
                else{
                    this.setCadena2(datos);
                }
            }
            linea = BufferArchivo.readLine();
         }
        return Contenido;
    }
    
    
    
}
