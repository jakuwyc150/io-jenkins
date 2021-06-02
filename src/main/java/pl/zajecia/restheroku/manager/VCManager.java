package pl.zajecia.restheroku.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.zajecia.restheroku.dao.VCRepository;
import pl.zajecia.restheroku.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VCManager {
    private final VCRepository videoCassetteRepository;

    @Autowired
    public VCManager(VCRepository videoCassetteRepository) {
        this.videoCassetteRepository = videoCassetteRepository;
    }

    public Optional<VideoCassette> findAllById(Long id) {
        return videoCassetteRepository.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepository.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        return videoCassetteRepository.save(videoCassette);
    }

    public void delete(Long id) {
        videoCassetteRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new VideoCassette(1L, "Tytuł 1", LocalDate.of(1999, 1, 1)));
        save(new VideoCassette(2L, "Tytuł 2", LocalDate.of(1998, 2, 3)));
        save(new VideoCassette(3L, "Tytuł 3", LocalDate.of(1997, 4, 5)));
    }
}
