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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "vw_age")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwAge.findAll", query = "SELECT v FROM VwAge v")
    , @NamedQuery(name = "VwAge.findByAge", query = "SELECT v FROM VwAge v WHERE v.age = :age")
    , @NamedQuery(name = "VwAge.findByCount", query = "SELECT v FROM VwAge v WHERE v.count = :count")})
public class VwAge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "age")
    private Integer age;
    @Column(name = "count")
    private BigInteger count;

    public VwAge() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }
    
}
