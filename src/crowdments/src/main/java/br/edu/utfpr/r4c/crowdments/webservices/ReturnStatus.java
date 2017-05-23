/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.webservices;

import java.io.Serializable;

/**
 *
 * @author ricar
 */
public class ReturnStatus implements Serializable{
    private Integer status;
    private String info;
    private Integer cod;
    private Object obj;
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Object getObject() {
        return obj;
    }

    public void setObject(Object obj) {
        this.obj = obj;
    }
}
