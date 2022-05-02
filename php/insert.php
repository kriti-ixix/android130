<?php

$name = $_POST["name"];
$gender = $_POST["gender"]; 
$marks = $_POST["marks"];

// $name = "XYZ"; $gender = "F"; $marks = 50;
$result;

// address, username, password, database
$connection = mysqli_connect("localhost", "root", "", "android_demo");

if ($connection)
{
    // echo "Connection successful <br>";
    $query = "insert into students values (null, '$name', '$gender', $marks)";
    $response = mysqli_query($connection, $query);

    if ($response == 0)
    {
        $result = "ERROR"; //echo "Query not executed";
    }
    else
    {
        $result = "OK"; //echo "Query executed";
    }
}
else
{
    die("Error connecting to database"); // echo "Error connecting";
}

echo json_encode(array("result" => $result));

?>