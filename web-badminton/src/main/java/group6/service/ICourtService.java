package group6.service;

import java.util.List;
import group6.dto.CourtDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Court;

public interface ICourtService {
    Court createCourt(CourtDTO courtDTO) throws DataNotFoundException;
    Court updateCourt(Long id, CourtDTO courtDTO) throws DataNotFoundException;
    List<Court> getAllCourts();
    Court getCourt(Long id) throws DataNotFoundException;
}
