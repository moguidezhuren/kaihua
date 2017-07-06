package com.example.liudan.activity;

import android.accounts.NetworkErrorException;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.liudan.Constants;
import com.example.liudan.R;
import com.example.liudan.util.SystemFunction;
import com.example.liudan.util.SystemWidget;
import com.example.liudan.util.T;
import com.example.liudan.view.CustomProgressBar;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by dan on 14-7-9.
 */
public class BaseActivity extends Activity {

    protected CustomProgressBar customProgressBar;
    public SharedPreferences sharedPreferences;
    public DbManager db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (customProgressBar == null) {
            customProgressBar = new CustomProgressBar(this);
        }
        if (sharedPreferences == null) {
            sharedPreferences = getSharedPreferences(Constants.User.user, 0);
        }
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                //.setDbVersion(Constants.dbVesion)
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                    }
                });
        db = x.getDb(daoConfig);
    }


    /**
     * 请求服务器操作方法 *
     */
    protected synchronized void sendHttpRequest(RequestParams params, HttpMethod method, final boolean isShowError, final int requestCode) throws Exception {
        if (!SystemFunction.isNetworkAvailable(this)) { // 网络判断
            T.show(this, "当前没有网络", Toast.LENGTH_SHORT);
            customProgressBar.cancel();
            httpOnError(new NetworkErrorException(), false, requestCode);  //没网让SwipeRefreshLayout 加载进度条 隐藏
            return;
        }

        Callback.Cancelable cancelable
                = x.http().request(method, params,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        httpOnResponse(result, requestCode);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        customProgressBar.cancel();
                        if (isShowError) {   // 是否提示ERROR
                            if (ex instanceof HttpException) { // 网络错误
                                HttpException httpEx = (HttpException) ex;
                                String errorResult = httpEx.getResult();
                                try {
                                    if (errorResult != null) {
                                        JSONObject jsonObj = new JSONObject(errorResult);
                                        if (jsonObj.has("error")) {
                                            JSONObject errorJSONObject = jsonObj.optJSONObject("error");
                                            String message = errorJSONObject.optString("message");
                                            int status_code = errorJSONObject.optInt("status_code");
                                            if (status_code == 401) {  //登陆失效
                                                SystemWidget.showDialog_aginLogin(BaseActivity.this);
                                                return;
                                            }
                                            T.show(BaseActivity.this, message, Toast.LENGTH_SHORT);
                                        }
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                T.show(BaseActivity.this, ex.getMessage(), Toast.LENGTH_SHORT);
                            }
                        }

                        httpOnError(ex, isOnCallback, requestCode);

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                        customProgressBar.cancel();
                        httpOnCancelled(cex, requestCode);

                    }

                    @Override
                    public void onFinished() {
                        customProgressBar.cancel();
                        httpOnFinished(requestCode);
                    }
                });
    }

    /**
     * http请求响应, 用于回调
     *
     * @param responseStr
     */
    protected synchronized void httpOnResponse(String responseStr, int requestCode) {

    }

    public void httpOnError(Throwable ex, boolean isOnCallback, int requestCode) {

    }


    public void httpOnCancelled(Callback.CancelledException cex, int requestCode) {
    }


    public void httpOnFinished(int requestCode) {

    }


    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

}
