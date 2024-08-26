package group6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import group6.dao.PaymentDAO;
import group6.pojo.Payment;
@Repository
public class PaymentRepository implements IPaymentRepository {

	private PaymentDAO paymentDAO;
	
	public PaymentRepository() {
		paymentDAO= new PaymentDAO("test-unit");
	}

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return paymentDAO.getCPayments() ;
	}

	@Override
	public Payment save(Payment payment) {
		// TODO Auto-generated method stub
		paymentDAO.save(payment);
		return payment;
	}

	@Override
	public void delete(Long paymentID) {
		// TODO Auto-generated method stub
		paymentDAO.delete(paymentID);
	}

	@Override
	public Optional<Payment> findById(Long paymentID) {
		// TODO Auto-generated method stub
		return Optional.ofNullable( paymentDAO.findById(paymentID));
	}

	@Override
	public Payment update(Payment payment) {
		// TODO Auto-generated method stub
		paymentDAO.update(payment);
return payment;
		
	}

}
