package service;

import com.flightbooking.dao.FlightDAO;
import com.flightbooking.model.Flight;
import com.flightbooking.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FlightServiceTest {

    private FlightDAO flightDAO;
    private FlightService flightService;

    @BeforeEach
    void setUp() {
        flightDAO = mock(FlightDAO.class);
        flightService = new FlightService(flightDAO);
    }

    @Test
    void testGetAllFlights() {
        Flight flight = new Flight(1L, LocalDateTime.now(), "Paris", 100, 50);
        when(flightDAO.getAllFlights()).thenReturn(List.of(flight));

        List<Flight> result = flightService.getAllFlights();

        assertEquals(1, result.size());
        verify(flightDAO).getAllFlights();
    }

    @Test
    void testBookFlightSuccess() {
        when(flightDAO.updateAvailableSeats(1L, 2)).thenReturn(true);

        boolean result = flightService.bookFlight(1L, 2);

        assertTrue(result);
        verify(flightDAO).updateAvailableSeats(1L, 2);
    }

    @Test
    void testSearchFlights() {
        Flight f1 = new Flight(1L, LocalDateTime.now(), "Rome", 100, 40);
        when(flightDAO.searchFlights("Rome", 1)).thenReturn(Arrays.asList(f1));

        List<Flight> result = flightService.searchFlights("Rome", 1);

        assertEquals(1, result.size());
        assertEquals("Rome", result.get(0).getDestination());
        verify(flightDAO).searchFlights("Rome", 1);
    }
}
