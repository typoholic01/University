<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<!-- submit용 script -->
<script type="text/javascript">
window.onload = function() {
    document.getElementById('click').onclick = function() {
        document.getElementById('bbsWrite').submit();
        return false;
    };
};
</script>
<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Font-Awesome -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Bootstrap-select -->
<link rel="stylesheet" href="../../assets/plugins/bootstrap-select-1.7.4/css/bootstrap-select.min.css">
<!-- Bootstrap-fileinput -->
<link rel="stylesheet" href="../../assets/plugins/bootstrap-fileinput-4.2.7/css/fileinput.css">
<!-- system-style -->
<link rel="stylesheet" href="../../assets/css/sys.css">
<!-- Common-style -->
<link rel="stylesheet" href="../../assets/css/classic.css">
<!-- BBS-style -->
<link rel="stylesheet" href="style.css">


<section class="category-content col-sm-9">
	<form id="bbsWrite" action="./write.do" method="POST">
    <h2 class="category-title">공지사항 글쓰기</h2>
    <!-- bbs write -->
    <!-- 템플릿 시작 -->
    <section class="rb-bbs rb-bbs-write">

        <form class="form-horizontal" enctype="multipart/form-data">
            <div class="form-group rb-category">
              <label for="" class="col-sm-2 control-label">카테고리</label>
              <div class="col-sm-10">
                  <span class="rb-category">
                      <select class="selectpicker input-group-btn bs-select-hidden" title="선택하세요"><option class="bs-title-option" value="">선택하세요</option>
                          <option data-subtext="(1)">카테고리1</option>
                          <option data-subtext="(23)">카테고리2</option>
                          <option data-subtext="(21)">카테고리3</option>
                          <option data-subtext="(11)">카테고리4</option>
                          <option data-subtext="(3)">카테고리5</option>
                          <option data-subtext="(2)">카테고리6</option>
                      </select><div class="btn-group bootstrap-select input-group-btn"><button type="button" class="btn dropdown-toggle btn-default" data-toggle="dropdown" title="선택하세요" aria-expanded="false"><span class="filter-option pull-left">선택하세요</span>&nbsp;<span class="bs-caret"><span class="caret"></span></span></button><div class="dropdown-menu open" style="max-height: 673px; overflow: hidden; min-height: 83px;"><ul class="dropdown-menu inner" role="menu" style="max-height: 661px; overflow-y: auto; min-height: 71px;"><li data-original-index="1"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">카테고리1<small class="text-muted">(1)</small></span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="2"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">카테고리2<small class="text-muted">(23)</small></span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="3"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">카테고리3<small class="text-muted">(21)</small></span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="4"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">카테고리4<small class="text-muted">(11)</small></span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="5"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">카테고리5<small class="text-muted">(3)</small></span><span class="glyphicon glyphicon-ok check-mark"></span></a></li><li data-original-index="6"><a tabindex="0" class="" style="" data-tokens="null"><span class="text">카테고리6<small class="text-muted">(2)</small></span><span class="glyphicon glyphicon-ok check-mark"></span></a></li></ul></div></div>
                      <a href="" class="btn btn-link btn-sm">
                          추가
                      </a>
                  </span>
              </div>
          </div>
            <div class="form-group">
                <label for="" class="col-sm-2 control-label">제목</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="" placeholder="제목을 입력하세요.">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <label class="checkbox-inline">
                        <input type="checkbox" id="" value="option1"> 공지글
                    </label>
                    <label class="checkbox-inline">
                        <input type="checkbox" id="" value="option2"> 비밀글
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label class="sr-only">내용</label>
                <div class="col-sm-12">

                    <div class="panel panel-default rb-editor">
                        <div class="panel-heading hidden-xs rb-editor-toolbar">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Bold">
                                    <i class="fa fa-bold"></i>
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Italic">
                                    <i class="fa fa-italic"></i>
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Underline">
                                    <i class="fa fa-underline"></i>
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Strikethrough">
                                    <i class="fa fa-strikethrough"></i>
                                </button>
                            </div>
                            <div class="btn-group">
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Cut">
                                    <i class="fa fa-scissors"></i>
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Copy">
                                    <i class="fa fa-copy"></i>
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Past">
                                    <i class="fa fa-paste"></i>
                                </button>
                            </div>
                            <div class="btn-group">
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Undo">
                                    <i class="fa fa-reply"></i>
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Redo">
                                    <i class="fa fa-share"></i>
                                </button>
                            </div>
                            <div class="btn-group">
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Align left">
                                    <i class="fa fa-align-left"></i>
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Align center">
                                    <i class="fa fa-align-center"></i>
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Align right">
                                    <i class="fa fa-align-right"></i>
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Align justify">
                                    <i class="fa fa-align-justify"></i>
                                </button>
                            </div>
                            <div class="btn-group">
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Numbered list">
                                    <i class="fa fa-list-ol"></i>
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Bulleted list">
                                    <i class="fa fa-list-ul"></i>
                                </button>
                            </div>
                            <div class="btn-group">
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Link">
                                    <i class="fa fa-link"></i>
                                </button>
                                <button type="button" class="btn btn-default" data-toggle="tooltip" title="Unlink">
                                    <i class="fa fa-unlink"></i>
                                </button>
                            </div>
                        </div>
                        <div class="rb-editor-body">
                            <textarea class="form-control" rows="15"></textarea>
                        </div>

                        <div class="panel-body rb-fileinput">
                            <a href="" class="btn btn-default btn-sm" data-toggle="modal" data-target="#modal-insertPhoto"><i class="fa fa-camera-retro fa-lg fa-fw"></i> 사진삽입</a>
                            <a href="" class="btn btn-default btn-sm" data-toggle="modal" data-target="#modal-attachFile"><i class="fa fa-floppy-o fa-lg fa-fw"></i> 파일첨부</a>
                        </div>
                    </div>

                    <div class="rb-attach">
                        <ul class="list-group rb-attach-photo">
                            <li class="list-group-item">
                                <span class="pull-right">
                                    <div class="btn-group btn-group-xs">
                                        <a href="" class="btn btn-default" title="삭제" data-toggle="tooltip"><i class="fa fa-times"></i></a>
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <span class="caret"></span>
                                            <span class="sr-only">Toggle Dropdown</span>
                                        </button>
                                        <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                            <li><a href="#">대표이미지 설정</a></li>
                                            <li><a href="#" data-toggle="modal" data-target="#modal-attach-photo-meta" data-filename="국화"  data-filetype="jpg" data-caption="국화 사진 캡션 입니다.">정보수정</a></li>
                                            <li><a href="#">숨김</a></li>
                                            <li><a href="#">삭제</a></li>
                                            <li class="divider"></li>
                                            <li role="presentation" class="dropdown-header">순서조정</li>
                                            <li><a href="#"><i class="fa fa-caret-up fa-lg"></i> 위로</a></li>
                                            <li><a href="#"><i class="fa fa-caret-down fa-lg"></i> 아래로</a></li>
                                        </ul>
                                    </div>
                                </span>
                                <div class="media">
                                    <a class="pull-left" href="#">
                                        <img class="media-object" src="http://placehold.it/48x48/" alt="">
                                    </a>
                                    <div class="media-body">
                                        <span class="label label-default">대표</span>
                                        <a href="">국화.jpg</a>
                                        <span class="rb-size">446.1KB</span> 
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item">
                                <span class="pull-right">
                                    <div class="btn-group btn-group-xs">
                                        <a href="" class="btn btn-default" title="삭제" data-toggle="tooltip"><i class="fa fa-times"></i></a>
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <span class="caret"></span>
                                            <span class="sr-only">Toggle Dropdown</span>
                                        </button>
                                        <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                            <li><a href="#">대표이미지 설정</a></li>
                                            <li><a href="#" data-toggle="modal" data-target="#modal-attach-photo-meta" data-filename="사막"  data-filetype="gif" data-caption="사막사진 캡션 입니다.">정보수정</a></li>
                                            <li><a href="#">숨김</a></li>
                                            <li><a href="#">삭제</a></li>
                                            <li class="divider"></li>
                                            <li role="presentation" class="dropdown-header">순서조정</li>
                                            <li><a href="#"><i class="fa fa-caret-up fa-lg"></i> 위로</a></li>
                                            <li><a href="#"><i class="fa fa-caret-down fa-lg"></i> 아래로</a></li>
                                        </ul>
                                    </div>
                                </span>
                                <div class="media">
                                    <a class="pull-left" href="#">
                                        <img class="media-object" src="http://placehold.it/48x48/" alt="">
                                    </a>
                                    <div class="media-body">
                                        <a href="">사막.jpg</a>
                                        <span class="rb-size">446.1KB</span> 
                                    </div>
                                </div>
                            </li>
                        </ul>
                        <ul class="list-group rb-attach rb-attach-file">
                            <li class="list-group-item">
                                <i class="fa fa-floppy-o fa-fw"></i> 
                                <a href="" class="list-group-item-text">STP-SWOT 분석-2010.05.hwp</a> 
                                <span class="rb-size">446.1KB</span>
                                <div class="btn-group btn-group-xs pull-right">
                                    <a href="" class="btn btn-default" data-toggle="tooltip" title="삭제"><i class="fa fa-times"></i></a>
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                        <li><a href="#" data-toggle="modal" data-target="#modal-attach-file-meta" data-filename="STP-SWOT 분석-2010.05"  data-filetype="hwp" data-caption="캡션 입니다.">정보수정</a></li>
                                        <li><a href="#">숨김</a></li>
                                        <li><a href="#">삭제</a></li>
                                        <li class="divider"></li>
                                        <li role="presentation" class="dropdown-header">순서조정</li>
                                        <li><a href="#"><i class="fa fa-caret-up fa-lg"></i> 위로</a></li>
                                        <li><a href="#"><i class="fa fa-caret-down fa-lg"></i> 아래로</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="list-group-item rb-hidden">
                                <span class="label label-default">숨김</span> 
                                <i class="fa fa-floppy-o fa-fw"></i> 
                                <a href="" class="list-group-item-text">131227-포상 공감대상자 명단(공개검증).xlsx</a> 
                                <span class="rb-size">446.1KB</span>
                                <div class="btn-group btn-group-xs pull-right">
                                    <a href="" class="btn btn-default" data-toggle="tooltip" title="삭제"><i class="fa fa-times"></i></a>
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                        <li><a href="#" data-toggle="modal" data-target="#modal-attach-file-meta" data-filename="31227-포상 공감대상자 명단(공개검증)"  data-filetype="xlsx" data-caption="캡션 입니다.">정보수정</a></li>
                                        <li><a href="#">보이기</a></li>
                                        <li><a href="#">삭제</a></li>
                                        <li class="divider"></li>
                                        <li role="presentation" class="dropdown-header">순서조정</li>
                                        <li><a href="#"><i class="fa fa-caret-up fa-lg"></i> 위로</a></li>
                                        <li><a href="#"><i class="fa fa-caret-down fa-lg"></i> 아래로</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="list-group-item">
                                <i class="fa fa-floppy-o fa-fw"></i> 
                                <a href="" class="list-group-item-text">공유저작물 개방형 협업 기반 조성 및 포털서비스 운영 제안서.pdf</a> 
                                <span class="rb-size">446.1KB</span> 
                                <div class="btn-group btn-group-xs pull-right">
                                    <a href="" class="btn btn-default" data-toggle="tooltip" title="삭제"><i class="fa fa-times"></i></a>
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                        <li><a href="#" data-toggle="modal" data-target="#modal-attach-file-meta" data-filename="공유저작물 개방형 협업 기반 조성 및 포털서비스 운영 제안서"  data-filetype="pdf" data-caption="캡션 입니다.">정보수정</a></li>
                                        <li><a href="#">숨김</a></li>
                                        <li><a href="#">삭제</a></li>
                                        <li class="divider"></li>
                                        <li role="presentation" class="dropdown-header">순서조정</li>
                                        <li><a href="#"><i class="fa fa-caret-up fa-lg"></i> 위로</a></li>
                                        <li><a href="#"><i class="fa fa-caret-down fa-lg"></i> 아래로</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="list-group-item">
                                <i class="fa fa-floppy-o fa-fw"></i> 
                                <a href="" class="list-group-item-text">사업계획서(웹_접근성_품질인증기관_지정관련)_작성_요령.zip</a> 
                                <span class="rb-size">446.1KB</span>
                                <div class="btn-group btn-group-xs pull-right">
                                    <a href="" class="btn btn-default" title="삭제" data-toggle="tooltip"><i class="fa fa-times"></i></a>
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                        <li><a href="#" data-toggle="modal" data-target="#modal-attach-file-meta" data-filename="사업계획서(웹_접근성_품질인증기관_지정관련)_작성_요령"  data-filetype="zip" data-caption="캡션 입니다.">정보수정</a></li>
                                        <li><a href="#">숨김</a></li>
                                        <li><a href="#">삭제</a></li>
                                        <li class="divider"></li>
                                        <li role="presentation" class="dropdown-header">순서조정</li>
                                        <li><a href="#"><i class="fa fa-caret-up fa-lg"></i> 위로</a></li>
                                        <li><a href="#"><i class="fa fa-caret-down fa-lg"></i> 아래로</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="list-group-item">
                                <i class="fa fa-floppy-o fa-fw"></i> 
                                <a href="" class="list-group-item-text">사업계획서(웹_접근성_품질인증기관_지정관련)_작성_요령.docx</a> 
                                <span class="rb-size">446.1KB</span> 
                                <div class="btn-group btn-group-xs pull-right">
                                    <a href="" class="btn btn-default" data-toggle="tooltip" title="삭제"><i class="fa fa-times"></i></a>
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                        <li><a href="#" data-toggle="modal" data-target="#modal-attach-file-meta" data-filename="사업계획서(웹_접근성_품질인증기관_지정관련)_작성_요령"  data-filetype="docx" data-caption="캡션 입니다.">정보수정</a></li>
                                        <li><a href="#">숨김</a></li>
                                        <li><a href="#">삭제</a></li>
                                        <li class="divider"></li>
                                        <li role="presentation" class="dropdown-header">순서조정</li>
                                        <li><a href="#"><i class="fa fa-caret-up fa-lg"></i> 위로</a></li>
                                        <li><a href="#"><i class="fa fa-caret-down fa-lg"></i> 아래로</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="" class="col-sm-2 control-label">검색태그</label>
                <div class="col-sm-10">
                    <div class="input-group input-group-sm">
                        <input type="text" class="form-control" placeholder="콤마(,)로 구분해서 입력해 주세요.">
                            <span class="input-group-btn">
                            <button class="btn btn-default" type="button" data-toggle="collapse" data-target="#help-tag"><i class="fa fa-question fa-lg"></i></button>
                        </span>
                    </div>
                    <span class="collapse help-block" id="help-tag">
                        이 게시물을 가장 잘 표현할 수 있는 단어를 콤마(,)로 구분해서 입력해 주세요.
                    </span>
                </div>
            </div>
             <div class="form-group">
                <label for="" class="col-sm-2 control-label">엮을주소</label>
                <div class="col-sm-10">
                    <div class="input-group input-group-sm">
                        <input type="text" class="form-control" placeholder="">
                            <span class="input-group-btn">
                            <button class="btn btn-default" type="button" data-toggle="collapse" data-target="#help-trackback"><i class="fa fa-question fa-lg"></i></button>
                        </span>
                    </div>
                    <span class="collapse help-block" id="help-trackback">
                        이 게시물을 보낼 트랙백주소를 입력해 주세요.
                    </span>
                </div>
            </div>
            <hr>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <p class="form-control-static"><span class="text-muted">게시물 등록(수정/답변) 후</span></p>
                    <label class="radio-inline">
                        <input type="radio" name="backtype" id="" value="option1" checked="checked"> 목록으로 이동
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="backtype" id="" value="option2"> 본문으로 이동
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="backtype" id="" value="option3"> 이 화면 유지
                    </label>
                </div>
            </div>
            <hr>
            <div class="form-group">
                <div class="col-sm-12 text-center">
                    <button type="button" class="btn btn-default">취소</button>
                    <button type="submit" class="btn btn-primary">확인</button>
                </div>
            </div>
        </form>
    </section>
    <!-- 템플릿 끝 -->

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

        <!-- Bootstrap js -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        <!-- Bootstrap-selcct js -->
        <script src="../../assets/plugins/bootstrap-select-1.7.4/js/bootstrap-select.min.js"></script>

        <!-- Bootstrap-fileinput js -->
        <script src="../../assets/plugins/bootstrap-fileinput-4.2.7/js/fileinput.min.js"></script>

        <!-- canvas-to-blob.min.js is only needed if you wish to resize images before upload.
             This must be loaded before fileinput.min.js -->
        <script src="../../assets/plugins/bootstrap-fileinput-4.2.7/js/plugins/canvas-to-blob.min.js"></script>

        <script src="../../assets/plugins/bootstrap-fileinput-4.2.7/js/fileinput_locale_ko.js"></script>

        <!-- Common js -->
        <script src="../../assets/js/common.js"></script>

        <!-- bbs js -->
        <script src="./script.js"></script>

        <script type="text/javascript">

            // Bootstrap-selcct - http://silviomoreto.github.io/bootstrap-select/
            $('.rb-bbs .selectpicker').addClass('input-group-btn').selectpicker('setStyle');

            // Bootstrap-fileinput - https://github.com/kartik-v/bootstrap-fileinput
            $("#bbs-insertPhoto").fileinput({
                language: 'ko',
                uploadUrl: "http://localhost/file-upload-single/2", // server upload action
                uploadAsync: true,
                allowedFileExtensions : ['jpg', 'png','gif','pdf','pptx'],
                overwriteInitial: false,
                maxFileSize: 100000,
                maxFileCount: 10,
                maxFilesNum: 10,
                browseClass: "btn btn-primary",
                removeClass: "btn btn-default",
                uploadClass: "btn btn-primary",
                showUpload: false,
                showCaption: false,
                browseLabel: "찾아보기..",
                removeLabel: "전체삭제",
                removeIcon: "<i class=\"glyphicon glyphicon-trash\"></i> ",
                uploadClass: "btn btn-info",
                uploadLabel: "Upload",
                uploadIcon: "<i class=\"glyphicon glyphicon-upload\"></i> ",
                allowedFileExtensions: ["jpg", "png", "gif"],

                layoutTemplates: {
                    main1: "{preview}\n" +
                    "<div class=\'input-group {class}\'>\n" +
                    "   <div class=\'input-group-btn\'>\n" +
                    "       {browse}\n" +
                    "       {upload}\n" +
                    "       {remove}\n" +
                    "   </div>\n" +
                    "   {caption}\n" +
                    "</div>"
                },

                allowedFileTypes: ['image', 'video', 'flash'],
                slugCallback: function(filename) {
                    return filename.replace('(', '_').replace(']', '_');
                }
            });

            $("#bbs-attachFile").fileinput({
                language: 'ko',
                uploadUrl: "http://localhost/file-upload-single/2", // server upload action
                uploadAsync: true,
                allowedFileExtensions : ['zip', 'png','gif','pdf','pptx'],
                overwriteInitial: false,
                maxFileSize: 100000,
                maxFileCount: 10,
                maxFilesNum: 10,
                browseClass: "btn btn-primary",
                removeClass: "btn btn-default",
                uploadClass: "btn btn-primary",
                showUpload: false,
                showCaption: false,
                browseLabel: "찾아보기..",
                removeLabel: "전체삭제",
                removeIcon: "<i class=\"glyphicon glyphicon-trash\"></i> ",
                uploadClass: "btn btn-info",
                uploadLabel: "Upload",
                uploadIcon: "<i class=\"glyphicon glyphicon-upload\"></i> ",
                allowedFileExtensions: ["jpg", "png", "gif"],

                layoutTemplates: {
                    main1: "{preview}\n" +
                    "<div class=\'input-group {class}\'>\n" +
                    "   <div class=\'input-group-btn\'>\n" +
                    "       {browse}\n" +
                    "       {upload}\n" +
                    "       {remove}\n" +
                    "   </div>\n" +
                    "   {caption}\n" +
                    "</div>"
                },

                allowedFileTypes: ['image', 'video', 'flash'],
                slugCallback: function(filename) {
                    return filename.replace('(', '_').replace(']', '_');
                }
            });

            // 첨부파일 메타정보 수정 http://getbootstrap.com/javascript/#modals-related-target
            $('.rb-modal-attach-meta').on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget) // Button that triggered the modal
                var filename = button.data('filename') // Extract info from data-* attributes
                var filetype = button.data('filetype') // Extract info from data-* attributes
                var caption = button.data('caption') // Extract info from data-* attributes
                // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
                // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
                var modal = $(this)
                modal.find('.modal-body .input-group-addon').text('.'+filetype)
                modal.find('.modal-body input').val(filename)
                modal.find('.modal-body textarea').val(caption)
            })
        </script>
    <!-- button-group -->
	<div class="button-group">
		<div class="arc-comment">
			<a id="click" href="#" title="Comment"><i class="fa fa-comments"></i> 글쓰기</a>
		</div>
	</div>
	</form>
</section>
<!-- write code lisence by http://gitaeks.github.io/ -->