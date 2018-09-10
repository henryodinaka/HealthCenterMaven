package health.center.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import health.center.model.Company;
import health.center.model.Payment;
import java.util.List;
/**
 *
 * @author LEOGOLD
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{
    
    @Autowired 
    private SessionFactory sessionFactory;

    public void save(Company company) {
        sessionFactory.getCurrentSession().save(company);
    }

    @Override
    public Company login(String username, String password) {
        return (Company) sessionFactory.getCurrentSession()
                .createQuery("FROM Company WHERE username = :username AND password = :password")
                .setParameter("username", username)
                .setParameter("password", password)
                .uniqueResult();
    }
    
//    public Admin loginAdmin(String username, String password){
//        return (Admin) sessionFactory.getCurrentSession()
//                .createQuery("FROM Admin WHERE username = :username AND password = :password")
//                .setParameter("username", username)
//                .setParameter("password", password)
//                .uniqueResult();
//    }

    @Override
    public Company retrieveOne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Company> retrieveAll() {
        return sessionFactory.getCurrentSession().createQuery("From Company").list();
    }

    @Override
    public void makePayment(Payment payment) {
        sessionFactory.getCurrentSession().save(payment);
    }
    
    @Override
    public List<Payment> getAllPayments(Integer companyId){
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Payment WHERE COMPANYID = :companyId")
                .setParameter("companyId", companyId)
                .list();
    }
}