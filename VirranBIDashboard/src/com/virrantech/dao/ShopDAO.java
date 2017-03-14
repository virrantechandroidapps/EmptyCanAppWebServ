package com.virrantech.dao;

import com.google.gson.JsonObject;
import com.virrantech.entity.ShopInfo;

public interface ShopDAO {
  public JsonObject saveShop(ShopInfo shopInfo);
  public ShopInfo findShopInfoById(long shopId);
}
