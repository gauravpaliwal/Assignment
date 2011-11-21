<html>
	<head>
    		<link href="css/main.css" rel="stylesheet" type="text/css">
		<META HTTP-EQUIV="Refresh" CONTENT="80">
		<title> 
			Track the Object Assignment
		</title>

		<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
		<!= This is to tell that the maps is full screen always and cannot be resized by the user!>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=true">
		</script>
		<script type="text/javascript">
                    
                function initialize()
                {
                        $.getJSON("http://localhost:8987/TrackOn/DataJSON",  function(data) {
                            var flightPlanCoordinates = new Array() ;
                             var myLatLng ;
                            for (var i = 0 ; i < data.length ; i++)
                            {       flightPlanCoordinates[i]  =  new google.maps.LatLng(data[i].lat, data[i].log) ;
                                    myLatLng = new google.maps.LatLng( data[i].lat, data[i].log);
                            }
                            
                            
                            
			  var myOptions_1 = {
			    zoom: 15,
			    center: myLatLng,
			    mapTypeId: google.maps.MapTypeId.HYBRID 
			  };

			  var myOptions_2 = {
			    zoom: 15,
			    center: myLatLng,
			    mapTypeId: google.maps.MapTypeId.ROADMAP 
			  };

			  var map_1 = new google.maps.Map(document.getElementById("map_canvas_1"),myOptions_1);
			  var map = new google.maps.Map(document.getElementById("map_canvas_2"),myOptions_2);



			  map.setTilt(45);
			  map.setHeading(90);
			    
                            var marker ;
                            for (var i = 0 ; i < data.length ; i++)
                            {       
                                   myLatLng = new google.maps.LatLng( data[i].lat, data[i].log);
                                    marker = new google.maps.Marker({
                                    position: myLatLng,
                                    map: map_1,
                                    title:"TimeStamp " + data[i].timestamp
                          });
                          
                          marker = new google.maps.Marker({
                                    position: myLatLng,
                                    map: map,
                                    title:"TimeStamp " + data[i].timestamp
                          });
                            }
                            

			var flightPath1 = new google.maps.Polyline({
			    path: flightPlanCoordinates,
			    strokeColor: "#FF0000",
			    strokeOpacity: 1.0,
			    strokeWeight: 2
			  });

			var flightPath2 = new google.maps.Polyline({
			    path: flightPlanCoordinates,
			    strokeColor: "#FF0000",
			    strokeOpacity: 1.0,
			    strokeWeight: 2
			  });
			  flightPath1.setMap(map_1);
			  flightPath2.setMap(map);  
                          });
                          
  
                          var t=setTimeout("initialize()",30000);
                          
                }  
                

	</script>
	</head>


	<body onload="initialize()">
	  <div id="map_canvas_1" style="position:absolute; width: 50%; height: 90%; top : 0% ;"> </div>
	  <div id="map_canvas_2" style="position:absolute; left:51%; width: 49%; top : 0% ; height: 90%;"></div>
          <div class="Information">
              <h3>TrackOn Application</h3>
              1. The Center of the Map is always current position in the map.<br>
              2. The tool tip on the marker gives the time in which the person is that location.<br>
              3. Their is a function (which I am unable to find) that will convert the whole Google Maps API to work for Google Earth API also.<br>
              4. Reserved for future use Current Location and Time of last update will be shown here.<br>
          </div>
	</body>

</html>