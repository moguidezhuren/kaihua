package com.example.liudan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liudan.Constants;
import com.example.liudan.R;
import com.example.liudan.moder.StatusToken;
import com.example.liudan.util.T;

import org.json.JSONObject;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;

import java.util.Map;
import java.util.TreeMap;

public class RegisterActivity extends BaseActivity {

    private Button registerButton;
    private EditText email,account,password;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText)findViewById(R.id.email);
        account = (EditText)findViewById(R.id.account);
        password = (EditText)findViewById(R.id.password);
        registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                httpSend();
            }
        });
    }

    private void httpSend() {
        customProgressBar.show();

        RequestParams params = new RequestParams(Constants.Http.reg);

        params.addQueryStringParameter("client_id", Constants.Http.client_id);
        params.addQueryStringParameter("client_secret", Constants.Http.client_secret);
        params.addQueryStringParameter("email", email.getText().toString().trim());
        params.addQueryStringParameter("account", account.getText().toString().trim());
        params.addQueryStringParameter("password", password.getText().toString().trim());

        Log.d(this.getClass().getName(),"11111"+Constants.Http.reg);
        Log.d(this.getClass().getName(),"11111"+email.getText().toString().trim());
        Log.d(this.getClass().getName(),"11111"+account.getText().toString().trim());
        Log.d(this.getClass().getName(),"11111"+password.getText().toString().trim());
        try {
            sendHttpRequest(params, HttpMethod.POST, true, 10011);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected  void httpOnResponse(String responseStr, int requestCode) {
        super.httpOnResponse(responseStr, requestCode);
        customProgressBar.cancel();
        try {
            if (responseStr != null) {
                Log.d(this.getClass().getName(),"responseStr====" + responseStr);
                JSONObject jsonObj = new JSONObject(responseStr);
                if (jsonObj != null) {
                        StatusToken statusToken = new StatusToken(jsonObj);
                        if(statusToken.status){
                            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                            this.finish();
                        }else {
                            T.show(this, getResources().getString(R.string.registerFailure), Toast.LENGTH_SHORT);
                        }
                }
            }
        } catch (Exception e) {
            T.show(this, getResources().getString(R.string.dataError), Toast.LENGTH_SHORT);
            e.printStackTrace();
        }

    }
}
