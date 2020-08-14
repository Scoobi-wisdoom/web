// 카테고리 선택 후 제품 정보 출력
	function display(datas){
		$(datas).each(function(index,product){
			var result = '';
			result += '<h3>';
			result += 'Code= '+product.id + ',  Product= '+product.name + ',  Category= '+product.category_id
			+',  Price= '+product.price+',  Stock= '+product.num+ ',  Sales= '+ product.cuml; 
			result += '&nbsp&nbsp<button>X</button>';
			result += '</h3>';
			
			$('#product').append(result);
	});
	};		
	
	// 카테고리로 돌아가기 누르면 새로운 카테고리 목록 출력
	function category_return(){
		$('#product').empty();
		var cat1 = '<div num = "1" name = "w1"><img src="img/w1.png" alt="My Image"></div>';
		var cat2 = '<div num = "2" name = "w1"><img src="img/w2.jpg" alt="My Image"></div>';
		var cat3 = '<div num = "3" name = "w1"><img src="img/w3.jpg" alt="My Image"></div>';
		var cat4 = '<div num = "4" name = "w1"><img src="img/w4.jpg" alt="My Image"></div>';
		var cat5 = '<div num = "5" name = "w1"><img src="img/w5.jpg" alt="My Image"></div>';
		var cat6 = '<div num = "6" name = "w1"><img src="img/w6.jpg" alt="My Image"></div>';
		
	    $('#product').append(cat1);
	    $('#product').append(cat2);
	    $('#product').append(cat3);
	    $('#product').append(cat4);
	    $('#product').append(cat5);
	    $('#product').append(cat6);
	    // 카테고리 목록 불러온뒤 ready function 재실행 - 카테고리클릭 이벤트
	    $('#product > div').click(function(){
			var num = $(this).attr('num');
			category_change(num);
			sendData('ja'+num);
		});
	    
	};
	
	// div num 에 따라 ajax 데이터 받아오기
	function sendData(d){
		$.ajax({
			url:'getproduct',
			async:false,
			data:{categoryN:d},
			success:function(result){
				display(result);
			},
			error: function(){
				alert('Error....');
			}
		});
	};
	
	// 카테고리 출력 시 화면 리셋 (이후 제품목록 출력)
	function category_change(n){
		$('#product').empty();

	};
	// 검색한 내용 출력 
function searchDisplay(data){
	$(data.documents).each(function(index,add){
		var result = '';
		result += '<h3>'+add.title+' '+add.contents+'</h3>';  //document name(정해진 값! 바꿀 수X) = title-본문제목, contents-본문 내용
		$('#srch_r').append(result);
	});
};
//웹 검색 내용 받아오기
function getData(){
	var urlstr = 'https://dapi.kakao.com/v2/search/web';	
	var srch = $('#srch_i[name="srch"]').val();  //srch=search 줄임
	$.ajax({
		method:'GET',
		url:urlstr,
		headers:{'Authorization':'KakaoAK 26e6df87e0b209a73bde4bdcb47d3e95'}, // 카카오 rest API 키값 바꿔주세요
		data:{'query':srch},
		success:function(data){
			searchDisplay(data);
		},
		error:function(){
			alert('error');
		}
	});
};
//차트 데이터
	function pchart(p_data) {  //pchart = profit chart, p_data = profit data 줄임
		Highcharts.chart('p_chart', {
			chart : {
				type : 'line'
			},
			title : {
				text : '연순수익 차트'  // 차트 속 제목
			},
			subtitle : {
				text : '지역별(시 단위) 순수익'  // 차트 속 부제목
			},
			xAxis : {
				categories : [ '2010', '2011', '2012', '2013', '2014', '2015', '2016',
						'2017', '2018', '2019']  
			},
			yAxis : {
				title : {
					text : '단위:천만원(10,000,000)'
				}
			},
			plotOptions : {
				line : {
					dataLabels : {
						enabled : true
					},
					enableMouseTracking : false
				}
			},
			series : p_data  // p_data = profit data 줄임
		});

	};

	function getDataPChart() {  //get data profit chart 줄임
		// AJAX
		var p_data = [ //p_data = profit data 줄임
				{
					name : '서울',
					data : [ 15.2, 17.4, 19.8, 20.2, 20.0, 21.5, 26.2, 25.5, 24.3,
							25.2]
				},
				{
					name : '부산',
					data : [ 4.9, 4.2, 6.0, 9.7, 15.9, 18.2, 19.5, 21.1, 23.8,
							22.4]
				} ];
		pchart(p_data);  ////pchart = profit chart, p_data = profit data 줄임
	};
	
	$(document).ready(function(){
		category_return();
		getDataPChart();
			// 카테고리 이미지 클릭 시 num 생성 후 senddata 실행
		$('#product > div').click(function(){
			var num = $(this).attr('num');
			category_change(num);
			sendData('ja'+num);
		});
			// 카테고리로 돌아가기 버튼 눌렀을때 실행
		$('#back-cate').click(function(){
			category_return();			
		});
		
		$('#search>h2>#srch_b').click(function(){
			$('#srch_r').empty(); // 이전에 검색해서 나온 검색내용 지우기
			getData();
		});
		
		$('#current>h2>#area').click(function(){
			getDataPChart();
		});
	});