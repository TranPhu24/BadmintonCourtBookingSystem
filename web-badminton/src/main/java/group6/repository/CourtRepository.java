package group6.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import group6.dao.CourtDAO;
import group6.pojo.Court;
@Repository
public class CourtRepository implements ICourtRepository {

    private CourtDAO courtDAO;

    public CourtRepository() {
        courtDAO = new CourtDAO("test-unit");
    }

    @Override
    public List<Court> findAll() {
        return courtDAO.getCourts();
    }

    @Override
    public void save(Court court) {
        courtDAO.createCourt(court);
    }

    @Override
    public void delete(Long courtId) {
        courtDAO.deleteCourt(courtId);
    }

    @Override
    public Court findById(Long courtId) {
        return courtDAO.findById(courtId);
    }

    @Override
    public void update(Court court) {
        courtDAO.updateCourt(court);
    }
}
