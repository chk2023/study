<?php
$today=time();
$type=$_GET[type];
/***********글쓰기***********/
if($mode=="write"){

    $qry=mysql_qeury("SELECT MIN(family)as family FROM 테이블"); //게시판 내용 중 부모값이 제일 작은 값을 가지고 옴
    $family=mysql_fetch_array($qry);
    $family=$family[family]-1; //입력될 게시글의 어미값을 제일 작은 값에서 하나 더 내림
    $orderby=0;
    $step=0;
    $pass=md5($pass); //비밀번호
    $sql="INSERT INTO 테이블 VALUES
    (",'$family', '$orderby', '$step', '$notice', '$nickname', '$pass', '$head', '$title', '$content', '$today',")";
    $res=mysql_query($sql); //글 내용 작성

    echo "<script>location.href='./list.php'</script>"; //완료 후 리스트로
}

/*****************************/
/************답 글************/
if($type=='reply'){
    $idx=$_GET[idx];

    $sql=mysql_query("SELECT * FROM 테이블 WHERE idx='".$idx."'"); //부모글의 정보를 가지고 옴
    $view=mysql_fetch_array($sql);

    $family=$view[family]; //family 값은 부모글과 같게
    $orderby=$view[orderby]+1; //orderby는 부모글보다 하나 더 많게
    $step=$view[step]+1; //step도 하나 더 많게
}

if($mode=="reply"){
    $pass=md5($pass);
    $qry=mysql_query("UPDATE board SET orderby=orderby+1 WHERE family='$family' AND orderby &gt; '".$view[orderby]."'"); //같은 부모글들에 대해서 orderby(정렬값)을 하나씩 +1 해줌
    $sql="INSERT INTO 테이블 VALUES
    (",'$family', '$orderby', '$step', '$notice', '$nickname', '$pass', '$head', '$title', '$content', '$today',")";
    $rest=mysql_query($sql);
    echo "<script>location.href='./list.php'</script>";
}
/*****************************/
?&gt;

<!--
    * Created on 2023.01.05.
    *
    * To change the template for this generated file go to
    * Window - Preferences - PHPeclipse - PHP - Code Templates
-->
<script>
    function FormCheck(){
        if (!fm.nickname.value)
        {
            alert("이름을 입력하세요.");
            return false;
        }
        if(!fm.pass.value)
        {
            alert("비밀번호를 입력하세요.");
            return false;
        }
        if(!fm.title.value)
        {
            alert("제목을 입력하세요.");
            return false;
        }
        if(!fm.contents.value);
        {
            aler("내용을 입력하세요.");
            return false;
        }
    }
</script>

<title></title>

<form method="post" name="fm" onsubmit="return FormCheck()" action="#">
<input type="hidden" name="mode" value="<?=$type?>">
<input type="hidden" name="idx" value="<?=$idx?>">
<table width="500" border="1" align="center">
<tbody>
    <tr>
        <td>작성자</td>
        <td>&nbsp;<input type="text" name="nickname" id="nickname">&nbsp;&nbsp;
        <!--?
        if($type=='reply'){?-->
        <!--?}else{?-->
            <input type="checkbox" name="notice" id="notice" value="1"> 게시판 공지
        <!--?}?-->
        </td>
    </tr>
    <tr>
        <td>비밀번호</td>
        <td>&nbsp;<input type="password" name="pass" id="pass"></td>
    </tr>
    <tr>
        <td>제목</td>
        <td>&nbsp;
            <select name="head" id="head">
                <option value="0">머릿말</option>
                <option value="1">알림</option>
                <option value="2">유머</option>
                <option value="3">기타</option>
            </select>&nbsp;
            <!--?
            if($type=='write'){?-->
                <input type="text" name="title" id="title">
                <!--?}else{?-->
                <input type="text" name="title" id="title" value="<?=$view[title]?>">
                <!--?}?-->
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <textarea rows="10" cols="60" width="500" name="content">&lt;?
        if($type=='reply'){?&gt;
            &lt;?=$view[content]?&gt;
            &lt;?}else{?&gt;&lt;?}?&gt;</textarea>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="right"><input type="button" value="리스트" onclick="location.href='./list.php'">&nbsp;
        <input type="submit" name="submit" value="등록하기">&nbsp;
        <input type="button" name="cancel" value="취소">
        </td>
    </tr>
    </tbody></table>
    </form>


