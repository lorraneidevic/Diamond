import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
//    Given a number n, print a centered diamond. Example for n=3:
//
//            *
//           ***
//          *****
//           ***
//            *
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please type the number (integer) of lines of the diamond:");
        int numberOfLines = scanner.nextInt();
        int numberOfRows = (numberOfLines * 2) - 1;
        int numberOfCols = numberOfRows;
        int middleCol = numberOfLines;

        int colIndex = 0; //control the current index that needs to add the asterisk
        Integer [] colsWithAsterisks = new Integer[numberOfCols]; //incrementally add the columns that will have the asterisks

        colsWithAsterisks[colIndex] = middleCol; //the first column that needs a asteristik is the middle column

        for(int i = 1; i <= numberOfRows; i++) {
            for (int j = 1; j <= colsWithAsterisks.length; j++) {
                if(contains(colsWithAsterisks, j)){ //for each row, verify if there is an column that needs to print the asterisk
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            if(colIndex + 2 <= colsWithAsterisks.length && i <= numberOfLines) { //increment 2 cause each row must have 2+ asterisks than the row above, each besides each side of the centered asterisk
                colIndex = colIndex + 2;
                colsWithAsterisks[colIndex - 1] = middleCol - i;
                colsWithAsterisks[colIndex] = middleCol + i;
            } else if(colIndex - 1 >= 0) {
                colsWithAsterisks[colIndex - 1] = 0;
                colsWithAsterisks[colIndex] = 0;
                colIndex = colIndex - 2;
            }

            System.out.println("\n");
        }
    }

    public static boolean contains(Integer[] arrayOfCols, Integer value) {
        List<Integer> list = Arrays.asList(arrayOfCols);
        return list.contains(value);
    }
}
