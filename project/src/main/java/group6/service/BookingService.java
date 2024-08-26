package group6.service;

import java.util.List;

import group6.pojo.Booking;
import group6.repository.BookingRepository;
import group6.repository.IBookingRepository;

public class BookingService implements IBookingService{
	private IBookingRepository ibookingRepository;

		@Override
		public List<Booking> findAll() {
			// TODO Auto-generated method stub
			return ibookingRepository.findAll();
		}

		@Override
		public void save(Booking booking) {
			// TODO Auto-generated method stub
			ibookingRepository.save(booking);
			
		}

		@Override
		public void delete(Long bookingId) {
			// TODO Auto-generated method stub
			ibookingRepository.delete(bookingId);
			
		}

		@Override
		public Booking findById(Long bookingId) {
			// TODO Auto-generated method stub
			return ibookingRepository.findById(bookingId);
		}

		@Override
		public void update(Booking booking) {
			// TODO Auto-generated method stub
			ibookingRepository.update(booking);
			
		}
	
	}
