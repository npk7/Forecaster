/*
 * This java program executes the normal equations solutions procedure for our supervised learning algorithm model.
   It has predefined methods for all the low level calculations involved in solving the model.

   Receives input from an external csv file and extracts the required matrix and vectors.
   Utilizes the user written methods to solve the optimization problem to minimize the residual sum of squares.

 */

package forecaster;

import static forecaster.MatrixInversion.MatrixInversion;
import static forecaster.MatrixMultiplication.MatrixMultiplication;
import static forecaster.MatrixTranspose.MatrixTranspose;
import static forecaster.MatrixVectorMultiplication.MatrixVectorMultiplication;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.util.Collections.list;
import java.util.StringTokenizer;


/**
 *
 * @author Pavan Kumar Narayanan, 2013
 */
public class Forecaster {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
       
       BufferedReader csvread = null;
       
        
       double [][] inputmat = new double[50][30];
       File inputfile = new File("/home/hduser/data.csv");
       int i=0,j=0;
       csvread = new BufferedReader(new FileReader(inputfile));
       String nextline = null;
       
       while((nextline = csvread.readLine()) != null){
           StringTokenizer str = new StringTokenizer(nextline,",");
           while(str.hasMoreTokens()) {
               inputmat[i][j] = Double.parseDouble(str.nextToken());
               j++;
           }
           i++;
           j=0;
           
       }
       System.out.println(inputmat[49][29]);
       
       
       
       //double [][] a = new double[50][30];
       String [] para = {"SIM","Business Features","Call Features","Operating System","Java","Resolution","Color",
						"FrontCam","Video","HD","Zoom","Camera Features","Weight","Memory","Bluetooth","Battery"};

       double [][] X = new double[inputmat.length][inputmat[0].length-1];
       double [] y = new double[inputmat.length];
       

       //EXTRACT THE REQUIRED MATRIX AND VECTOR
		for(i=0;i<inputmat.length;i++)
			for(j=0;j<inputmat[0].length-1;j++)
				X[i][j] = inputmat[i][j];

		for(i=0,j=17;i<inputmat.length;i++)
			y[i] = inputmat[i][j];

		//NORMAL EQUATION SOLUTION PROCEDURE STARTS
		double [][]tran = MatrixTranspose(X);
		double [][]neqn1 = MatrixMultiplication(tran, X);
		double [][]inv = MatrixInversion(neqn1);
		double []neqn2 = MatrixVectorMultiplication(tran, y);
		double []neqn = MatrixVectorMultiplication(inv,neqn2);

		System.out.println("\n\n\t+++MOBILE PHONE PRICING TOOL BASED ON SUPERVISED LEARNING+++");
		System.out.println("\t-----------------------------------------------------------");
                //System.out.println("\n\t    WARNING: MAY NOT RUN WITH A SINGULAR MATRIX");
		System.out.println("\n\n\tThe parameters for the required cost equation is: \n\t");

		for(i=0;i<16;i++) {
			System.out.println("\tWeights for "+para[i]+" is   "+neqn[i]);
		}
    }
    
}

