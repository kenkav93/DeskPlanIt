package com.deskplanit.controller;

import com.deskplanit.model.MapFile;
import com.deskplanit.repository.MapFileRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/maps")
public class MapFileController {
    private final MapFileRepository mapFileRepository;

    @Value("${map.upload.dir:uploads}")
    private String uploadDir;

    public MapFileController(MapFileRepository mapFileRepository) {
        this.mapFileRepository = mapFileRepository;
    }

    @PostMapping("/upload")
    public ResponseEntity<MapFile> uploadMap(@RequestParam("file") MultipartFile file) throws IOException {
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir, filename);
        Files.write(path, file.getBytes());
        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/" + uploadDir + "/")
                .path(filename)
                .toUriString();
        MapFile mapFile = new MapFile(file.getOriginalFilename(), file.getContentType(), fileUri, LocalDateTime.now());
        mapFileRepository.save(mapFile);
        return new ResponseEntity<>(mapFile, HttpStatus.CREATED);
    }

    @GetMapping
    public List<MapFile> listMaps() {
        return mapFileRepository.findAll();
    }
}
