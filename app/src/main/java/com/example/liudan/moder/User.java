package com.example.liudan.moder;

import org.json.JSONObject;

/**
 * Created by liudan on 2017/7/6.
 */

public class User {
    public int id;
    public String email;
    public String account;
    public String password;

    public User(JSONObject optJSONObject) {
        id = optJSONObject.optInt("id");
        email = optJSONObject.optString("email");
        account = optJSONObject.optString("account");
        password = optJSONObject.optString("password");
    }
}
