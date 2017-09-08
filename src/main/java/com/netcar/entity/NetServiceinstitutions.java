package com.netcar.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Mander on 2017/5/12.
 */
public class NetServiceinstitutions {

    private int serviceinstitutionsid;
    private String servicename;
    private String serviceno;
    private String detailaddress;
    private String responsiblename;
    private String responsiblephone;
    private String managername;
    private String managephone;
    private String contactphone;
    private String mailaddress;
    private Date createdate;
    private Timestamp createtime;
    private Timestamp updatetime;

    public int getServiceinstitutionsid() {
        return serviceinstitutionsid;
    }

    public void setServiceinstitutionsid(int serviceinstitutionsid) {
        this.serviceinstitutionsid = serviceinstitutionsid;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getServiceno() {
        return serviceno;
    }

    public void setServiceno(String serviceno) {
        this.serviceno = serviceno;
    }

    public String getDetailaddress() {
        return detailaddress;
    }

    public void setDetailaddress(String detailaddress) {
        this.detailaddress = detailaddress;
    }

    public String getResponsiblename() {
        return responsiblename;
    }

    public void setResponsiblename(String responsiblename) {
        this.responsiblename = responsiblename;
    }

    public String getResponsiblephone() {
        return responsiblephone;
    }

    public void setResponsiblephone(String responsiblephone) {
        this.responsiblephone = responsiblephone;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getManagephone() {
        return managephone;
    }

    public void setManagephone(String managephone) {
        this.managephone = managephone;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public String getMailaddress() {
        return mailaddress;
    }

    public void setMailaddress(String mailaddress) {
        this.mailaddress = mailaddress;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetServiceinstitutions that = (NetServiceinstitutions) o;
        return serviceinstitutionsid == that.serviceinstitutionsid &&
                Objects.equals(servicename, that.servicename) &&
                Objects.equals(serviceno, that.serviceno) &&
                Objects.equals(detailaddress, that.detailaddress) &&
                Objects.equals(responsiblename, that.responsiblename) &&
                Objects.equals(responsiblephone, that.responsiblephone) &&
                Objects.equals(managername, that.managername) &&
                Objects.equals(managephone, that.managephone) &&
                Objects.equals(contactphone, that.contactphone) &&
                Objects.equals(mailaddress, that.mailaddress) &&
                Objects.equals(createdate, that.createdate) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(updatetime, that.updatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceinstitutionsid, servicename, serviceno, detailaddress, responsiblename, responsiblephone, managername, managephone, contactphone, mailaddress, createdate, createtime, updatetime);
    }
}
