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

        readboard(myArray);
        game(myArray);

        //System.out.println(myArray[0][2]);

        // pirma eilutes rules
        // pop up su sudoku taisyklem
        // sukurti delete funkcija +
        // sukurti cubu tikrinimo funkcija
        // sukurti eiliu tikrinimo funkcija i sonus ir apacia
        // level selection

    }

    private static void readboard( int[][] myArray)
    {
        try{
            int sk = 0;
            Scanner sc = new Scanner(new BufferedReader(new FileReader("G:\\Intellij projektukai\\Sudoku\\src\\board.txt")));
            System.out.println("Board: " + "\n");
            System.out.println("    0 1 2  3 4 5  6 7 8" + "\n");
            while(sc.hasNextLine()) {
                for (int i = 0; i < myArray.length; i++) {
                    if(i == 3 || i == 6) System.out.println(); // tarpai tarp 3 x 3 cubu i apacia
                    System.out.print(sk + "   ");
                    sk++;
                    String[] line = sc.nextLine().trim().split(" ");
                    for (int j = 0; j < line.length; j++) {
                        if(j == 3 || j == 6) System.out.print(" "); // tarpai tarp 3 x 3 cubu i sona
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

    private static void board(int[][] myArray)
    {
        int sk = 0;
        System.out.println("\n");
        System.out.println("Board: " + "\n");
        System.out.println("    0 1 2  3 4 5  6 7 8" + "\n");
        for(int i = 0; i < 9; i++)
        {
            if(i == 3 || i == 6) System.out.println(); // tarpai tarp 3 x 3 cubu i apacia
            System.out.print(sk + "   ");
            sk++;
            for(int j = 0; j < 9; j++)
            {
                if(j == 3 || j == 6) System.out.print(" "); // tarpai tarp 3 x 3 cubu i sona
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void game (int [][] myArray)
    {
        Scanner input = new Scanner(System.in);
        int kiekis = 0;
        while(kiekis < 81)
        {
            int i, j, skaicius;
            i = input.nextInt();
            j = input.nextInt();

            if(i == 10 && j == 10){ // komanda ivedus isiveda istrynimo funkcija
                System.out.println("Iveskite kuri skaiciu norite istrinti");
                i = input.nextInt(); // ivesti ka norim istrinti
                j = input.nextInt();
                myArray[i][j] = 0;
                System.out.println("Sekmingai istrintas skaicius");
                board(myArray);
                System.out.println("Toliau tesiamas zaidimas, iveskite kur norite ivesti skaiciu");
                i = input.nextInt(); // is naujo vedimas toliau zaidimo
                j = input.nextInt();
            }
            if(myArray[i][j] == 0) { //jeigu tinkamoje vietoje pasirinkta
                skaicius = input.nextInt();
                if(skaicius > 0 && skaicius < 10){ // jei ne uz lentos ribu
                    myArray[i][j] = skaicius;
                    board(myArray);
                }

            }

            else {
                System.out.println("Uzimta vieta arba uz lentos ribu");
            }

            kiekis = 0;
            for(int a = 0; a < 9; a++)
            {
                for(int b = 0; b < 9; b++)
                {
                    if(myArray[a][b] != 0) kiekis++;
                }

            }
                if(kiekis == 81) // 9 x 9 jeigu viskas uzpildyta tai pasibaige zaidimas (taisykles bus kur patikrina ar viskas tinka)
                {
                    System.out.println("Laimejote zaidima"); //check kiekviena eilute ir kuba ar atitinka
                }
            }
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

