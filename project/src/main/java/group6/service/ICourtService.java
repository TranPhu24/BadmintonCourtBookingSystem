package group6.service;

import java.util.List;
import group6.pojo.Court;

public interface ICourtService {
List<Court> findAll();
    
    void save(Court court);
    
    void delete(Long courtID);
    
    Court findById(Long court);
    
    void update(Court court);
}
