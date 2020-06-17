package Domain;

import java.util.List;
import java.util.Map;

public class Client {

    private String clientName;
    private String date;
    private List<String> productList;
    private Map<Integer, String> marketPriority;


    public Client(String clientName, String date, List<String> productList, Map<Integer, String> marketPriority) {
        this.clientName = clientName;
        this.date = date;
        this.productList = productList;
        this.marketPriority = marketPriority;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = productList;
    }

    public Map<Integer, String> getMarketPriority() {
        return marketPriority;
    }

    public void setMarketPriority(Map<Integer, String> marketPriority) {
        this.marketPriority = marketPriority;
    }

    @Override
    public String toString(){
        return clientName + " " + date + '\n' + productList.toString() + "\n" + marketPriority.toString();
    }

}
