<?php
$connect = new mysqli("multisite_mariadb_1", "root", "chk", "study", "3306");
$name = $_POST['co_name'];                   //Writerwk
$pwd = $_POST['co_pwd'];                  //Password
$content = $_POST['co_content']; 
$idx = $_GET['idx'];

$date = date('Y-m-d H:i:s');          //Date


$query = "INSERT INTO tComment (m_idx, co_name, co_pwd, co_content, co_date)values('$idx', '$name', '$pwd', '$content', '$date')";

$result = $connect->query($query);
if ($result) {
?> <script>
        alert("<?php echo "등록되었습니다." ?>");
        location.href='/content.php?idx=<?=$idx?>';
    </script>
<?php
} else {
    echo "등록에 실패하였습니다.";
}
mysqli_close($connect);
?>