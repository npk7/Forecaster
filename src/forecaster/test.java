/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forecaster;

import static forecaster.tools.MatrixTranspose;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author hduser
 */
public class test {
    public static void main(String []args) throws FileNotFoundException, IOException  {
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
       System.out.println(inputmat[12][20]);
       double [][] inputtran = new double[50][30];
       inputtran = MatrixTranspose(inputmat);
       
       System.out.println(inputtran[12][20]);
       
    }
    
}
