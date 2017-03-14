<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.form-style-1 {
    margin:10px auto;
    max-width: 400px;
    padding: 20px 12px 10px 20px;
    font: 13px "Lucida Sans Unicode", "Lucida Grande", sans-serif;
}
.form-style-1 li {
    padding: 0;
    display: block;
    list-style: none;
    margin: 10px 0 0 0;
}
.form-style-1 label{
    margin:0 0 3px 0;
    padding:0px;
    display:block;
    font-weight: bold;
}
.form-style-1 input[type=text], 
.form-style-1 input[type=date],
.form-style-1 input[type=datetime],
.form-style-1 input[type=number],
.form-style-1 input[type=search],
.form-style-1 input[type=time],
.form-style-1 input[type=url],
.form-style-1 input[type=email],
textarea, 
select{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    border:1px solid #BEBEBE;
    padding: 7px;
    margin:0px;
    -webkit-transition: all 0.30s ease-in-out;
    -moz-transition: all 0.30s ease-in-out;
    -ms-transition: all 0.30s ease-in-out;
    -o-transition: all 0.30s ease-in-out;
    outline: none;  
}
.form-style-1 input[type=text]:focus, 
.form-style-1 input[type=date]:focus,
.form-style-1 input[type=datetime]:focus,
.form-style-1 input[type=number]:focus,
.form-style-1 input[type=search]:focus,
.form-style-1 input[type=time]:focus,
.form-style-1 input[type=url]:focus,
.form-style-1 input[type=email]:focus,
.form-style-1 textarea:focus, 
.form-style-1 select:focus{
    -moz-box-shadow: 0 0 8px #88D5E9;
    -webkit-box-shadow: 0 0 8px #88D5E9;
    box-shadow: 0 0 8px #88D5E9;
    border: 1px solid #88D5E9;
}
.form-style-1 .field-divided{
    width: 49%;
}

.form-style-1 .field-long{
    width: 100%;
}
.form-style-1 .field-select{
    width: 100%;
}
.form-style-1 .field-textarea{
    height: 100px;
}
.form-style-1 input[type=submit], .form-style-1 input[type=button]{
    background: #4B99AD;
    padding: 8px 15px 8px 15px;
    border: none;
    color: #fff;
}
.form-style-1 input[type=submit]:hover, .form-style-1 input[type=button]:hover{
    background: #4691A4;
    box-shadow:none;
    -moz-box-shadow:none;
    -webkit-box-shadow:none;
}
.form-style-1 .required{
    color:red;
}
</style>

 <script src="${pageContext.request.contextPath}/js/jquery_Version_1_10_2.min.js"></script>
	<script>
	var consumerList='${consumerList}'
	$(function(){
		$.fn.serializeObject = function()
    	{
    	   var o = {};
    	   var a = this.serializeArray();
    	   $.each(a, function() {
    	       if (o[this.name]) {
    	           if (!o[this.name].push) {
    	               o[this.name] = [o[this.name]];
    	           }
    	           o[this.name].push(this.value || '');
    	       } else {
    	           o[this.name] = this.value || '';
    	       }
    	   });
    	   return o;
    	};
		JSON.parse(consumerList).forEach(function(k,val){
			//alert(k.consumerDeviceNotificationId);
				var option="<option data-id="+k.id.id+" value="+k.consumerDeviceNotificationId+">"+k.consumerName+"</option>"
				$("#receiverFCMKey").append(option);
			});
$("#notificationformbtn").click(function(){
	var addresobj=new Object();
	var option=$("#receiverFCMKey option:selected")[0];
	var consumerId=parseInt(option.dataset.id);
	 /*  addresobj["delivery_type"]= "APARTMENT");
	  addresobj["apartment_name"]= "";
	  addresobj["apartment_floor"]= "";
	  addresobj["street_name"]= ""; */
	  
	 /*  addresobj["delivery_type"]= "OFFICE";
	  addresobj["office_name"]="";
	  addresobj["office_floor"]="";
	  addresobj["street_name"]="";
	  
	  addresobj["delivery_type"]="HOTEL";
	  addresobj["hotel_name"]="";
	  addresobj["street_name"]=""; */
	  
	  addresobj["delivery_type"]="HOME";
	  addresobj["door_number"]="70";
	  addresobj["street_name"]="SALEM MAIN ROAD";
	var addressObj=new Object();
	addressObj["addressHeader"]="TEST HEADER";
	addressObj["consumerFullName"]="VARADHARAJAN RAJARAM"
	addressObj["consumerHouseNo"]="70"
	addressObj["livingType"]="APARTMENT"
	addressObj["addressAsJson"]=JSON.stringify(addresobj)
	addressObj["consumerProfileId"]=6421147906211840;
	addressObj["consumerLocLat"]="32.83"
	addressObj["consumerLocLang"]="45.12";
	addressObj["consumerStreetName"]="SALEM MAIN ROAD";
	
	   var notificationObject=new Object();
	  notificationObject["title"]=$("#title").val();
	  notificationObject["body"]=$("#body").val();
	  notificationObject["click_action"]="NOTIFICATION_BOOTH";
	 var notificationEntity= $("#notificationform").serializeObject();
	 notificationEntity["notificationPayLoad"]=JSON.stringify(notificationObject);
	 var dataObj=new Object();
	 dataObj["key1"]="VALUE1";
	 dataObj["key2"]="VALUE2";
	 dataObj["key3"]="VALUE3";
	 
	 var dataPayloadObj =new Object();
	 dataPayloadObj["title"]=$("#title").val();
	 dataPayloadObj["body"]= $("#body").val();
	 dataPayloadObj["sound"]= "default";
	 dataPayloadObj["image"]= "bootleicon";
	 dataPayloadObj["click_action"]= "NotificationListActivity.class";
	 dataPayloadObj["data"]=JSON.stringify(dataObj);
	 notificationEntity["dataPayLoad"]=JSON.stringify(dataPayloadObj);
	 notificationEntity["receiverId"]=consumerId;
	 delete notificationEntity.body;
	 delete notificationEntity.title;
	 delete notificationEntity.field5; 
	 var consumerObj=new Object();
	// consumerObj.consumerProfileId=JSON.parse(consumerList)[0].id.id;
	
	 /* Object.keys(JSON.parse(consumerList)[0]).forEach(function(k,v){
		 if(k!="id")
		 delete consumerObj[k];
		 }); */
	 //consumerObj.consumerProfileId=consumerObj.id.id;
	// delete consumerObj.id;
	 
	// consumerObj.consumerFirstName="Varadharajan Rajarm";
	consumerObj.consumerName="TestDeveloper";
	consumerObj.consumerPhoneNumber="8754694454";
	consumerObj.consumerPassword="testpassword";
	//consumerObj.consumerRegistredDate"
	consumerObj.consumerDeviceName="LENOVO";
	consumerObj.consumerDeviceId="b16ac8e1ff1e5ad";
	consumerObj.consumerDeviceNotificationId="ffWboBANp-s:APA91bHql9koza6V7mI1iZhcNjTirL9PeYk9Pm9-YAIoaF-OM108plgg0R00Uny7qJJijgYUaNPbch7E2TokSu2z2HjcsI_XmyFQICx5NU1RexxztSjIPgsegdae3FMhW_ZuihSAfZ8Y";
	consumerObj.consumerDeviceModel="Lenovo A536";
	consumerObj.consumerLastName="Rajaram";
									
	//consumerObj.consumerProfileId=6298002603900928;
	consumerObj.consumerDOB="";
	//consumerObj.consumerFirstName="Varadharajan Rajarm";
	//save-new-consumer
	//consumer-new-address
	var passwordJsonObj=new Object();
	//http://virranbi.appspot.com//rest/send-notification-to-phone
	passwordJsonObj["consumer_username"]="8754694454";
	passwordJsonObj["consumer_pwd"]="testpassword";
			 $.ajax({
    headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    'type': 'POST',
    'url': 'http://localhost:8888/rest/send-notification-to-phone',
    'data': JSON.stringify(notificationEntity),
    'dataType': 'json',
    success:function(data){
    	alert(JSON.stringify(data));
    },error:function(data){
    	alert(data)
    }
    
    });; 
		});
	});
	</script>
</head>
<body>
<form id="notificationform">
<ul class="form-style-1">
   <!--  <li><label>Sender Name<span class="required">*</span></label><input type="text" name="field1" class="field-divided" placeholder="First" />&nbsp;<input type="text" name="field2" class="field-divided" placeholder="Last" /></li> -->
    <li>
        <label>Title <span class="required">*</span></label>
        <input type="text" name="title" id="title" class="field-long" />
    </li>
    <li>
        <label>Body <span class="required">*</span></label>
        <input type="text" name="body" id="body" class="field-long" />
        <input type="hidden" name="senderFCMKey" value="AIzaSyAgkYqRK8en_kT4m_HwNdm8NxlisqSyUzQ" class="field-long" />
    </li>
    <li>
        <label>Customers</label>
        <select name="receiverFCMKey" id="receiverFCMKey" class="field-select">
        
        </select>
    </li>
    <li>
        <label>Subject</label>
        <select name="notificationType" id="notificationType" class="field-select">
        <option value="booking_confirm">BOOKING CONFIRM</option>
        <option value="order_on_the_way">ORDER ON THE WAY</option>
        <option value="offer">OFFER</option>
        <option value="alert">ALERT</option>
        <option value="common_message">COMMON MESSAGE</option>
        
        </select>
    </li>
   <!--  <li>
        <label>Your Message <span class="required">*</span></label>
        <textarea name="field5" id="field5" class="field-long field-textarea"></textarea>
    </li> -->
    <li>
        <input type="button" id="notificationformbtn" value="Submit" />
    </li>
</ul>
</form>
</body>
</html>