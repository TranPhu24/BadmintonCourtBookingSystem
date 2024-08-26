package group6.service;

import java.util.List;

import group6.dao.PaymentDAO;
import group6.pojo.Payment;

public class PaymentService implements IPaymentService {

	private PaymentDAO paymentDAO;
	
	public PaymentService(String  fileName) {
		paymentDAO= new PaymentDAO(fileName);
	}

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return paymentDAO.getCPayments() ;
	}

	@Override
	public void save(Payment payment) {
		// TODO Auto-generated method stub
		paymentDAO.save(payment);
	}

	@Override
	public void delete(String paymentID) {
		// TODO Auto-generated method stub
		paymentDAO.delete(paymentID);
	}

	@Override
	public Payment findById(String paymentID) {
		// TODO Auto-generated method stub
		return paymentDAO.findById(paymentID);
	}

	@Override
	public void update(Payment payment) {
		// TODO Auto-generated method stub
		paymentDAO.update(payment);
		
	}

}
