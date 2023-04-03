package dev.adrien.restapispring.controller;

import dev.adrien.restapispring.model.LiveStream;
import dev.adrien.restapispring.repository.LiveStreamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<LiveStream> getAll(){
        return repository.getAll();
    }
}
