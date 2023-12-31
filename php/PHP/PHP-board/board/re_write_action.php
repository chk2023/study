<?php
$connect = new mysqli("multisite_mariadb_1", "root", "chk", "study", "3306");
$name = $_POST['name'];                   //Writerwk
$pwd = $_POST['pwd'];                  //Password
$title = $_POST['title'];             //Title
$content = $_POST['content'];         //Content
$date = date('Y-m-d H:i:s');          //Date
$ref = $_POST['ref'];
$re_step = $_POST['re_step'];
$re_level = $_POST['re_level'];
$URL = './index.php';                 //return URL

    $query = "UPDATE  tMember SET  re_step = re_step + 1 WHERE  ref= $ref  AND  re_step > $re_step"; 
    $connect->query($query);

    $ref =  $_POST['ref'];
    $re_step = $_POST['re_step'] + 1;
    $re_level = $_POST['re_level'] + 1;

//정보 전송
$query = "INSERT INTO tMember (title, content, date, hit, name, pwd, ref, re_step, re_level) 
        values('$title', '$content', '$date', 0, '$name', '$pwd', '$ref', '$re_step', '$re_level')";

$result = $connect->query($query);
if ($result) {
?> <script>
        alert("<?php echo "등록되었습니다." ?>");
        location.replace("<?php echo $URL ?>");
    </script>
<?php
} else {
    echo "등록에 실패하였습니다.";
}
mysqli_close($connect);
?>