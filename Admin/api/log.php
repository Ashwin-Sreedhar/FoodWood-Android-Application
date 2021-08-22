
<?php

//connection file
include('conn.php');

$response = array();

if (isset($_POST)) //check if the login form is submitted, if yes then execute this code
{
    $username = $_POST["username"];
    $password = $_POST["password"];
    //echo $password; 
    // echo "New record created successfully";
    $lquery = "SELECT * FROM user WHERE username='$username'";
   if($lres = mysqli_query($conn,$lquery))
   {
        $ldata = mysqli_fetch_assoc($lres);
        $lcount = mysqli_num_rows($lres);
        
        if ($lcount != 0)
        {
            //echo $ldata['Password'];
            if($ldata['password']==$password)
    		{
    			$response['data'] = $ldata;
    			$response['status'] = 'success';
    			$response['msg'] = 'User Login Successful';
    		}
            else
            {
                $response['data'] = '';
                $response['status'] = 'error';
                $response['msg'] = 'Invalid Password';
            }
        }
    	else
    	{
    		$response['data'] = '';
            $response['status'] = 'error';
            $response['msg'] = 'No Such Account Found';
        }
   }
   else{
       	$response['data'] = '';
        $response['status'] = 'error';
        $response['msg'] = mysqli_error($conn);
   }
   
}
else
{
    echo "ahhsdasjd";
    $response['data'] = 'the Api cannot work';
    $response['status'] = 'error';
    $response['msg'] = 'Error Hitting API';
}
echo json_encode($response);
?>