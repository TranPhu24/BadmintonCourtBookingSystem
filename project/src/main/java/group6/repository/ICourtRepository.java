package group6.repository;

import java.util.List;
import group6.pojo.Court;

public interface ICourtRepository {
    List<Court> findAll();
    
    void save(Court court);
    
    void delete(Long courtId);
    
    Court findById(Long courtId);
    
    void update(Court court);
}
