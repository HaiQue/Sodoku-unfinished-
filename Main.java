import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
//import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        int rows = 9;
        int columns = 9;
        int [][] myArray = new int[rows][columns];

        readboard(rows, columns, myArray);
        game(rows, columns, myArray);


        //System.out.println(myArray[0][2]);

    }

    public static void readboard(int rows, int columns, int[][] myArray){
        try{
            int sk = 0;
            Scanner sc = new Scanner(new BufferedReader(new FileReader("G:\\Intellij projektukai\\Sudoku\\src\\file.txt")));
            System.out.println("    0 1 2  3 4 5  6 7 8" + "\n");
            while(sc.hasNextLine()) {
                for (int i = 0; i < myArray.length; i++) {
                    System.out.print(sk + " - ");
                    sk++;
                    if(i == 3 || i == 6) System.out.println(); // tarpai tarp 3 x 3 cubu i apacia
                    String[] line = sc.nextLine().trim().split(" ");
                    for (int j = 0; j < line.length; j++) {
                        if(j == 3 || j == 6 || j == 9) System.out.print(" "); // tarpai tarp 3 x 3 cubu i sona
                        myArray[i][j] = Integer.parseInt(line[j]);
                        System.out.print(myArray[i][j] + " ");
                    }
                    System.out.println();
                }
                //System.out.println(Arrays.deepToString(myArray));
            }
        }

        catch (Exception e)
        {
            System.out.println("Problem reading");
        }

    }

    public static void board(int rows, int columns, int[][] myArray)
    {
        System.out.println("\n");
        for(int i = 0; i < 9; i++)
        {
            if(i == 3 || i == 6) System.out.println();
            for(int j = 0; j < 9; j++)
            {
                if(j == 3 || j == 6) System.out.print(" ");
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void game (int rows, int columns, int [][] myArray) {
        Scanner input = new Scanner(System.in);
        int i, j, skaicius;
        i = input.nextInt();
        j = input.nextInt();
        if(myArray[i][j] == 0) { //jeigu tinkamoje vietoje pasirinkta ir ne uz ribu lentos  && myArray[ii][jj] < 10 && myArray[ii][jj] > 0
             skaicius = input.nextInt();
             if(skaicius > 0 && skaicius < 10){
                 myArray[i][j] = skaicius;
                 board(rows, columns, myArray);
             }

        }

        else {
            System.out.println("Uzimta vieta arba uz lentos ribu");
        }
        //System.out.println(ANSI_GREEN_BACKGROUND + "This text has a green background but default text!" + ANSI_RESET);



        // padaryti default
    }



}


//private static Scanner x;

    /*
    public static void main(String[] args) {
        //String username = "Bob69";
       // String password = "123";
        int rows = 9, elemets = 9;
        int [][]Arr = new int[rows][elemets];

        //String filepath = "G:\\Intellij projektukai\\Sudoku\\src\\file.txt";
        //verifyLogin (username,password,filepath);

        //Scanner  scanner = new Scanner(new File("File.txt"));
        //int[] data = readFiles()

    }

    /*
    public static void board (int rows, int elements, int[][] Arr)
    {
        try{
            Scanner  scanner = new Scanner(new File("G:\\Intellij projektukai\\Sudoku\\src\\file.txt"));

            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < elements; j++)
                {
                    Arr[i][j] = scanner.next.Int();
                }
            }
        }

        catch (Exception e)
        {
            System.out.println("Error");
        }



    }

     */


    /*
        public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("G:\\Intellij projektukai\\Sudoku\\src\\file.txt")));
        int rows = 9;
        int columns = 9;
        int [][] myArray = new int[rows][columns];
        while(sc.hasNextLine()) {
            for (int i = 0; i < myArray.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    myArray[i][j] = Integer.parseInt(line[j]);
                    System.out.print(myArray[i][j] + " ");

                }
                System.out.println();
            }
            //System.out.println(Arrays.deepToString(myArray));

        }

    }
     */
