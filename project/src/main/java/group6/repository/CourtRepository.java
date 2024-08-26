package group6.repository;

import java.util.List;

import group6.dao.CourtDAO;
import group6.pojo.Court;

public class CourtRepository implements ICourtRepository {

    private CourtDAO courtDAO;

    public CourtRepository(String persistenceUnitName) {
        courtDAO = new CourtDAO(persistenceUnitName);
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
