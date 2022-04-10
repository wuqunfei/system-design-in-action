package com.systemdesign.services;

import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface PageInvertedRepository extends SolrCrudRepository<PageInvertedDocument, String> {

    public List<PageInvertedDocument> conjunctiveQuery(List<String> keywords);

    public List<PageInvertedDocument> noConjunctiveQuery(List<String> keywords);
}
