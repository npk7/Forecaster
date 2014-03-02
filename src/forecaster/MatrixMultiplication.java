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
public class MatrixMultiplication {
    	public static double[][] MatrixMultiplication(double x[][],double y[][]){

		if(x.length == 0)
			return new double[0][0];

		if(x[0].length != y.length)
			return null;

		int i = x[0].length;
		int j = x.length;
		int k = y[0].length;

		double result[][] = new double[j][k];

		for(int a=0;a<j;a++)
			for(int b=0;b<k;b++)
				for(int c=0;c<i;c++)
					result[a][b] += x[a][c] * y[c][b];


		return result;

	}
    
}
