
<!DOCTYPE HTML>
<html>
<head>
    <meta charset='utf-8'>
    <style>
        table.table2 { 
            border-collapse: separate;
            border-spacing: 1px;
            text-align: left;
            line-height: 1.5;
            margin: 0px 10px 20px 10px;
        } 
        table.table2 tr {
            width: 50px;
            padding: 10px;
            font-weight: bold;
            vertical-align: top;
            border-bottom: 1px solid #cccccc;
        }
        table.table2 td {
            width: 100px;
            padding: 10px;
            vertical-align: top;
            border-bottom: 1px solid #cccccc;
        }
    </style>
</head>
<body>
    <!--보안상 중요한 글쓰기 기능이므로 method는 GET 방식이 아닌 POST 방식을 사용-->
    <form method="POST" action="write_action.php" >
        <table style="padding-top: 50px" align=center width=auto border=0 cellpadding=2>
           
        <tr>
                <td style="height: 40; float:center; background-color:#556884">
                    <p style="font-size:25px; text-align:center; color:#ffffff; margin-top:15px; margin-bottom:15px;">
                    <b> 게시글 작성하기 </b></p>
                </td>
            </tr>
            <tr>
                <td bgcolor=white>
                    <table class="table2">
                        <tr>
                            <td>작성자</td>
                            <td><input type="text" name="name" size=30></td>
                        </tr>
                        <tr>
                            <td>제목</td>
                            <td><input type="text" name="title" size=70></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><textarea name="content" cols=75 rows=15></textarea></td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><input type="password" name="pwd" size=15 maxlength=15></td>
                        </tr>        
                    </table>
                    <center>
                        <input style="height:30px; width:100px; border-width:0; font-size:16px; color:#ffffff; background-color:#556884;" 
                                type="button" onClick="history.back(-1)" value="뒤로가기">
                        <input style="height:30px; width:100px; border-width:0; font-size:16px; color:#ffffff; background-color:#556884;" 
                                type="submit" value="작 성">
                    </center>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
