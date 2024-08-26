package group6.service;

import java.util.List;

import group6.pojo.Court;
import group6.repository.CourtRepository;
import group6.repository.ICourtRepository;

public class CourtService implements ICourtService{
	private ICourtRepository icourtRepository;

		@Override
		public List<Court> findAll() {
			// TODO Auto-generated method stub
			return icourtRepository.findAll();
		}

		@Override
		public void save(Court court) {
			// TODO Auto-generated method stub
			icourtRepository.save(court);
			
		}

		@Override
		public void delete(Long courtId) {
			// TODO Auto-generated method stub
			icourtRepository.delete(courtId);
			
		}

		@Override
		public Court findById(Long courtgId) {
			// TODO Auto-generated method stub
			return icourtRepository.findById(courtgId);
		}

		@Override
		public void update(Court court) {
			// TODO Auto-generated method stub
			icourtRepository.update(court);
			
		}
	
	}
