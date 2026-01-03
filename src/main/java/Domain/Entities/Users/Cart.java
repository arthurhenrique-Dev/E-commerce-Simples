package Domain.Entities.Users;

import Domain.ValueObjects.CartItem;
import Domain.ValueObjects.Price;

import java.math.BigDecimal;
import java.util.List;

public class Cart {

    private List<CartItem> items;
    private Price price;

    private Price CalculateTotalPrice(List<CartItem> items){
        Price total = new Price(BigDecimal.ZERO);
        for(CartItem item : items){
            Price itemPrice = item.price();

            total = total.add(itemPrice);
        }
        return total;
    }

    public List<CartItem> addCartItem(List<CartItem> items, CartItem item){
        items.add(item);
        return items;
    }

    public List<CartItem> removeCartItem(List<CartItem> items, CartItem item){
        items.remove(item);
        return items;
    }

    public Cart(List<CartItem> items) {
        this.items = items;
        this.price = CalculateTotalPrice(items);
    }


}
