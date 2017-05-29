/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "vw_usersex")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwUsersex.findAll", query = "SELECT v FROM VwUsersex v")
    , @NamedQuery(name = "VwUsersex.findBySex", query = "SELECT v FROM VwUsersex v WHERE v.sex = :sex")
    , @NamedQuery(name = "VwUsersex.findByCount", query = "SELECT v FROM VwUsersex v WHERE v.count = :count"),
    @NamedQuery(name = "VwUsersex.findAllSex", query = "SELECT v FROM VwUsersex v WHERE v.questionary = :questionary"),
    @NamedQuery(name = "VwUsersex.findByQuestionary", query = "SELECT v FROM VwUsersex v WHERE v.questionary = :questionary AND v.sex = :sex")})
public class VwUsersex implements Serializable {

    @Column(name = "questionary")
    private Integer questionary;

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 255)
    @Column(name = "sex")
    private String sex;
    @Column(name = "count")
    private BigInteger count;

    public VwUsersex() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }

    public Integer getQuestionary() {
        return questionary;
    }

    public void setQuestionary(Integer questionary) {
        this.questionary = questionary;
    }
    
}
