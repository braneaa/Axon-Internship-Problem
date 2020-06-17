package Repository;

import Domain.LongPromotion;
import Domain.Market;
import Domain.OneDayPromotion;
import Domain.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MarketRepository implements Repository{

    private List<Market> markets;
    private List<String> filenames;

    public MarketRepository(List<String> filenames) throws IOException {
        this.filenames = filenames;
        this.markets = new ArrayList<>();
        readFromFile();
    }


    /***
     * Reads data from every market file
     * @throws IOException
     */
    @Override
    public void readFromFile() throws IOException {
        for(String s: filenames){
            File file = new File(s);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            List<String> split = Arrays.asList(s.split("_"));//split the name of the file for market name
            String name = split.get(1).split(".txt")[0];

            String line = bufferedReader.readLine();
            boolean isOpen;
            isOpen = line.equals("Deschis");//read the first line to see if the market is open on sundays

            line = bufferedReader.readLine();

            List<LongPromotion> longPromotions = new ArrayList<>();
            List<OneDayPromotion> oneDayPromotions = new ArrayList<>();
            List<Product> products = new ArrayList<>();

            line = bufferedReader.readLine();
            while (!line.equals("**********")){//start reading lines for promotions
                boolean isLongPromotion = false;
                List<String> dates = new ArrayList<>();
                String date = null;
                if(line.length() >= 11) {// checks if the promotion is a long promotion or a one day promotion
                    dates = Arrays.asList(line.split(" "));
                    isLongPromotion = true;
                }
                else if(line.length() == 10){
                    date = line;
                    isLongPromotion = false;
                }
                List<Product> productList = new ArrayList<>();
                line = bufferedReader.readLine();
                while (!(line.equals("")) && !(line.equals("**********"))){
                    List<String> prod = Arrays.asList(line.split(":"));//split products and price at promotion
                    if(prod.size() == 1) {
                        System.out.println(prod.toString() + " is not a valid output!");//in case the input is not ok
                    }
                    else {
                        productList.add(new Product(prod.get(0), Double.parseDouble(prod.get(1))));
                    }
                    line = bufferedReader.readLine();
                }
                if(isLongPromotion){

                    LongPromotion longPromotion = new LongPromotion(dates.get(0),dates.get(1), productList);
                    longPromotions.add(longPromotion);
                }
                else {
                    OneDayPromotion oneDayPromotion = new OneDayPromotion(date,productList);
                    oneDayPromotions.add(oneDayPromotion);
                }

                if(!line.equals("**********"))
                    line = bufferedReader.readLine();

            }
            while ((line = bufferedReader.readLine()) != null){// read the product at their normal price
                List<String> prod = Arrays.asList(line.split(":"));
                if(prod.size() == 1) {
                    System.out.println(prod.toString() + " is not a valid output!");
                }
                else {
                    products.add(new Product(prod.get(0), Double.parseDouble(prod.get(1))));
                }
            }
            markets.add(new Market(name, isOpen, longPromotions, oneDayPromotions, products));

        }
    }

    public List<Market> getMarkets() {
        return markets;
    }



}
