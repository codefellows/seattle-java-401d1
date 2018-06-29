# ![CF](http://i.imgur.com/7v5ASc8.png) (GPS) Placing Information at Locations


## Resources
* [Location and Maps Guide](https://developer.android.com/guide/topics/location/index.html)
* [MapView Docs](https://developers.google.com/android/reference/com/google/android/gms/maps/MapView)
* [Android View Event Listeners](https://developer.android.com/guide/topics/ui/ui-events.html)

## Learning Objectives
* Students will be able to configure a database to store location information
  for real world places (using Lat/Long)
* Students will be able to configure a database to associate a place with other
  data, like text that describes the place.
* Students will be able to perform CRUD operations on the database to manipulate
  places and their associated information.
* Students will be able to query their database for place location data and
  display it on a map

## Lecture Outline
* Accessing a Map is great, but wouldn't it be cool if we could save information
  about places we like?
* Today we'll use a MapView and a database together to store information
  about places so we can retrieve it later, and share it with other users.
* We're working toward build a Postmates-like app where users can place tasks
  on a map where other users can go to a place, perform a task, or pick
  something up, and bring it back to the user.
* Create a new application from scratch, and include a MapView
* Attach event listeners on the map to react when a user taps on the map
  or long-presses on the map
* Add a text view that displays the Lat/Long information when a user touches
  the map
* Have a input appear when someone long presses.
  * Place a new marker where the user long-pressed
  * Prompt the user to give the place a name and a description
  * Include save/cancel buttons
  * If the user presses save upload the place/name/description information
    to a database and store it
  * The place with it's information should persist when the user opens the app
    again
* Configure the map to display name/description information when someone
  taps on a place that exists on the map.

### Code Sample
#### Configure Touch Event Listeners For Map
```java
public class DemoMapActivity implements OnMapClickListener, OnMapLongClickListener {
    private MapView mMap;
    private TextView mInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_demo);

        mInfo = (TextView) findViewById(R.id.info);
        mMap = (MapView) findViewById(R.id.map);
        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);
    }

    @Override
    public void onMapClick(LatLng point) {
        mTapTextView.setText("tapped, point=" + point);
    }

    @Override
    public void onMapLongClick(LatLng point) {
        mTapTextView.setText("long pressed, point=" + point);
    }
}
```
  
