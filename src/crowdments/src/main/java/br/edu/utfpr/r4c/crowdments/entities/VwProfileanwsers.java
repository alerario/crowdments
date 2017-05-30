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
@Table(name = "vw_profileanwsers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwProfileanwsers.findAll", query = "SELECT v FROM VwProfileanwsers v")
    , @NamedQuery(name = "VwProfileanwsers.findById", query = "SELECT v FROM VwProfileanwsers v WHERE v.id = :id")
    , @NamedQuery(name = "VwProfileanwsers.findByAnwser", query = "SELECT v FROM VwProfileanwsers v WHERE v.anwser = :anwser")
    , @NamedQuery(name = "VwProfileanwsers.findByMail", query = "SELECT v FROM VwProfileanwsers v WHERE v.questionary = :questionary AND v.mail = :mail")
    , @NamedQuery(name = "VwProfileanwsers.findByProfile", query = "SELECT v FROM VwProfileanwsers v WHERE v.questionary = :questionary")
    , @NamedQuery(name = "VwProfileanwsers.findByQuestion", query = "SELECT v FROM VwProfileanwsers v WHERE v.question = :question")
    , @NamedQuery(name = "VwProfileanwsers.findByQuestionary", query = "SELECT v FROM VwProfileanwsers v WHERE v.questionary = :questionary")})
public class VwProfileanwsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "anwser")
    private String anwser;
    @Size(max = 255)
    @Column(name = "mail")
    private String mail;
    @Column(name = "profile")
    private Integer profile;
    @Column(name = "question")
    private Integer question;
    @Column(name = "questionary")
    private Integer questionary;

    public VwProfileanwsers() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnwser() {
        return anwser;
    }

    public void setAnwser(String anwser) {
        this.anwser = anwser;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    public Integer getQuestionary() {
        return questionary;
    }

    public void setQuestionary(Integer questionary) {
        this.questionary = questionary;
    }
    
}
