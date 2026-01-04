package Domain.Entities.Users;

import Domain.Exceptions.Exceptions.InvalidDataException;
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
            Price itemPrice = item.getPrice();
            total = total.add(itemPrice);
        }
        return total;
    }

    public List<CartItem> addCartItem(CartItem item){
        this.items.add(item);
        return this.items;
    }

    public List<CartItem> removeCartItem(Integer idxItem){
        if (idxItem < 1 || idxItem > this.items.size()) throw new InvalidDataException("Erro");
        this.items.remove(this.items.get(idxItem - 1));
        return this.items;
    }

    public Cart(List<CartItem> items) {
        this.items = items;
        this.price = CalculateTotalPrice(items);
    }


}
