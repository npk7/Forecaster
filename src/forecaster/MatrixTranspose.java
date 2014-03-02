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
public class MatrixTranspose {
      
    public static double[][] MatrixTranspose(double A[][]) {

		int i = A.length;
		int j = A[0].length;
		double result[][] = new double[j][i];

		for(int r=0;r<i;r++)
			for(int c=0;c<j;c++)
				result[c][r] = A[r][c];

		return result;

	}
    
}
