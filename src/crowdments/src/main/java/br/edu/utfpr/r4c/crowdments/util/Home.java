/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.util;

import br.edu.utfpr.r4c.crowdments.crud.AnwserHasTagpatternCrud;
import br.edu.utfpr.r4c.crowdments.entities.AnwserHasTagpattern;
import java.util.List;

/**
 *
 * @author ricar
 */
public class Home {
    public static void main(String[] args) {
        AnwserHasTagpatternCrud vwCrud = new AnwserHasTagpatternCrud();
        List<AnwserHasTagpattern> record = vwCrud.byTag(3);
        
        System.out.println(record.get(0).getTagpattern().getDescription());
    }
}
