package globaldex.com.newlistapp.domain.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by renjumenon on 24/02/19.
 */
public class ResultsTest {
    Results results;
    private String url = "https:\\/\\/www.nytimes.com\\/interactive\\/2019\\/02\\/15\\/upshot\\/british-irish-dialect-quiz.html";
    private String adx_keywords = "English Language;Geography;Ireland;Great Britain";
    private String section = "The Upshot";
    private String byline = "By JOSH KATZ";
    private String type = "Interactive";
    private String title = "The British-Irish Dialect Quiz";
    private String published_date = "019-02-15";
    private String source = "The New York Times";
    private long id = 1004694;


    @Before
    public void setUp() throws Exception {
        results = new Results();
        List<Media> mediaList = new ArrayList<>();
        results.setUrl(url);
        results.setAdxKeywords(adx_keywords);
        results.setSection(section);
        results.setByline(byline);
        results.setType(type);
        results.setTitle(title);
        results.setPublishedDate(published_date);
        results.setSource(source);
        results.setId(id);
        results.setMedia(mediaList);


    }

    @Test
    public void testResultConstructorHappyCase() {
        final String url = results.getUrl();
        assertThat(url, is(url));

        final String adx_keywords = results.getAdxKeywords();
        assertThat(adx_keywords, is(adx_keywords));

        final String section = results.getSection();
        assertThat(section, is(section));

        final String byline = results.getByline();
        assertThat(byline, is(byline));

        final String type = results.getType();
        assertThat(type, is(type));

        final String title = results.getTitle();
        assertThat(title, is(title));

        final String published_date = results.getPublishedDate();
        assertThat(published_date, is(published_date));

        final long id = results.getId();
        assertThat(id, is(id));


    }


}
