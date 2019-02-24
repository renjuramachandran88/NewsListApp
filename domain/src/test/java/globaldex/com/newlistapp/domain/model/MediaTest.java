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
public class MediaTest {
    private Media media;
    private String type = "image";
    private String subtype = "photo";
    private String caption = "u201cIt\\u2019s the next scandal,\\u201d said Vincent Doyle, the son of a priest.";
    private String copyright = "Suzanne Kreiter\\/Boston Globe, via Getty Images";

    @Before
    public void setUp() throws Exception {
        media = new Media();
        List<Media_Metadata> mediaList = new ArrayList<>();
        media.setType(type);
        media.setSubtype(subtype);
        media.setCaption(caption);
        media.setCopyright(copyright);
        media.setMedia_metadata(mediaList);
    }

    @Test
    public void testmediaConstructorHappyCase() {
        final String type = media.getType();
        assertThat(type, is(type));

        final String subtype = media.getSubtype();
        assertThat(subtype, is(subtype));

        final String caption = media.getCaption();
        assertThat(caption, is(caption));

        final String copyright = media.getCopyright();
        assertThat(copyright, is(copyright));




    }
}
