package com.systemdesign.services;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchApplicationTest {

    private Logger logger = LoggerFactory.getLogger(SearchApplicationTest.class);

    @Autowired
    private IndexerService indexerService;

    @Test
    void testIndexBuilderAndQuery() throws IOException, ParseException {
        indexerService.buildIndex("google.com", "this is google munich office");
        indexerService.buildIndex("duckduckgo", "duckduck search office in Europe");
        indexerService.closeWriter();

        String queryLang = "office";
        Query query = new QueryParser("content",indexerService.getStandardAnalyzer()).parse(queryLang);

        IndexReader indexReader = DirectoryReader.open(indexerService.getIndexDirectory());
        IndexSearcher searcher = new IndexSearcher(indexReader);
        TopDocs topDocs = searcher.search(query, 10);
        List<Document> documents = new ArrayList<>();
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            documents.add(searcher.doc(scoreDoc.doc));
            logger.info(scoreDoc.toString());
        }

    }
}