package dao;

import com.flightbooking.dao.FlightDAOImpl;
import com.flightbooking.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class FlightDAOTest {

    private FlightDAOImpl dao;

    @BeforeEach
    void setUp() {
        dao = new FlightDAOImpl();
    }

    @Test
    void testAddAndGetFlight() {
        Flight flight = new Flight(99L, LocalDateTime.now().plusDays(1), "Tokyo", 100, 100);
        dao.addFlight(flight);

        Flight retrieved = dao.getFlightById(99L);
        assertNotNull(retrieved);
        assertEquals("Tokyo", retrieved.getDestination());
    }

    @Test
    void testUpdateAvailableSeats() {
        Flight flight = new Flight(100L, LocalDateTime.now().plusDays(1), "Berlin", 100, 100);
        dao.addFlight(flight);

        boolean updated = dao.updateAvailableSeats(100L, 5);
        assertTrue(updated);

        Flight updatedFlight = dao.getFlightById(100L);
        assertEquals(95, updatedFlight.getAvailableSeats());
    }
}
