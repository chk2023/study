<?php
$conn = mysqli_connect('127.0.0.1', 'root', 'kongnpark', 'opentutorials');
$sql = "
    INSERT INTO topic
        (title, description, created)
        VALUES(
            '{$_POST['title']}',
            '{$_POST['description']}',
            NOW()
        )
";
$result = mysqli_query($conn, $sql);
if($result === false){
    echo '저장하는 과정에서 문제가 생겼습니다. 관리자에게 문의해주세요';
    error_log(mysqli_error($conn));
}
else {
    echo '저장, 성공! <a href="index.php">돌아가기</a> ';
}
if(mysqli_connect_error()){
    echo '데이터베이스 접속에 문제가 있습니다. '.mysqli_connect_error()
    .'.';
}
?> 