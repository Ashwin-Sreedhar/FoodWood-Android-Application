<?php
include "header.php";
?>
<style>
input[type=text] {
  border: 2px solid lightblue;
  border-radius: 4px;
  background-color: #e6f5ff;
  color:black;

}

input[type=text]:hover {
background-color: white;
color: black;
border: 2px solid #2980B9;;
font-size:15px;
padding:0px;
margin: 4px 2px;
}
</style>

<style>
button{
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color:#0073e6;
  color:white;
  resize: none;
}
button:hover{
background-color: white;
color: black;
border: 2px solid #2980B9;;
font-size:16px;
box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}
</style>

<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 900px;
  height: 600px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

</style>
<div class="outter-wp">

	
		<div class="ribbon-one graph" style="height:600px">
											  <!--/ribbon-inner-->
			<div class="ribbon-inner" style="height:500px;background-color:  #e6f0ff;">
				<div class="ribbon left_ribbon" style="height:80px">
					<h3><b>FoodWood</b></h3>
				</div>
				<div class="ribbon both_ribbon" style="height:80px">
					<h3><i>''Cooking Made easy''</i> </h3>
				</div>
				<br>
				<br>
				<br>
				<div style="font-size: 25px;font-family: Forte, Times, serif;"><p><b>Date/Time: <span id="datetime"></span></b></p></div>

				<script>
				var dt = new Date();
				document.getElementById("datetime").innerHTML = (("0"+dt.getDate()).slice(-2)) +"."+ (("0"+(dt.getMonth()+1)).slice(-2)) +"."+ (dt.getFullYear()) +" "+ (("0"+dt.getHours()).slice(-2)) +":"+ (("0"+dt.getMinutes()).slice(-2));
				</script>
				<br>
				<br>
				<br>
			</div>
			 <!--/ribbon-inner-->
		</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

</div>
<?php
include "footer.php";
?>

