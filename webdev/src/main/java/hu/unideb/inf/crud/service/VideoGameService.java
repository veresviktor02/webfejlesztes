package hu.unideb.inf.crud.service;

import hu.unideb.inf.crud.uito.VideoGameUITO;

import java.util.List;

public interface VideoGameService {
    VideoGameUITO doSaveVideoGame(VideoGameUITO videoGameUITO);

    List<VideoGameUITO> doFetchAllVideoGame();

    VideoGameUITO doGetVideoGame(VideoGameUITO videoGameUITO);

    void doDeleteVideoGame(VideoGameUITO videoGameUITO);
}
