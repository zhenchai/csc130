package project3fa13;

import java.io.File;
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
        SymbolTable symbolData = new SymbolTable(symbolDataFile);
        Portfolio myPortfolio = new Portfolio(symbolData);
        myPortfolio.toString();

    }
}
