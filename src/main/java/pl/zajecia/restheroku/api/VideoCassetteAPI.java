package pl.zajecia.restheroku.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zajecia.restheroku.dao.entity.VideoCassette;
import pl.zajecia.restheroku.manager.VCManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes")
public class VideoCassetteAPI {
    private final VCManager videoCassettes;

    @Autowired
    public VideoCassetteAPI(VCManager vcManager) {
        videoCassettes = vcManager;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassettes.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getByID(@RequestParam long index) {
        return videoCassettes.findAllById(index);
    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette newVideo) {
        return videoCassettes.save(newVideo);
    }

    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette updatedVideo) {
        return videoCassettes.save(updatedVideo);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam long index) {
        videoCassettes.delete(index);
    }
}
