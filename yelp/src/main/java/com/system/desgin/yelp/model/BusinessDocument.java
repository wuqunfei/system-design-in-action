package com.system.desgin.yelp.model;

import jakarta.persistence.Id;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/***
 * https://www.baeldung.com/elasticsearch-geo-spatial
 * https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping-types.html
 * https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/
 */

@Document(indexName = "businessIndex")
@Setting(
        shards = 10,
        replicas = 2
)

public class BusinessDocument {

    @Id
    private UUID businessId;

    @GeoPointField
    private String geoHashKey;

    @GeoPointField
    private GeoPoint geoPoint;

    @Field(type = FieldType.Text)
    private String businessName;

    @Field(type = FieldType.Date_Range)
    private Date openTime;

    @Field(type = FieldType.Nested)
    private List<String> tags;

    @Field(type = FieldType.Nested)
    private List<String> types;

    @Field(type = FieldType.Nested)
    private List<String> catalogs;


}
