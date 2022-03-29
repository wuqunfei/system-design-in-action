package com.system.desgin.yelp;

import com.google.common.geometry.*;
import com.system.desgin.yelp.services.GeoService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = YelpApplication.class)
class YelpApplicationTest {

    Logger logger = LoggerFactory.getLogger(YelpApplicationTest.class);
    @Autowired
    public GeoService geoService;

    @Test
    public void testLatLngCell() {
        double latitude = 48.16657075848941;
        double longitude = 11.590010333780187;
        S2Cell cell = geoService.getGeoHashByLatLong(latitude, longitude);
        S2CellId cellId = cell.id();

        logger.info(cellId.toString());
        logger.info(cellId.toToken());
        logger.info(Long.toString(cellId.id()));
    }

    @Test
    public void testRect(){
        S2LatLng topRight = S2LatLng.fromDegrees(48.163748525574555, 11.620565023980681);
        S2LatLng downLeft = S2LatLng.fromDegrees(48.117527444703654, 11.550111906275628);
        S2LatLngRect s2LatLngRect = new S2LatLngRect(topRight, downLeft);
        S2LatLng point = S2LatLng.fromDegrees(48.13184561449968, 11.586533925331358);
        logger.info(Double.toString(s2LatLngRect.area()));
    }
}