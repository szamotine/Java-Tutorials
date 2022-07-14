import java.util.Arrays;

public class HelloJava {
    public static void main(String[] args){


        String[] items = {"clock", "table", "ladder", "chair", "oven", "phone"};

        String[] moreItems = Arrays.copyOf(items, 2);
        items[1] = "sofa";

        System.out.println(Arrays.toString(items));
        System.out.println(Arrays.toString(moreItems));


    }
    /**
     *
     * @param name  (String)
     * @param age   (String)
     *
     *              Inside the function:
     *              1. Prints the name and age as part of the text
     */
    public static void printText(String name, String age){
        System.out.println("Hi, I'm " + name + " and I'm " + age + " years old");
    }
}
