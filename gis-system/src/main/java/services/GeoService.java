package services;

import com.google.common.geometry.S2Cell;
import com.google.common.geometry.S2CellId;
import com.google.common.geometry.S2LatLng;
import org.springframework.stereotype.Service;

@Service
public class GeoService {

    /***
     * https://www.tabnine.com/code/java/classes/com.google.common.geometry.S2Cell
     * @param latitude
     * @param longitude
     * @return generate  GeoHash from Cell
     */
    public S2CellId getGeoHash(double latitude, double longitude){
        S2LatLng latLng = S2LatLng.fromDegrees(latitude,longitude);
        S2Cell cell = new S2Cell(latLng);
        return cell.id();
    }
}
