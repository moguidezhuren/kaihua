package com.example.liudan.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast统一管理类
 * 
 * @author way
 * 
 */
public class T {
	private static Toast toast;

	/**
	 * 自定义显示Toast时间
	 * 
	 * @param context
	 * @param message
	 * @param duration
	 */
	public static void show(Context context, CharSequence message, int duration) {
//		if(context!=null){
//            Toast.makeText(context, message, duration).show();
//            // toast.setGravity(Gravity.CENTER, 0, 0);
//		}
		if(context!=null){
			if (toast == null) {
				toast = Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_SHORT);
			} else {
				toast.setText(message);
			}
			toast.show();
		}

	}

	/**
	 * 自定义显示Toast时间
	 *
	 * @param context
	 * @param message
	 * @param duration
	 */
	public static void show(Context context, int message, int duration) {
        if(context!=null){
            Toast.makeText(context, message, duration).show();
            // toast.setGravity(Gravity.CENTER, 0, 0);
        }
	}

}
