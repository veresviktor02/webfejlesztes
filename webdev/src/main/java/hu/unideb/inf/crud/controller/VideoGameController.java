package hu.unideb.inf.crud.controller;

import hu.unideb.inf.crud.service.DeveloperService;
import hu.unideb.inf.crud.service.VideoGameService;
import hu.unideb.inf.crud.uito.DeveloperUITO;
import hu.unideb.inf.crud.uito.VideoGameUITO;
import org.primefaces.PrimeFaces;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import java.util.ArrayList;
import java.util.List;

@Controller("videoGameController")
@SessionScope
public class VideoGameController {

    @Autowired
    private VideoGameService videoGameService;

    @Autowired
    private DeveloperService developerService;

    private String actionLabel;
    private VideoGameUITO videoGameUITO;
    private List<VideoGameUITO> videoGameUITOList;
    private List<DeveloperUITO> developerUITOList;

    @PostConstruct
    public void getAllVideoGame() {
        if(!this.getVideoGameUITOList().isEmpty()) {
            this.getVideoGameUITOList().clear();
            this.getDeveloperUITOList().clear();
        }
        this.getVideoGameUITOList().addAll(videoGameService.doFetchAllVideoGame());
        this.getDeveloperUITOList().addAll(developerService.getAllDeveloper());
        this.setActionLabel("Add");
    }

    public void deleteVideoGame(VideoGameUITO videoGameUITO) {
        videoGameService.doDeleteVideoGame(videoGameUITO);
        getAllVideoGame();
    }

    public void editVideoGame(VideoGameUITO videoGameUITO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(videoGameUITO, this.getVideoGameUITO());
    }

    public void doSaveInfoVideoGame() {
        videoGameService.doSaveVideoGame(this.getVideoGameUITO());
        getAllVideoGame();
        this.setVideoGameUITO(new VideoGameUITO());

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "VideoGame details", "VideoGame detalis added/updated.");
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public VideoGameUITO getVideoGameUITO() {
        if(videoGameUITO == null) {
            videoGameUITO = new VideoGameUITO();
        }
        return videoGameUITO;
    }

    public List<VideoGameUITO> getVideoGameUITOList() {
        if(null == videoGameUITOList) {
            videoGameUITOList = new ArrayList<>();
        }
        return videoGameUITOList;
    }

    public List<DeveloperUITO> getDeveloperUITOList() {
        if(developerUITOList == null) {
            developerUITOList = new ArrayList<>();
        }
        return developerUITOList;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public void setVideoGameUITO(VideoGameUITO videoGameUITO) {
        this.videoGameUITO = videoGameUITO;
    }

    /*
    public void setVideoGameUITOList(List<VideoGameUITO> videoGameUITOList) {
        this.videoGameUITOList = videoGameUITOList;
    }
    */

    public void setDeveloperUITOList(List<DeveloperUITO> developerUITOList) {
        this.developerUITOList = developerUITOList;
    }
}
