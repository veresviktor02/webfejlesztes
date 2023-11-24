package hu.unideb.inf.crud.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEVELOPER")
public class DeveloperDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DEVELOPER_ID")
    private Long id;
    @Column(name = "NAME")
    private String name; //CD Project Red
    @Column(name = "ADDRESS")
    private String address; //Krakow
    @Column(name = "EMPLOYEES")
    private int employees; //400

    @OneToMany(mappedBy = "developerDTO")
    private List<VideoGameDTO> videoGameDTOList;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getEmployees() {
        return employees;
    }

    public List<VideoGameDTO> getVideoGameDTOList() {
        if (null == videoGameDTOList) {
            videoGameDTOList = new ArrayList<>();
        }
        return videoGameDTOList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public void setVideoGameDTOList(List<VideoGameDTO> videoGameDTOList) {
        this.videoGameDTOList = videoGameDTOList;
    }
}
