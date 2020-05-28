<?php
 require "connect.php";
 $id = $_POST['id'];
 $name = $_POST['editName'];
 $birthday = $_POST['editBirthday'];
 $address = $_POST['editAddress'];
 $query = "UPDATE management SET name ='$name', birthday = '$birthday', address = '$address' WHERE id = '$id'";
 if(mysqli_query($connect,$query)){
   echo "Update success";
 }
 else{
   echo "Update error";
 }
?>
