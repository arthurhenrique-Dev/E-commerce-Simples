package Domain.Entities.Products;

import Domain.ValueObjects.Price;
import Domain.ValueObjects.Quantity;
import Domain.ValueObjects.ValidText;

import java.math.BigDecimal;
import java.util.List;

public class Model {

    private ValidText name;
    private Price price;
    private Quantity quantity;
    private List<String> photos;
    private AvailabilityStatus availability;
    private Integer timesViewed;
    private Integer timesPurchased;
    private Integer timesViewedInMonth;
    private Integer timesPurchasedInMonth;
    private BigDecimal discountPercentage;

    private AvailabilityStatus checkAvailability() {
        return this.quantity.quantity() > 0 ? AvailabilityStatus.IN_STOCK : AvailabilityStatus.OUT_OF_STOCK;
    }

    private Price checkDiscount(BigDecimal discountPercentage, Price price) {
        if (discountPercentage != null) return price.discount(discountPercentage);
        else return price;
    }

    public Model(ValidText name, Price price, Quantity quantity, List<String> photos, BigDecimal discountPercentage) {
        this.name = name;
        this.price = checkDiscount(discountPercentage, price);
        this.quantity = quantity;
        this.availability = checkAvailability();
        this.timesViewed = 0;
        this.timesPurchased = 0;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public ValidText getName() {
        return name;
    }

    public void setName(ValidText name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public AvailabilityStatus getAvailability() {
        return availability;
    }

    public Integer getTimesViewed() {
        return timesViewed;
    }

    public Integer getTimesPurchased() {
        return timesPurchased;
    }

    public void incrementTimesViewed() {
        this.timesViewed++;
    }

    public void incrementTimesPurchased() {
        this.timesPurchased++;
    }

    public Integer getTimesViewedInMonth() {
        return timesViewedInMonth;
    }

    public void incrementTimesViewedInMonth() {
        this.timesViewedInMonth++;
    }

    public Integer getTimesPurchasedInMonth() {
        return timesPurchasedInMonth;
    }

    public void incrementTimesPurchasedInMonth() {
        this.timesPurchasedInMonth++;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
