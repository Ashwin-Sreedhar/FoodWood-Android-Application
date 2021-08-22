<?php
include "conn.php";
if($_SERVER['REQUEST_METHOD']=='POST'){
		$_a1 = $_POST["a1"];
		$_a2 = $_POST["a2"];
		$_a3 = $_POST["a3"];
		$_a4 = $_POST["a4"];
		$_a5 = $_POST["a5"];
		$_a6 = $_POST["a6"];
		$_a7 = $_POST["a7"];
		$_a8 = $_POST["a8"];
		$_a9 = $_POST["a9"];
		$_a10 = $_POST["a10"];
		$_a11 = $_POST["a11"];
		$_a12 = $_POST["a12"];
		$_a13 = $_POST["a13"];
		$_a14 = $_POST["image"];
		$_a15 = $_POST["a15"];
		
		$target = "images/".basename($_FILES['image']['name']);
		$image = $_FILES['image']['name'];
		echo $_a14;
		
		if(move_uploaded_file($_FILES['image']['tmp_name'],$target))
		{
			$msg = "Image Uploaded";
			echo $msg;
		}
		else{
			$msg = "Image Failed";
			echo $msg;
		}
		
		$query = "insert into addproduct (a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,image,a15) values('$_a1','$_a2','$_a3','$_a4','$_a5','$_a6','$_a7','$_a8','$_a9','$_a10','$_a11','$_a12','$_a13','$image','$_a15')";
		if(mysqli_query($conn,$query))
		{
			echo "Message inserted sucessfully";
		}
		else
		{
			echo "ERROR".$query."<br>".$mysqli_error($conn);
		}
		//echo $_checkbox_value;
		//echo $_name;
		//echo $_email;
		//echo $_subject;
		//echo $_message;
		//echo $_a1;
		//echo $_a2;
		//echo $_a3;
		//echo $_a4;
		//echo $_a5;
		//echo $_a6;
		//echo $_a7;
		//echo $_a8;
		//echo $_a9;
		//echo $_a10;
		//echo $_a11;
		//echo $_a12;
		//echo $_a13;
		//echo $_a14;
		//echo $_a15;
	
	}
	
?>