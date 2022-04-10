package com.systemdesign.services;

import jakarta.persistence.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "page")
public class PageDocument {

    @Id
    @Indexed(name="url", type="string")
    private String url;

    @Indexed(name = "body", type = "string")
    private String body;

}
