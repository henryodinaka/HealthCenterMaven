/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package health.center.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author LEOGOLD
 */
@Entity
@Table(name = "payment")
public class Payment {
    
    @Id
    @Column(name = "paymentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "companyId",foreignKey = @ForeignKey (name= "FK_Payment_Company"))
    private Company companyId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String title;
        
    @Column(nullable = false)
    private boolean signature;
    
    @Column(nullable = false)
    private String purposeOfPayment;

    @Column(nullable = false)
    private String paymentVoucherNum;

    @Column(nullable = false)
    private String amountInWords;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String bank;
    
    @Column(nullable = false)
    private String receipt;
    
    @Column(nullable = false)
    private Date month;

    @Column(nullable = true)
    private Date dateOfPayment;

    @Column
    @CreationTimestamp
    private Date created;

    @Column
    @UpdateTimestamp
    private Date modified;

    public Payment() {
    }

    public Payment(Company companyId, String fullName, String title, boolean signature, String purposeOfPayment, String paymentVoucherNum, String amountInWords, double amount, String bank, String receipt, Date month, Date dateOfPayment) {
        this.companyId = companyId;
        this.fullName = fullName;
        this.title = title;
        this.signature = signature;
        this.purposeOfPayment = purposeOfPayment;
        this.paymentVoucherNum = paymentVoucherNum;
        this.amountInWords = amountInWords;
        this.amount = amount;
        this.bank = bank;
        this.receipt = receipt;
        this.month = month;
        this.dateOfPayment = dateOfPayment;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSignature() {
        return signature;
    }

    public void setSignature(boolean signature) {
        this.signature = signature;
    }

    public String getPurposeOfPayment() {
        return purposeOfPayment;
    }

    public void setPurposeOfPayment(String purposeOfPayment) {
        this.purposeOfPayment = purposeOfPayment;
    }

    public String getPaymentVoucherNum() {
        return paymentVoucherNum;
    }

    public void setPaymentVoucherNum(String paymentVoucherNum) {
        this.paymentVoucherNum = paymentVoucherNum;
    }

    public String getAmountInWords() {
        return amountInWords;
    }

    public void setAmountInWords(String amountInWords) {
        this.amountInWords = amountInWords;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentId=" + paymentId + ", companyId=" + companyId + ", fullName=" + fullName + ", title=" + title + ", signature=" + signature + ", purposeOfPayment=" + purposeOfPayment + ", paymentVoucherNum=" + paymentVoucherNum + ", amountInWords=" + amountInWords + ", amount=" + amount + ", bank=" + bank + ", receipt=" + receipt + ", month=" + month + ", dateOfPayment=" + dateOfPayment + ", created=" + created + ", modified=" + modified + '}';
    }

    
}
