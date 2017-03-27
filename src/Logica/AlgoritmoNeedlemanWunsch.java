/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author ana
 */
public class AlgoritmoNeedlemanWunsch {

    private int[][] matrizS = {{10, -1, -3, -4}, {-1, 7, -5, -3}, {-3, -5, 9, 0}, {-4, -3, 0, 8}};
    int A = 1, G = 2, C = 3, T = 4;
    private int gap = -5;
    private int[][] matrizF;
    private char[] secuenciaA;
    private char[] secuenciaB;
    private int[] secA;
    private int[] secB;

    public char[] getSecuenciaA() {
        return secuenciaA;
    }

    public void setSecuenciaA(char[] secuenciaA) {
        this.secuenciaA = secuenciaA;
    }

    public char[] getSecuenciaB() {
        return secuenciaB;
    }

    public void setSecuenciaB(char[] secuenciaB) {
        this.secuenciaB = secuenciaB;
    }

    public int[] getSecA() {
        return secA;
    }

    public void setSecA(int[] secA) {
        this.secA = secA;
    }

    public int[] getSecB() {
        return secB;
    }

    public void setSecB(int[] secB) {
        this.secB = secB;
    }
    private int n;
    private int m;

    public int[][] getMatrizS() {
        return matrizS;
    }

    public void setMatrizS(int[][] matrizS) {
        this.matrizS = matrizS;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public int[][] getMatrizF() {
        return matrizF;
    }

    public void setMatrizF(int[][] matrizF) {
        this.matrizF = matrizF;
    }

    public char[] getSeqA() {
        return secuenciaA;
    }

    public void setSeqA(char[] seqA) {
        this.secuenciaA = seqA;
    }

    public char[] getSeqB() {
        return secuenciaB;
    }

    public void setSeqB(char[] seqB) {
        this.secuenciaB = seqB;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void inicializacion(char[] cadena1, char[] cadena2) {
        
        secuenciaA = cadena1;
        secuenciaB = cadena2;
        secA = convertirSecuencia(secuenciaA);
        secB = convertirSecuencia(secuenciaB);
        m = secuenciaA.length + 1;
        n = secuenciaB.length + 1;
        
        int matriz[][] = new int[m][n];
        matrizF = matriz;
        System.out.println("columnas " + n);
        System.out.println("filas " + m);

        System.out.println("matrizF.length " + matrizF.length);
    }

    public void crearMatrizF() {
        for (int i = 0; i < n; i++) {
            matrizF[0][i] = i * gap;
        }

        for (int i = 0; i < m; i++) {
            matrizF[i][0] = i * gap;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //System.out.println("i"+i+" "+seqB[i - 1]);
                //System.out.println("j"+j+" "+seqA[j - 1]);
                //int scoreDiagonal = matrizF[i - 1][j - 1] 
                //int scoreDiagonal = matrizF[i - 1][j - 1] + calcularS(secuenciaB[i - 1], secuenciaA[j - 1]);
                int scoreDiagonal = matrizF[i - 1][j - 1] + calcularS(secA[i - 1], secB[j - 1]);
                int scoreIzquierda = matrizF[i - 1][j] + gap;
                int scoreArriba = matrizF[i][j - 1] + gap;
                //System.out.println("scoreDiagonal =");
                matrizF[i][j] = Math.max(Math.max(scoreDiagonal, scoreIzquierda), scoreArriba);
            }
        }

    }

    public void MostrarMatrizS() {
        for (int i = 0; i < matrizS.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrizS[i].length; j++) {
                System.out.print(matrizS[i][j]);
                if (j != matrizS[i].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }

    }

    public void MostrarMatrizF() {
        System.out.println("Mostrar matris" + m);
        for (int i = 0; i < m; i++) {
            System.out.print("|");
            for (int j = 0; j < n; j++) {
                System.out.print(matrizF[i][j]);
                if (j != n - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }

    }

    public int caracterS(char caracter) {
        int posi = 0;
        if (caracter == 'A') {
            posi = A;
        } else {
            if (caracter == 'G') {
                posi = G;
            } else {
                if (caracter == 'C') {
                    posi = C;
                } else {
                    if (caracter == 'T') {
                        posi = T;
                    }
                }
            }
        }
        return posi;
    }

    public int calcularS(int pos1, int pos2) {
        int valorPosicion = matrizS[pos1 - 1][pos2 - 1];
        //System.out.println("i " + i + " j " + j + " valorPosicion " + valorPosicion);
        return valorPosicion;
    }

    /*
    public int calcularS(char caracter1, char caracter2) {
        int i = caracterS(caracter1) - 1;
        int j = caracterS(caracter2) - 1;
        int valorPosicion = matrizS[i][j];
        //System.out.println("i " + i + " j " + j + " valorPosicion " + valorPosicion);
        return valorPosicion;
    }
     */
    //arreglar
    public int[] convertirSecuencia(char[] secuencia) {
        int[] secuenciaValor = new int[secuencia.length];
        for (int i = 0; i < secuencia.length; i++) {
            secuenciaValor[i] = caracterS(secuencia[i]);
        }
        return secuenciaValor;
    }

    public void alineamiento() {
        int i = secA.length;
        System.out.println("i-->"+i);
        int j = secB.length;
        System.out.println("j-->"+j);
        int score =0,scoreDiag=0,scoreUp=0,scoreLeft=0;
        String AlignmentA = "";
        String AlignmentB = "";
        while (i > 0 && j > 0){
   {
       score = matrizF[i][j];
       scoreDiag = matrizF[i-1][j-1]; 
       scoreUp = matrizF[i][j - 1];
       scoreLeft = matrizF[i-1][j];
       if(score == scoreLeft + gap){
           AlignmentA = secuenciaA[i-1] + AlignmentA;
           AlignmentB = "-" + AlignmentB;
           i = i - 1;
       } 
       else{
           if(score == scoreUp+gap){
               AlignmentA = "-" + AlignmentA;
               AlignmentB = secuenciaB[j-1] + AlignmentB;
               j = j - 1;
           }else{
               if(score==scoreDiag+calcularS(secA[i-1], secB[j-1])){
                   AlignmentA = secuenciaA[i-1] + AlignmentA;
                   AlignmentB = secuenciaB[j-1] + AlignmentB;
                   i = i - 1;
                   j = j - 1;
               }
           }
       }
            
   }}    
               
               
       while (i > 0) {
           AlignmentA = secuenciaA[i-1] + AlignmentA;
           AlignmentB = "-" + AlignmentB;
           i = i - 1;
        }
        while (j > 0) {
            AlignmentA = "-" + AlignmentA;
            AlignmentB = secuenciaB[j-1] + AlignmentB;
            j = j - 1;
        }
        
       
       System.out.println(AlignmentA + "\n");
        System.out.println(AlignmentB + "\n");
       
   }   //matrizF[i - 1][j - 1] + calcularS(secB[i - 1], secA[j - 1])
       
}
