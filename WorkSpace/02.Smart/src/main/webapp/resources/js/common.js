/**
 * 공통 함수 선언
 */


function toPhone(tag) {
	// 02-1234-5678(10자리) 010-1234-5678(11자리)
	var phone = tag.val().replace(/[^0-9]/g, '').replace(/[-]/g, ''); // 숫자만 입력되게 처리
	if (phone.length > 1) { // 2자리 이상 입력하면 : 02, 062, 010...
		// -가 들어가야 할 위치 계산하기
		var start = phone.substr(0, 2) == "02" ? 2 : 3,
			middle = start + 4; // 두번째 항목 : 1234 - 무조건 4자리
		// - 만들어서 넣기
		if (phone.length > middle) {
			phone = phone.substr(0, start) + "-" + phone.substr(start, 4) + "-" + phone.substr(middle, 4);
		} else if (phone.length > start) {
			phone = phone.substr(0, start) + "-" + phone.substr(start, 4) + "-";
		}
	}
	// substr(0, 길이), substring(시작, 끝위치)
	tag.val(phone);
}

function modalAlert(type, title, message) {
	$('#modal-alert .modal-title').html(title);
	$('#modal-alert .modal-body').html(message);
	// 모달창 type에 따라 아이콘 모양, 색 지정을 위해 모든 클래스 삭제
	$('.modal-icon').removeClass('text-info text-warning text-danger text-primary text-success fa-circle-question fa-circle-exclamation')
	// 아니오/확인으로 사용되는 버튼의 색상 초기화
	$('.modal-footer .btn-ok').removeClass('btn-info btn-warning btn-danger btn-primary btn-success');

	if (type == 'danger') { // confirm에 해당
		// 아니오, 예 버튼
		$('.modal-footer .btn-ok').addClass('btn-secondary').text('아니오')
		$('.modal-footer .btn-danger').removeClass('d-none')
		$('.modal-icon').addClass('fa-circle-question') // 아이콘 물음표
	} else {
		// 확인 버튼, confirm일때만 사용 할 btn-danger는 필요없음
		$('.modal-footer .btn-ok').addClass('btn-' + type).text('확인')
		$('.modal-footer .btn-danger').addClass('d-none')
		$('.modal-icon').addClass('fa-circle-exclamation') // 아이콘 느낌표
	}
	$('.modal-icon').addClass('text-' + type);
}

// 동적으로 만들어진 요소에 대해서는 document에 이벤트를 등록해야 한다
$(document).on('click', '.date + .date-delete', function() {
	$(this).css('display', 'none'); // 삭제버튼 안보이게
	$(this).prev('.date').val(''); // 날짜 태그의 값을 초기화
})
	// 첨부파일 삭제 버튼 클릭
	.on('click', '#file-attach .file-delete', function() {
		$(this).addClass('d-none'); // 삭제버튼 안 보이게

		$('input[type=file]').val(''); // 첨부되어 있던 이미지파일 없애기
		var _preview = $('#file-attach .file-preview');
		if (_preview.length > 0) _preview.empty(); // 미리보기 한 이미지 태그 없애기
		var _name = $('#file-attach .file-name'); // 파일명 태그
		if (_name.length > 0) _name.empty(); // 파일명 없애기

	})

// 파일이 이미지파일인지 확인
function isImage(filename) {
	// abc.png, abc.jpg, abc.txt, abc.hwp, abc.bmp, abc.webp
	var ext = filename.substr(filename.lastIndexOf('.') + 1).toLowerCase(); // 파일확장자 => 대문자도 소문자로 바뀜
	var imgs = ["png", "jpg", "bmp", "gif", "webp", "jpeg"];
	return imgs.indexOf(ext) == -1 ? false : true;
}

// 첨부파일 크기 제한 함수
function rejectedFile(fileInfo, tag) {
	// 1024 byte = 1Kb, 1Mb = 1024*1024 byte, ...
	if (fileInfo.size > 1024 * 1024 * 10) {
		alert("10Mb를 넘는 파일은 첨부할 수 없습니다.");
		tag.val('');
		return true;
	} else
		return false;
}

$(function() {
	// 프로필 이미지 선택처리
	$('input#file-single').change(function() {
		// console.log($(this))
		// console.log(this.files)

		var _preview = $('#file-attach .file-preview'); // 이미지 미리보기 요소
		var _delete = $('#file-attach .file-delete'); // 파일 삭제요소
		var _name = $('#file-attach .file-name'); // 파일명 요소

		var attached = this.files[0];
		console.log(attached)
		if (attached) {
			// 파일사이즈 제한
			if (rejectedFile(attached, $(this))) return;
			// 파일명 보여지게
			if (_name.length > 0) _name.text(attached.name);
			_delete.removeClass('d-none');
			// 이미지파일인지 확인
			if (isImage(attached.name)) {
				singleFile = attached; // 선택한 파일정보를 관리
				_delete.removeClass('d-none'); // 삭제버튼 보이게

				// 미리보기 태그가 있을 때만
				if (_preview.length > 0) {
					_preview.html("<img>");

				} else {
					// 첨부파일이 이미지인데, 미리보기 요소가 없으면 동적으로 만들어 보이게 처리
					// 삭제버튼 앞에 넣기
					_delete.before("<span class='file-preview'><img></span>");
					_preview = $('#file-attach .file-preview')
				}
				var reader = new FileReader();
				reader.readAsDataURL(attached);
				reader.onload = function(e) {
					// _preivew.children("img").attr("src",e.target.result);
					_preview.children("img").attr("src", this.result);
				}
			} else {
				// 이전 선택했던 이미지 파일처리
				_preview.empty();

				if ($(this).hasClass("image-only")) {
					singleFile = ''; // 이미지가 아닌 파일일 경우는 관리정보를 초기화
					$(this).val(''); // 실제 file 태그의 정보는 초기화
					_delete.addClass('d-none'); // 삭제버튼 안보이게
				}
			}
		} else {
			// 파일선택 창에서 취소를 클릭한 경우 : 어떤 처리도 하지 않는다
			// 파일정보는 관리된 singleFile 변수에 있다.

		}
	})



	$('.date').change(function() {
		$(this).next('.date-delete').css('display', 'inline')
	})

	$('[name=phone]').keyup(function() {
		toPhone($(this));
	})

	var today = new Date();
	var range = today.getFullYear() - 100 + ':' + today.getFullYear();
	$.datepicker.setDefaults({
		dateFormat: "yy-mm-dd",
		changeYear: true,
		changeMonth: true,
		yearRange: range,
		showMonthAfterYear: true,
		monthNamesShort: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
		dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
		maxDate: today,
	})

	$(".date").datepicker();
	$(".date").attr('readonly', true);
})

// 입력항목 입력여부 확인
function emptyCheck() {
	var ok = true;
	$('.check-empty').each(function() {
		if ($(this).val() == "") {
			alert($(this).attr('title') + "을 입력하세요");
			$(this).focus();
			ok = false;
			return ok;
		}
	})
	return ok;
}




