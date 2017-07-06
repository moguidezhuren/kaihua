package com.example.liudan.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.example.liudan.activity.LoginActivity;

public class SystemWidget {


    /**
     * 登陆失效弹出 重新登陆
     *
     * @param context
     */
    public static void showDialog_aginLogin(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setMessage("登录已失效，请重新登录")//设置对话框内容
                .setTitle("提示")//设置对话框标题
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {//设置对话框[肯定]按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();//关闭对话框
                        Intent intent = new Intent(context, LoginActivity.class);
                        context.startActivity(intent);
                    }
                });
        builder.create().show();//创建对话框并且显示该对话框
    }

}
