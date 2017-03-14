/**
 * 
 */

function  renderProducts(productListArray){
	var  productSize=productListArray.length;
	if(productSize!=0){
		for(var i=0;i<productSize;i++){
			var productObj=productListArray[i];
			var productInfo="<div class=\"item text-center \" data-productname='"+productObj.productName+"' data-productid="+productObj.id.id+"  data-productqty="+productObj.productQty+" data-productprice="+productObj.productPrice+">"+
		     "<img src=\"images/Can.png\" alt=\"canwater\" style=\"display: initial;\">"+
		     "</div>";
			$("#products-container").append(productInfo);
		}
		$("#products-container>.item:first").addClass("active");
		 var productObj = $('.item.active').data();
         $("#productname").html(productObj.productname);
         $("#productqunatity").html(productObj.productqty+" &#8467;");
         $("#productprice").html("&#8377; "+productObj.productprice);
	}
	
}

function renderProductTbl(cartObject){
	
	//carttblbody
	
	var tableRow =$("tr[data-productid=\""+cartObject.productid+"\"]");
	if(tableRow.length==0){
		 tableRow="<tr  data-key=\"cartPrdctId\" data-productid="+cartObject.productid+" >"+ 
		 	  " <td></td>"+ 
              " <td data-key=\"cartPrdctName\" >"+cartObject.productname+" </td> "+ 
              " <td data-key=\"cartPrdctPrice\">"+cartObject.productprice+"</td> "+ 
              " <td data-key=\"cartPrdctUnit\" data-unit=\"YES\">"+cartObject.unit+"</td> "+ 
              " <td><button class=\"btn btn-default btn-sm\" ><i class=\"glyphicon glyphicon-trash\"></i></button></td>"+ 
           "  </tr>";
		 $("#carttblbody").append(tableRow);
		 $("#carttblbody tr").not("tr[data-productid=\""+cartObject.productid+"\"]").css("background","#fff");
		 $("tr[data-productid=\""+cartObject.productid+"\"]").css("background","#e9ebee");
		
	}else{
		$("tr[data-productid=\""+cartObject.productid+"\"] td[data-unit=\"YES\"]").html(cartObject.unit);
		
	}
	
}

function renderProductDescription(productObj){
	 $("#productname").html(productObj.productname);
     $("#productqunatity").html(productObj.productqty+" &#8467;");
     $("#productprice").html("&#8377; "+productObj.productprice);
     $("#carttblbody tr").not("tr[data-productid=\""+productObj.productid+"\"]").css("background","#fff");
     $("tr[data-productid=\""+productObj.productid+"\"]").css("background","#e9ebee");
 	var produnctUnit= $("tr[data-productid=\""+productObj.productid+"\"] td[data-unit=\"YES\"]");
     if(produnctUnit.length==0){
   	  $("#productcount").val(0);
 		productqty=Number.parseInt($("#productcount").val());
 	}else{
 		$("#productcount").val(produnctUnit.html());
 		//productqty=Number.parseInt(produnctUnit.html());
 	}
}

function  processAddCart(){
	var cartInfoArray=[];
	var totalCash=0;
	$("#carttblbody tr").each(function(k, val) {
		var cartObj = new Object();
		var childrens = $(val).children()
		cartObj[$(val).data("key")] = $(val).data("productid");
		$(childrens).each(function(k, v) {
			var data = $(v).data();
			if(Object.keys(data).length!=0)
			cartObj[data.key] = $(v).html();

		});
		totalCash=totalCash+Number.parseFloat(cartObj.cartPrdctPrice)*Number.parseFloat(cartObj.cartPrdctUnit)
		cartInfoArray.push(cartObj);
	});	
	
	/*orderInfoObj["consumerKey"]
	orderInfoObj["orderAddressId"]
	orderInfoObj["totalPayment"]*/
	if(consumerObj.status != "invalid"){
			orderInfoObj["paymentMode"]="CASH"
			orderInfoObj["consumerKey"]	=consumerObj.consumer_info.rows[0].id.id;
			orderInfoObj["cartInfoList"]=cartInfoArray;
			orderInfoObj["totalPayment"]=Number.parseFloat(totalCash);
			//console.log(orderInfoObj);
			$("#cashmessage").html("Your amount to be paid &#8377; "+Number.parseFloat(totalCash)+" ")
	}
	
	
}

function renderAddressList(addressArray){
	$("#addresssection>div[data-address=true]").remove();
	addressArray.forEach(function(object,v,d){
		var isDefault="";
		if(object.defaultAddress=="YES"){
			isDefault="checked"
		}
		var addressComponent=	"<div class=\"col-md-4\" data-address=\"true\" data-id="+object.id.id+">"+
	    "<div class=\"well\" style=\"background: #fff;\">"+
	      "<h5 style=\"margin-top: 0;padding-left: 5px;\"><b id=\"addresstitlname\">"+object.consumerFullName+"</b></h5>"+
	      "<span class=\"center-block\" style=\"color: #777;line-height: 25px;padding-left: 5px;\" id=\"streetname\"><i class=\"glyphicon glyphicon-map-marker\" style=\"margin-left: -17px;\"></i> "+object.consumerHouseNo+","+object.consumerStreetName+"</span>"+
	      "<span class=\"center-block\" style=\"color: #777;line-height: 25px;padding-left: 5px;\" id=\"locationame\">"+object.locationName+"</span>"+
	     " <span class=\"center-block\" style=\"color: #777;line-height: 25px;padding-left: 5px;\" id=\"districtpincde\">"+object.postalCode+"</span>"+
	      "<span class=\"center-block\" style=\"color: #777;line-height: 25px;padding-left: 5px;\" id=\"contactno\"><i class=\"glyphicon glyphicon-phone\" style=\"margin-left: -17px;\"></i> +91 "+object.contactNumber+"</span>"+
	      "<div class=\"checkbox\">"+
	           " <label>"+
	              "<input type=\"checkbox\" "+isDefault+"> Make Default Address"+
	           " </label>"+
	         " </div>"+
	     " <div class=\"text-center\" style=\"margin-top: 15px;\">"+
	       " <button type=\"button\" data-id="+object.id.id+" name=\"deleteaddress\" class=\"btn btn-danger btn-sm\" style=\"width: 100%;\">Delete</button>"+
	      "</div>"+
	    "</div>"+
	    "</div>";
		$("#addresssection").append(addressComponent);
		$("button[data-id="+object.id.id+"]").click(function(eve){
			var deleteInfo =new Object();
			deleteInfo["consumer_id"]=	Number.parseInt(consumerObj.consumer_info.rows[0].id.id); 
			deleteInfo["consumer_address_id"]=	Number.parseInt(this.dataset.id);
			deleteAddress(deleteInfo);
			eve.preventDefault();
		});
		})

}

function placeOrder(orderInfoData){
	$.ajax({
	    headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
	    'type': 'POST',
	    'url': domainContext+'/rest/consumer-new-order',
	     data:JSON.stringify(orderInfoData),
	    'dataType': 'json',
	    success:function(data){
	    	window.location.href="/launch-main";
	    	//alert(JSON.stringify(data));
	    },error:function(data){
	    	alert(data);
	    }
	    
	    });; 
}
function callSignInFunction(){
	 var formcredentials= $("#emptycanloginform").serializeObject();
	 $.ajax({
		    headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
		    'type': 'POST',
		    'url': domainContext+'/rest/consumer-login-authenticate',
		    'data': JSON.stringify(formcredentials),
		    'dataType': 'json',
		    success:function(data){
		    //	alert(JSON.stringify(data));
		    
		    	if(data.status=="invalid"){
		    		alert("invalid username/password");
		    	}else{
		    		$("#consumer_username").val("");
		    		$("#consumer_pwd").val("");
		    		data["consumer_info"]=JSON.parse(data.consumer_info);
		    		data["products"]=JSON.parse(data.products);
		    		var consumerObject=JSON.stringify(data);
		    		$("#consumerid").val(data.consumer_info.rows[0].id.id);
		    		
		    		$("#emptycanloginform").attr("action","/launch-main");
		    		$("#emptycanloginform").submit();
		    		//alert(JSON.stringify(data))
		    	}
		    },error:function(data){
		    	alert(data)
		    }
		    
		    });
}
function updateProfileInfo(){
	 var formcredentials= $("#personlainfoeditform").serializeObject();
	// formcredentials["consumerProfileId"]=consumerObj.consumer_info.rows[0].id.id;
	 $.ajax({
		    headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
		    'type': 'POST',
		    'url': domainContext+'/rest/consumer-add-basic-profile',
		    'data': JSON.stringify(formcredentials),
		    'dataType': 'json',
		    success:function(data){
		    	
		    	
		    	if(data.status=="success"){
		    		consumerObj.consumer_info.rows[0].consumerName=formcredentials.consumerName;
		    		consumerObj.consumer_info.rows[0].consumerEmailId=formcredentials.consumerEmailId;
		    		consumerObj.consumer_info.rows[0].consumerPhoneNumber=formcredentials.consumerPhoneNumber;
		    		consumerObj.consumer_info.rows[0].consumerDOB=formcredentials.consumerDOB;
		    		consumerObj.consumer_info.rows[0].consumerGender=formcredentials.consumerGender;
		    		 $("#dconsumerusername").html(formcredentials.consumerName!=null?formcredentials.consumerName:"")
	        		  $("#dconsumermailid").html(formcredentials.consumerEmailId!=null?formcredentials.consumerEmailId:"");
	        		 // $("#dconsumerphonenumber").html(formcredentials.consumerPhoneNumber!=null?formcredentials.consumerPhoneNumber:"");
	        		  $("#dconsumerdob").html(formcredentials.consumerDOB!=null?formcredentials.consumerDOB:"");
	        		  $("#dconsumergender").html(formcredentials.consumerGender!=null?formcredentials.consumerGender:"");
		    		alert("data updated successfully");
		    	}
		    	
		    },error:function(data){
		    	alert(data)
		    }
		    
		    });
}
function loadPersonalInfoData(){
	var consumerInfo=consumerObj.consumer_info.rows[0];
	$("#consumerName").val(consumerInfo.consumerName);
	$("#consumerEmailId").val(consumerInfo.consumerEmailId);
	$("#consumerPhoneNumber").val( consumerInfo.consumerPhoneNumber);
	$("#consumerDOB").val(consumerInfo.consumerDOB);
	$("#consumerProfileId").val(Number.parseInt(consumerInfo.id.id));
	$("input[name=consumerGender][value="+consumerInfo.consumerGender+"] ").prop('checked', true);
}
function initMap(){
	
	var locationInput=document.getElementById("locationName");
	 var infowindow = new google.maps.InfoWindow();
	 var infowindowContent = document.getElementById('infowindow-content');
	 infowindow.setContent(infowindowContent);

	 var autocomplete = new google.maps.places.Autocomplete(locationInput);
	 autocomplete.addListener('place_changed', function() {
	     
	     var place = autocomplete.getPlace();
	     if (!place.geometry) {
	       // User entered the name of a Place that was not suggested and
	       // pressed the Enter key, or the Place Details request failed.
	       window.alert("No details available for input: '" + place.name + "'");
	       return;
	     }else{
	    	 
	    	 $.parseHTML(place.adr_address).forEach(function(obj,value,te){
	    		// console.log($(obj).find(".postal-code").text())
	    		 if($(obj).attr("class")=="postal-code"){
	    			 addressObject["postalCode"]=$(obj).text();
	    		 }else if($(obj).attr("class")=="region"){
	    			 addressObject["state"]=$(obj).text();
	    		 }else if($(obj).attr("class")=="country-name"){
	    			 addressObject["countryCode"]=$(obj).text();
	    		 }else if($(obj).attr("class")=="locality"){
	    			 addressObject["district"]=$(obj).text();
	    			 addressObject["consumerCity"]=$(obj).text();
	    		 }else if($(obj).attr("class")=="extended-address"){
	    			 addressObject["consumerAreaName"]=$(obj).text();
	    	    	 addressObject["subArea"]=$(obj).text();
	    		 }

	    		 });
	    	 addressObject["consumerLocLat"]=place.geometry.location.lat();
	    	 addressObject["consumerLocLang"]=place.geometry.location.lng();
	    	 
	    	/* addressObject["consumerAreaName"]
	    	 addressObject["subArea"]
	    	 
	    	
	    	 */
	     }

	     
	   

	     var address = '';
	     if (place.address_components) {
	       address = [
	         (place.address_components[0] && place.address_components[0].short_name || ''),
	         (place.address_components[1] && place.address_components[1].short_name || ''),
	         (place.address_components[2] && place.address_components[2].short_name || '')
	       ].join(' ');
	     }

	    /* infowindowContent.children['place-icon'].src = place.icon;
	     infowindowContent.children['place-name'].textContent = place.name;
	     infowindowContent.children['place-address'].textContent = address;
	     infowindow.open(map, marker);*/
	   });
}

function callLivingType(livingObj){
	/*$("#apartmentName").show();
	$("#apartmentFloor").show();
	$("#officeName").show();
	$("#officeFloor").show();
	$("#officeName").show();
	$("#doorNumber").show();*/
	if(livingObj.value=="HOME"){
		$("#doorNumberdiv").show();
		
		$("#apartmentNamediv").hide();
		$("#apartmentFloordiv").hide();
		$("#officeNamediv").hide();
		$("#officeFloordiv").hide();
		$("#hotelNamediv").hide();
		
		
	}else if(livingObj.value=="APARTMENT"){
		$("#apartmentNamediv").show();
		$("#apartmentFloordiv").show();
		
		$("#officeNamediv").hide();
		$("#officeFloordiv").hide();
		$("#doorNumberdiv").hide();
		$("#hotelNamediv").hide();
		
	}else if(livingObj.value=="OFFICE"){
		$("#officeNamediv").show();
		$("#officeFloordiv").show();
		
		$("#apartmentNamediv").hide();
		$("#apartmentFloordiv").hide();
		$("#hotelNamediv").hide();
		$("#doorNumberdiv").hide();
	}else if(livingObj.value=="HOTEL"){
		$("#hotelNamediv").show();
		
		$("#apartmentNamediv").hide();
		$("#apartmentFloordiv").hide();
		$("#officeNamediv").hide();
		$("#officeFloordiv").hide();
		$("#doorNumberdiv").hide();
	}
}

function saveAddress(){
	var   formObject= $("#cnsumraddressform").serializeObject();
	if($("#defaultAddress").prop('checked')){
		formObject["defaultAddress"]="YES";
	}else{
		formObject["defaultAddress"]="NO";
	}
	
	formObject["postalCode"]=	addressObject.postalCode ;
	formObject["state"]=	addressObject.state;
	formObject["countryCode"]=	addressObject.countryCode;
	formObject["district"]=	addressObject.district ;
	formObject["consumerCity"]=	addressObject.consumerCity;
	formObject["consumerAreaName"]=	addressObject.consumerAreaName;
	formObject["subArea"]=	addressObject.subArea;
	formObject["consumerProfileId"]= consumerObj.consumer_info.rows[0].id.id;
	formObject["consumerLocLat"]=addressObject.consumerLocLat;
	formObject["consumerLocLang"]=addressObject.consumerLocLang;
		// formcredentials["consumerProfileId"]=consumerObj.consumer_info.rows[0].id.id;
		 $.ajax({
			    headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
			    'type': 'POST',
			    'url': domainContext+'/rest/consumer-new-address',
			    'data': JSON.stringify(formObject),
			    'dataType': 'json',
			    success:function(data){
			    	if(data.status=="success"){
			    		 alert("address saved successfully");
			    		refreshAddressList();
			    		
			    	}
			    },error:function(data){
			    	alert(data)
			    }
			    
			    });
}
function refreshAddressList(){
	 $.ajax({
		    headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
		    'type': 'POST',
		    'url': domainContext+'/rest/consumer-address/'+consumerObj.consumer_info.rows[0].id.id+'',
		  
		   'dataType': 'json',
		    success:function(data){
		    	renderAddressList(data);
		    },error:function(data){
		    	alert(data)
		    }
		    
		    });
}

function deleteAddress(deleteInfo){
	 $.ajax({
		    headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
		    'type': 'POST',
		    'url': domainContext+"/rest/delete-consumer-address",
		    'data': JSON.stringify(deleteInfo),
		   'dataType': 'json',
		    success:function(data){
		    	if(data.status='success'){
		    		alert("delete success fully");
		    		refreshAddressList();
		    	}
		    },error:function(data){
		    	alert(data)
		    }
		    
		    });
}