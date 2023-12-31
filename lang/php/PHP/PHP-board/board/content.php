<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <style>
        .read_table {
            margin-top: 30px;
        }
        .read_title {
            height: 45px;
            font-size: 23.5px;
            text-align: center;
            background-color: #556884;
            color: white;
            width: 1000px;
        }
        .read_id {
            text-align: center;
            background-color: #EBF3FF;
            width: 30px;
            height: 33px;
        }
        .read_id2 {
            background-color: white;
            width: 60px;
            height: 33px;
            padding-left: 10px;
        }
        .read_hit {
            background-color: #EBF3FF;
            width: 30px;
            text-align: center;
            height: 33px;
        }
        .read_hit2 {
            background-color: white;
            width: 60px;
            height: 33px;
            padding-left: 10px;
        }
        .read_content {
            padding: 20px;
            border-top: 1px solid #444444;
            border-bottom: 1px solid #b5b5b5;
            height: auto;
        }
        .read_btn {
            width: 700px;
            height: 100px;
            text-align: center;
            margin: auto;
            margin-top: 20px;
        }
        .read_btn1 {
            height: 50px;
            width: 100px;
            font-size: 20px;
            text-align: center;
            background-color: white;
            border: 2px solid #556884;
            /*border-radius: 10px;  버튼 끝 둥글게 효과*/ 
        }
        /*댓글 스타일 시작 */
        .reply_list {
            width: 1000px;
            /*text-align: center;*/
            margin: auto;
            margin-top: 20px;
            color: #556884;
            border-bottom: 1px solid #556884;
        }
        table.table2 { 
            border-collapse: separate;
            border-spacing: 1px;
            text-align: left;
            line-height: 1.5;
        } 
        table.table2 tr {
            width: 50px;
            padding: 10px;
            font-weight: bold;
            vertical-align: top;
        }
        table.table2 td {
            width: 1000px;
            padding: 10px;
            vertical-align: top;
        }


        .re_view {
            width : 1000px;
            margin-top : 50px;
            border-bottom: 1px solid #556884;
        }
        .name_view {
            font-weight: bold;
            font-size : 14px;
            padding : 10px 0 5px 0;
            border-bottom : 1px solid #b5b5b5;
        }

        .date_view {
            font-size : 12px;
            padding : 10px 0 5px 0;
            border-bottom: 1px solid #556884;
        }

        .content_view {
            font-size : 14px;
            padding : 10px 0 5px 0;
            border-bottom : 1px
        }

    </style>
</head>
<body>
    <?php
    $connect = new mysqli("multisite_mariadb_1", "root", "chk", "study", "3306");
    $idx = $_GET['idx'];
    $ref = $_GET['ref'];
    $re_step = $_GET['re_step'];  // GET 방식 사용
    
    $query = "SELECT * FROM tMember where idx = $idx"; //선택한 글 가져오기
    $result = mysqli_query($connect, $query);
    $data = mysqli_fetch_array($result);
    //조회수 증가
    $hit = "UPDATE tMember set hit=hit+1 where idx=$idx"; 
    $connect->query($hit);
    ?>
    
    <table class="read_table" align=center>
        <tr>
            <td colspan="4" class="read_title"><?php echo $data[title] ?></td>
        </tr>
        <tr>
            <td class="read_id">작성자</td>
            <td class="read_id2"><?php echo $data[name] ?></td>
            <td class="read_hit">조회수</td>
            <td class="read_hit2"><?php echo $data[hit] ?></td>
        </tr>
        <tr>
            <td colspan="4" class="read_content" valign="top">
                <?php echo $data['content'] ?></td>
        </tr>
    </table>

    <div class="read_btn">
        <button class="read_btn1" onclick="location.href='./index.php'" style="height:30px; width:100px; border-width:0; font-size:16px; color:#ffffff; background-color:#556884;">목록보기</button>&nbsp;&nbsp;
        <button class="read_btn1" onclick="location.href='./re_write.php?idx=<?=$data[idx]?>&ref=<?=$data[ref]?>&re_step=<?=$data[re_step]?>&re_level=<?=$data[re_level]?>'" style="height:30px; width:100px; border-width:0; font-size:16px; color:#ffffff; background-color:#556884;">답글달기</button>&nbsp;&nbsp;
        <button class="read_btn1" onclick="location.href='./modify.php?idx=<?=$data[idx]?>'" style="height:30px; width:100px; border-width:0; font-size:16px; color:#ffffff; background-color:#556884;">수정하기</button>&nbsp;&nbsp;
        <button class="read_btn1" onclick="location.href='./delete.php?idx=<?=$data[idx]?>'" style="height:30px; width:100px; border-width:0; font-size:16px; color:#ffffff; background-color:#556884;">삭제하기</button>
    </div>

    
    <!-- 댓글 시작 -->
    <div class="reply_list">
        <div class="re_view">
    <h2> 댓글 목록 </h2>
        </div>
    <?php
    $re_query = "SELECT*FROM tComment WHERE m_idx = $idx ORDER BY co_idx ASC";
    $re_result = mysqli_query($connect, $re_query);
    while($reply = mysqli_fetch_array($re_result)) {
    ?>
    <div class="name_view">
        <td> <?php echo $reply[co_name] ?> </td>
        </div>
        <div class="content_view">
        <td> <?php echo $reply[co_content] ?> </td>
        </div>
    <div class="date_view">
        <td> <?php echo $reply[co_date] ?> </td>
        </div>
        <?php } ?>
        </div>


    <form method="POST" action="reply_ok.php?idx=<?php echo $idx; ?>" >
        <table style="padding-top: 30px" align=center width=1000px border=0 cellpadding=2>
            <tr>
                <td bgcolor=white>
                    <table class="table2">
                        <tr>
                            <td><input type="text" name="co_name" size=30 placeholder="닉네임">&nbsp;&nbsp;&nbsp;<input type="password" name="co_pwd" size=30 maxlength=15 placeholder="비밀번호"></td>
                        </tr>
                        <tr>
                            <td><textarea name="co_content" cols=130 rows=5 placeholder="댓글을 입력하세요."></textarea></td>
                        </tr>
                    </table>
                    <input style="height:30px; width:100px; border-width:0; font-size:16px; color:#ffffff; background-color:#556884;" 
                                type="submit" value="작 성">
                </td>
            </tr>
    </table>
    </form>
    
</body>
</html>
