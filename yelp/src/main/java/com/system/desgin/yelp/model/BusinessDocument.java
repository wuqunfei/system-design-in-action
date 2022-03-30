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


//https://www.datadoghq.com/blog/monitor-elasticsearch-performance-metrics/#search-metrics
/***
 * Query load: Monitoring the number of queries currently in progress can give you a rough idea of how many requests your cluster is dealing with at any particular moment in time. Consider alerting on unusual spikes or dips that may point to underlying problems. You may also want to monitor the size of the search thread pool queue, which we will explain in further detail
 * Query latency: Though Elasticsearch does not explicitly provide this metric, monitoring tools can help you use the available metrics to calculate the average query latency by sampling the total number of queries and the total elapsed time at regular intervals. Set an alert if latency exceeds a threshold, and if it fires, look for potential resource bottlenecks, or investigate whether you need to optimize
 * Fetch latency: The second part of the search process, the fetch phase, should typically take much less time than the query phase. If you notice this metric consistently increasing, this could indicate a problem with slow disks, enriching of documents (highlighting relevant text in search results, etc.), or requesting too many results.
 */