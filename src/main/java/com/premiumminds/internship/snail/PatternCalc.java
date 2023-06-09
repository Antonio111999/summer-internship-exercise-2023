package com.premiumminds.internship.snail;

import java.util.concurrent.Callable;

public class PatternCalc implements Callable<int[]> {
	
	// Atributos
    private final int[][] matrix;

    // Constructor
    public PatternCalc(int[][] matrix) {
    	super();
        this.matrix = matrix;
    }

    @Override
    public int[] call() throws InterruptedException{
    	
    	System.out.println("Calculating Pattern...");
    	    	
        int n = matrix.length;
        int totalElems = (int) Math.pow(n, 2);
        int[] resultado = new int[totalElems]; // Obrigatoriamente matrix eh quadrada
        
        int indice = 0;
        
        int cima = 0;
        int baixo = n - 1;
        int esquerda = 0;
        int direita = n - 1;

        while (indice < totalElems) { 

            for (int i = esquerda; i <= direita; i++) {
                resultado[indice] = matrix[cima][i];
                indice++;
            }
            cima++;

            for (int i = cima; i <= baixo; i++) {
                resultado[indice] = matrix[i][direita];
                indice++;
            }
            direita--;

            if (cima <= baixo) {
                for (int i = direita; i >= esquerda; i--) {
                    resultado[indice] = matrix[baixo][i];
                    indice++;
                }
                baixo--;
            }

            if (esquerda <= direita) {
                for (int i = baixo; i >= cima; i--) {
                    resultado[indice] = matrix[i][esquerda];
                    indice++;
                }
                esquerda++;
            }
        }
        return resultado;
    }
}