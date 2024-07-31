package group6.service;
import java.util.List;

import group6.pojo.*;
import group6.repository.*;

public class SlotService implements ISlotService {
	private ISlotRepository iRepository;

	@Override
	public List<Slot> findAll() {
		// TODO Auto-generated method stub
		return iRepository.findAll();
	}

	@Override
	public void save(Slot slot) {
		// TODO Auto-generated method stub
		iRepository.save(slot);
		
	}

	@Override
	public void delete(Long slotId) {
		// TODO Auto-generated method stub
		iRepository.delete(slotId);
		
	}

	@Override
	public Slot findbyId(Long slotId) {
		// TODO Auto-generated method stub
		return iRepository.findById(slotId);
	}

	@Override
	public void update(Slot slot) {
		// TODO Auto-generated method stub
		iRepository.update(slot);
		
	}
	

}
