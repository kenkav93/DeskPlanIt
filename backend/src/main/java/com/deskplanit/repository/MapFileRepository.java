package com.deskplanit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deskplanit.model.MapFile;

@Repository
public interface MapFileRepository extends JpaRepository<MapFile, Long> {
}
