package Application.Ports.Input.Users;

import Application.DTO.Users.DTORemoveCartItem;

public interface RemoveCartItemPort {

    void removeCartItem(DTORemoveCartItem dtoRemoveCartItem);
}
