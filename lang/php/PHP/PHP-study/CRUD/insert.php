<?php
$conn = mysqli_connect("127.0.0.1", "root", "kongnpark", "opentutorials", 30067);
$sql = "
INSERT INTO topic
    (title, description, created)
    VALUES(
        'MySQL',
        'MySQL is...',
        NOW()
    )";
$result = mysqli_query($conn, $sql);
if($result === false){
    echo mysqli_error($conn);
}

if (mysqli_connect_errno())
{
echo "DB 연결에 실패했습니다 " . mysqli_connect_error();
}
?>

<?php
  $jb_connect = mysqli_connect('127.0.0.1', 'root', 'kongnpark', 'opentutorials');
  if($jb_connect == false){
    echo mysqli_connect_error();
  }
  var_dump( $jb_connect );
?> 