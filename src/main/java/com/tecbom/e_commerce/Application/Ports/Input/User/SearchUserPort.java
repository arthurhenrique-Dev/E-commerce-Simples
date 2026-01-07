package com.tecbom.e_commerce.Application.Ports.Input.User;

import com.tecbom.e_commerce.Application.DTOs.Users.DTOReturnUser;
import com.tecbom.e_commerce.Application.DTOs.Users.DTOSearchUser;

import java.util.List;

public interface SearchUserPort {

    List<DTOReturnUser> searchUsers(DTOSearchUser dtoSearchUser);
}
