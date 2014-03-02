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
public class MatrixInversion {
    public static double[][] MatrixInversion(double A[][])
	  {
	    int n = A.length;
	    int row[] = new int[n];
	    int col[] = new int[n];
	    double temp[] = new double[n];
	    int hold , I_pivot , J_pivot;
	    double pivot, abs_pivot;

	    // set up row and column interchange vectors
	    for(int k=0; k<n; k++)
	    {
	      row[k] = k ;
	      col[k] = k ;
	    }
	    // begin main reduction loop
	    for(int k=0; k<n; k++)
	    {
	      // find largest element for pivot
	      pivot = A[row[k]][col[k]] ;
	      I_pivot = k;
	      J_pivot = k;
	      for(int i=k; i<n; i++)
	      {
	        for(int j=k; j<n; j++)
	        {
	          abs_pivot = Math.abs(pivot) ;
	          if(Math.abs(A[row[i]][col[j]]) > abs_pivot)
	          {
	            I_pivot = i ;
	            J_pivot = j ;
	            pivot = A[row[i]][col[j]] ;
	          }
	        }
	      }
	      if(Math.abs(pivot) < 1.0E-10)
	      {
	        System.out.println("Matrix is singular");
	      }
	      hold = row[k];
	      row[k]= row[I_pivot];
	      row[I_pivot] = hold ;
	      hold = col[k];
	      col[k]= col[J_pivot];
	      col[J_pivot] = hold ;
	       // reduce about pivot
	      A[row[k]][col[k]] = 1.0 / pivot ;
	      for(int j=0; j<n; j++)
	      {
	        if(j != k)
	        {
	          A[row[k]][col[j]] = A[row[k]][col[j]] * A[row[k]][col[k]];
	        }
	      }
	      // inner reduction loop
	      for(int i=0; i<n; i++)
	      {
	        if(k != i)
	        {
	          for(int j=0; j<n; j++)
	          {
	            if( k != j )
	            {
	              A[row[i]][col[j]] = A[row[i]][col[j]] - A[row[i]][col[k]] *
	                                   A[row[k]][col[j]] ;
	            }
	          }
	          A[row[i]][col [k]] = - A[row[i]][col[k]] * A[row[k]][col[k]] ;
	        }
	      }
	    }
	    // end main reduction loop

	    // unscramble rows
	    for(int j=0; j<n; j++)
	    {
	      for(int i=0; i<n; i++)
	      {
	        temp[col[i]] = A[row[i]][j];
	      }
	      for(int i=0; i<n; i++)
	      {
	        A[i][j] = temp[i] ;
	      }
	    }
	    // unscramble columns
	    for(int i=0; i<n; i++)
	    {
	      for(int j=0; j<n; j++)
	      {
	        temp[row[j]] = A[i][col[j]] ;
	      }
	      for(int j=0; j<n; j++)
	      {
	        A[i][j] = temp[j] ;
	      }
	    }
	    return A;
  }
    
}
