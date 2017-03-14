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
body {
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
  width: 960px;
  height: 500px;
  position: relative;
}

svg {
	width: 100%;
	height: 100%;
}

path.slice{
	stroke-width:2px;
}

polyline{
	opacity: .3;
	stroke: black;
	stroke-width: 2px;
	fill: none;
}

.labelValue
{
	font-size: 60%;
	opacity: .5;
	
}

.toolTip {
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    position: absolute;
    display: none;
    width: auto;
    height: auto;
    background: none repeat scroll 0 0 white;
    border: 0 none;
    border-radius: 8px 8px 8px 8px;
    box-shadow: -3px 3px 15px #888888;
    color: black;
    font: 12px sans-serif;
    padding: 5px;
    text-align: center;
}
text {
  font: 12px sans-serif;
}
</style>

 <script src="${pageContext.request.contextPath}/js/jquery_Version_1_10_2.min.js"></script>
 <%-- <script src="${pageContext.request.contextPath}/js/d3.v3.min.js"></script> --%>
 <script src="${pageContext.request.contextPath}/js/raphael-2.1.4.min.js"></script>
 <script src="${pageContext.request.contextPath}/js/justgage.js"></script>
	<!-- <script>
	d3.select("input[value=\"total\"]").property("checked", true);

	var svg = d3.select("body")
		.append("svg")
		.append("g")

	svg.append("g")
		.attr("class", "slices");
	svg.append("g")
		.attr("class", "labelName");
	svg.append("g")
		.attr("class", "labelValue");
	svg.append("g")
		.attr("class", "lines");

	var width = 960,
	    height = 450,
		radius = 100;

	var pie = d3.layout.pie()
		.sort(null)
		.value(function(d) {
			return d.value;
		});

	var arc = d3.svg.arc()
		.outerRadius(radius * 0.8)
		.innerRadius(radius * 0.4);

	var outerArc = d3.svg.arc()
		.innerRadius(radius * 0.9)
		.outerRadius(radius * 0.9);

	var legendRectSize = (radius * 0.05);
	var legendSpacing = radius * 0.02;


	var div = d3.select("body").append("div").attr("class", "toolTip");

	svg.attr("transform", "translate(" + width / 2 + "," + height / 2 + ")");

	var colorRange = d3.scale.category20();
	var color = d3.scale.ordinal()
		.range(colorRange.range());


var 	datasetTotal = [
	        		{state:"Category 1", value:19}, 
	                {state:"Category 2", value:5}, 
	                {state:"Category 3", value:13},
	                {state:"Category 4", value:17},
	                {state:"Category 5", value:19},
	                {state:"Category 6", value:27}
	                ];
	/* var piechartData=[];
	piechartData.push({value:22327,state:'AZ'});
	piechartData.push({value:684452,state:'CA'});
	piechartData.push({value:285217,state:'CT'});
	piechartData.push({value:103564,state:'DC'});
	piechartData.push({value:53924,state:'FL'});
	piechartData.push({value:9345,state:'GA'});
	piechartData.push({value:20568,state:'ID'});
	piechartData.push({value:57028,state:'IL'});
	piechartData.push({value:38190,state:'IN'});
	piechartData.push({value:42552,state:'KY'});
	piechartData.push({value:30663,state:'LA'});
	piechartData.push({value:153439,state:'MA'});
	piechartData.push({value:5186,state:'MD'});
	piechartData.push({value:1359,state:'ME'});
	piechartData.push({value:41152,state:'MN'});
	piechartData.push({value:76496,state:'MO'});
	piechartData.push({value:205647,state:'NC'});
	piechartData.push({value:98749,state:'NE'});
	piechartData.push({value:200828,state:'NH'});
	piechartData.push({value:92770,state:'NM'});
	piechartData.push({value:53854,state:'NV'});
	piechartData.push({value:28824,state:'NY'});
	piechartData.push({value:6858,state:'OH'});
	piechartData.push({value:26657,state:'OK'});
	piechartData.push({value:66881,state:'OR'});
	piechartData.push({value:18835,state:'PA'});
	piechartData.push({value:28602,state:'RI'});
	piechartData.push({value:54017,state:'TN'});
	piechartData.push({value:165471,state:'TX'});
	piechartData.push({value:103423,state:'UT'}); */
	change(datasetTotal);


	d3.selectAll("input")
		.on("change", selectDataset);
		
	function selectDataset()
	{
		var value = this.value;
		if (value == "total")
		{
			change(datasetTotal);
		}
		else if (value == "option1")
		{
			change(datasetOption1);
		}
		else if (value == "option2")
		{
			change(datasetOption2);
		}
	}

	function change(data) {

		/* ------- PIE SLICES -------*/
		var slice = svg.select(".slices").selectAll("path.slice")
	        .data(pie(data), function(d){ return d.data.state });

	    slice.enter()
	        .insert("path")
	        .style("fill", function(d) { return color(d.data.state); })
	        .attr("class", "slice");

	    slice
	        .transition().duration(1000)
	        .attrTween("d", function(d) {
	            this._current = this._current || d;
	            var interpolate = d3.interpolate(this._current, d);
	            this._current = interpolate(0);
	            return function(t) {
	                return arc(interpolate(t));
	            };
	        })
	    slice
	        .on("mousemove", function(d){
	            div.style("left", d3.event.pageX+10+"px");
	            div.style("top", d3.event.pageY-25+"px");
	            div.style("display", "inline-block");
	            div.html((d.data.state)+"<br>"+(d.data.value)+"%");
	        });
	    slice
	        .on("mouseout", function(d){
	            div.style("display", "none");
	        });

	    slice.exit()
	        .remove();

	    var legend = svg.selectAll('.legend')
	        .data(color.domain())
	        .enter()
	        .append('g')
	        .attr('class', 'legend')
	        .attr('transform', function(d, i) {
	            var height = legendRectSize + legendSpacing;
	            var offset =  height * color.domain().length / 2;
	            var horz = -3 * legendRectSize;
	            var vert = i * height - offset;
	            return 'translate(' + horz + ',' + vert + ')';
	        });

	    legend.append('rect')
	        .attr('width', legendRectSize)
	        .attr('height', legendRectSize)
	        .style('fill', color)
	        .style('stroke', color);

	    legend.append('text')
	        .attr('x', legendRectSize + legendSpacing)
	        .attr('y', legendRectSize - legendSpacing)
	        .text(function(d) { return d; });

	    /* ------- TEXT LABELS -------*/

	    var text = svg.select(".labelName").selectAll("text")
	        .data(pie(data), function(d){ return d.data.label });

	    text.enter()
	        .append("text")
	        .attr("dy", ".35em")
	        .text(function(d) {
	            return (d.data.state+": "+d.value+"%");
	        });

	    function midAngle(d){
	        return d.startAngle + (d.endAngle - d.startAngle)/2;
	    }

	    text
	        .transition().duration(1000)
	        .attrTween("transform", function(d) {
	            this._current = this._current || d;
	            var interpolate = d3.interpolate(this._current, d);
	            this._current = interpolate(0);
	            return function(t) {
	                var d2 = interpolate(t);
	                var pos = outerArc.centroid(d2);
	                pos[0] = radius * (midAngle(d2) < Math.PI ? 1 : -1);
	                return "translate("+ pos +")";
	            };
	        })
	        .styleTween("text-anchor", function(d){
	            this._current = this._current || d;
	            var interpolate = d3.interpolate(this._current, d);
	            this._current = interpolate(0);
	            return function(t) {
	                var d2 = interpolate(t);
	                return midAngle(d2) < Math.PI ? "start":"end";
	            };
	        })
	        .text(function(d) {
	            return (d.data.state+": "+d.value+"%");
	        });


	    text.exit()
	        .remove();

	    /* ------- SLICE TO TEXT POLYLINES -------*/

	    var polyline = svg.select(".lines").selectAll("polyline")
	        .data(pie(data), function(d){ return d.data.state });

	    polyline.enter()
	        .append("polyline");

	    polyline.transition().duration(1000)
	        .attrTween("points", function(d){
	            this._current = this._current || d;
	            var interpolate = d3.interpolate(this._current, d);
	            this._current = interpolate(0);
	            return function(t) {
	                var d2 = interpolate(t);
	                var pos = outerArc.centroid(d2);
	                pos[0] = radius * 0.95 * (midAngle(d2) < Math.PI ? 1 : -1);
	                return [arc.centroid(d2), outerArc.centroid(d2), pos];
	            };
	        });

	    polyline.exit()
	        .remove();
	};
	
	
	</script> -->
	<script>
	  var gauge2 = new JustGage({
          id: "gauge1",
          title: "#2",
          value: 50,
          min: 0,
          max: 100,
          humanFriendly: false,
          decimals: 0,
          counter: true
      });
	</script>
</head>
<body>
<div id="gauge1"></div>

</body>
</html>