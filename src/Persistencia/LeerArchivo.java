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
    
    public String leerDatos(String archivo) throws IOException{
        ArchivoLee=new FileReader(archivo);
        BufferArchivo = new BufferedReader(ArchivoLee);
        String datos=" ";
        String linea = this.BufferArchivo.readLine();
        while (linea != null) {
            datos+=linea+"\n";
            linea = BufferArchivo.readLine();
            }
        return datos;
    }
    
    
    
}
