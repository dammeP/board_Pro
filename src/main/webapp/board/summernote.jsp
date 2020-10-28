<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Summernote</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  <script>
//     $(document).ready(function() {
//         $('#summernote').summernote();
//     });

    $(document).ready(function() {
        $('#summernote').summernote();
    });
    $(document).ready(function() {
    	$('#summernote').summernote({
    		  height: 300,                 // 에디터 높이
    		  minHeight: null,             // 최소 높이
    		  maxHeight: null,             // 최대 높이
    		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
    		  lang: "ko-KR",					// 한글 설정
    		  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
              
    	});
    });
  </script>
</head>
<body>
<!--   <div id="summernote"><p>Hello Summernote</p></div> -->
  <textarea id="summernote" name="editordata"></textarea> 
</body>
</html>