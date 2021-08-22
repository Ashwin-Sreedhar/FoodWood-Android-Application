<?php
if(isset($_POST['view']))
	{
		$name = $_POST['prname'];
		if ($name == null)
		{
			
			echo "<script>alert('Enter details');</script>";
		}
	}
?>