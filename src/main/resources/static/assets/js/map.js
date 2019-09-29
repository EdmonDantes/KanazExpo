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
let marker = null;
var icon = new H.map.Icon('marker.png');
function setUpClickListener(map) {
    if (marker)
        H.map.removeObject(marker);
    // Attach an event listener to map display
    // obtain the coordinates and display in an alert box.
    map.addEventListener('tap', function (evt)
    {
        console.log('внутри функции evt')
        var coord = map.screenToGeo     (evt.currentPointer.viewportX,
            evt.currentPointer.viewportY);
        logEvent('Clicked at ' + Math.abs(coord.lat.toFixed(6   )) +
            ((coord.lat > 0) ? 'N' : 'S') +
            ' ' + Math.abs(coord.lng.toFixed(6)) +
            ((coord.lng > 0) ? 'E' : 'W'));

          a1 =Math.abs(coord.lat.toFixed(6));
          a2 = Math.abs(coord.lng.toFixed(6));
          coords = {
              lat: a1,
              lng: a2
          }
          console.log(a1);
          if (marker)
            map.removeObject(marker);

          marker = new H.map.Marker({lat: a1, lng: a2}, { icon: icon });

            if (marker)
              map.addObject(marker);
                g



          
          
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

// Create an icon, an object holding the latitude and longitude, and a marker:







   // Create an icon, an object holding the latitude and longitude, and a marker:










setUpClickListener(map);











