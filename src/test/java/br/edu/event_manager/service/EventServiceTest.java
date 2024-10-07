package br.edu.event_manager.service;

import br.edu.event_manager.model.Event;
import br.edu.event_manager.model.Event.Status;
import br.edu.event_manager.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    private Event sampleEvent;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        sampleEvent = new Event(1L, "Sample Event", LocalDateTime.now(), LocalDateTime.now().plusDays(1), 50.0, Status.STARTED);
        sampleEvent.setId(1L);
    }

    @Test
    void getEventById_ShouldReturnEvent_WhenEventExists() {
        when(eventRepository.findById(1L)).thenReturn(Optional.of(sampleEvent));

        Event result = eventService.getEventById(1L);

        assertNotNull(result);
        assertEquals(sampleEvent.getId(), result.getId());
        assertEquals("Sample Event", result.getTitle());
    }

    @Test
    void getEventById_ShouldThrowException_WhenEventDoesNotExist() {
        when(eventRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> eventService.getEventById(1L));
    }

    @Test
    void createEvent_ShouldThrowException_WhenEndDateIsBeforeStartDate() {
        Event invalidEvent = new Event(1L, "Invalid Event", LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(1), 100.0, Status.STARTED);

        assertThrows(ResponseStatusException.class, () -> eventService.createEvent(invalidEvent));
    }

    @Test
    void createEvent_ShouldSaveEvent_WhenEventIsValid() {
        when(eventRepository.save(sampleEvent)).thenReturn(sampleEvent);

        Event createdEvent = eventService.createEvent(sampleEvent);

        assertNotNull(createdEvent);
        verify(eventRepository, times(1)).save(sampleEvent);
    }
}
