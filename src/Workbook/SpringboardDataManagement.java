package Workbook;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpringboardDataManagement {

    public static void main(String[] args){
        System.out.println("First power of 16 after 16^4 that does not contain 1,2,4,or 8: " + findPower());
    }

    public static int findPower(){
        int i = 14803;
        BigDecimal number = new BigDecimal(16);
        BigDecimal n;

        while(true){
            n = number.pow(i);
            if(checkDigits(n)){
                System.out.println("Number is: " + n);
                System.out.println("Power checked is: " + i);
                i ++;
            }else{
                System.out.println("Number is: " + number);
                return i;
            }
        }
    }
    public static boolean checkDigits(BigDecimal n){
        BigDecimal temp = n;

        BigDecimal remainder;
        BigDecimal divisor = new BigDecimal(10);

        while(temp.compareTo(new BigDecimal(0)) > 0){
        remainder = (temp.remainder(divisor));

        if(remainder.equals(new BigDecimal(1)) || remainder.equals(new BigDecimal(2)) ||remainder.equals(new BigDecimal(4)) ||remainder.equals(new BigDecimal(8))) return true;
        temp = temp.divide(divisor,0 ,RoundingMode.DOWN);

        }
        return false;
    }
}
