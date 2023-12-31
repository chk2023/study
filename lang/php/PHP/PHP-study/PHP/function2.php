<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>functions</title>
</head>
<body>
    <h1>Function</h1>
    <h2>Basic</h2>
    <?php
      function basic() {
        print("hi.<br>");
        print("hello<br>");
      }
      basic();
      basic();
      basic();
    ?>
    <h2>parameter &amp; argument</h2>
    <?php
    function sum($left, $right) {
        print ($left+$right);
        print ("<br>");
    }
    sum(2,4);
    sum(4,4);
    ?>
    <h2>return</h2>
    <?php
    function sum2($left, $right) {
        return $left + $right;
    }
    print(sum2(2,4));
    file_put_contents('result.txt', sum2(2,4)); //result.txt에 sum2() 함수의 값을 넣어주는 것이다.
    // 예시1) email('example@gmail.com', sum2(2,4)); 실제 이러한 코드는 없다.
    // 예시2) upload('example.com', sum2(2,4)); 실제 이러한 코드는 없다.
    ?>
</body>
</html>