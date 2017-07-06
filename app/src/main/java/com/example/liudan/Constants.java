package com.example.liudan;

import android.os.Environment;


public final class Constants {
	public static final int dbVesion = 63;
	public static final boolean daDebug = true;

	public static final class Http{
        public static final String client_id = "9539058";
        public static final String client_secret = "0fc7ec71da9c30ff76d70a73dd8a32f2";
		public static final String url = "http://www.tngou.net/api/oauth2";
		public static final String reg = url+"/reg";
		public static final String login = url+"/login";

	}


	public static final class User{
	        public static final String user = "user";
	        public static final String userId = "userId";
	        public static final String lecturerId = "lecturerId";
	        public static final String userName = "userName";   
	        public static final String nickname = "nickname";
	        public static final String expertName = "expertName";
	        public static final String password = "password";
	        public static final String sipId = "sip_id";
	        public static final String sippwd = "sip_password";
	        public static final String im_username = "im_username";
	        public static final String im_password = "im_password";
	        public static final String invitation_code = "invitation_code";  //邀请码
	        public static final String user_profit_tit = "user_profit_tit";  //邀请码内容
	        public static final String user_profit = "user_profit";  //优惠 智币 10元
	        public static final String user_profit_txt = "user_profit_txt";  //邀请码介绍
	        public static final String voip_domain = "voip_domain";
	        public static final String pushid = "pushid";  //推送每台设备ID
	        public static final String phone = "phone";
	        public static final String avatar = "avatar"; //头像URL
	        public static final String zcoin_balance = "zcoin_balance"; //余额
	        public static final String real_name = "real_name"; //真实姓名
	        public static final String mobile = "mobile"; //手机号
	        public static final String email = "email";  //邮件
	        public static final String companyName = "companyName";  //公司名
	        public static final String position = "position";  //职位
	        public static final String status = "status"; //专家状态
	        public static final String navigation = "navigation"; //是否展示导航，只在第一次展现导航

            public static final String consultable = "consultable"; //是否可咨询
            public static final String verified = "verified"; //是否认证
            public static final String income_url = "income_url"; //专家收入

	        public static final String sipPhone = "sipPhone";
	        public static final String api_token = "api_token";
	        public static final String headImgPath = Environment.getExternalStorageDirectory()+"/zhimei/zhimeiHeadImag/";   //照片剪切后的文件地址必须与原图地址在同目录  不能不能保存
	        public static final String headImgSmallPath = "zhimei/zhimeiHeadSmallImag/header.png";
	        public static final String headImgFile = "zhimeiHead";

           public static final String new_myConsult = "new_myConsult"; //新功能 我的咨询， 只在第一次出现

     }
	 
	 public static final class Weixin{
		 public static final String access_token = "access_token";   //调用凭证
		 public static final String openid = "openid";   //普通用户的标识，对当前开发者帐号唯一，获取该openid的好友列表
		 public static final String refresh_token = "refresh_token";   //用户刷新access_token
	 }
	 public static final class SinaWeibo{
		 public static final String uid = "uid";
		 public static final String access_token = "access_token";
		 public static final String expires_in = "expires_in";		
	 }
	 public static final class ClassName{
	        public static final String MediaPlayActivity = "MediaPlayActivity";	        
	        public static final String AccountSettingActivity = "AccountSettingActivity";	        
	        public static final String LoginActivity = "LoginActivity";	        
	        public static final String MyTabActivity = "MyTabActivity";	        
	        public static final String OfflineCourseDetailActivity = "OfflineCourseDetailActivity";	        
	        public static final String ClassroomDetailActivity = "ClassroomDetailActivity";
	        public static final String ZhiBoDetailActivity = "ZhiBoDetailActivity";
	        public static final String RegisterActivity = "RegisterActivity";
	        public static final String AmendBoundActivity = "AmendBoundActivity";	        
	        public static final String ClassroomOrderTrueOnlineActivity = "ClassroomOrderTrueOnlineActivity";	        
	        public static final String ClassroomPrompt = "ClassroomPrompt";	        
	        public static final String ClassroomOrderTrueActivity = "ClassroomOrderTrueActivity";	        
	    }

    
    public static final class XUtils{
        public static final int databaseVersion = 4;
    }

	public static final int refresh = 11001;  //刷新
	public static final int load = 11002;  //加载


}
