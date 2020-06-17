package Controller;

import Domain.*;
import Repository.ClientRepository;
import Repository.MarketRepository;
import com.sun.tools.javac.util.Pair;

import java.io.*;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Controller {

    private ClientRepository clients;
    private MarketRepository markets;
    private File file = new File("D:\\MetPP\\AxonInternshipProblem\\src\\main\\resources\\comenzi.txt");

    public Controller(ClientRepository c, MarketRepository m) throws IOException {
        this.clients = c;
        this.markets = m;

    }

    /***
     * Get the price of the product and the market based on promotions and market priority
     * @param productName - name of the product out client searchs
     * @param date - the date our client goes shopping
     * @param marketPriority - market priority of the client
     * @return - a pair with the price of the product and the market we find it
     */
    private Pair<Double, String> priceAndMarketForProduct(String productName, String date, Map<Integer, String> marketPriority){

        double price = 0.00;
        String marketname = null;
        LocalDate localDate = LocalDate.parse(date);
        boolean isSunday = localDate.getDayOfWeek() == DayOfWeek.SUNDAY;

        //Check promotions first
        for(Map.Entry<Integer,String> entry: marketPriority.entrySet()){
            String currentCheckedMarket = entry.getValue();
            List<Market> allMarkets = markets.getMarkets();
            Market currentMarket = null;
            for (Market allMarket : allMarkets) {
                if (currentCheckedMarket.equals(allMarket.getName())) {
                    currentMarket = allMarket;
                }
            }

            if(!(isSunday && !currentMarket.isOpen()))// check if the client goes on sunday and if the market is open
            {   //check first for one day promotion because we know the products are cheaper
                List<OneDayPromotion> oneDayPromotions = currentMarket.getOneDayPromotions();
                for(OneDayPromotion oneDayPromotion: oneDayPromotions){
                    LocalDate promotionDate = LocalDate.parse(oneDayPromotion.getLocalDate());
                    if(promotionDate.isEqual(localDate)){
                        List<Product> products = oneDayPromotion.getProducts();
                        for(Product product : products){
                            if(product.getName().equals(productName)){
                                price = product.getValue();
                                marketname = currentCheckedMarket;
                            }
                        }
                    }
                }

                if(price != 0.00 && marketname!=null) return new Pair<Double, String>(price, marketname);

                // then we check for long promotion in case we haven't found the product yet
                List<LongPromotion> longPromotions = currentMarket.getLongPromotions();
                for(LongPromotion longPromotion: longPromotions){
                    LocalDate promotionDateStart = LocalDate.parse(longPromotion.getLocalDateStart());
                    LocalDate promotionDateFinal = LocalDate.parse(longPromotion.getLocalDateFinal());
                    if((localDate.isEqual(promotionDateStart) || localDate.isAfter(promotionDateStart)) && (localDate.isEqual(promotionDateFinal) || localDate.isBefore(promotionDateFinal))){
                        // checks if the date the client goes shopping is in the promotion interval
                        List<Product> products = longPromotion.getProducts();
                        for(Product product: products){
                            if(product.getName().equals(productName)){
                                price = product.getValue();
                                marketname = currentCheckedMarket;
                            }
                        }
                    }
                }

                if(price != 0.00 && marketname!=null) return new Pair<Double, String>(price, marketname);
            }

        }

        //Check normal prices in case promotions are not found for this product
        for(Map.Entry<Integer,String> entry: marketPriority.entrySet()){
            String currentCheckedMarket = entry.getValue();
            List<Market> allMarkets = markets.getMarkets();
            Market currentMarket = null;
            for (Market allMarket : allMarkets) {
                if (currentCheckedMarket.equals(allMarket.getName())) {
                    currentMarket = allMarket;
                }
            }
            if(!(isSunday && !currentMarket.isOpen()))
            {
                List<Product> products = currentMarket.getProducts();
                for(Product product: products){
                    if(product.getName().equals(productName)){
                        price= product.getValue();
                        marketname = currentCheckedMarket;
                    }
                }

                if(price != 0.00 && marketname!=null) return new Pair<Double, String>(price, marketname);
            }
        }

        return new Pair<Double, String>(0.00, null);

    }

    /***
     * Return a list of pair with the clients all the total sum they had to pay
     * @return
     */
    private List<Pair<Client, Double>> getTotalSums(){
        List<Client> allClient = clients.getClients();
        List<Pair<Client, Double>> totalSums = new ArrayList<>();
        for(Client c : allClient){
            double totalSum = 0.00;
            Map<Integer,String> map = c.getMarketPriority();
            String date = c.getDate();
            List<String> productList = c.getProductList();
            for(String s : productList){
                Pair<Double, String> pair = priceAndMarketForProduct(s, date, map);
                totalSum += pair.fst;
            }

            DecimalFormat df = new DecimalFormat("0.00");
            Pair<Client, Double> pair = new Pair<Client, Double>(c, Double.parseDouble(df.format(totalSum)));
            totalSums.add(pair);

        }
        //sort the list first by the total sum, then if the sums are equal after the clients' name
        totalSums.sort(new Comparator<Pair<Client, Double>>() {
            @Override
            public int compare(Pair<Client, Double> o1, Pair<Client, Double> o2) {
                if (o1.snd > o2.snd) {
                    return -1;
                } else if (o1.snd.equals(o2.snd)) {
                    return o1.fst.getClientName().compareTo(o2.fst.getClientName());
                } else {
                    return 1;
                }
            }
        });


        return totalSums;
    }

    /***
     * Write the information for every client in a file as required
     * @throws IOException
     */
    public void writeToFile() throws IOException {

        FileWriter fileWriter = new FileWriter("D:\\MetPP\\AxonInternshipProblem\\src\\main\\resources\\comenzi.txt");

        List<Pair<Client,Double>> information = getTotalSums();
        for(Pair<Client,Double> info : information){
            fileWriter.write(info.fst.getClientName() + " goes shopping on  " + info.fst.getDate() + '\n');
            fileWriter.write("Product - Price - Market : \n");
            List<String> products = info.fst.getProductList();
            Map<Integer,String> map = info.fst.getMarketPriority();
            String date = info.fst.getDate();
            for(String s: products){
                Pair<Double, String> pair = priceAndMarketForProduct(s, date, map);
                if(pair.fst == 0.00){
                    fileWriter.write(s + " - was not found" + '\n');
                }
                else fileWriter.write(s + " - " + pair.fst + " - " + pair.snd + '\n');
            }
            fileWriter.write("Total sum was : " + info.snd + "\n\n");

        }
        fileWriter.close();

    }

}
