package dev.adrien.restapispring.controller;

import dev.adrien.restapispring.model.LiveStream;
import dev.adrien.restapispring.repository.LiveStreamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;


    // Constructor injection
    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    // GET /streams
    @GetMapping
    public List<LiveStream> getAll(){
        return repository.getAll();
    }

    // GET /streams/{id}
    @GetMapping("/{id}")
    public LiveStream getById(@PathVariable String id){
        return repository.getById(id);
    }

    // POST /streams
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream add(@RequestBody LiveStream stream){
        return repository.create(stream);
    }

    // PUT /streams/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody LiveStream stream, @PathVariable String id){
        repository.update(stream, id);
    }

    // DELETE /streams/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        repository.delete(id);
    }
}
