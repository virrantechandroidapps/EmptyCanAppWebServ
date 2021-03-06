package com.virrantech.controllers;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
@Controller

public class CopyOfEmptycanController {

  private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
  @RequestMapping(value="/launch-emptycan-form",method=RequestMethod.GET)
  public String launchNotificationPage(HttpServletRequest request){
   
    System.out.println("calling esignup ");
    return "esignup";
    
  }
 
  @RequestMapping(value="/blob/upload",method=RequestMethod.POST)
  public void getFileToUpload(HttpServletRequest request,HttpServletResponse res){
    try{
      System.out.println("Calling at blob creation");
      List<BlobKey> blobs = blobstoreService.getUploads(request).get("file");
      BlobKey blobKey = blobs.get(0);

      ImagesService imagesService = ImagesServiceFactory.getImagesService();
      ServingUrlOptions servingOptions = ServingUrlOptions.Builder.withBlobKey(blobKey);

      String servingUrl = imagesService.getServingUrl(servingOptions);

      res.setStatus(HttpServletResponse.SC_OK);
      res.setContentType("application/json");

      JSONObject json = new JSONObject();
      json.put("servingUrl", servingUrl);
      json.put("blobKey", blobKey.getKeyString());

      PrintWriter out = res.getWriter();
      out.print(json.toString());
      out.flush();
      out.close();
    }catch(Exception e){
      e.printStackTrace();
    }
   
   
    
  }
 
}
