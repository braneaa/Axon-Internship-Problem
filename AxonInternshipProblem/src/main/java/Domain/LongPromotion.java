package Domain;

import java.time.LocalDate;
import java.util.List;

public class LongPromotion {

    private String localDateStart;
    private String localDateFinal;
    private List<Product> products;

    public LongPromotion(String localDateStart, String localDateFinal, List<Product> products) {
        this.localDateStart = localDateStart;
        this.localDateFinal = localDateFinal;
        this.products = products;
    }

    public String getLocalDateStart() {
        return localDateStart;
    }

    public void setLocalDateStart(String localDateStart) {
        this.localDateStart = localDateStart;
    }

    public String getLocalDateFinal() {
        return localDateFinal;
    }

    public void setLocalDateFinal(String localDateFinal) {
        this.localDateFinal = localDateFinal;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "LongPromotion{" +
                "localDateStart='" + localDateStart + '\'' +
                ", localDateFinal='" + localDateFinal + '\'' +
                ", products=" + products +
                '}'+ '\n';
    }
}
