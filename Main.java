package com.dan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //variable that controls weather the calculator is running or not
        boolean stat=true;
        //option that will allow user to determine if they want to exit
        int option;
        /*this loop will keep the calculator running a long as the stat variable is true,
        the variable stat can be changed to false that is option 2 */
        while (stat){
            System.out.print("This is a matrix calculator \n"+
                    "to create a new matrix problem enter 1 and to exit the calculator enter 2:");
            option=scanner.nextInt();
            switch (option){
                /*will start the create problem method. The boolean value entered will determine weather
                the calculator will terminate or not
                 */
                case 1:
                    stat=createProblem(option);
                    break;
                case 2:
                    stat=false;
                    break;
                    /*any other value entered apart from 1 and 2 terminates the calculator but with an error
                    ill carry out debugging later
                     */
                default:
                    stat=true;
                    System.out.println("Enter a valid number");
            }
        }
        System.out.println("Calculator terminated. Thank you");
    }
    //This method starts the matrices calculator
    /*it starts the matrices and invokes methods that allow the user to insert values
    for matrices
     */
    public static boolean createProblem(int i){
        Scanner scanner= new Scanner(System.in);

        boolean condition;
        //integer option that will store user numerical input on menu
        int contStat;
        boolean statusC;
        //variables that count number of rows and columns in a matrix
        int firstRows;
        int firstColumns;
        int secondRows;
        int secondColumns;
        //matrix arrays
        int[][]matrix1;
        int[][]matrix2;
        int[][]matrix1Values;
        int[][]matrix2Values;
        //to set the dimension of matrices
        System.out.println("enter number of rows in the first matrix");
        firstRows=scanner.nextInt();
        System.out.println("enter number of columns in the first matrix");
        firstColumns=scanner.nextInt();
        System.out.println("enter number of rows in the second matrix");
        secondRows=scanner.nextInt();
        System.out.println("enter the number of columns in the second matrix");
        secondColumns=scanner.nextInt();
        //creates matrix with the given dimension
        matrix1=createMatrix(firstRows,firstColumns);
        matrix2=createMatrix(secondRows,secondColumns);
        //sets the matrices values
        matrix1Values=setMatrixValues(matrix1,"first");
        matrix2Values=setMatrixValues(matrix2,"second");
        /*variable that allows for user to work with the same matrices so that they don't have to input
        them again.when this variable is false the user is taken to main menu
         */
        int operator;
        statusC=true;
        while (statusC){
            System.out.println("select matrix operation, \n type in 2 for addition, 3 for subtraction or 1 for multiplication:");
            operator=scanner.nextInt();
            statusC=performOperation(operator,matrix1Values,matrix2Values);
    }
         //allow user to go to main menu
        System.out.println("Type 1 if you would like to continue using the calculator, \n type 2 if you would like to exit");
        contStat=scanner.nextInt();
        switch (contStat){
            case 1:
                condition=true;
                break;
            case 2:
                condition=false;
                break;
            default:
                condition=false;
                break;
        }
        return condition;
}
         /*this method will provide users with options to either perform an arithmetic operation or exit*/
         public static boolean performOperation(int operator, int[][]matrix1, int[][]matrix2){
             Scanner scanner=new Scanner(System.in);
             int optSelected;
             boolean status=false;
             switch (operator){
                 case 1:
                     multiplyMatrices(matrix1, matrix2);
                     break;
                 case 2:
                     addMatrices(matrix1,matrix2);
                     break;
                 case 3:
                     subtractMatrices(matrix1,matrix2);
                     break;
                 default:
                     System.out.println("operator not valid");
                     break;
             }
             /*dialogue informing users of options after arithmetic operation is done running. options include
             performing additional operations on the matrices set or exit
              */
             System.out.println("if you would like to perform additional operations on the two matrices used type 1," +
                     "or if you what to use a different pair of matrices to perform operations type 2, to exit type" +
                     "3 ");
             optSelected=scanner.nextInt();
             switch (optSelected){
                 case 1:
                     status=true;
                     break;
                 case 2:
                     status=false;
                     break;
                 case 3:
                     status=false;
                     break;
             }
             return status;

}
             //this method recurse through an array assigning values at each location
            public static int[][]setMatrixValues(int[][]matrix, String label) {
                Scanner scanner = new Scanner(System.in);
                int dataEntered;
                int rows = matrix.length;
                int columns = matrix[0].length;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        System.out.println("Enter value of " + label + "  matrix at row: " + i + " and column:   " + j + " :");
                        dataEntered = scanner.nextInt();
                        matrix[i][j] = dataEntered;
                    }
                }
                return matrix;
            }
            //This method sets the dimensions of a matrix
             public static int[][]createMatrix(int numRows, int numColumns){
             int[][] matrix=new int[numRows][numColumns];
             return matrix;
    }
    //all methods below this line perform operations
    public static void multiplyMatrices(int[][]matrix1, int[][]matrix2) {
        boolean status = checkIfValidMult(matrix1, matrix2);
        if (status == true) {
            for (int i = 0; i < matrix1.length; i++) {
                int total = 0;
                for (int j = 0; j < matrix2[0].length; j++) {
                    int fNum = matrix1[i][j];
                    int sNum = matrix2[j][i];
                    int product = fNum * sNum;
                    total += product;
                }
                System.out.println(total + "");
            }
        }
                 else{
                System.out.println("Invalid Input");
            }
    }

     public static void addMatrices(int[][]matrix1, int[][]matrix2){
             boolean status= checkIfValidAddSub(matrix1, matrix2);
             if(status==true) {
                 for (int i = 0; i < matrix1.length; i++) {
                     for (int j = 0; j < matrix1[0].length; j++) {
                         int charM1 = matrix1[i][j];
                         int charM2 = matrix2[i][j];
                         int resultant = charM1 + charM2;
                         System.out.println(resultant + "");
                     }
                     System.out.println("\n");
                 }
             }
                 else{
                     System.out.println("In order to add or subtract matrices they both must be of the same order");
                 }
    }
    public static void subtractMatrices(int[][]matrix1, int[][]matrix2){
             boolean status=checkIfValidAddSub(matrix1, matrix2);
             if (status==true){
                 for(int i=0; i<matrix1.length; i++){
                     for (int j=0; j<matrix1[0].length; j++){
                         int charM1= matrix1[i][j];
                         int charM2= matrix2[i][j];
                         int resultant= charM1-charM2;
                         System.out.println(resultant+ "");
                     }
                     System.out.println("\n");
                 }
             }
             else {
                 System.out.println("In order to add or subtract matrices they both must be of the same order");
             }
    }
    //The two methods below will check if the operations can be performed on the matrices
    public static boolean checkIfValidMult(int[][]matrix1, int[][]matrix2){
             boolean status;
             int columns=matrix1[0].length;
             int rows=matrix2.length;
             if(columns==rows){
                 status=true;
             }
             else {
                 status=false;
             }
             return status;
    }
    public static boolean checkIfValidAddSub(int[][]matrix1, int[][]matrix2){
             boolean status;
             int numRows1=matrix1.length;
             int numColumns1=matrix1[0].length;
             int numRows2=matrix2.length;
             int numColumns2=matrix2[0].length;
             if(numRows1==numRows2 && numColumns1==numColumns2){
                 status=true;
             }
             else{
                 status=false;
             }
             return status;
    }
}