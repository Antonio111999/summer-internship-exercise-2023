package com.premiumminds.internship.snail;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * Despite implementing an asynchronous system in the pattern calculation, 
   * the parent function does not perform any additional tasks.
   * 
   * It is assumed that the input matrix is square.
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
	public Future<int[]> getSnailShell(int[][] matrix) {
		
		int n = matrix.length;
		
        if (n == 0) { // Se for matriz vazia
            int[] emptyArray = new int[0];
            System.out.println("Calculating Pattern...");
            return CompletableFuture.completedFuture(emptyArray);
        } else if (n == 1) { // Se for matriz com um elemento
        	int[] singleArray = matrix[0];
            System.out.println("Calculating Pattern...");
            return CompletableFuture.completedFuture(singleArray);
        }

        // Se for matriz com mais do que um elemento
        
        // Thread pool unico
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // Instancia da classe de calculo do snail pattern (Call)
        PatternCalc patternCalc = new PatternCalc(matrix);
        // Tarefa a ser executada assincronamente
        Future<int[]> resultado = executor.submit(patternCalc);

        return resultado;
    }
}