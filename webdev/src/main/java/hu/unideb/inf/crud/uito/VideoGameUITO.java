package hu.unideb.inf.crud.uito;

import java.io.Serializable;
import java.util.Objects;

public class VideoGameUITO implements Serializable {

    private static final long serialVersionUID = 4840260415183676656L;
    private Long id;
    private String title;
    private String genre;
    private String type;
    private DeveloperUITO developerUITO;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getType() {
        return type;
    }

    public DeveloperUITO getDeveloperUITO() {
        return developerUITO;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDeveloperUITO(DeveloperUITO developerUITO) {
        this.developerUITO = developerUITO;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        VideoGameUITO that = (VideoGameUITO) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(genre, that.genre) && Objects.equals(type, that.type) && Objects.equals(developerUITO, that.developerUITO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, type, developerUITO);
    }

    @Override
    public String toString() {
        return "VideoGameUITO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", type='" + type + '\'' +
                ", developerUITO=" + developerUITO +
                '}';
    }
}
