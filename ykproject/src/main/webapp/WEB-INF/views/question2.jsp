<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/ykBasic.css">
<script src="js/ykBasic.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script>
	$(function() {
		getInsuranceList();
		makeDiseaseCategory1();
		makeDiseaseCategory2();
		makeDiseaseCategory3();
		makeDiseaseCategory4();
		makeTreatementDays();
	});
</script>

<title>보험금질문</title>
</head>
<body>
	<div class="jumbotron text-center">
		<h1>보험금 질문하기</h1>
		<form action="searchInsure" name="search-insure-form">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="#태아보험,#제왕절개">
				<div class="input-group-btn">
					<input class="btn btn-info" type="submit" value="검색">
				</div>
			</div>
		</form>
		<br>
		<form action="insure/questionEnroll" name="insure-info-form" id = "insure-info-form" method="post">
			<select class="form-control" id="insure-title" name = "insureTitle">
				<option value="" selected disabled>Please select</option>
			</select>
			<div class="form-row">
				<div class="form-group">
					<label for="diseaseCategory1">대분류</label> <select
						id="diseaseCategory1" class="form-control" name = "diseaseCategory1">
					</select>
				</div>
				<div class="form-group">
					<label for="diseaseCategory2">중분류</label> <select
						id="diseaseCategory2" class="form-control" name = "diseaseCategory2">
					</select>
				</div>
				<div class="form-group">
					<label for="diseaseCategory3">소분류</label> <select
						id="diseaseCategory3" class="form-control" name = "diseaseCategory3">
					</select>
				</div>
				<div class="form-group">
					<label for="inputState">옵션</label> <select id="diseaseCategory4"
						class="form-control" name="diseaseCategory4">
						<option selected value=""></option>
						<option value="+">+</option>
					</select>
				</div>
			</div>
			<br> <label for="informationOpen">공개여부</label> <select
				class="form-control" id="informationOpen" name="informationOpen">
				<option selected value="1">공개</option>
				<option value="2">비공개</option>
			</select> <br>
			<div class="form-row">
				<div class="form-group">
					<label for="hospitalType">치료구분</label> <select id="hospitalType"
						class="form-control" name="hospitalType">
						<option selected value="1">통원</option>
						<option value="2">입원</option>
					</select>
				</div>
				<div class="form-group">
					<label for="treatementDays">치료일수</label> <select
						id="treatementDays" class="form-control" name="treatementDays">
					</select>
				</div>
			</div>
			<input type="text" class="form-control" placeholder="제목" name = "questionTitle">
			<div class="col-sm-4 ">
				<div class="basic_div form-group">
					<label for="comment">내용</label>
					<textarea class="form-control" rows="5" cols="20" id="comment"
						name="questionContent"></textarea>
				</div>
			</div>
			<input type="submit" class="btn btn-info" value="제출">
		</form>
		<div class="container">
			<div class="row">
				<div class="col-sm-4 ">
					<h3>Column 1</h3>
					<div class="basic_div"></div>
				</div>
				<div class="col-sm-4">
					<h3>Column 2</h3>
					<div class="basic_div"></div>
				</div>
				<div class="col-sm-4">
					<h3>Column 3</h3>
					<div class="basic_div"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>