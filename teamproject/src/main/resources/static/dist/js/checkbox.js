/**
 * checkbox가 있는 테이블에서 전체 선택 및 해제 
 * ------------------
 * You should not use this file in production.
 * This file is for demo purposes only.
 */
(function ($) {
	//전체 선택 & 해제
	var allCheck = $('[name=checkAll]');
	var checkRow = $('[name=checkRow]');
	allCheck.click(function(){
		if(allCheck.is(":checked")) {
			checkRow.prop("checked",true);
			console.log("체크하기");
		}else{			
			console.log("해제하기");
			checkRow.prop("checked",false); 
		}
	});
	//하나 취소되면 전체 선택 해제
	checkRow.click(function(){
		if($('[name=checkRow]:checked').length == 10){
			allCheck.prop("checked",true);
		}else{
			allCheck.prop("checked",false);
		}
	});
})(jQuery)
