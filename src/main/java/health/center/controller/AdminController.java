package health.center.controller;

import health.center.model.Administrator;
import health.center.model.Company;
import health.center.model.Payment;
import health.center.service.AdminService;
import health.center.service.CompanyService;
import health.center.utils.SessionUtils;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *
 * @author Blaccop Group
 */
@Named("adminBean")
@SessionScoped
public class AdminController implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String fullName;
    private String password;
    private String confirmPassword;
    private Company company;
    private Payment payment;
    @Autowired
    private AdminService adminService;
    @Autowired
    private CompanyService companyService;

    public AdminController() {
    }

    public String createAccount() {
        Administrator admin = new Administrator(username, fullName, password);
        adminService.createAccount(admin);
        return "login?faces-redirect=true";
    }

    public String test(){
        return "file_upload?faces-redirect=true";
    }
    public String login() {
        try {
            Administrator admin = adminService.login(username, password);
            setAdmin(admin);
            
            HttpSession httpSession = SessionUtils.getSession();
            httpSession.setAttribute("logged", 1);
            return "admin_dashBoard?faces-redirect=true";
        } catch (NullPointerException e) {
            return "login";
        }
    }

    public void setAdmin(Administrator admin) {
        setUsername(admin.getUsername());
        setFullName(admin.getFullName());
    }

    public String viewPayments(Company company) {
        this.company = company;
        return "all_payment?faces-redirect=true";
    }

    public String viewPayment(Payment payment) {
        this.payment = payment;
        return "html_to_pdf?faces-redirect=true";
    }

    public List<Payment> getCompanyPayments() {
        return companyService.getAllPayments(company.getCompanyId());
    }

    public void downloadPayment() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        String url = "http://localhost:8080/HealthCenter/faces/html_to_pdf.xhtml;session="+session+"?pdf=true";
        try{
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(new URL(url).toString());
            renderer.layout();
            response.reset();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; file=\"paymentFile.pdf\"");
            OutputStream out = response.getOutputStream();
            renderer.createPDF(out);
        } catch (Exception e) {}
        facesContext.responseComplete();
    }

    public Company getCompany() {
        return company;
    }
    
    public Payment getPayment() {
        return payment;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
