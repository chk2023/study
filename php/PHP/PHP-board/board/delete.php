<?php
$connect = new mysqli("multisite_mariadb_1", "root", "chk", "study", "3306");
$URL = './index.php';

$idx = $_GET['idx'];
$query = "DELETE FROM tMember WHERE idx = $idx";

$result = $connect->query($query);
if ($result) {
?> <script>
        alert("<?php echo "삭제 되었습니다." ?>");
        location.replace("<?php echo $URL ?>");
    </script>
<?php
} else {
    echo "삭제에 실패하였습니다.";
}
mysqli_close($connect);
?>