<?php

if($_SERVER['REQUEST_METHOD']=='POST')
{
	include "conn.php";
	$_username = $_POST["username"];
	$_password = $_POST["password"];
	//login
	echo $_username;
	echo $_password;
    $sql1="SELECT username , password FROM `login`";
    $result=mysqli_query($conn,$sql1);
    $data=mysqli_fetch_row($result);
    $user = $data[0];
    $pass = $data[1];
    if($_username == $user)
    {   
                
        $sql="update `login` set logged = 1";
        mysqli_query($conn,$sql);
		//echo "<script>console.log('$cres');</script>";
        echo "<script>window.location.href = 'home.php';</script>";
    }
    else
    {
        echo"<script>alert('Invalid Username or Password');</script>";
        echo "<script>window.location.href = 'index.php';</script>";
    }
    
}
?>
