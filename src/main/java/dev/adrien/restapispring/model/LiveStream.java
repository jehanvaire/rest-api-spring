package dev.adrien.restapispring.model;

public record LiveStream(String id, String title, String description, String url, java.time.LocalDateTime startDate, java.time.LocalDateTime endDate) {
    public LiveStream {
        if(id==null || id.isBlank()) throw new IllegalArgumentException("id cannot be null or blank");
    }
}
