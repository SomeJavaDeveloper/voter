package ru.vote.testtask.web;


import ru.vote.testtask.model.AbstractEntity;

public class SecurityUtil{

    private static int id = AbstractEntity.START_SEQ;

    private SecurityUtil() {
    }

    public static int authUserId() {
        return id;
    }

    public static void setAuthUserId(int id) {
        SecurityUtil.id = id;
    }

}
