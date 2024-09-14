package group6.service;

import group6.dto.CourtDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Court;

import java.sql.Time;
import java.util.List;

public interface ICourtService {
    Court registerCourt(CourtDTO courtDTO) throws DataNotFoundException;

    Court updateCourt(Long id, CourtDTO courtDTO) throws DataNotFoundException;

    List<Court> getAllCourts();

    Court getCourt(Long id) throws DataNotFoundException;

    boolean checkCourt(String location, Time startTime, Time endTime);
}
