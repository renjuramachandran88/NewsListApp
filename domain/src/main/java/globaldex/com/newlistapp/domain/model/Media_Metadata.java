package globaldex.com.newlistapp.domain.model;

import java.io.Serializable;

/**
 * Created by renjumenon on 20/02/19.
 */
public class Media_Metadata implements Serializable {
    private String format;

    private int width;

    private String url;

    private int height;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
