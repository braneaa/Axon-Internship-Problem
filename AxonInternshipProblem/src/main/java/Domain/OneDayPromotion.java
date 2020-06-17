package Domain;

import java.time.LocalDate;
import java.util.List;

public class OneDayPromotion {

    private String localDate;
    private List<Product> products;

    public OneDayPromotion(String localDate, List<Product> products) {
        this.localDate = localDate;
        this.products = products;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "OneDayPromotion{" +
                "localDate='" + localDate + '\'' +
                ", products=" + products +
                '}'+'\n';
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
