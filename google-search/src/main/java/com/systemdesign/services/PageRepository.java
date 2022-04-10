package com.systemdesign.services;

import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface PageRepository extends SolrCrudRepository<PageDocument, String> {
    public List<PageDocument> findByPage(String name);
}
