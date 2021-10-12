package com.example.songr.Repository;

import com.example.songr.model.Song;
import com.example.songr.model.albumModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Long> {
}
