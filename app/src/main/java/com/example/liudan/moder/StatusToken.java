package com.example.liudan.moder;

import org.json.JSONObject;

/**
 * Created by liudan on 2017/7/6.
 */

public class StatusToken {

    public int id;
    public String access_token;
    public String refresh_token;
    public boolean status;

    public StatusToken(JSONObject optJSONObject) {
        id = optJSONObject.optInt("id");
        access_token = optJSONObject.optString("access_token");
        refresh_token = optJSONObject.optString("refresh_token");
        status = optJSONObject.optBoolean("status");
    }

}
