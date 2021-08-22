<?php
include "header.php";
include "conn.php";
		
?>
<style>
input[type=text] {
  border: 2px solid lightblue;
  border-radius: 4px;
  background-color: #e6f5ff;
  color:black;
  width: 100%;
}

input[type=text]:hover {
background-color: white;
color: black;
border: 2px solid #2980B9;;
font-size:15px;
padding:0px;
margin: 4px 2px;
}

input[type=file] {
  border: 2px solid lightblue;
  border-radius: 4px;
  background-color: #e6f5ff;
  color:black;
}

input[type=submit] {
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color:#0073e6;
  resize: none;
}
input[type=submit]:hover{
background-color: white;
color: black;
border: 2px solid #2980B9;;
font-size:16px;

}

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
textarea {
  width: 100%;
  height: 80px;
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #e6f5ff;
  resize: none;
}

textarea:hover {
background-color: white;
color: black;
border: 2px solid #2980B9;;
border-radius:12px;
font-size:20px;
padding:10px;
//box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
margin: 4px 2px;
}
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 1000px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

</style>

<?php
if (isset($_POST['upload'])) {
	$_a1 = $_POST["a1"];
	$_a2 = $_POST["a2"];
	$_a3 = $_POST["a3"];
	$_a4 = $_POST["a4"];
	$_a5 = $_POST["category"];

	//echo $_a1;
			// Get image name
	$image = $_FILES['image']['name'];
	

	// Get text
	//$image_text = mysqli_real_escape_string($db, $_POST['image_text']);

	// image file directory
	$target = "images/product/".basename($image);
	
	if ($_a1 == null)
	{
		echo "<div class='alert alert-danger' role='alert'><strong>ERROR!</strong> Please Enter Product Name</div>";
	}
	else
	{

		$sql = "INSERT INTO admin (recipename,method,ingredients,videolink,category,image) VALUES ('$_a1','$_a2','$_a3','$_a4','$_a5','$target')";
		// execute query
		if(mysqli_query($conn, $sql))
		{
			echo "<div class='alert alert-success' role='alert'>Product Added Successfully</div>";
		}

		if (move_uploaded_file($_FILES['image']['tmp_name'], $target)) {
			echo "<div class='alert alert-success' role='alert'>Product Image Uploaded Successfully</div>";
		}else{
			echo "<div class='alert alert-danger' role='alert'><strong>ERROR!</strong>Failed to Upload Product Image</div>";
		}


		// if (move_uploaded_file($_FILES['image1']['tmp_name'], $target1)) {
		// 	echo "<div class='alert alert-success' role='alert'>Table Image Uploaded Successfully</div>";
		// }else{
		// 	echo "<div class='alert alert-danger' role='alert'><strong>ERROR!</strong>Failed to Upload Table Image</div>";
		// }
	}	
	
}
?>
<form method="POST" action="addproduct.php" enctype="multipart/form-data">
	<div class="card">
		<fieldset>
			<legend><b>Recipe Description&nbsp;&nbsp;&nbsp;&nbsp;</b><i class="fa fa-edit"></i></legend>
			<div style="display:block">
				Enter Recipe name:&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="a1"><br><br>
				Method or Procedure:&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea  row="5" cols="40" name="a2"></textarea><br><br>
				Ingredients:&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea  row="5" cols="40" name="a3"></textarea><br><br>
				<!-- Category :&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea  row="5" cols="40" name="a4"></textarea><br><br> -->
				Video Link:&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea  row="5" cols="40" name="a4"></textarea><br><br>
				<label for="category">Choose Category:</label>

				<select name = "category" id="category">
				<option value="Chinese">Chinese</option>
				<option value="Breakfast">Breakfast</option>
				<option value="Curry">Curry</option>
				<option value="Salad">Salad</option>
				<option value="Non-Veg">Non-Veg</option>
				<option value="Snacks">Snacks</option>
				<option value="Desert">Desert</option>
				<option value="Biryani">Biryani</option>
				<option value="South">South</option>
				<option value="Drinks">Drinks</option>
				<option value="North">North</option>
				<option value="Others">Others</option>
				</select>
				<br>
				<br>
				
				<!-- Control System:&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea  row="5" cols="40" name="a6"></textarea><br><br>
				Cooling System:&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea  row="5" cols="40" name="a7"></textarea><br><br>
				Heating System:&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea  row="5" cols="40" name="a8"></textarea><br><br>
				Humidity System:&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea  row="5" cols="40" name="a9"></textarea><br><br>
				Sensor:&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea  row="5" cols="40" name="a10"></textarea><br><br>
				Safety:&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea  row="5" cols="40" name="a11"></textarea><br><br>
				Support:&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea  row="5" cols="40" name="a12"></textarea><br><br>
				Optional:&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea  row="5" cols="40" name="a13"></textarea><br><br> -->
			</div>
		</fieldset>
	</div>
	<br><br><br>
	<div class="card">
		<fieldset>
				<legend><b>Recipe Image</b><i class="fa fa-picture-o"></i></legend>
		
			<br>
			<br>
			<input type="hidden" name="size" value="1000000">
			<div>
			  <input type="file" name="image">
			</div>
			<br>
			<br>
			<br>
			<!-- <input type="hidden" name="size" value="1000000">
				<div >
				  <input type="file" name="image1">
				</div>
			<br>
			<br>
			<br> -->
		
		</fieldset>
	</div>
	
	
	<br>
	<br>
  	<div align="center">
  		<button type="submit" name="upload">Add Recipe</button>
  	</div>
  </form>
<?php
include "footer.php";
?>