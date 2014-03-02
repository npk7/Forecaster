/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forecaster;

/**
 *
 * @author Pavan Kumar Narayanan, 2013
 */
public class MatrixVectorMultiplication {
    public static double[] MatrixVectorMultiplication(double A[][],double x[]){

		int i = A.length;
		int j = A[0].length;

		double result[] = new double[j];

		for(int a=0;a<i;a++)
			for(int b=0;b<j;b++)
				result[a] += A[a][b] * x[b];

		return result;

	}
    
}
