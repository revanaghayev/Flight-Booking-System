package controller;

import com.flightbooking.controller.FlightController;
import com.flightbooking.model.Flight;
import com.flightbooking.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class FlightControllerTest {

    private FlightService flightService;
    private FlightController flightController;

    @BeforeEach
    void setUp() {
        flightService = mock(FlightService.class);
        flightController = new FlightController(flightService);
    }

    @Test
    void testShowAllFlightsWithData() {
        Flight flight = new Flight(1L, LocalDateTime.now(), "NY", 100, 20);
        when(flightService.getAllFlights()).thenReturn(List.of(flight));

        flightController.showAllFlights();

        verify(flightService).getAllFlights();
    }

    @Test
    void testShowAllFlightsNoData() {
        when(flightService.getAllFlights()).thenReturn(Collections.emptyList());

        flightController.showAllFlights();

        verify(flightService).getAllFlights();
    }

    @Test
    void testBookFlight() {
        when(flightService.bookFlight(1L, 2)).thenReturn(true);

        flightController.bookFlight(1L, 2);

        verify(flightService).bookFlight(1L, 2);
    }
}
