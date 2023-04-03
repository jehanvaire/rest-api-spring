package dev.adrien.restapispring;

import dev.adrien.restapispring.model.ImmutableLiveStream;
import dev.adrien.restapispring.model.LiveStream;
import dev.adrien.restapispring.model.MutableLiveStream;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestApiSpringApplicationTests {

	@Test
	void create_new_mutable_live_stream() {
		MutableLiveStream mutableLiveStream = new MutableLiveStream();
		mutableLiveStream.setId("1");
		mutableLiveStream.setTitle("title");
		mutableLiveStream.setDescription("description");
		mutableLiveStream.setUrl("url");
		mutableLiveStream.setStartDate(LocalDateTime.now());
		mutableLiveStream.setEndDate(LocalDateTime.now());

		assertNotNull(mutableLiveStream);
		assertEquals("1", mutableLiveStream.getId());

	}

	@Test
	void create_new_immutable_live_stream() {
		ImmutableLiveStream immutableLiveStream = new ImmutableLiveStream(
				"1",
				"title",
				"description",
				"url",
				LocalDateTime.now(),
				LocalDateTime.now()
		);

		assertNotNull(immutableLiveStream);
		assertEquals("1", immutableLiveStream.getId());

	}

	@Test
	void create_new_record_live_stream() {
		LiveStream recordLiveStream = new LiveStream(
				"1",
				"title",
				"description",
				"url",
				LocalDateTime.now(),
				LocalDateTime.now()
		);

		assertNotNull(recordLiveStream);
		assertEquals("1", recordLiveStream.id());
		assertTrue(recordLiveStream.getClass().isRecord());
		assertEquals(6, recordLiveStream.getClass().getRecordComponents().length);


	}


}
