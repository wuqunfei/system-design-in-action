package com.system.desgin.yelp.services;

//https://blog.christianperone.com/2015/08/googles-s2-geometry-on-the-sphere-cells-and-hilbert-curve/
import com.google.common.geometry.S2Cell;
import com.google.common.geometry.S2CellId;
import com.google.common.geometry.S2LatLng;
import org.springframework.stereotype.Service;

@Service
public class GeoService {

    public S2Cell getGeoHashByLatLong(double latitude, double longitude){
        S2LatLng latLng = S2LatLng.fromDegrees(latitude, longitude);
        S2Cell cell = new S2Cell(latLng);
        return cell;
    }
}
