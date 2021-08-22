<?php
include 'conn.php';

if($_SERVER["REQUEST_METHOD"] == "POST")
{
	$username=$_POST["username"];
	$password=$_POST["password"];
	$name=$_POST["name"];
	$email=$_POST["email"];
	$phoneno=$_POST["phoneno"];
	$response = array();
	
	 $sql = "INSERT INTO user (username,password,name,email,phoneno)
	VALUES ('".$username."','".$password."','".$name."','".$email."','".$phoneno."')";	
	if (mysqli_query($conn,$sql)) {
		//echo "New record created successfully";
		 $response['status'] = "success";
		 $response['msg'] = "User Registration Successful";
	}
			
		
	else {	
					$response['status'] = 'error';
					$response['msg'] = 'Invalid Password';
					$response['error'] = $conn->error;
			//	echo "Error: " . $sql . "<br>" . $conn->error;
	}
}
else
{
    $response['status'] = 'error';
    $response['msg'] = 'Error Hitting API';
}
echo json_encode($response);
//include 'closedb.php';
?>