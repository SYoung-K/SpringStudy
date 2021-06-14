/**
 * 
 */



function move(now){
	var frm = $('#frm_board')[0];
		frm.nowPage.value = nowPage;
		var param = $(frm).serialize();
	
		$('#border').load('./board.do?job=search', param);
}
