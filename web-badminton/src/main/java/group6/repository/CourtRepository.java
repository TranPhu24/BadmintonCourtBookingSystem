package group6.repository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import group6.dao.CourtDAO;
import group6.pojo.Court;
import group6.pojo.Slot;
@Repository
public class CourtRepository implements ICourtRepository {

    private CourtDAO courtDAO;

    public CourtRepository() {
        courtDAO = new CourtDAO("test-unit");
    }
    

    public List<Court> findCourtsByTime(Time startTime, Time endTime) {
        return courtDAO.findCourtsByTime(startTime, endTime);
    }


    @Override
    public List<Court> findAll() {
        return courtDAO.getCourts();
    }

    @Override
    public Court save(Court court) {
        courtDAO.createCourt(court);
        return court;
    }

    @Override
    public void delete(Long courtId) {
        courtDAO.deleteCourt(courtId);
    }

    @Override
    public Optional<Court> findById(Long courtId) {
        return Optional.ofNullable(courtDAO.findById(courtId));
    }

    @Override
    public Court update(Court court) {
        courtDAO.updateCourt(court);
        return court;
    }
    
    @Override
    public boolean checkCourt(String location, Time startTime, Time endTime) {
    	return courtDAO.checkCourt(location,startTime,endTime);
    }
}
