<?php

$result;
$gender = array();
$roll_no = array(); 
$marks = array(); 
$name = array();

$connection = mysqli_connect("localhost", "root", "", "android_demo");

if ($connection)
{
    echo "Connection successful <br>";
    $query = "select * from students";
    $response = mysqli_query($connection, $query);

    if ($response -> num_rows == 0)
    {
        $result = "EMPTY";
    }
    else
    {
        $result = "OK";

        while ($row = mysqli_fetch_array($response))
        {
            array_push($roll_no, $row['roll_no']);
            array_push($name, $row['name']);
            array_push($marks, $row['marks']);
            array_push($gender, $row['gender']);
        }
    }

}
else
{
    echo "Connection failed";
    die("Could not connect to the database");
}

echo json_encode(array("result"=>$result, "roll no"=>$roll_no, 
"name"=>$name, "gender"=>$gender, "marks"=>$marks));

?>