package com.solvd.socialNetwork;

import com.solvd.socialNetwork.exceptions.InvalidRegionException;

import java.util.Objects;

public class Region {
    private double latitude;
    private double longitude;
    private double range;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) throws  InvalidRegionException {
        if (latitude < -90 || latitude > 90){
            throw new InvalidRegionException("Latitude should be a number between -90 and 90");
        } else {
            this.latitude = latitude;
        }
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) throws InvalidRegionException {
        if (longitude < -180 || longitude > 180) {
            throw new InvalidRegionException("Longitude should be a number between -180 and 180");
        } else {
            this.longitude = longitude;
        }
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }


    @Override
    public String toString() {
        return  "latitude=" + latitude + ", longitude=" + longitude + ", range=" + range;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, range);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Double.compare(region.latitude, latitude) == 0 && Double.compare(region.longitude, longitude) == 0 && Double.compare(region.range, range) == 0;
    }


}
