/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebasAlineamiento;

import Logica.AlgoritmoNeedlemanWunsch;

/**
 *
 * @author ana
 */
public class pruebas {
    public static void main(String[] args) {
        AlgoritmoNeedlemanWunsch needleman = new AlgoritmoNeedlemanWunsch();
        char[] seqA1 = {'C', 'G', 'T', 'C', 'T', 'T'};
        char[] seqB2 = {'A', 'C', 'C', 'G', 'T', 'C', 'T', 'T'};
        needleman.inicializacion(seqA1, seqB2);
        
        //needleman.MostrarMatrizF();
        needleman.MostrarMatrizS();
        needleman.crearMatrizF();
        needleman.MostrarMatrizF();
        needleman.alineamiento();
    }
    
}
