package com.stackroute.service;

import com.stackroute.domain.Track;

import java.util.List;

public interface MusicService  {

    public Track saveTrack(Track track);

    public List<Track> getTrack();

    public Track getById(int id);

    public void deleteById(int id);

    public boolean updateById(Track track, int id);


}
