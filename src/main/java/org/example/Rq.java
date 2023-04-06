package org.example;

import java.util.HashMap;

public class Rq {
    private String actionCode;
    private HashMap<String, String> params;

    public Rq(String command) {
        String[] commandBits = command.split("\\?", 2);

        this.actionCode = commandBits[0];

        if (commandBits.length == 1) return;
        params = new HashMap<>();

        String[] paramsBits = commandBits[1].split("&");

        for (String paramsStr : paramsBits) {
            String[] paramsStrBits = paramsStr.split("=", 2);

            if (paramsStrBits.length == 1) continue;

            String key = paramsStrBits[0];
            String value = paramsStrBits[1];
            params.put(key, value);

        }
    }

    public String getActionCode() {
        return this.actionCode;
    }

    public String getParam(String name) {
        return params.get(name);
    }

    public int getIntparam(String name, int defaultValue) {

        try {
            return Integer.parseInt(getParam(name));
        } catch (NumberFormatException e) {
            System.out.println("정수를 입력해주세요.");
        }
        return defaultValue;


    }


}

