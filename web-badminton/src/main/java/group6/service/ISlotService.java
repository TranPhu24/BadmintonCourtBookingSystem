package group6.service;

import java.util.List;
import group6.pojo.Slot;

public interface ISlotService {
	
	List<Slot> findAll();
	void save(Slot slot);
	void delete(Long slotId);
	Slot findbyId(Long slotId);
	void update(Slot slot);
	

}
