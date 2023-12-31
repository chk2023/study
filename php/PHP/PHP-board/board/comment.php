<?php
$connect = new mysqli("multisite_mariadb_1", "root", "chk", "study", "3306");
?>
<html>
 <div class="reply_view">
    <h3>댓글 목록</h3>
    <?php
    $co_query = "SELECT * FROM tComment WHERE co_num = '".$idx."' ORDER BY idx DESC";
    $co_result = mysqli_query($connect, $co_query);
    $co_data = mysqli_fetch_array($co_result);
    
    ?>