export var multi = {
    lat: 37.5665734,
    lng: 126.978179,
};
export var map;

export function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: multi,
        zoom: 12,
    });
    var marker = new google.maps.Marker({
        position: multi,
        map: map,
    });
}

export function addMarker(tmpLat, tmpLng, aptName) {
    var marker = new google.maps.Marker({
        position: new google.maps.LatLng(
            parseFloat(tmpLat),
            parseFloat(tmpLng)
        ),
        label: aptName,
        title: aptName,
    });
    marker.addListener('click', function() {
        map.setZoom(17);
        map.setCenter(marker.getPosition());
        callHouseDealInfo();
    });
    marker.setMap(map);
}

export function callHouseDealInfo() {
    alert('목록에서 클릭하여 확인하세요.');
}