package health.center.service;

import java.util.List;
import health.center.model.Company;
import health.center.model.Payment;

/**
 *
 * @author LEOGOLD
 */
public interface CompanyService {
    
    public void save(Company company);
    
    public Company login(String username, String password);
    
    public Company retrieveOne();
    
    public List<Company> retrieveAll();
    
    public void makePayment(Payment payment);
    
    public List<Payment> getAllPayments(Integer companyId);
}
