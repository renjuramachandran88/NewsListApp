package globaldex.com.newlistapp.domain.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by renjumenon on 20/02/19.
 */
public class Media implements Serializable {
    private String copyright;

    private List<Media_Metadata> media_metadata;

    private String subtype;

    private String caption;

    private String type;

    private int approved_for_syndication;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<Media_Metadata> getMedia_metadata() {
        return media_metadata;
    }

    public void setMedia_metadata(List<Media_Metadata> media_metadata) {
        this.media_metadata = media_metadata;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getApproved_for_syndication() {
        return approved_for_syndication;
    }

    public void setApproved_for_syndication(int approved_for_syndication) {
        this.approved_for_syndication = approved_for_syndication;
    }
}
