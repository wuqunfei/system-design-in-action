package services;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WordExtractor {

    public List<String> tokenize(String line){
        return Collections.emptyList();
    }
    public List<String> normalize(String word){
        return Collections.emptyList();
    }

    public String stemming(List<String> words){
        return "";
    }
    public String lemmatisation(List<String> words){
        return "";
    }
}
