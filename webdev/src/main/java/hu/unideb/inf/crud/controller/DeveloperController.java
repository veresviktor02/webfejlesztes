package hu.unideb.inf.crud.controller;

import hu.unideb.inf.crud.service.DeveloperService;
import hu.unideb.inf.crud.service.VideoGameService;
import hu.unideb.inf.crud.uito.DeveloperUITO;
import hu.unideb.inf.crud.uito.VideoGameUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller("developerContoller")
@SessionScope
public class DeveloperController {

    List<DeveloperUITO> developerUITOList;

    List<VideoGameUITO> videoGameUITOList;

    @Autowired
    DeveloperService developerService;

    @Autowired
    VideoGameService videoGameService;

    @PostConstruct
    public void init() {
        videoGameUITOList = videoGameService.doFetchAllVideoGame();
        developerUITOList = developerService.getAllDeveloper();
        developerUITOList.forEach(x -> x.setVideoGameUITOList(new ArrayList<>()));

        for(VideoGameUITO videoGameUITO : videoGameUITOList) {
            for(DeveloperUITO developerUITO : developerUITOList) {
                if(videoGameUITO.getDeveloperUITO().getId().equals(developerUITO.getId())) {
                    developerUITO.getVideoGameUITOList().add(videoGameUITO);
                }
            }
        }
    }

    public void removeDeveloper(Long id) {
        developerService.deleteDepartment(id);
        developerUITOList = developerService.getAllDeveloper();
    }

    public List<DeveloperUITO> getDeveloperUITOList() {
        return developerUITOList;
    }

    public void setDeveloperUITOList(List<DeveloperUITO> developerUITOList) {
        this.developerUITOList = developerUITOList;
    }
}
