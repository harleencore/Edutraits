<?php
include_once( "dbConnect.php");
$sql = "SELECT * FROM organisation";
$r = mysqli_query($con, $sql);
$result = array();
while($row = mysqli_fetch_array($r))
{
    array_push($result,array(
        'organisationid'=>$row['organisationid'],
        'organisationname'=>$row['organisationname'],
        'region'=>$row['region']
    ));
	echo $row['organisation'];
}
echo json_encode($result);
mysqli_close($con);
?>
