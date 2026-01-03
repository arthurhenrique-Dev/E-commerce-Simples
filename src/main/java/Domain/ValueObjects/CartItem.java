package Domain.ValueObjects;

public class CartItem{

        private Long id;
        private ValidText name;
        private Quantity quantity;
        private Integer indexModel;
        private Price price;

    public CartItem(Long id, ValidText name, Quantity quantity, Integer indexModel, Price price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.indexModel = indexModel;
        this.price = price;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Price getPrice() {
        return price;
    }

    public ValidText getName() {
        return name;
    }
}
