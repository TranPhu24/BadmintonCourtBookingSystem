package group6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import group6.dto.BookingDTO;
import group6.exceptions.DataNotFoundException;
import group6.pojo.Booking;
import group6.pojo.Customer;
import group6.pojo.Court;
import group6.pojo.Slot;
import group6.pojo.Payment;
import group6.repository.BookingRepository;
import group6.repository.CustomerRepository;
import group6.repository.CourtRepository;
import group6.repository.SlotRepository;
import group6.repository.PaymentRepository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService{

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final CourtRepository courtRepository;
    private final SlotRepository slotRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public BookingService(
            BookingRepository bookingRepository,
            CustomerRepository customerRepository,
            CourtRepository courtRepository,
            SlotRepository slotRepository,
            PaymentRepository paymentRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.courtRepository = courtRepository;
        this.slotRepository = slotRepository;
        this.paymentRepository = paymentRepository;
    }

    public Booking createBooking(BookingDTO bookingDTO) throws DataNotFoundException {
        Customer existingCustomer = customerRepository.findById(bookingDTO.getCustomerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find customer with id " + bookingDTO.getCustomerId()));
        Court existingCourt = courtRepository.findById(bookingDTO.getCourtId())
        		.orElseThrow(() -> new DataNotFoundException("Cannot find court with id " + bookingDTO.getCourtId()));

        Slot existingSlot = slotRepository.findById(bookingDTO.getSlotId())
				.orElseThrow(() -> new DataNotFoundException("Cannot find slot with id " + bookingDTO.getSlotId()));

//        Payment existingPayment = paymentRepository.findById(bookingDTO.getPaymentId())
//				.orElseThrow(() -> new DataNotFoundException("Cannot find slot with id " + bookingDTO.getPaymentId()));

        Booking booking = new Booking();
        booking.setBookingType(bookingDTO.getBookingType());
        booking.setBookingDay(bookingDTO.getBookingDay());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setCustomer(existingCustomer);
        booking.setCourt(existingCourt);
        booking.setSlot(existingSlot);
        booking.setPayment(null);

        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, BookingDTO bookingDTO) throws DataNotFoundException {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Booking not found with id " + id));

        Customer existingCustomer = customerRepository.findById(bookingDTO.getCustomerId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find customer with id " + bookingDTO.getCustomerId()));
        Court existingCourt = courtRepository.findById(bookingDTO.getCourtId())
        		.orElseThrow(() -> new DataNotFoundException("Cannot find court with id " + bookingDTO.getCourtId()));

        Slot existingSlot = slotRepository.findById(bookingDTO.getSlotId())
				.orElseThrow(() -> new DataNotFoundException("Cannot find slot with id " + bookingDTO.getSlotId()));
        Payment payment = findPaymentById(bookingDTO.getPaymentId());

        existingBooking.setBookingType(bookingDTO.getBookingType());
        existingBooking.setBookingDay(bookingDTO.getBookingDay());
        existingBooking.setBookingDate(bookingDTO.getBookingDate());
        existingBooking.setCustomer(existingCustomer);
        existingBooking.setCourt(existingCourt);
        existingBooking.setSlot(existingSlot);
        existingBooking.setPayment(payment);

        return bookingRepository.update(existingBooking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    public Booking getBooking(Long id) throws DataNotFoundException {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Booking not found with id " + id));
    }

    private Customer findCustomerById(String id) throws DataNotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Customer not found with id " + id));
    }

    private Court findCourtById(Long id) throws DataNotFoundException {
        return courtRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Court not found with id " + id));
    }

    private Slot findSlotById(Long id) throws DataNotFoundException {
        return slotRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Slot not found with id " + id));
    }

    private Payment findPaymentById(Long id) throws DataNotFoundException {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Payment not found with id " + id));
    }
    public List<Booking> findNoPayment(String customerId) {
		return bookingRepository.findNoPayment(customerId);
	}
	public List<Booking> findNoDate() {
		return bookingRepository.findNoDate();
	}
	public List<Booking> guestFind(String courtLocation, Time courtStartTime, Time courtEndTime, Time slotStartTime,
			Time slotEndTime) {
		return bookingRepository.guestFind(courtLocation, courtStartTime, courtEndTime, slotStartTime, slotEndTime);
	}
	public List<Booking> listCourtOfCustomer(String customerId) {
		return bookingRepository.listCourtOfCustomer(customerId);
	}
	

}
