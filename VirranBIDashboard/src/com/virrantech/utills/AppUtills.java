package com.virrantech.utills;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

public class AppUtills {
  public static String getURLWithContextPath(HttpServletRequest request) {
    return request.getScheme() + "://" + getIpAddress() + ":" + request.getServerPort() + request.getContextPath();
 }
  
  public static String getIpAddress(){
    String serverIpAddress="";
    try{
      InetAddress inetAddress = InetAddress.getLocalHost();
      serverIpAddress = inetAddress.getHostAddress();
      }catch(Exception e){
      e.printStackTrace();
    }
    
    return serverIpAddress;
  }
  public double distance(Double srcLatitude, Double srcLongitude, double e, double f) {
    double d2r = Math.PI / 180;

    double dlong = (srcLongitude - f) * d2r;
    double dlat = (srcLatitude - e) * d2r;
    double a = Math.pow(Math.sin(dlat / 2.0), 2) + Math.cos(e * d2r)
            * Math.cos(srcLatitude * d2r) * Math.pow(Math.sin(dlong / 2.0), 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double d = 6367 * c;
            return d;

}
  private  static double meterDistanceBetweenPoints(float lat_a, float lng_a, float lat_b, float lng_b) {
    float pk = (float) (180.f/Math.PI);

    float a1 = lat_a / pk;
    float a2 = lng_a / pk;
    float b1 = lat_b / pk;
    float b2 = lng_b / pk;

    float t1 = (float) (Math.cos(a1)*Math.cos(a2)*Math.cos(b1)*Math.cos(b2));
    float t2 = (float) (Math.cos(a1)*Math.sin(a2)*Math.cos(b1)*Math.sin(b2));
    float t3 = (float) (Math.sin(a1)*Math.sin(b1));
    double tt = Math.acos(t1 + t2 + t3);

    return 6366000*tt;
}
  public static void main(String args[]){
  System.out.println( new AppUtills().distance(12.984695,80.2190767,12.9872635f,80.205323f));
  }
}
