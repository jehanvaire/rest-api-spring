package dev.adrien.restapispring.repository;

import dev.adrien.restapispring.model.LiveStream;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LiveStreamRepository {



    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository() {
        streams.add(new LiveStream(
                "1",
                "title",
                "description",
                "url",
                null,
                null
        ));
    }

    public List<LiveStream> getAll() {
        return streams;
    }

    public LiveStream getById(String id) {
        return streams.stream()
                .filter(stream -> stream.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public LiveStream create(LiveStream stream) {
        streams.add(stream);
        return stream;
    }

    public void update(LiveStream stream, String id) {
        LiveStream streamToUpdate = getById(stream.id());
        if (streamToUpdate != null) {
            streamToUpdate = stream;
        }
    }

    public void delete(String id) {
        LiveStream streamToDelete = getById(id);
        if (streamToDelete != null) {
            streams.remove(streamToDelete);
        }
    }
}
