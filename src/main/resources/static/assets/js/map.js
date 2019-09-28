let platform = new H.service.Platform({
    'apikey': 'NVWahhVJxvjpUzmlSpWnwh_Fy-QKHYFz1ji_HUm_KVE'
});
let defaultLayers = platform.createDefaultLayers();
console.log(defaultLayers);
const map = new H.Map(
    document.getElementById('map'),
    defaultLayers.vector.normal.map,
    {
        zoom: 13,
        center: {lng: 46.013017, lat: 51.540878}
    }
);
console.log(map);
const mapEvent = new H.mapevents.MapEvents(map);
const mapBehavior = new H.mapevents.Behavior(mapEvent);