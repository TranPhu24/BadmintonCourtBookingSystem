package group6.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import group6.pojo.Court;

public class CourtDAOTest {

    private CourtDAO courtDAO;

    @BeforeEach
    public void setUp() {
        courtDAO = new CourtDAO("testPU");
    }

    @Test
    public void testCreateCourt() {
        Court court = new Court();
        court.setLocation("Location A");
        court.setOperatingHours("08:00 - 20:00");
        court.setPrice(100.0);

        courtDAO.createCourt(court);
        Court savedCourt = courtDAO.findById(court.getCourtId());
        assertNotNull(savedCourt);
        assertEquals("Location A", savedCourt.getLocation());
        assertEquals("08:00 - 20:00", savedCourt.getOperatingHours());
        assertEquals(100.0, savedCourt.getPrice());
    }

    @Test
    public void testFindById() {
        Court court = new Court();
        court.setLocation("Location B");
        court.setOperatingHours("09:00 - 21:00");
        court.setPrice(120.0);

        courtDAO.createCourt(court);
        Court foundCourt = courtDAO.findById(court.getCourtId());
        assertNotNull(foundCourt);
        assertEquals("Location B", foundCourt.getLocation());
        assertEquals("09:00 - 21:00", foundCourt.getOperatingHours());
        assertEquals(120.0, foundCourt.getPrice());
    }

    @Test
    public void testUpdateCourt() {
        Court court = new Court();
        court.setLocation("Location C");
        court.setOperatingHours("10:00 - 22:00");
        court.setPrice(150.0);

        courtDAO.createCourt(court);
        court.setLocation("Location C - Updated");
        court.setOperatingHours("11:00 - 23:00");
        court.setPrice(160.0);
        courtDAO.updateCourt(court);

        Court updatedCourt = courtDAO.findById(court.getCourtId());
        assertEquals("Location C - Updated", updatedCourt.getLocation());
        assertEquals("11:00 - 23:00", updatedCourt.getOperatingHours());
        assertEquals(160.0, updatedCourt.getPrice());
    }

    @Test
    public void testDeleteCourt() {
        Court court = new Court();
        court.setLocation("Location D");
        court.setOperatingHours("12:00 - 00:00");
        court.setPrice(180.0);

        courtDAO.createCourt(court);
        Long courtId = court.getCourtId();
        courtDAO.deleteCourt(courtId);

        Court deletedCourt = courtDAO.findById(courtId);
        assertNull(deletedCourt);
    }

    @Test
    public void testGetCourts() {
        Court court1 = new Court();
        court1.setLocation("Location E");
        court1.setOperatingHours("06:00 - 18:00");
        court1.setPrice(90.0);

        Court court2 = new Court();
        court2.setLocation("Location F");
        court2.setOperatingHours("07:00 - 19:00");
        court2.setPrice(110.0);

        courtDAO.createCourt(court1);
        courtDAO.createCourt(court2);

        List<Court> courts = courtDAO.getCourts();
        assertEquals(2, courts.size());
        assertEquals("Location E", courts.get(0).getLocation());
        assertEquals("Location F", courts.get(1).getLocation());
    }
}
