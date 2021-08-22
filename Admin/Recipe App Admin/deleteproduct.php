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
  max-width: 1000px;
  margin: auto;
  text-align: center;
  font-family: arial;
}
</style>

<?php
	//if(isset($_POST['delete']))
	//{
	include "conn.php";	
	
	//$name = $_POST['prname'];
	//$sql="delete from addproduct where a1 = '$name' ";
	//mysqli_query($conn,$sql);
	//}
?>
<div class="card">
<br>
<br>
<br>
<form action="deleteproduct.php" method="POST">
	<b>Enter Recipe name:</b>&nbsp;&nbsp;&nbsp;&nbsp;
	<!-- <input type="text" name="prname"><br><br> -->
	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 

    <select id="category" name = "category">
    <?php 
        $getval = mysqli_query($conn,"Select recipename from admin") or die($mysqli_error($conn)) ;
        while ($a = mysqli_fetch_array($getval)) {
    ?>
        <option value="<?php echo $a['recipename']?>"><?php echo $a['recipename']?></option>
        <?php
        }
        ?>
    
	</select> 


	<input type="submit" name="delete" value="Delete Recipe">
			<br>
	<br>
	<br>
	<?php
	if(isset($_POST['delete']))
	{
	$name = $_POST['category'];
	$sql="delete from admin where recipename = '$name' ";
	
	
	mysqli_query($conn,$sql);
	if ($name == null)
		{
			
			echo "<div class='alert alert-danger' role='alert'><strong>ERROR!</strong> Please Enter Product Name</div>";
	
		}
	else
		{
			if(mysqli_query($conn,$sql))
			{
				echo "<div class='alert alert-success' role='alert'>Product Deleted Successfully</div>";
				echo "<script>loctaion.reload(true);</script>";
			}
			else
			{
				echo "ERROR".$sql."<br>".$mysqli_error($conn);
			}
		}
	}

	
	
	?>

	 
	
</form>
	
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
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