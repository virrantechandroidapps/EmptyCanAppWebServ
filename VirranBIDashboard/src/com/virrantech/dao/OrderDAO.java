package com.virrantech.dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.virrantech.entity.CartInfoEntity;
import com.virrantech.entity.OrderInfoEntity;

public interface OrderDAO {

  public JsonObject saveOrder(OrderInfoEntity orderInfoEntity)throws Exception;
  public JsonObject saveCart(CartInfoEntity cartInfoEntity);
  public JsonArray findOrdersbyConsumerId(long consumerKey,int rangeFrom,int rangeTo);
  public long updateUserRefferalCode(long benificaryId,String status,String redeemStatus);
  public int findOrderListSizeByConsumerId(long consumerId);
  public String findCartsByOrderId(long orderId);
  public JsonObject cancelOrder(long orderId,String cancelledBy);
  //Retail solutions Methods
  public String getRecentOrders(long distributorId,String status);
  
}
