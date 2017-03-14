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
		$("#offerNameli").hide();
		$("#offerEndDateli").hide();
		$("#productDiscountPercentageli").hide();
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
$("#productformbtn").click(function(){
	
	 var productForm= $("#productdefform").serializeObject();
	 productForm["productBrandName"]="test";
	 productForm["productCategoryName"]="test";
	 productForm["productFullName"]="test";
	 productForm["productId"]=23432432;
	 productForm.distributorId=123456
			 $.ajax({
    headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    'type': 'POST',
    'url': 'http://localhost:8888/rest/save-new-product',
    'data': JSON.stringify(productForm),
    'dataType': 'json',
    success:function(data){
    	alert(JSON.stringify(data));
    },error:function(data){
    	alert(data)
    }
    
    });; 
		});
		
	});
	
	function callDiscountChange(obj){
		if(obj.value=="OFFER"){
			$("#offerNameli").show();
			$("#offerEndDateli").show();
			$("#productDiscountPercentageli").hide();
		}else if(obj.value=="DISCOUNT"){
			$("#offerNameli").hide();
			$("#offerEndDateli").hide();
			$("#productDiscountPercentageli").show();
		}else{
			$("#offerNameli").hide();
			$("#offerEndDateli").hide();
			$("#productDiscountPercentageli").hide();
		}
	}
	</script>
</head>
<body>
<form id="productdefform">
<ul class="form-style-1">
   <!--  <li><label>Sender Name<span class="required">*</span></label><input type="text" name="field1" class="field-divided" placeholder="First" />&nbsp;<input type="text" name="field2" class="field-divided" placeholder="Last" /></li> -->
    <li>
        <label>Product Name <span class="required">*</span></label>
        <input type="text" name="productName" id="productName" class="field-long" />
    </li>
    <li>
        <label>Product Qty Type</label>
        <select name="productQtyType" id="productQtyType" class="field-select">
        <option value="KG">Kilo Gram</option>
        <option value="LITER">Liter</option>
      </select>
    </li>
     <li>
        <label>Product Quantity <span class="required">*</span></label>
        <input type="text" name="productQty" id="productQty" class="field-long" />
    </li>
    <li>
        <label>Product Price <span class="required">*</span></label>
        <input type="text" name="productPrice" id="productPrice" class="field-long" />
    </li>
    <li>
        <label>Product Manufacturing Date <span class="required">*</span></label>
        <input type="date" name="productManufacturingDate" id="productManufacturingDate" class="field-long" />
    </li>
    <li>
        <label>Product Expiry Date <span class="required">*</span></label>
        <input type="date" name="productExpiryDate" id="productExpiryDate" class="field-long" />
    </li>
     <li>
        <label>Product Discount Type</label>
        <select name="discountType" id="discountType" class="field-select" onchange="callDiscountChange(this);">
        <option value="NONE">No Discount or Offer</option>
        <option value="OFFER">Offer Type</option>
        <option value="DISCOUNT">Discount Type</option>
      </select>
    </li>
     <li id="productDiscountPercentageli">
        <label>Product Discount Percentage <span class="required">*</span></label>
        <input type="text" name="productDiscountPercentage" id="productDiscountPercentage" class="field-long" />
        <input type="hidden" name="productImgUrl" value="http://virranbi.appspot.com/images/Can.png" class="field-long" />
        <input type="hidden" name="distributorId" id="distributorId" value=123456 />
        
    </li>
     <li id="offerNameli">
        <label>Offer Name<span class="required">*</span></label>
        <input type="text" name="offerName" id="offerName" class="field-long" />
    </li>
     <li id="offerEndDateli">
        <label>Offer end date<span class="required">*</span></label>
        <input type="date" name="offerEndDate" id="offerEndDate" class="field-long" />
    </li>
    
    
    
   <!--  <li>
        <label>Your Message <span class="required">*</span></label>
        <textarea name="field5" id="field5" class="field-long field-textarea"></textarea>
    </li> -->
    <li>
        <input type="button" id="productformbtn" value="Submit" />
    </li>
</ul>
</form>
</body>
</html>