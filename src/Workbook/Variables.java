package Workbook;

public class Variables {
    public static void main(String [] args){

        double decimal = 4.3;
        System.out.println(" Original Decimal is " + decimal);
        int integer = (int)decimal;
        decimal = integer;
        System.out.println(" Typecast Decimal is " + decimal);

    }
}
