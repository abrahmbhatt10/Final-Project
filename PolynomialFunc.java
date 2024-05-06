/*
Name: Agastya-Brahmbhatt
Date: 4/27/2024
CS2 Final Project: Graphs
Polynomial function is a child class of the math function class.
It allows for custom user input polynomials to be processed.
 */

import java.util.ArrayList;
import java.util.regex.*;
public class PolynomialFunc extends MathFunction{
    ArrayList<Integer> pCoefficients;
    ArrayList<Integer> pPower;
    ArrayList<Integer> dCoefficients;
    ArrayList<Integer> dPower;

    public PolynomialFunc(String fStr, FrontEnd window)
    {
        super.setWindow(window);
        pCoefficients = new ArrayList<Integer>();
        pPower = new ArrayList<Integer>();
        dCoefficients = new ArrayList<Integer>();
        dPower = new ArrayList<Integer>();
        parsePolynomial(fStr);
        parseDerivative();
    }

    /*
    To write the polynomial parser equation, I used code from this website:
    https://www.w3schools.com/java/java_regex.asp
    */

    public void parsePolynomial(String fStr)
    {
        String pHeader = "polynomial ";
        String pFuncStr = fStr;
        String pStart = "";
        // Match substrings of format [plus or minus sign] [num digits] x [carrot sign] [plus or minus sign] [num digits] space
        Pattern pStr = Pattern.compile("^([+-]*)([0-9]+)[x][\\^]*([+-]*)([0-9]*)");
        if(pFuncStr.isEmpty())
        {
            erasePolynomial();
            return;
        }
        System.out.println("Poly Constructor "+pFuncStr);
        if(pFuncStr.length() <= pHeader.length())
        {
            erasePolynomial();
            return;
        }
        if(pFuncStr.substring(0,pHeader.length()).equals(pHeader)) {
            pStart = pFuncStr.substring(pHeader.length());
            System.out.println("Stripped polynomial " + pStart);
            String[] arrOfStr = pStart.split(" ");
            int numMultiplier = 1;
            int numIndex = 0;
            for(int i = 0; i < arrOfStr.length; i++) {
                System.out.println("Poly substring " + arrOfStr[i]);
                Matcher mStr = pStr.matcher(arrOfStr[i]);
                if (!mStr.find()) {
                    // This is the last constant without x
                    numMultiplier = 1;
                    numIndex = 0;
                    if (arrOfStr[i].length() > 0 && arrOfStr[i].charAt(0) == '+') {
                        numMultiplier = 1;
                        numIndex++;
                    }
                    if (arrOfStr[i].length() > 0 && arrOfStr[i].charAt(0) == '-') {
                        numMultiplier = -1;
                        numIndex++;
                    }
                    if (arrOfStr[i].length() > numIndex && Character.isDigit(arrOfStr[i].charAt(numIndex))) {
                        int akInt = numMultiplier * Integer.parseInt(arrOfStr[i].substring(numIndex));
                        if (akInt == 0) {
                            // handle bad string
                            erasePolynomial();
                            return;
                        }
                        if (pPower.size() < pCoefficients.size()) {
                            pPower.add(0);
                        }
                        pCoefficients.add(akInt);
                    } else {
                        erasePolynomial();
                        return;
                    }
                } else {
                    // This is matched string of type [+-]ax^[+-]b
                    for (int j = 1; j < mStr.groupCount() + 1; j++) {
                        if (!mStr.group(j).isEmpty())
                            System.out.println("Group " + j + " " + mStr.group(j));
                    }
                    // Parse optional preceding plus or minus sign
                    numMultiplier = 1;
                    if (!mStr.group(1).isEmpty()) {
                        if (mStr.group(1).equals("-"))
                            numMultiplier = -1;
                    }
                    // Parse for coefficient
                    if (mStr.group(2).isEmpty()) {
                        pCoefficients.add(1 * numMultiplier);
                    } else {
                        if (Character.isDigit(mStr.group(2).charAt(0)))
                            pCoefficients.add(numMultiplier * Integer.parseInt(mStr.group(2)));
                    }
                    // Parse for optional plus or minus sign for the power
                    numMultiplier = 1;
                    if (!mStr.group(3).isEmpty()) {
                        if (mStr.group(3).equals("-")) {
                            numMultiplier = -1;
                        }
                    }
                    // Parse for the power
                    if (!mStr.group(4).isEmpty()) {
                        if (Character.isDigit(mStr.group(4).charAt(0)))
                            pPower.add(numMultiplier * Integer.parseInt(mStr.group(4)));
                        System.out.println("pPower " + pPower.getLast());
                    }
                    else {
                        pPower.add(1);
                    }
                }
            }
            if (pPower.size() < pCoefficients.size()) {
                pPower.add(0);
            }
            if (pPower.size() > pCoefficients.size()) {
                pCoefficients.add(1);
            }
        }
        // System console print messages to debug
        for(int j = 0; j < pCoefficients.size() && j < pPower.size(); j++)
        {
            System.out.println("pCoefficient " + pCoefficients.get(j) + " power " + pPower.get(j));
        }
    }
    public void parseDerivative()
    {
        if(getStringF().equals("Error"))
            return;
        if(!dCoefficients.isEmpty()) {
            dCoefficients.removeAll(dCoefficients);
        }
        if(!dPower.isEmpty()) {
            dPower.removeAll(dPower);
        }
        for(int i=0; i < pCoefficients.size(); i++)
        {
            if(pPower.get(i) != 0) {
                dCoefficients.add((pCoefficients.get(i) * pPower.get(i)));
                dPower.add((pPower.get(i) - 1));
            }
            if(dCoefficients.size() <= 0)
            {
                dCoefficients.add(0);
                dPower.add(0);
            }
            System.out.println("Derivative coefficient "+dCoefficients.getLast()+" Power "+dPower.getLast());
        }
    }
    public void erasePolynomial()
    {
        if(!pCoefficients.isEmpty()) {
            pCoefficients.removeAll(pCoefficients);
        }
        if(!pPower.isEmpty()) {
            pPower.removeAll(pPower);
        }
        if(!dCoefficients.isEmpty()) {
            dCoefficients.removeAll(dCoefficients);
        }
        if(!dPower.isEmpty()) {
            dPower.removeAll(dPower);
        }
        super.setStringF("Error");
    }
    public double calcFunction(double x)
    {
        double retValue = 0;
        if(getStringF().equals("Error"))
        {
            System.out.println("Polynomial function calculation error");
            return 0;
        }
        for(int i=0; i < pCoefficients.size(); i++)
        {
            retValue += pCoefficients.get(i)* Math.pow(x, pPower.get(i));
        }
        // System.out.println("X value "+x+" function "+retValue);
        return retValue;
    }
    public double getDerivative(double x)
    {
        double retValue = 0;
        if(getStringF().equals("Error"))
        {
            System.out.println("Derivative error");
            return 0;
        }
        for(int i=0; i < dCoefficients.size(); i++)
        {
            retValue += dCoefficients.get(i)* Math.pow(x, dPower.get(i));
        }
        return retValue;
    }
    public int convertMathXToGraph(double xValue)
    {
            // This helps zoom in on high level polynomial functions
            if(pPower.getFirst() >= 3) return (int) (super.getWindow().getOriginX() + (xValue * 100));
            return (int) (super.getWindow().getOriginX() + (xValue));
    }
}