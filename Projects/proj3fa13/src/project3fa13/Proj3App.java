package project3fa13;

import java.io.File;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Marvin
 * Date: 11/16/13
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Proj3App
{
    public static void main(String args[]) throws Exception
    {
        File symbolDataFile = new File("symboldata.txt");
        File stockDataFile = new File("tempdata.txt");
        SymbolTable symbolData = new SymbolTable(symbolDataFile);

        Portfolio myPortfolio = new Portfolio(symbolData);
        Scanner fileScan = new Scanner(stockDataFile);
        String[] splitLine;
        while (fileScan.hasNextLine())
        {
            splitLine = fileScan.nextLine().split(" ", 4);
            myPortfolio.processTransaction(
                    splitLine[0].charAt(0),
                    Integer.parseInt(splitLine[1]),
                    Double.parseDouble(splitLine[2]),
                    splitLine[3]
            );
        }
    }
}
