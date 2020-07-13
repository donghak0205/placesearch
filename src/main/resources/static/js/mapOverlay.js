
$(document).on('click', '#mapOverlay', function(e){

    var place_name = $(this).data('place_name');
    var address_name = $(this).data('address_name');
    var phone = $(this).data('phone');

    var x = $(this).data('x');

    var y = $(this).data('y');

//    /*sessionStorage는 세션에 저장하여 데이터를 사용하기 위함*/
    sessionStorage.clear();
    sessionStorage.setItem("place_name", place_name);
    sessionStorage.setItem("address_name", address_name);
    sessionStorage.setItem("phone", phone);

    loadMap(x,y);
});


function loadMap(x,y){
      sessionStorage.getItem('place_name')
    var mapContainer = document.getElementById('map'), // 지도의 중심좌표
        mapOption = {
            center: new kakao.maps.LatLng(33.451475, 126.570528), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    // 지도에 마커를 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(33.450701, 126.570667)
    });


// 커스텀 오버레이에 표시할 컨텐츠 입니다
// 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
// 별도의 이벤트 메소드를 제공하지 않습니다
//var content = '<div class="card" style="width: 10rem;"><div class="card text-white bg-info mb-3"> Featured</div><div class="card-body"><h5 class="card-title">Special title treatment</h5></div></div>'

var contents = '<div class="wrap">\n';
    contents += '    <div class="info">\n';
    contents += '        <div class="title">\n';
    contents += '            <div class="text">' + sessionStorage.getItem('place_name') + '</div>\n';
    contents += '            <div class="close" onclick="closeOverlay()" title="닫기"></div>\n';
    contents += '        </div>\n';
    contents += '        <div class="body">\n';
    contents += '            <div class="desc">\n';
    contents += '                <div class="ellipsis">'+ sessionStorage.getItem('address_name')+'</div>\n';
    contents += '                <div class="jibun">'+ sessionStorage.getItem('phone')+'</div>\n';
    contents += '            </div>\n';
    contents += '        </div>\n';
    contents += '    </div>\n';
    contents += '</div>\n';
    // 마커 위에 커스텀오버레이를 표시합니다
    // 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
    overlay = new kakao.maps.CustomOverlay({
        content: contents,
        map: map,
        position: marker.getPosition()
    });

    // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        overlay.setMap(map);
    });

  setTimeout(function(){
        map.relayout();
        map.setCenter(mapOption.center);
    }, 300);

}
// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다
function closeOverlay() {
    overlay.setMap(null);
}