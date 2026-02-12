package com.tecbom.e_commerce.ReferenceObjects;

import com.tecbom.e_commerce.Domain.Entities.Products.Category;
import com.tecbom.e_commerce.Domain.Entities.Products.Model;
import com.tecbom.e_commerce.Domain.Entities.Products.Product;
import com.tecbom.e_commerce.Domain.Entities.Users.*;
import com.tecbom.e_commerce.Domain.ValueObjects.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//TODOS OS DADOS PESSOAIS PRESENTES NESTA CLASSE SÃO GERADOS PELO SITE 4DEVS E NÃO APRESENTAM CORRELAÇÃO NEM VALIDADE, APENAS REFERÊNCIAS PARA OS TESTES
public class ReferenceObject {
    public User NormalUser(){
            EmailValidation emailValidation = new EmailValidation(null, true);
            Cep cep = new Cep("08380215");
            ValidText number = new ValidText("83");
            EmailVO email = new EmailVO("exemplo@gmail.com");
            Cpf cpf = new Cpf("07653437036");
            Name name = new Name("exemplo");
            Password password = new Password("aA123456@");
            PhoneNumber phoneNumber = new PhoneNumber("11987654321");
            Address address = new Address(
                    cep,
                    "Rua Exemplo",
                    "Bairro Exemplo",
                    "Cidade Exemplo",
                    "Estado Exemplo",
                    "apto 83",
                    number
            );

            User user = new User(
                    cpf,
                    name,
                    password,
                    email,
                    address,
                    phoneNumber,
                    Role.COMUM,
                    Status.ON,
                    emailValidation,
                    null
            );
            return  user;
    }
    public User UserRegister(){  Cep cep = new Cep("08380215");
        ValidText number = new ValidText("83");
        EmailVO email = new EmailVO("exemplo@gmail.com");
        Cpf cpf = new Cpf("07653437036");
        Name name = new Name("exemplo");
        Password password = new Password("aA123456@");
        PhoneNumber phoneNumber = new PhoneNumber("11987654321");
        Address address = new Address(
                cep,
                "Rua Exemplo",
                "Bairro Exemplo",
                "Cidade Exemplo",
                "Estado Exemplo",
                "apto 83",
                number
        );

        User user = new User(
                cpf,
                name,
                password,
                email,
                address,
                phoneNumber,
                Role.COMUM
        );
        return  user;
    }
    public Master NormalMaster(){
        Cpf cpf = new Cpf("11104534002");
        Name name = new Name("exemplão");
        Password password = new Password("aA123456@");
        EmailVO email = new EmailVO("emailmestre@gmail.com");
        PhoneNumber phoneNumber = new PhoneNumber("11987654321");
        Master master = new Master(
            cpf,
            name,
            password,
            email,
            phoneNumber
        );
        return master;
    }
    public CartItem simpleItem() {
        return new CartItem(
                1,
                new ValidText("Mouse Gamer"),
                new Quantity(1),
                new Price(new BigDecimal("150.00"))
        );
    }

    public CartItem expensiveItem() {
        return new CartItem(
                2,
                new ValidText("Monitor 4K"),
                new Quantity(1),
                new Price(new BigDecimal("3500.00"))
        );
    }

    public CartItem bulkItem() {
        return new CartItem(
                3,
                new ValidText("Pack de Pilhas"),
                new Quantity(10),
                new Price(new BigDecimal("45.00"))
        );
    }

    public List<CartItem> fullCartList() {
        return new ArrayList<CartItem>();
    }

    public Cart fullCart() {
        return new Cart(
                new Cpf("07653437036"),
                fullCartList()
        );
    }

    public Model smartphoneModel() {
        ValidText name = new ValidText("iPhone 15 Pro");
        Price price = new Price(new BigDecimal("8000.00"));
        Quantity quantity = new Quantity(15);
        Photos photos = new Photos(List.of("url1.jpg", "url2.jpg"));
        BigDecimal discount = new BigDecimal("0.10");

        return new Model(
                name,
                price,
                quantity,
                photos,
                discount
        );
    }

    public Product smartphoneProduct() {
        Model blackModel = new Model(
                new ValidText("Preto 128GB"),
                new Price(new BigDecimal("5000.00")),
                new Quantity(10),
                new Photos(List.of("url_preto_1.jpg")),
                new BigDecimal("10")
        );

        Model whiteModel = new Model(
                new ValidText("Branco 128GB"),
                new Price(new BigDecimal("5000.00")),
                new Quantity(5),
                new Photos(List.of("url_branco_1.jpg")),
                null
        );

        List<Model> modelList = new ArrayList<>();
        modelList.add(blackModel);
        modelList.add(whiteModel);

        return new Product(
                new ValidText("iPhone 15"),
                new ValidText("O mais novo smartphone da Apple"),
                modelList,
                Category.TELEFONES
        );
    }
}
