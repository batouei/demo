package com.company.shop.common;

public final class UrlMapping {

    /* USERS APIs */
    public static final String USERS = "/users";
    public static final String USER_LOGIN = USERS + "/login";
    public static final String USER_REGISTER = USERS + "/register";


    /* Order APIs */
    public static final String ORDERS = "/orders";
    public static final String DELETE_ORDERS = ORDERS + "/{id}";


    /* Product APIs */
    public static final String PRODUCTS = "/products";


    /* Delivery APIs */
    public static final String Delivery = "/delivery";


    /* Payment APIs */
    public static final String PAYMENTS = "/payments";
}
