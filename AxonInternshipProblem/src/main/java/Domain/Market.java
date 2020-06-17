package Domain;

import java.util.List;

public class Market {

    private String marketName;
    private boolean isOpen;
    private List<LongPromotion> longPromotions;
    private List<OneDayPromotion> oneDayPromotions;
    private List<Product> products;

    public Market(String n, boolean o, List<LongPromotion> l1, List<OneDayPromotion> l2, List<Product> l3){
        this.marketName = n;
        this.isOpen = o;
        this.longPromotions = l1;
        this.oneDayPromotions = l2;
        this.products = l3;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getName() {
        return marketName;
    }

    public void setName(String name) {
        this.marketName = name;
    }

    public List<LongPromotion> getLongPromotions() {
        return longPromotions;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setLongPromotions(List<LongPromotion> longPromotions) {
        this.longPromotions = longPromotions;
    }

    public void setOneDayPromotions(List<OneDayPromotion> oneDayPromotions) {
        this.oneDayPromotions = oneDayPromotions;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<OneDayPromotion> getOneDayPromotions() {
        return oneDayPromotions;
    }

    public List<Product> getProducts() {
        return products;
    }
    
    @Override
    public String toString(){
        return marketName + "\n" +isOpen+ "\n" + longPromotions.toString()+ "\n" + oneDayPromotions.toString()+ "\n" + products.toString()+ "\n";
    }
    
}
