public class WorldPoint {
    private double latitude;
    private double longitude;

    public WorldPoint(double latitude, double longitude) {
        this.setLatitude(latitude);
        this.setLongitude(longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // prevent anyone from ever setting the latitude to anything unreal.
    public void setLatitude(double latitude) {
        if (-90 < latitude && latitude < 90)  {
            this.latitude = latitude;
        }
    }

    // prevent anyone from ever setting the latitude to anything unreal.
    public void setLongitude(double longitude) {
        if (-180 < longitude && longitude < 180)  {
            this.longitude = longitude;
        }
    }
}
