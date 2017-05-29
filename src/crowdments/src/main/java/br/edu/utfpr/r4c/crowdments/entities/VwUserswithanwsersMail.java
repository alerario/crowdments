/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "vw_userswithanwsers_mail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwUserswithanwsersMail.findAll", query = "SELECT v FROM VwUserswithanwsersMail v")
    ,@NamedQuery(name = "VwUserswithanwsersMail.findByMail", query = "SELECT v FROM VwUserswithanwsersMail v WHERE v.mail = :mail"),
    @NamedQuery(name = "VwUserswithanwsersMail.findByQuestionary", query = "SELECT v FROM VwUserswithanwsersMail v WHERE v.questionary = :questionary")})
public class VwUserswithanwsersMail implements Serializable {

    @Column(name = "questionary")
    private Integer questionary;

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 255)
    @Column(name = "mail")
    private String mail;

    public VwUserswithanwsersMail() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getQuestionary() {
        return questionary;
    }

    public void setQuestionary(Integer questionary) {
        this.questionary = questionary;
    }
    
}
