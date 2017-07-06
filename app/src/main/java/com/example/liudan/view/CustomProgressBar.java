package com.example.liudan.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liudan.R;


/**
 * @author： Shine
 * @date：2013-4-10 下午2:12:35 自定义进度条
 */
public class CustomProgressBar extends Dialog {

	private String progressText;

	private Animation circleAnim = null;

	private ImageView mProgressBar = null;
	TextView title;

	public CustomProgressBar(Context context) {
		super(context, R.style.submit_dialog_theme);

		setContentView(R.layout.custom_progressbar);
		title = (TextView) findViewById(R.id.custom_imageview_progress_title);
		title.setText(progressText == null ? "加载中": progressText);

//		if (circleAnim == null) {
////			circleAnim = AnimationUtils.loadAnimation(context,
////					R.anim.round_loading);
//		}
		if (mProgressBar == null) {
			mProgressBar = (ImageView) findViewById(R.id.custom_imageview_progress_bar);
			 AnimationDrawable  animationDrawableProgressBar = (AnimationDrawable)mProgressBar.getDrawable();  
		        if(animationDrawableProgressBar!=null)animationDrawableProgressBar.start();

		}
		mProgressBar.setVisibility(View.GONE);
//		mProgressBar.clearAnimation();
//		mProgressBar.startAnimation(circleAnim);
	}

	public void setLoadText(String load) {
		title.setText(load);
	}
	// public CustomProgressBar(Context context, String progressText) {
	// super(context, R.style.submit_dialog_theme);
	// this.context = context;
	// this.progressText = progressText;
	// initController();
	//
	// }
//add by 2014-03-11 chenqiang
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		try{
			super.cancel();
			mProgressBar.setVisibility(View.GONE);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		try{
			super.show();
            if(mProgressBar.getVisibility()==View.VISIBLE){
                mProgressBar.setVisibility(View.GONE);
            }
			mProgressBar.setVisibility(View.VISIBLE);
		}catch(Exception e){
			e.printStackTrace();
		}
			
		
	}

	// public void setText(String text) {
	// TextView title = (TextView)
	// findViewById(R.id.custom_imageview_progress_title);
	// title.setText(text);
	// }

}
