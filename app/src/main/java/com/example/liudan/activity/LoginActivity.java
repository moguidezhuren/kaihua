package com.example.liudan.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liudan.Constants;
import com.example.liudan.R;
import com.example.liudan.moder.StatusToken;
import com.example.liudan.util.T;

import org.json.JSONObject;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;

public class LoginActivity extends BaseActivity {

    private TextView register;
    private EditText userName,password;
    private Button login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (TextView)findViewById(R.id.register);
        userName = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                httpSend();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void httpSend() {
        customProgressBar.show();

        RequestParams params = new RequestParams(Constants.Http.login);

        params.addQueryStringParameter("client_id", Constants.Http.client_id);
        params.addQueryStringParameter("client_secret", Constants.Http.client_secret);
        params.addQueryStringParameter("name", userName.getText().toString().trim());
        params.addQueryStringParameter("password", password.getText().toString().trim());

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
                        Intent intent = new Intent(LoginActivity.this,MyTabActivity.class);
                        startActivity(intent);
                        this.finish();
                    }else {
                        T.show(this, getResources().getString(R.string.loginFailure), Toast.LENGTH_SHORT);
                    }
                }
            }
        } catch (Exception e) {
            T.show(this, getResources().getString(R.string.dataError), Toast.LENGTH_SHORT);
            e.printStackTrace();
        }

    }
}
