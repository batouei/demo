package com.company.shop.common;

public final class UrlMapping {
    public static final String USERS = "/users";
    public static final String USER_LOGIN = USERS + "/login";
    public static final String USER_REGISTER = USERS + "/register";


    public static final String ORDERS = "/orders";
    public static final String DELETE_ORDERS = ORDERS + "/{id}";


}
