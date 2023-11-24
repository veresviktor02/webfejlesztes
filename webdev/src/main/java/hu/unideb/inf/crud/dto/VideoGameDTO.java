package hu.unideb.inf.crud.dto;

import javax.persistence.*;
import java.io.Serializable;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "VIDEOGAME")
@NamedQuery(name = "VideoGameDTO.findAll", query = "SELECT a FROM VideoGameDTO a")
public class VideoGameDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VIDEOGAME_ID")
    private Long id;
    @Column(name = "TITLE")
    private String title; //The Witcher 3
    @Column(name = "GENRE")
    private String genre; //RPG
    @Column(name = "TYPE")
    private String type; //Standalone, DLC, stb.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEVELOPER_ID")
    private DeveloperDTO developerDTO;

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

    public DeveloperDTO getDeveloperDTO() {
        return developerDTO;
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

    public void setDeveloperDTO(DeveloperDTO developerDTO) {
        this.developerDTO = developerDTO;
    }
}
