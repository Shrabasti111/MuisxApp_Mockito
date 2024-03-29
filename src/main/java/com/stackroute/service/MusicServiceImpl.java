package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService {

    MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Track saveTrack(Track track) {

        Track savedTrack = musicRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getTrack() {
        return (List<Track>)musicRepository.findAll();
    }

    @Override
    public Track getById(int id) {

        Optional<Track> getByIdTrack = musicRepository.findById(id);

        return getByIdTrack.get();
    }

    @Override
    public void deleteById(int id) {

        musicRepository.deleteById(id);

    }

    @Override
    public boolean updateById(Track track, int id) {

        Optional<Track> updateTrack = musicRepository.findById(id);

        if(updateTrack.isEmpty())
            return false;

        track.setId(id);
        musicRepository.save(track);
        return true;
    }

}


