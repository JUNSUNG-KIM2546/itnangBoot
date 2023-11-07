var ie = /MSIE/.test(navigator.userAgent);
ieVer = ie ? parseInt(navigator.userAgent.split('MSIE')[1].split(';')[0]) : false;

!function ($) {
	'use strict';

	$(function () {
		initUI.setup();
	});

	var initUI = (function () {
		var isLoaded;

		function setup() {
			if (isLoaded) {
				return;
			}

			isLoaded = true;

			pluginJueryuiFunc().init();
			uiHeader().init();
			uiCommon().init();
			$('.lnb').flexibleLNB();
		}

		return {
			setup: setup
		};
	})();
}(jQuery);


// ------------------------  공통함수 ------------------------
var exTarget;
var a11yFocus = function () { // 접근성 포커싱 관련 공통 함수. 함수 선언 시 exTarget 전역변수로 넣어줘야함.
	function openFocus(e, tit) {
		exTarget = $(e.target);

		setTimeout(function () {
			tit.attr('tabindex', '-1').focus();
		}, 0)
	}

	function closeFocus() { // btn, a 같은 것들
		setTimeout(function () {
			$(exTarget).focus();
		}, 0)
	}

	function closeFocusTabindex() { // tabindex 넣어줘야하는 것들
		setTimeout(function () {
			$(exTarget).attr('tabindex', '-1').focus();
		}, 0)
	}

	return {
		openFocus: openFocus,
		closeFocus: closeFocus,
		closeFocusTabindex: closeFocusTabindex
	}
}

/**
 * @param opt {
 * 	'obj' : 토글 클래스가 붙을 오브젝트,
 * 	'className' : 토글시 클래스명,
 * 	'hasClass' : 요소가 클래스를 가지고 있을 때 함수를 실행한다,
 * 	'noneClass' : 요소가 클래스를 가지고 있지 않을 때 함수를 실행한다
 * } 
 */
var togglCommonFunc = function (opt) {
	opt.obj = opt.obj;

	$(opt.obj).toggleClass(opt.className);

	if ($(opt.obj).hasClass(opt.className)) {
		opt.hasClass()

	} else {
		opt.noneClass();
	}
}

/**
 *
 * @param opt {
 * pc : function
 * mo : function
 * ta : fucntion
 * }
 */
var ssmFunc = function (opt) {
	var ssmPc = (opt.hasOwnProperty('pc') && opt.pc) ? true : false;
	var ssmTa = (opt.hasOwnProperty('ta') && opt.ta) ? true : false;
	var ssmMo = (opt.hasOwnProperty('mo') && opt.mo) ? true : false;

	if (ssmPc) {
		ssm.addState({
			id: 'pc',
			query: '(min-width: 1025px)',
			onEnter: function () {
				opt.pc();
			},
		});
	}
	if (ssmTa) {
		ssm.addState({
			id: 'ta',
			query: '(min-width: 768px) and (max-width: 1024px)',
			onEnter: function () {
				opt.ta();
			},
		});
	}
	if (ssmMo) {
		ssm.addState({
			id: 'mo',
			query: '(max-width: 767px)',
			onEnter: function () {
				opt.mo();
			},
		});
	}
}


/* FUNC */
var pluginJueryuiFunc = function () {
	function init() {
		_jqueryCommonFunc();
	}

	function _jqueryCommonFunc() {
		$('input[type=checkbox], input[type=radio]').checkboxradio();
		$('.tabs ul').tabs();
		$('.datepicker:not(.dropdown)').datepicker({
			closeText: '닫기',
			prevText: '이전달',
			nextText: '다음달',
			currentText: '오늘',
			monthNames: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
			monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
			dateFormat: 'yy-mm-dd',
			dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
			firstDay: 0,
			isRTL: false,
			duration: 200,
			showAnim: 'show',
			showMonthAfterYear: true,
			yearSuffix: '.'
		});
		$('.datepicker.dropdown').datepicker({
			changeMonth: true,
			changeYear: true,
			yearSuffix: '',
			monthNamesShort: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'],
		});
	}

	return {
		init: init
	}
};

var uiHeader = function () {
	function init() {
		startFunc('.site-header .site-gnb', fncGnb);
		startFunc('.m-site-header .site-gnb', fncMGnb);
		startFunc('.m-my-site-header', fncMyMGnb);
	}

	function startFunc(obj, fn) {
		$(obj).each(function (idx, data) {
			_startFunc = new fn();
			_startFunc.init(data);
		});
	}

	return {
		init: init
	}
}

var fncGnb = function () {
	var obj;

	function init(_obj) {
		obj = $(_obj).children('ul');
		gnb(obj);
	}

	function gnb(_gnb) {
		gnb = $(_gnb);

		var snb = $('<div class="snb"></div>').appendTo(gnb.parent()),
			dep1 = gnb.find('>li>a'),
			ul = gnb.children().find('>ul'),
			ulLeng, ulH, timer;

		// snb, ul의 높이값 지정
		var ulL_temp = 0,
			prevH = 0,
			padding = 14;
		for (var i = 0; i < ul.length; i++) {
			//ulLeng = ul.eq(i).find('li').length;
			//if (ulLeng > ulL_temp) { ulL_temp = ulLeng; }
			//ulLeng = ulL_temp;
			ulLeng = ul.eq(i).height();

			if (ulLeng > prevH) {
				prevH = ulLeng + padding;
			}
		}
		//ulH = ul.eq(0).find('li:first-child').height() * ulLeng;
		//ulH = gnb.find('ul').height();


		ulH = prevH;

		// 이벤트 설정 및 기능 실행
		closeSNB();

		dep1.on('mouseenter.fncGnb', function () {
			openSNB();
		}).on('focusin.fncGnb', function () {
			openSNB();
		});

		gnb.parent().on('mouseleave.fncGnb', function () {
			timer = setTimeout(function () {
				closeSNB();
			}, 500);
		}).on('mouseenter.fncGnb', function () {
			clearTimeout(timer);
		});

		//ul.last().find('li').last().find('a').on('focusout.openSNB',function(){
		//	closeSNB();
		//});

		ul.find('a').on('focusin', function (e) {
			openSNB();
		})
			.on('focusout', function (e) {
				closeSNB();
			});

		// 열기
		function openSNB() {
			gnb.addClass('open-snb');
			snb.stop().animate({
				height: ulH,
				paddingTop: padding + 'px',
				paddingBottom: padding + 'px',
				opacity: 1
			});
			ul.stop().animate({
				height: ulH,
				opacity: 1,
				paddingTop: padding + 'px',
				paddingBottom: padding + 'px'
			});
			/* bg 있을경우 스타일 */
			$('.bg-gnb').css({
				height: ulH,
				paddingTop: padding + 'px',
				paddingBottom: padding + 'px',
				opacity: .9
			});
		}

		// 닫기
		function closeSNB() {
			gnb.removeClass('open-snb');
			snb.stop().animate({
				height: 0,
				paddingTop: 0,
				paddingBottom: 0,
				opacity: 0
			});
			ul.stop().animate({
				height: 0,
				paddingTop: 0,
				paddingBottom: 0,
				opacity: 0
			});
			/* bg 있을경우 스타일 리셋 */
			$('.bg-gnb').css({
				height: 0,
				paddingTop: 0,
				paddingBottom: 0,
				opacity: 0
			});
		}
	}

	return {
		init: init
	}
}	

var fncMGnb = function () {
	var init = function (mgnb) {
	    $('.btn-site-nav').on('click', function () {
	        $('.m-site-header').toggleClass('active');				
			//$('.m-site-header.active').flexibleLNB();
			$('.m-site-header.active nav > ul').accordion({
				heightStyle: "content",
				active: true,
				collapsible: true
			});
		});
	}

	$(this).each(function () {
	    init(this);
	});

	return $(this);
}


var fncMyMGnb = function () {
	var init = function (mgnb) {
		$('.btn-my-site-nav').on('click', function () {
			$('.m-my-site-header').toggleClass('active');
		});
	}

	$(this).each(function () {
		init(this);
	});

	return $(this);
}

var fncToggleSchOption = function (btn) {
	var box = $(btn).closest('.sch-option');
	box.toggleClass('active');
	box.find('fieldset').slideToggle(300);
	if (box.hasClass('active')) {
		$(btn).attr('title' , '도서관 더보기 닫기');
	}
	else {
		$(btn).attr('title' , '도서관 더보기 열기');
    }
}

var fncBookSort = function (btn) {
	var $btn = $(btn);
	$btn.siblings('.btn').removeClass('on');
    $btn.addClass('on');
	sortType = 	$btn.children('i').hasClass('ico-list');
	if(sortType) {
		$('.book-list').addClass('sort-list');
		fnSetCookieValue("bookList", "Y");
		$(".listAtN").attr("title", "선택됨");
		$(".listAtY").attr("title", "");
    }
	else {
		$('.book-list').removeClass('sort-list');
		fnSetCookieValue("bookList", "N");
		$(".listAtN").attr("title", "");
		$(".listAtY").attr("title", "선택됨");
    }
}

var uiCommon = function () {
	function init() {
		startFunc('.tab-list', tabList);
		startFunc('.file-box', fileuploadFocus);
	}

	function startFunc(obj, fn) {
		$(obj).each(function (idx, data) {
			_startFunc = new fn();
			_startFunc.init(data);
		});
	}

	return {
		init: init
	}
}

var tabList = function() {
	var init = function () {
		var $tab_list = $('.tab-list'),
			$tab_nav = $tab_list.find('.tab-list-nav'),
			$tab_navH = $tab_nav.height();

		$tab_list.find('.tab-list-cont').hide();
		$tab_list.find('li.active .tab-list-cont').show();
			
		

		/*function listH(obj) {
			$(obj).each(function(){
				var $this = $(this);	
				$this.css('height','auto');
				$this.height($this.find('.tab-list-cont').outerHeight(true) + $tab_navH);
			});
		}*/

		function listH(obj) {
			$(obj).each(function(){
				var $this = $(this),
				    $tabcont = $(this).find('.tab-list-cont');
				var tabcontH = 0;	

				// tab-list-cont 중 제일 큰 높이 찾기
				$tabcont.each(function(){
					if ($(this).outerHeight(true) > tabcontH) {
						tabcontH = $(this).outerHeight(true);
					}
				});		

				$this.css('height','auto');
				$this.height(tabcontH + $tab_navH);
			});
		}


		function listTabMenuToggle(obj){	
			var $this = $(obj);
			$this.next('.tab-list-cont').show().parent('li').addClass('active').siblings('li').removeClass('active').find('.tab-list-cont').hide();

			//tab-nav 클릭시 tab-list-cont 높이 세팅
			//$this.closest('.tab-list').height($this.next('.tab-list-cont').outerHeight(true) + $tab_navH);

			if($this.attr('href') === '#'){
				return false;
			}
		}
		
		listH($tab_list);

		$tab_nav.on('click, focus', function(e) {
			e.preventDefault();
			listTabMenuToggle($(this));
		});
    }

    $(this).each(function () {
        init(this);
    });

    return $(this);

}


//메인페이지 달력 해당일자 클릭하면 레이어 팝업 띄우는 스크립트
function layer_open(el, searchDay, obj) {
	var listCount = $('.layer').find(".listSize").size();
	var i;
	for(i=1;i<=listCount;i++) {
		$('.layer').find(".schdulEndde"+i).parent(".layer_content").hide();
		// 게시물 시작하는 날짜
		var schdulBgnde = $('.layer').find(".schdulBgnde"+i).val();
		var schdulBgnde2 = schdulBgnde.substr(0,8);
		
		// 게시물 마지막 날짜
		var schdulEndde = $('.layer').find(".schdulEndde"+i).val();
		var schdulEndde2 = schdulEndde.substr(0,8);
		
		if(schdulBgnde2 <= searchDay && schdulEndde2 >= searchDay) {
			$('.layer').find(".schdulEndde"+i).next(".listNm").show();
			$('.layer').find(".schdulEndde"+i).parent(".layer_content").show();
			$('.layer').find(".schdulEndde"+i).parent(".layer_content").attr('tabindex', '0');
		}
	}
	
	var temp = $('#' + el);
	var bg = temp.prev().hasClass('bg'); //dimmed 레이어를 감지하기 위한 boolean 변수

	if (bg) {
		$('.layer').fadeIn(); //'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다.
	} else {
		temp.fadeIn();
	}

	// 화면의 중앙에 레이어를 띄운다.
	if (temp.outerHeight() < $(document).height()) temp.css('margin-top', '-' + temp.outerHeight() / 2 + 'px');
	else temp.css('top', '0px');
	if (temp.outerWidth() < $(document).width()) temp.css('margin-left', '-' + temp.outerWidth() / 2 + 'px');
	else temp.css('left', '0px');

	$('.layer').find(".layer_content:visible:eq(0)").focus();

	temp.find('a.cbtn').click(function(e) {
		if (bg) {
			$('.layer').fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다.
			$(obj).focus();
		} else {
			temp.fadeOut();
			$(obj).focus();
		}
		e.preventDefault();
	});

	$('.layer .bg').click(function(e) {//배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
		$('.layer').fadeOut();
		e.preventDefault();
	});
}

function layerPopupShow(obj){
	var w = parseInt($(obj).outerWidth()) / 2,
		h = parseInt($(obj).outerHeight()) / 2;

	$(obj).css({
		marginLeft : -w,
		marginTop : -h
	}).show();
}


var fileuploadFocus = function() {
	var init = function () {
		$fileBox = $('.file-box'); 
		btnupFocus();
	}

	 function btnupFocus() {
		 var $this = $fileBox,
			 $label = $this.find('label');
	 
			  $label.on('keypress', function(a) {
		         if(a.keyCode == 13) { 		        	
		        	 $(this).click();   
		        	 return  false;
		         }
			 });
     }
	
	$(this).each(function () {
		init(this);
	});

	return $(this);

}

