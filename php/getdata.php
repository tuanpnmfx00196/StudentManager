<?php
$connect = mysqli_connect("localhost","root","","student");
mysqli_query($connect, "SET NAME 'utf-8'");
$query = "SELECT * FROM management";
$data = mysqli_query($connect,$query);
class Student{
  function Student($id, $name, $birthday, $address){
    $this->ID=$id;
    $this->Name=$name;
    $this->Birthday =$birthday;
    $this->Address = $address;
    }
}

$ArrayStudent = array();
while($row = mysqli_fetch_assoc($data)){
  array_push($ArrayStudent, new Student($row['id'],$row['name'],$row['birthday'],$row['address']));
}
echo json_encode($ArrayStudent);
?>
