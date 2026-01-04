package Application.Ports.Input.Users;

import Application.DTO.Users.DTOAddCartItem;

public interface AddCartItemPort {

    void addCartItem(DTOAddCartItem dtoAddCartItem);
}
