/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.util;

import br.edu.utfpr.r4c.crowdments.crud.QuestionaryCrud;

/**
 *
 * @author ricar
 */
public class Home {
    public static void main(String[] args) {
        QuestionaryCrud qc = new QuestionaryCrud();
        System.out.println("Quant: "+ qc.getAll().size());
    }
}
