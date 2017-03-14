package com.virrantech.utills;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;










import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.virrantech.entity.NotificationEntity;

public class NotificationUtills {
  
  public static JSONObject composeNotification(NotificationEntity notificationEntity){
    JSONObject notificationObj=null;
    JSONObject result=null;
    try{
      if(notificationEntity!=null){
        notificationObj=  new JSONObject();
        notificationObj.put("to", notificationEntity.getReceiverFCMKey());
      // notificationObj.put("notification", notificationEntity.getNotificationPayLoad());
        JSONObject dataPayload=  notificationEntity.getDataPayLoad();
        notificationEntity.setDataPayLoadString(StringEscapeUtils.escapeJavaScript(dataPayload.toString()));
        notificationEntity.setTitle(dataPayload.has("title")?dataPayload.getString("title"):"");
        notificationEntity.setBody(dataPayload.has("body")?dataPayload.getString("body"):"");
        notificationEntity.setClickAction(dataPayload.has("click_action")?dataPayload.getString("click_action"):"" );
        notificationEntity.setMessage(dataPayload.has("body")?dataPayload.getString("body"):"");
        dataPayload.put("click_action",notificationEntity.getClickAction());
        dataPayload.put("noti_img_url",notificationEntity.getNotificationImageUrl());
        //dataPayload.put("", notificationEntity.getNot)
        notificationObj.put("data", dataPayload);
        notificationObj.put("sender_fcm_key", notificationEntity.getSenderFCMKey());
        notificationObj.put("notification_url","http://virranbi.appspot.com/images/bell.png");
        result=new JSONObject(sendNotification(notificationObj));  
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return result;
  }
  public static  JsonObject sendNotification(JSONObject notificationObj){
    URL url=null;
    BufferedReader bufferedInput = null;
    HttpURLConnection webServiceConn=null;
    OutputStreamWriter wr=null;
    JsonObject  fcmResponse=null;
    try{
      if(notificationObj!=null){
        url = new URL(Constants.FMCurl);
        webServiceConn = (HttpURLConnection) url.openConnection();
       webServiceConn.setUseCaches(false);
       webServiceConn.setDoInput(true);
       webServiceConn.setDoOutput(true);
       webServiceConn.setRequestMethod("POST");
       webServiceConn.setRequestProperty("Authorization","key="+notificationObj.get("sender_fcm_key").toString());
       webServiceConn.setRequestProperty("Content-Type","application/json");
        wr = new OutputStreamWriter(webServiceConn.getOutputStream());
       wr.write(notificationObj.toString());
       wr.flush();
       wr.close();
        int responseCode = webServiceConn.getResponseCode();
        bufferedInput = new BufferedReader(new InputStreamReader(webServiceConn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = bufferedInput.readLine()) != null) {
        response.append(inputLine);
        }
             fcmResponse=new JsonObject();
           fcmResponse.addProperty("google_respone", response.toString());
           System.out.println("FCM Response:"+fcmResponse+"\\n response code: "+responseCode);
           bufferedInput.close();
      }
     }catch(Exception e){
      e.printStackTrace();
    }
     return fcmResponse;
  }
  
 
}
