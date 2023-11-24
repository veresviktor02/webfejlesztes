package hu.unideb.inf.crud.service.impl;

import hu.unideb.inf.crud.dto.DeveloperDTO;
import hu.unideb.inf.crud.dto.VideoGameDTO;
import hu.unideb.inf.crud.repository.VideoGameRepository;
import hu.unideb.inf.crud.service.VideoGameService;
import hu.unideb.inf.crud.uito.DeveloperUITO;
import hu.unideb.inf.crud.uito.VideoGameUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VideoGameServiceImpl implements VideoGameService {

    @Autowired
    VideoGameRepository videoGameRepository;

    private void dtoToUito(VideoGameUITO videoGameUITO, VideoGameDTO dto) {
        DeveloperUITO uitTO = new DeveloperUITO();
        BeanUtils.copyProperties(dto.getDeveloperDTO(), uitTO);
        videoGameUITO.setDeveloperUITO(uitTO);
    }

    private VideoGameDTO UiToToDto(VideoGameUITO videoGameUITO) {
        VideoGameDTO dto = new VideoGameDTO();
        DeveloperDTO developerDTO = new DeveloperDTO();
        BeanUtils.copyProperties(videoGameUITO, dto);
        BeanUtils.copyProperties(videoGameUITO.getDeveloperUITO(), developerDTO);
        dto.setDeveloperDTO(developerDTO);
        List<VideoGameDTO> lst = new ArrayList<>();
        lst.add(dto);
        developerDTO.getVideoGameDTOList().addAll(lst);
        return dto;
    }

    @Override
    @Transactional(readOnly = false)
    public VideoGameUITO doSaveVideoGame(VideoGameUITO videoGameUITO) {
        VideoGameDTO dto = UiToToDto(videoGameUITO);
        dto = videoGameRepository.save(dto);
        BeanUtils.copyProperties(dto, videoGameUITO);
        dtoToUito(videoGameUITO, dto);

        return videoGameUITO;
    }

    @Override
    public List<VideoGameUITO> doFetchAllVideoGame() {
        List<VideoGameDTO> dtoList = videoGameRepository.findAll();
        List<VideoGameUITO> uitoList = new ArrayList<>();
        dtoList.forEach(dto -> {
            VideoGameUITO tmpUITO = new VideoGameUITO();
            BeanUtils.copyProperties(dto, tmpUITO);
            dtoToUito(tmpUITO, dto);
            uitoList.add(tmpUITO);
        });

        return uitoList;
    }

    @Override
    public VideoGameUITO doGetVideoGame(VideoGameUITO videoGameUITO) {
        if(null != videoGameUITO.getTitle()) {
            VideoGameDTO dto = new VideoGameDTO();
            BeanUtils.copyProperties(videoGameUITO, dto);
            dto = videoGameRepository.getOne(dto.getId());
            BeanUtils.copyProperties(dto, videoGameUITO);
        }

        return videoGameUITO;
    }

    @Override
    @Transactional
    public void doDeleteVideoGame(VideoGameUITO videoGameUITO) {
        videoGameRepository.deleteById(videoGameUITO.getId());
    }
}
