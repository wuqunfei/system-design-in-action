package services;

import info.debatty.java.stringsimilarity.Levenshtein;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Service
public class PageSimilarityService {
    private Levenshtein levenshtein;

    public PageSimilarityService() {
        levenshtein = new Levenshtein();
    }

    public double getDistance(String originPage, String newPage) {
        return levenshtein.distance(originPage, newPage);
    }

    public boolean isOverTimeRequest(HttpServletResponse httpResponse){
        String header = httpResponse.getHeader("Last-Modified");
        Date lastModifiedDate = new Date();
        Date now = new Date();
        return lastModifiedDate.before(now);
    }
}
