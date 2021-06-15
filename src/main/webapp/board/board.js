/**
 * 게시판
 */
var brd = {};

	//게시판 메뉴를 클릭한 경우
	brd.home = function(){
	alert("버튼 눌림")
	$('#border').load('search.brd');
	}
	
brd.init = function(){
	

	
	
	$('#board #btnFind').on('click', function(){
		var frm = $('#frm_board')[0];
		frm.nowPage.value = 1;
		var param = $(frm).serialize();
		$('#border').load('search.brd', param);
	})
	
	$('#board #btnSearch').on('click', function(){
		var frm = $('#frm_board')[0];
		
		var param = $(frm).serialize();
		$('#border').load('search.brd', param);
	})
	
	$('#board #btnInsert').on('click', function(){
		alert("버튼 눌림")
		var frm = $('#frm_board')[0];
		var param = $(frm).serialize();
		$('#border').load('register.brd', param);
	})
	
	$('#board #btnInsertR').on('click', function(){
		alert("버튼눌림")
		var frm = $('#frm_upload')[0];
		var data = new FormData(frm);
	
		$.ajax({
			type    : 'POST',
			url     : './fup.brd',
			enctype : 'multipart/form-data',
			data    : data,
			contentType : false,
			processData : false,
			success : function(resp){
				alert("성공")
				$('#border').load('insertR.brd');
			}
		});
		
	});
	
	

	$('#board #btnModify').on('click', function(){
		var frm = $('#frm_board')[0];
		var param = $(frm).serialize();
		$('#border').load('modify.brd', param);	
	})

	$('#board #btnUpdate').on('click', function(){
		$('#brdPasswordZone').css({
			'display' : 'block'
		})
	})
	$('#board #btnUpdateR').on('click', function(){
		var frm = $('#frm_board')[0];
		var pwd = $('#brdPasswordZone #pwd').val();
		frm.pwd.value = pwd;
	
		//내용입력폼과 파일 업로드폼이 분리되지 않아서...
		if(frm.findStr.value=='') frm.findStr.value = ' ';
		if(frm.serial.value=='') frm.serial.value = 0;
		if(frm.nowPage.value=='') frm.nowPage.value = '1';
		
		var data = new FormData(frm);
		
		$.ajax({
			type    : 'POST',
			url     : 'update.fup',
			enctype : 'multipart/form-data',
			data    : data,
			contentType : false,
			processData : false,
			success : function(resp){
				$('#brdPasswordZone').css({'display' : 'none'});
				$('#border').load('modifyR.brd');  
			}
		});
	});

		

	/* ------------------------------------------ */
	/*  답글 처리 부분                               */ 
	/* ------------------------------------------ */
	$('#board #btnRepl').on('click', function(){
		var frm = $('#frm_board')[0];
		var param = $(frm).serialize();
		$('#border').load('repl.brd', param);
	})
	
	$('#board #btnReplR').on('click', function(){
		var frm = $('#frm_board')[0];
		
		var data = new FormData(frm);
		
		$.ajax({
			type    : 'POST',
			url     : 'repl.fup',
			enctype : 'multipart/form-data',
			data    : data,
			contentType : false,
			processData : false,
			success : function(resp){
				$('#border').load('replR.brd');
			}
		});
		
	});
	
	
	
	
	
	$('#btnDelete').on('click', function(){
		$('#brdPasswordZone').css({
			'display' : 'block'
		})
	})
	
	$('#btnCancel').on('click', function(){
		$('#brdPasswordZone').css({
			'display' : 'none'
		})
	})
	
	$('#board #btnDeleteR').on('click', function(){
		var frm = $('#frm_board')[0];
		var pwd = $('#brdPasswordZone #pwd').val();
		frm.pwd.value = pwd;

		var param = $(frm).serialize();
		$('#border').load('delete.brd', param, function(){
			$('#brdPasswordZone').css({
				'display' : 'none'
			})
		});
	})
}



brd.view = function(serial){
	var frm = $('#frm_board')[0];
	frm.serial.value = serial;
	var param = $(frm).serialize();
	$('#border').load('view.brd', param);
	
}

brd.move = function(nowPage){
	var frm = $('#frm_board')[0];
	frm.nowPage.value = nowPage;
	var param = $(frm).serialize();
	
	$('#border').load('search.brd', param);
	
}



/* 파일 미리보기 --------------------- */
function imageView(fileTag, imageZone){
	var ft = document.getElementById(fileTag);
	var izone = document.getElementById(imageZone);
	
	ft.onchange = function(ev){
		var ele = ev.srcElement;//이벤트가 발생한 테그
		var files = ele.files;
		for(var index in files){
			console.table(files[index]);
		}
		
		for(var file of files){
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function(ev2){
				var div = makeItem(izone);
				var img = new Image();
				img.src = ev2.target.result;
				
				div.appendChild(img);
				izone.appendChild(div);
			}
		}
		
	} // end of ft.onchage
	
	// drag & drop 기능 추가
	izone.ondragenter = function(e){
		e.preventDefault();
		e.stopPropagation();
		return false;
	}
	
	izone.ondragover = function(e){
		e.preventDefault();
		e.stopPropagation();
		return false;
	}
	
	izone.ondrop = function(e){
		e.preventDefault();
		e.stopPropagation();

		var dt = e.dataTransfer;
		var files = dt.files;
		
		for(var file of files){
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function(ev2){
				var div = makeItem(izone);
				var img = new Image();
				img.src = ev2.target.result;
				
				div.appendChild(img);
				izone.appendChild(div);
			}
		}
	}
}


function makeItem(izone){
	// div 태그 생성 : <div class='item'></div>
	var div = document.createElement('div');
	div.setAttribute('class', 'item');
	
	// 삭제버튼 : <input type='button' value='x' class='del_btn' name='btnDel+ N'/>
	var delBtn = document.createElement('input');
	delBtn.setAttribute('type', 'button');
	delBtn.setAttribute('value', 'X')
	delBtn.setAttribute('class', 'del_btn')
	delBtn.setAttribute('name', 'btnDel')
	
	div.appendChild(delBtn);
	
	delBtn.onclick = function(){
		var p = this.parentNode;
		izone.removeChild(p);
	}
	
	
	return div;
}





