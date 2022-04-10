package com.systemdesign.services;


import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;

@Service
public class IndexerService {


    private FSDirectory indexDirectory;
    private String indexDirectoryPath;
    private IndexWriter indexWriter;
    private StandardAnalyzer standardAnalyzer;

    public StandardAnalyzer getStandardAnalyzer() {
        return standardAnalyzer;
    }
    public FSDirectory getIndexDirectory() {
        return indexDirectory;
    }

    public IndexerService() throws IOException {
        this.indexDirectoryPath = ".";
        this.indexDirectory = FSDirectory.open(Path.of(this.indexDirectoryPath));
        this.standardAnalyzer = new StandardAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(this.standardAnalyzer);
        this.indexWriter = new IndexWriter(this.indexDirectory, indexWriterConfig);
    }

    public void buildIndex(String url, String content) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("url", url, Field.Store.YES));
        doc.add(new StringField("content", content, Field.Store.YES));
        this.indexWriter.addDocument(doc);
    }

    public void closeWriter() throws IOException {
        this.indexWriter.close();
    }
}
