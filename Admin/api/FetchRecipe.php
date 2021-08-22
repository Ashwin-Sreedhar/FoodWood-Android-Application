
<?php

//connection file
include('conn.php');

$response = array();

if (isset($_POST)) //check if the login form is submitted, if yes then execute this code
{
    $value = $_POST["value"];
    
    $lquery = "SELECT * FROM admin WHERE category='$value'";
   if($lres = mysqli_query($conn,$lquery))
   {
       // $ldata = mysqli_fetch_all($lres);
        $lcount = mysqli_num_rows($lres);
        
        $recipe = array();
        if ($lcount != 0)
        {
            //echo $ldata['Password'];
            while($ldata=mysqli_fetch_assoc($lres))
            {
				array_push($recipe,$ldata);                
                    
            }
            $response['recipe'] = $recipe;
            $response['status'] = 'success';
            $response['msg'] = 'Fetched Successful';      
        }
    	else
    	{
    		$response['data'] = '';
            $response['status'] = 'error';
            $response['msg'] = 'No Data Found';
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
    //echo "ahhsdasjd";
    $response['data'] = 'the Api cannot work';
    $response['status'] = 'error';
    $response['msg'] = 'Error Hitting API';
}
echo json_encode($response);
?>