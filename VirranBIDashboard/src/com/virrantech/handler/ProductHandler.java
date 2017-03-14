package com.virrantech.handler;



import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.ByteBuffer;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsOutputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.virrantech.dao.ConsumerDAO;
import com.virrantech.dao.ProductDAO;
import com.virrantech.daoimpl.ConsumerDAOImpl;
import com.virrantech.daoimpl.ProductDAOImpl;
import com.virrantech.entity.GroceryInfo;
import com.virrantech.entity.GroceryInfoEntity;
import com.virrantech.entity.NotificationEntity;
import com.virrantech.entity.ProductCategoryEntity;
import com.virrantech.entity.ProductEntity;
import com.virrantech.utills.Constants;
import com.virrantech.utills.DateUtilities;
import com.virrantech.utills.NotificationUtills;
import com.virrantech.utills.SpringBeanUtils;

public class ProductHandler {
  private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

  String[] category1={"BABY FOODS","baby care","diapers",
      "Breads","bakery","flour","rice","candies","Cosmetics",
      "Dairy","eggs","Delicatessen foods","Diet foods","Flowers",
      "Frozen foods","fruits" ," vegetables","House-cleaning","Housewares","dishware",
      "cooking utensils","Laundry ","Meats",
      "seafoods","Medicines","Personal Care",
      "Personal hygiene and grooming ","Pet foods","Snack foods","Toys ","novelties"};
  String[] category2={" Fruits and  Vegetables ","Grocery and  Staples "," Bread  Dairy and Eggs ",
      "Beverages "," Branded  Foods "," Personal  Care "," Household "," Imported and Gourmet "," Meat ",
       "Toor Dal","Health Drinks","Sunflower Oils","Chocolate","Other Fruits",
       "Whole Spices","Other Vegetables","Shampoo","Toothpaste","Toilet Cleaners",
       "Flakes","Glucose, Marieand Milk Biscuits","Daipers and Wipes","Mango Juices"};
  public static Connection myConnection=null;
  public static String baseBucketName="/gs/virranbi.appspot.com/Grocery Images";
  public static String jsonUrl="http://localhost:8888/js/grocery_info.json";
  public String addNewProduct(ProductEntity productEntity,HttpServletRequest request){
    JsonObject  result=null;
     try{
     
       ProductDAO  productDao=(ProductDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "productDAOImpl",request);
       result=  productDao.saveProduct(productEntity);
     }catch(Exception e){
       result=new JsonObject();
       result.addProperty("status", "error");
       e.printStackTrace();
     }
   
   return result.toString();
 }
  
  public JsonArray getAllDistributorProducts(Long distributorId,HttpServletRequest request){
    JsonArray resultArry=null;
      try{
        ProductDAO  productDao=(ProductDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "productDAOImpl",request);
        resultArry=  productDao.findProductsByDistributor(distributorId);
       if(resultArry==null)
         resultArry=new JsonArray();
      }catch(Exception e){
        e.printStackTrace();
      }
      return resultArry;
    }
  public String addNewProductCategory(ProductCategoryEntity categoryEntity,HttpServletRequest request){
    JsonObject  result=null;
     try{
     
       ProductDAO  productDao=(ProductDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "productDAOImpl",request);
       result=  productDao.saveProductCategory(categoryEntity);
     }catch(Exception e){
       result=new JsonObject();
       result.addProperty("status", "error");
       e.printStackTrace();
     }
   
   return result.toString();
 }
  
  public String saveGroceryInfo(GroceryInfoEntity groceryInfo,HttpServletRequest request){
    JsonObject  result=null;
    try{
    
      ProductDAO  productDao=(ProductDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "productDAOImpl",request);
      result=  productDao.saveGroceryInfo(groceryInfo);
    }catch(Exception e){
      result=new JsonObject();
      result.addProperty("status", "error");
      e.printStackTrace();
    }
  
  return result.toString();
  }
  public JsonObject addProductToMaster(String itemName,String itemAvailble,long shopId,HttpServletRequest request){
    GroceryInfoEntity  groceryInfoEntity=null;
    JsonObject  result=null;
    try{
    
      ProductDAO  productDao=(ProductDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "productDAOImpl",request);
      System.out.println("hello");
      groceryInfoEntity=  productDao.findGroceryByItemName(itemName);
    
      result=new JsonObject();
      if(groceryInfoEntity!=null && itemAvailble.equals("TRUE")){
        groceryInfoEntity.setIsItemAvailable(itemAvailble);
        ProductEntity productEntity=new ProductEntity();
        productEntity.setProductName(groceryInfoEntity.getItemName());
        productEntity.setProductImgUrl(groceryInfoEntity.getItemImage());
        productEntity.setProductBrandName(groceryInfoEntity.getItemBrandName());
        productEntity.setProductCategoryName(groceryInfoEntity.getItemCategoryName());
        productEntity.setProductFullName(groceryInfoEntity.getItemFullName());
        productEntity.setDistributorId(shopId);
        productEntity.setProductPrice(randInt(40,300));
        productEntity.setProductAvailable(itemAvailble);
        productEntity.setProductId(groceryInfoEntity.getId().getId());
        productDao.saveProduct(productEntity);
        productDao.updateGroceryItem(groceryInfoEntity);
        result.addProperty("status", "success");
      }else if(groceryInfoEntity!=null && itemAvailble.equals("FALSE")){
        groceryInfoEntity.setIsItemAvailable(itemAvailble);
        result= productDao.updateGroceryItem(groceryInfoEntity);
        result= productDao.deleteProduct(groceryInfoEntity.getId().getId());
      }else{
        result.addProperty("status", "fail");
      }
    }catch(Exception e){
      result=new JsonObject();
      result.addProperty("status", "error");
      e.printStackTrace();
    }
  
  return result;
  }
  public static float randInt(int min, int max) {
    Random rand = new Random();
    float randomNum = rand.nextFloat()* (max  -min ) + min;
    randomNum=Float.parseFloat(String.format("%.02f",randomNum));


    return randomNum;
}
  public void sendProductUpdateNotification(JsonArray jsonArray,HttpServletRequest request,long consumerKey){
    try{
      ConsumerHandler consumerHandler=new ConsumerHandler();
     String referrerFcmId= consumerHandler.getLatestFcmId(consumerKey, request);
     if(referrerFcmId.equals("")){
       ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
       referrerFcmId=    consumerDAO.findConsumerById(consumerKey).getConsumerDeviceNotificationId();
       
       
     }
      JSONObject dataPayloadObj =new JSONObject();
      
      dataPayloadObj.put("title","Products Updation Alert");
      dataPayloadObj.put("body","We revised our product catalog since \n "+DateUtilities.getCurrentDateAsString(DateUtilities.DD_MON_YYYY_HH_MM_SS)+" plese check the revised price of \n the latest product");
      dataPayloadObj.put("sound","default");
      dataPayloadObj.put("image","bootleicon");
      dataPayloadObj.put("click_action","NotificationListActivity.class");
      dataPayloadObj.put("data", jsonArray.toString());
      NotificationEntity notificationEntity=new NotificationEntity();
      notificationEntity.setReceiverFCMKey(referrerFcmId);
      notificationEntity.setReceiverId(consumerKey);
      notificationEntity.setNotificationType(Constants.NOTI_OFFER);
      notificationEntity.setSenderFCMKey(Constants.FIREBASE_CUSTOMER_FCM_KEY);
      notificationEntity.setDataPayLoad(dataPayloadObj);
      NotificationUtills.composeNotification(notificationEntity);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public JSONArray getProducts(String categoryName,HttpServletRequest request,HttpServletResponse response){
   JSONArray jsonArray=new JSONArray();
    try{
     ResultSet resultSet= (ResultSet) getConnection().createStatement().executeQuery("SELECT product_category, "
         + "product_brand, img_title, img_src, "
          + "column1, column2 FROM grocery_info WHERE  product_category='"+categoryName+"'");
     while(resultSet.next()){
       JSONObject jsonObj=new JSONObject();
      // GroceryInfoEntity groceryInfoEntity=new GroceryInfoEntity();
       String categoryNameee=resultSet.getString("product_category");
       String image_name=resultSet.getString("column2");
       jsonObj.put("product_category",  categoryNameee);
       jsonObj.put("product_brand",resultSet.getString("product_brand"));
       jsonObj.put("img_title",resultSet.getString("img_title"));
       jsonObj.put("img_src",resultSet.getString("img_src"));
       jsonObj.put("qualified_name",resultSet.getString("column1"));
       jsonObj.put("image_name",resultSet.getString("column2"));
       /*groceryInfoEntity.setItemName(resultSet.getString("column1"));
       groceryInfoEntity.setItemFullName(resultSet.getString("img_title"));
       groceryInfoEntity.setItemBrandName(resultSet.getString("product_brand"));
       groceryInfoEntity.setItemCategoryName(categoryNameee);
       groceryInfoEntity.setItemCost(0L);*/
       
       //returnBlobKey("C:\\Application Developments\\Grocery Images\\"+categoryNameee+"\\"+image_name+"",image_name,response);
      
      // String imageServingUrl=   getBlobKey(categoryName,image_name);
        //groceryInfoEntity.setItemImage(imageServingUrl);
     //  jsonObj.put("image_url",imageServingUrl);
       jsonArray.put(jsonObj);
      // saveGroceryInfo(groceryInfoEntity,request);
     }
    }catch(Exception e){
      e.printStackTrace();
    }
    return jsonArray;
  }
  
  public JsonArray getGroceryInfoByCategoryName(String categoryName,HttpServletRequest request){
  JsonArray resultArray=null;
    try{
      ProductDAO  productDao=(ProductDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "productDAOImpl",request);
      resultArray=productDao.findGroceryInfoByCategory(categoryName);
    }catch(Exception e){
      e.printStackTrace();
    }
    return resultArray;
  }
  public Connection getConnection(){
    try{  
      if(myConnection==null){
        
      Class.forName("com.mysql.jdbc.Driver");  
      myConnection=(Connection) DriverManager.getConnection(  
      "jdbc:mysql://162.211.109.215:3306/grocerydb","grocerydb","grocerydb");  
     
      }else{
       return  myConnection;
      //here sonoo is database name, root is username and password  
      
  }
    }catch(Exception e){
      e.printStackTrace();
    }
    return  myConnection;
  }
  
 public String writeToBucket(String filePath,String fileName,HttpServletResponse response){
   String photoUrl="";
   try{
     BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

     ImagesService imagesService = ImagesServiceFactory.getImagesService();
     File fileObj=new File(filePath);
     // byte[] data=   Files.readAllBytes(fileObj.toPath());
         //FileInputStream fileInputStream=new FileInputStream(fileObj);
         byte[] squareCardImageBytes = new byte[(int)fileObj.length()];
     String bucket = "card-image-bucket";
     String gcsCardObjectName =fileName ;
     String gcsPath = "/gs/" + bucket + "/" + gcsCardObjectName;
     GcsFilename gcsCardFilename = new GcsFilename(bucket, gcsCardObjectName);
     GcsFileOptions gcsOptions = new GcsFileOptions.Builder().mimeType("image/jpg").build();
     GcsService gcsService = GcsServiceFactory.createGcsService();
     GcsOutputChannel outputChannel = gcsService.createOrReplace(gcsCardFilename, gcsOptions);
     outputChannel.write(ByteBuffer.wrap(squareCardImageBytes));
    

     //generate a blobkey for the GCS object.
     //this is a little different because the blobkey is based off the GCS filename
     //and it doesn't actually check that the object exists in GCS so it's fast and immediately available
     BlobKey cardBlobKey = blobstoreService.createGsBlobKey(gcsPath);
    //blobstoreService.
     String keyString= cardBlobKey.getKeyString();     //generate the two image URLs
     BlobKey blobKeey=new BlobKey(keyString);
     System.out.println(keyString);
   // System.out.println( getImageURL("/gs/virranbi.appspot.com/Grocery Images/beverages/100006629_2-horlicks-junior-health-nutrition-drink-original-flavor-stage-1-2-3-years.jpg"));
     //blobstoreService.serve(cardBlobKey, response);
     //photoUrl = imagesService.getServingUrl(cardBlobKey, true);       
    /* ServingUrlOptions options = ServingUrlOptions.Builder.withBlobKey(blobKeey).secureUrl(false);
     photoUrl = imagesService.getServingUrl(
         ServingUrlOptions.Builder.withBlobKey(blobKeey));
     String servingUrl = ImagesServiceFactory.getImagesService().getServingUrl(options);

      photoUrl = imagesService.getServingUrl(
      ServingUrlOptions.Builder.withBlobKey(cardBlobKey));
     String cardUrl = imagesService.getServingUrl(
      ServingUrlOptions.Builder.withBlobKey(cardBlobKey));*/
     outputChannel.close();
   }catch(Exception e){
     e.printStackTrace();
   }
   
   return photoUrl;
  }
 
 public String getBlobKey(String categoryName,String imageName){
   String url="";
   try{
    // imageName="100006629_2-horlicks-junior-health-nutrition-drink-original-flavor-stage-1-2-3-years.jpg";
     GcsFilename gcsCardFilename = new GcsFilename(baseBucketName+"/"+categoryName.trim()+"/"+imageName.trim(), imageName);
     BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
     
     BlobKey blobKey= blobstoreService.createGsBlobKey(baseBucketName+"/"+categoryName.trim()+"/"+gcsCardFilename.getObjectName());
     blobstoreService.createUploadUrl(baseBucketName+"/"+categoryName.trim()+"/"+gcsCardFilename.getObjectName());
     url= getImageURL(baseBucketName+"//"+categoryName.trim()+"//"+imageName.trim(),blobKey);
    
   }catch(Exception e){
     e.printStackTrace();
   }
   
   return url;
 }
 public static String getImageURL(String inFilename,BlobKey blobKey) {
   String key = inFilename;
   ImagesService imagesService = ImagesServiceFactory.getImagesService();
   ServingUrlOptions options =     ServingUrlOptions.Builder.withBlobKey(blobKey);
 //  options.blobKey(blobKey);
   String servingUrl = imagesService.getServingUrl(options);

   return servingUrl;
}
 public void readJsonFile(String jsonUrl,HttpServletRequest request){
   try{
    /*  GroceryInfoEntity REVIEW_TYPE = (GroceryInfoEntity) new TypeToken<List<GroceryInfoEntity>>() {
     }.getType();*/
     Gson gson = new Gson();
     URL url = new URL("http://virranbi.appspot.com/js/grocery_info.json");

     ObjectMapper mapper = new ObjectMapper();

     /*
      * This allows the ObjectMapper to accept single values for a collection.
      * For example: "location" property in the returned JSON is a collection that 
      * can accept multiple objects but, in deserialization process, this property just 
      * have one object and causes an Exception.
      */
     mapper.configure(Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

     /* 
      * If some JSON property is not present, avoid exceptions setting
      * FAIL_ON_UNKNOWN_PROPERTIES to false 
      */
     mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

     /* Get all computers */
     List<GroceryInfo> groceryInfoEntityList = mapper.readValue(url, new TypeReference<List<GroceryInfo>>(){});
     //System.out.println(groceryInfoEntityList);
      int length=groceryInfoEntityList.size();
      for(int s=0;s<length;s++){
        GroceryInfoEntity groceryInfoEntity=new GroceryInfoEntity();
        GroceryInfo groceryInfo= (GroceryInfo)groceryInfoEntityList.get(s);
       // String imageName= groceryInfo.getColumn2();
        String brandName=groceryInfo.getProduct_brand();
        String categoryName= groceryInfo.getProduct_category();
      //String imageSrcName=groceryInfo.getColumn2();
        groceryInfoEntity.setItemBrandName(  brandName);
        groceryInfoEntity.setItemCategoryName(  categoryName);
        groceryInfoEntity.setItemFullName(groceryInfo.getImg_title());
        groceryInfoEntity.setItemName(groceryInfo.getColumn1().replace(brandName, ""));
        groceryInfoEntity.setItemImage(groceryInfo.getImg_src());
       // groceryInfoEntity.setItemImage(getBlobKey(categoryName,imageSrcName));
        
        saveGroceryInfo(groceryInfoEntity,request);
        ///TimeUnit.SECONDS.sleep(2);
        System.out.println("waiting....");
      }
      
/*
     InputStream is = new URL(jsonUrl).openStream();
     BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
     
     BufferedReader br = new BufferedReader(
         new FileReader("jsonUrl"));

     //convert the json string back to object
     JSONArray obj = gson.fromJson(rd, JSONArray.class);

     System.out.println(obj);
     String jsonText = readAll(rd);
      JSONObject jsonObject=new JSONObject(jsonText);
      System.out.println(jsonObject);*/
    
   /* Type REVIEW_TYPE=  new TypeToken<List<GroceryInfoEntity>>() {}.getType();
   //  Gson gson = new Gson();
    ClassLoader classLoader = getClass().getClassLoader();

     JsonReader reader = new JsonReader(new FileReader(jsonUrl ));
   
    List<GroceryInfoEntity> data = gson.fromJson(reader, (Type) REVIEW_TYPE); // contains the whole reviews list
    System.out.println(data);*/
   }catch(Exception e){
     e.printStackTrace();
   }
 }
 private static String readAll(Reader rd) throws IOException {
   StringBuilder sb = new StringBuilder();
   int cp;
   while ((cp = rd.read()) != -1) {
     sb.append((char) cp);
   }
   return sb.toString();
 }
}
 

