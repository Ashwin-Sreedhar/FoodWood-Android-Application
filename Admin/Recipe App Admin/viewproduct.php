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


<div class="card">
	<br>
	<br>
	<br>
	<form action="" method="POST">
		<b>Select Recipe name:</b>&nbsp;&nbsp;&nbsp;&nbsp;
		
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


		<input type="submit" name="view" value="view">
		<br>
		<br>
		<br>
		<?php
		
		if(isset($_POST['view']))
		{
			$name = $_POST['category'];
			$query = "select * from admin where recipename = '$name' ";
			$cres = mysqli_query($conn,$query);
			$a1 = mysqli_fetch_array($cres);
			
		}
		
		?>
		
		<br>
		<br>
		<br>
		
	</form>
</div>
	<br>
	<br>
    <br>
	<br>
		
	
	  
      <?php
	  if(isset($a1)){
		  ?>
	<div align = "center" >
		<h2 style = "font-family:georgia,garamond,serif;font-size:30;font-style:italic;"><b><?php echo $a1['recipename'];?></b></h2>
	</div>
	<div>
		<p>
			<ol>
				<li><b>Recipe Name:</b> <?php echo $a1['recipename'];?>	<br> </li>
				<li><b>Method:</b> <?php echo $a1['method'];?>	<br> </li>       
				<li><b>Ingredients:</b>	<?php echo $a1['ingredients'];?>	<br></li>
				<li><b>Link</b> <?php echo $a1['videolink'];?>	<br></li>
			</ol>
		
		</p>
	</div>	
<?php
	  }
include "footer.php";
?>