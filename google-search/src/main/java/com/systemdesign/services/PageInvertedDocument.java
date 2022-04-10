package com.systemdesign.services;

import jakarta.persistence.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;
import java.util.Map;

@SolrDocument(collection = "PageInvertedDocument")
public class PageInvertedDocument {
    @Id
    @Indexed(name = "keyword", type = "string")
    private String keyword;


    @Indexed(name = "occurrence", type ="list")
    private List<Map<String, List>> occurrence;


}
