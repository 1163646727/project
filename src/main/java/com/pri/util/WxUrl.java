package com.pri.util;

 /**
  * @ClassName:      WxUrl
  * @Description:
  * @author:         ChenQi
  * @CreateDate:     2019/5/5 13:26
  */
public class WxUrl {

    public static final String APP_SECRET="d7bb88ae4c2c5531c358992a2f790e68";
    public static final String APP_ID="wxbd5334d32503ecd7";
    public static final String MEACH_ID="1495709582";
    public static final String KEY=" Pass4XcxforAPIDS2019forAPIDS2019";
	
	
	/*获取openId*/
	public static final String GET_USER_INFO_URL="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
   
	/*获取token*/
	public static final String GET_ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /*创建微信二维码*/
	public static final String GET_WXACodeUNLIMIT_URL="https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN";

    /*发送模板消息*/
	public static final String SEND_TEMP="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";
}
