<?php
$connect = new mysqli("multisite_mariadb_1", "root", "chk", "study", "3306");

$idx = $_GET['idx'];
$name = $_POST['name'];                   //Writerwk
$title = $_POST['title'];             //Title
$content = $_POST['content']; 

$query = "UPDATE tMember SET name = $name, title=$title, content = $content WHERE idx = $idx";

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