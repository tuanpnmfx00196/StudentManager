<?php
 require "connect.php";
 $name = $_POST['addName'];
 $birthday = $_POST['addBirthday'];
 $address = $_POST['addAddress'];
 $query = "INSERT INTO management VALUES(null, '$name','$birthday','$address')";
 if(mysqli_query($connect,$query)){
   echo "Insert success";
 }
 else{
   echo "Insert error";
 }
?>
