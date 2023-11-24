package hu.unideb.inf.crud.uito;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class DeveloperUITO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private int employees;
    private String address;
    private List<VideoGameUITO> videoGameUITOList;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEmployees() {
        return employees;
    }

    public String getAddress() {
        return address;
    }

    public List<VideoGameUITO> getVideoGameUITOList() {
        return videoGameUITOList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setVideoGameUITOList(List<VideoGameUITO> videoGameUITOList) {
        this.videoGameUITOList = videoGameUITOList;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        DeveloperUITO that = (DeveloperUITO) o;
        return employees == that.employees && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(videoGameUITOList, that.videoGameUITOList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employees, videoGameUITOList);
    }

    @Override
    public String toString() {
        return "DeveloperUITO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                ", employeeUITOList=" + videoGameUITOList +
                '}';
    }
}
