<!DOCTYPE HTML>
<html>

<?
$connect = new mysqli("multisite_mariadb_1", "root", "chk", "study", "3306");

// 한 페이지에 보여줄 리스트 수 list_num
$record_per_page = 10; 
// 한 블럭에 보여줄 페이지 수 page_num
$page_per_block = 5;
// 현재 페이지
$now_page = ($_GET['page']) ? $_GET['page'] : 1; 
// 현재 블럭 
$now_block = ceil($now_page / $page_per_block);

$sql = "SELECT count(*) as cnt FROM tMember";
$result = mysqli_query($connect, $sql);
$count_row = mysqli_fetch_array($result); 

// 전체 리스트 수
$total_record = $count_row["cnt"];


//1페이지에서는 0이시작 2페이지에서는 10이 시작
$start =($now_page-1) * $record_per_page; 
$sql = "SELECT * FROM tMember ORDER BY ref desc LIMIT $start, $record_per_page";
$result = mysqli_query($connect, $sql);
$current_total_record = mysqli_num_rows($result);

//$sql = "SELECT idx, title, name, date, hit FROM tMember ORDER BY idx desc LIMIT '". $record_per_page * ($now_page - 1) ."','". $record_per_page * $now_page."'";
//$result_data = mysqli_query($connect, $sql);

?>

<head>
    <meta charset='utf-8'>
	<script src="https://kit.fontawesome.com/d796099f7b.js" crossorigin="anonymous"></script>
    <style>
        table {
            border-top: 1px solid #444444;
            border-collapse: collapase;
        }
        tr {
            border-bottom: 1px solid #444444;
            padding: 12px;
        }
        td {
            border-bottom: 1px; /* solid #efefef; */
            padding: 12px;
        }
        .text {
            text-align: center;
            padding-top: 20px;
            color: #000000;
        }
        .text:hover {
            text-decoration: underline;
        }
        a:link {
            color: #57a0ee;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
	<p style="font-size: 25px; text-align:center"><b>게시판 리스트</b></p>
		<div>
			<table align="center">

				<thead>
				<tr>
				<td width="50" style="border-bottom: 1px solid #b5b5b5;" align="center">번호</td>
					<td width="500" style="border-bottom: 1px solid #b5b5b5;" align="center">제목</td>
					<td width="100" style="border-bottom: 1px solid #b5b5b5;" align="center">작성자</td>
					<td width="200" style="border-bottom: 1px solid #b5b5b5;" align="center">작성일</td>
					<td width="50" style="border-bottom: 1px solid #b5b5b5;" align="center">조회수</td>
				</tr>
				</thead>

				<tbody>
				<?
				for ($i = 0; $i < $current_total_record; $i++) {
				// 데이터 가져오기
				mysqli_data_seek($result, $i);       
				$row = mysqli_fetch_array($result); 
				//$width = 100*$row["re_level"];  
				
				?>
				<tr>
					<td width="50" align="center"><?= $row["idx"] ?></td>
					<td width="500">   
					<?
					if ($row[re_level] > 0 ) { //공백출력
					for($k = 0 ; $k < $row[re_level]; $k++)                   
					echo "&nbsp&nbsp&nbsp";                    
					echo("└>");  
							} 
					?>                   
					<a href="content.php?idx=<?=$row["idx"]?>&no=<?=$i?>"><?= $row["title"] ?></a>
				</td>
					<td width="100" align="center"><?= $row["name"] ?></td>
					<td width="200" align="center"><?= $row["date"] ?></td>
					<td width="50" align="center"><?= $row["hit"] ?></td>
			
				</tr>
				<? }?>
				</tbody>	
				
		</table>
		<br>
		<form action="write.php" align="center">
			<input style="height:30px; width:100px; border-width:0; font-size:16px; color:#ffffff; background-color:#556884;" type="submit" value="글쓰기">
        </form>
	</div>
	<div align="center">
	    <tr>
        <br>
			<?

			$total_page = ceil($total_record / $record_per_page); // 전체 페이지 수
        
			$total_block = ceil($total_page / $page_per_block); // 전체 블럭 수


			//현재 페이지가 1보다 작거나 같을때
			if($now_page)

			if($now_page <= 1){
				?>
				<a href="index.php?page=1" title="이전 페이지"> <!--<i class="fa-solid fa-angle-left"></i> --></a>
			
				<? } else{ ?>

				<a href="index.php?page=<? echo $now_block == 1?'1' : ($now_block -1)*5; ?>" 
					title= "이전 목록"> <i class="fa-solid fa-angles-left"></i> </a>
				<!--현재 블럭 에서 1뺀 후 5를 곱해준 페이지로 이동 -->
				<a href="index.php?page=<? echo ($now_page-1); ?>"> <i class="fa-solid fa-angle-left"></i> </a>
				<? };?>
			

				

			<?
			$start_page = ($now_block - 1) * $page_per_block + 1;
			$end_page = $now_block * $page_per_block;
 			// 총 페이지와 마지막 페이지를 같게 하기, 즉 글이 있는 페이지까지만 설정
 			if($end_page > $total_page) {
			$end_page = $total_page;
  			}
			?>

			<?
			for($print_page = $start_page; $print_page <= $end_page; $print_page++){
				?>


			<a id="page<? echo $print_page; ?>" href="index.php?page=<? echo $print_page; ?>"><? echo $print_page; ?></a>

			<? };?> <!--for문으로 번호부분 반복-->

			    
	
			<?
 			if($now_page >= $total_page){
   				 ?>
   			 <a href="index.php?page=<? echo $total_page; ?>" title="다음 페이지"><!-- <i class="fa-solid fa-angle-right"></i>--> </a>
   			 <? } else{ ?>
   		 	<a href="index.php?page=<? echo ($now_page+1); ?>"> <i class="fa-solid fa-angle-right"></i> </a>
    		<a href="index.php?page=<? echo $now_block != 1 ? ($now_block == $total_block ? $total_page : $now_block * 5+1) : $end_page; ?>" title="다음 목록"> <i class="fa-solid fa-angles-right"></i> </a>
    		<? };?>

		</tr>
	</div>
</body>
</html>