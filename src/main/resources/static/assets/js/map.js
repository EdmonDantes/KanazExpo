var platform = new H.service.Platform({
    'apikey': 'NVWahhVJxvjpUzmlSpWnwh_Fy-QKHYFz1ji_HUm_KVE'
});
var i = 0;
var defaultLayers = platform.createDefaultLayers();
console.log(defaultLayers);
const map = new H.Map(
    document.getElementById('map'),
    defaultLayers.vector.normal.map,
    {
        zoom: 13,
        center: {lng: 46.013017, lat: 51.540878}
    }
); var ui = H.ui.UI.createDefault(map, defaultLayers, 'ru-RU');


const mapEvent = new H.mapevents.MapEvents(map);
const mapBehavior = new H.mapevents.Behavior(mapEvent);
/*расположение
var mapSettings = ui.getControl('mapsettings');
var zoom = ui.getControl('zoom');
var scalebar = ui.getControl('scalebar');

mapSettings.setAlignment('top-left');
zoom.setAlignment('top-left');
scalebar.setAlignment('top-left');*/
console.log('начало');
function setUpClickListener(map) {
    // Attach an event listener to map display
    // obtain the coordinates and display in an alert box.
    map.addEventListener('tap', function (evt) { console.log('внутри функции evt')
        var coord = map.screenToGeo     (evt.currentPointer.viewportX,
            evt.currentPointer.viewportY);
        logEvent('Clicked at ' + Math.abs(coord.lat.toFixed(6   )) +
            ((coord.lat > 0) ? 'N' : 'S') +
            ' ' + Math.abs(coord.lng.toFixed(6)) +
            ((coord.lng > 0) ? 'E' : 'W'));
        let a = new Array();
         a [1] =Math.abs(coord.lat.toFixed(6)) +
             ((coord.lat > 0) ? 'N' : 'S') ;
         a[2]=Math.abs(coord.lng.toFixed(6)) +
             ((coord.lng > 0) ? 'E' : 'W');
         console.log('a[i]');
        console.log(a[1]);
        console.log(a[2]);
    });
}
window.addEventListener('resize', () => map.getViewPort().resize());
var logContainer = document.createElement('ul');
logContainer.className ='log';
logContainer.innerHTML = 'Try clicking on the map';
map.getElement().appendChild(logContainer);

function logEvent(str) {
    var entry = document.createElement('li');
    entry.className = 'log-entry';
    entry.textContent = str;
    console.log(str);
    logContainer.insertBefore(entry, logContainer.firstChild);
}

console.log('вызов map')

setUpClickListener(map);


