package StockSimulation;

import StockSimulation.Model.Account.Account;
import StockSimulation.Model.Account.Personal;
import StockSimulation.Model.Account.TFSA;
import StockSimulation.Model.Stock;
import StockSimulation.Model.Trade;
import StockSimulation.utils.Color;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    static Account account;
    static List<Stock> stocks;
    static final double INITIAL_DEPOSIT = 4000;
    static Scanner scanner = new Scanner(System.in);

    static int day;
    String buyOrSell;
    String stock;
    Stock chosenStock;
    int numShares;
    Trade trade;
    boolean flag;



    public Game() {
        initialize();
        getPriceList();
    }

    public void play(){

        while(day <=2160){
            flag = true;
            do{
                displayPrices(day);
                buyOrSell = buyOrSell();
                if(buyOrSell.equals("skip")){
                    day += skipDay();
                   break;
                }
                if(buyOrSell.equals("exit")) System.exit(0);

                stock = chooseStock();
                chosenStock = findStock(stock);

                numShares = numShares(chosenStock, buyOrSell);
                trade = new Trade(chosenStock,buyOrSell, numShares);
                tradeStatus(account.ExecuteTrade(trade));
                System.out.println("Do you want to make any other transactions for this day?");
                String choice = scanner.nextLine();
                if(choice.equals("no")){
                    flag = false;
                }


            }while(flag);

            day ++;
        }
        System.out.println("Congratulations, you've reached the end of the game");

        scanner.close();
    }


    private void initialize(){

        day = 1;
        flag = true;
        explainApp();
        initializeStocks();
        initializeAccount(accountChoice());
        initialBalance();

    }

    public static void explainApp() {
        System.out.print(Color.BLUE + "\n - PERSONAL: ");
        System.out.println(Color.YELLOW + "Every sale made in a personal account is charged a 5% fee.");
        System.out.print(Color.BLUE + "\n - TFSA: ");
        System.out.println(Color.YELLOW + "Every trade (buy/sell) made from a TFSA is charged a 1% fee.\n");
        System.out.println(Color.BLUE + " - Neither account has a limit on the amount of trades that can be made." + Color.RESET);
    }

    public static void initializeStocks(){
        Stock FB = new Stock(Stock.StockName.FB);
        Stock AAPL = new Stock(Stock.StockName.AAPL);
        Stock GOOG = new Stock(Stock.StockName.GOOG);
        Stock TSLA = new Stock(Stock.StockName.TSLA);
        stocks = new ArrayList<>();
        stocks.add(FB);
        stocks.add(AAPL);
        stocks.add(GOOG);
        stocks.add(TSLA);

    }

    public static void initializeAccount(String type){
        if(type.equalsIgnoreCase("a")){
            account = new Personal(INITIAL_DEPOSIT);
        }
        if(type.equalsIgnoreCase("b")){
            account = new TFSA(INITIAL_DEPOSIT);
        }
        for(Stock s : stocks){
            account.initializeStock(s,0);
        }
    }

    public static void initialBalance() {
        System.out.print("\n\n  You created a " + Color.YELLOW + account.getClass().getSimpleName() + Color.RESET + " account.");
        System.out.println(" Your account balance is " + Color.GREEN + "$" + account.getFunds() + Color.RESET);
        System.out.print("\n  Enter anything to start trading: ");
        scanner.nextLine();
    }

    public static String accountChoice() {
        System.out.print("\n  Type 'a' to create a Personal account or 'b' to create a TFSA account: ");
        String choice = scanner.nextLine();
        while (!choice.equals("a") && !choice.equals("b")) {
            System.out.print("  Respectively, type 'a' or 'b' to create a Personal account or TFSA: ");
            choice = scanner.nextLine();
        }
        return choice;
    }


    public static String buyOrSell() {
        System.out.print( Color.RESET + "\n\n   Would you like to 'buy' or 'sell' or 'skip': ");
        String choice = scanner.nextLine();
        while (!choice.equals("buy") && !choice.equals("sell") && !choice.equals("skip") && !choice.equals("exit")) {
            System.out.print("  Would you like to 'buy' or 'sell' or 'skip': ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    public static String chooseStock() {
        System.out.println(account);
        System.out.print("  Choose a stock: ");
        String stock = scanner.nextLine();
        while (!stock.equals("AAPL") && !stock.equals("FB") && !stock.equals("GOOG") && !stock.equals("TSLA") ) {
            System.out.print("  Choose a stock: ");
            stock = scanner.nextLine();
        }
        return stock;
    }

    public static Stock findStock(String stock){

        return stocks.stream().filter(s->s.getName().equals(Stock.StockName.valueOf(stock)))
                .findFirst().orElse(null);
    }

    public static int numShares(Stock stock, String choice) {
        System.out.println(account);
        checkMax(stock);
        System.out.print("  Enter the number of shares you'd like to " + choice + ": ");
        int shares = scanner.nextInt();
        scanner.nextLine(); //throwaway nextLine
        while (shares <= 0) {
            System.out.print("  Enter the number of shares you'd like to " + choice + ": ");
            shares = scanner.nextInt();
            scanner.nextLine(); //throwaway nextLine

        }
        return shares;
    }

    public static void displayPrices(int day) {
        System.out.println("\n\n\t  DAY " + day + " PRICES\n");

        for (Stock s:stocks ) {
            String price = getPrice(s, day);
            System.out.println("  " + Color.BLUE + s.getName() + "\t\t" + Color.GREEN + price + Color.RESET);
            if(price != null){
                s.setPrice(Double.parseDouble(price));
            }

        }
    }

    public static boolean tradeStatus(boolean result) {
        String r = result ? "successful" : "unsuccessful";

        System.out.println(Color.RESET + "\n  The trade was " + (result ? Color.GREEN : Color.RED) + r + Color.RESET + ". \n\tHere is your portfolio:\n");
        System.out.println(account);
        System.out.print("\n  Press anything to continue");
        scanner.nextLine();
        return result;
    }

    public static String getPrice(Stock stock, int day) {
        Path p = getPath(stock.getName().toString());

        try{
            String[] result = Files.lines(p)
                    .map(line -> line.split(","))
                    .filter(r -> r[0].equals(String.valueOf(day)))
                    .findFirst().orElse(null);
            if (result != null) {
                return result[1];
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void getPriceList(){


    }
    public static int skipDay(){
        System.out.print("\n\n  How many days would you like to skip: ");
        return Integer.parseInt(scanner.nextLine());


    }

    public static Path getPath(String stock) {
        String filename = "C:\\Projects\\Java\\Java-Tutorials\\src\\StockSimulation\\Data\\" + stock + ".csv";
        try{
            return Paths.get(filename);
            //return Paths.get(Thread.currentThread().getContextClassLoader().getResource("src/StockSimulation/data/"+stock+".csv").toURI());

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static void checkMax(Stock stock){

        double m = round(account.getFunds()/stock.getPrice());
        int max = (int) m-1;
        System.out.println( Color.RESET + "The max amount of " + Color.BLUE + stock.getName() + Color.RESET + " that you can purchase is: " + Color.GREEN + max + Color.RESET);


    }
    public static double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("##");
        return Double.parseDouble(formatter.format(amount));
    }
}
