package br.edu.utfpr.r4c.crowdments.entities;

import br.edu.utfpr.r4c.crowdments.entities.Anwser;
import br.edu.utfpr.r4c.crowdments.entities.Questionary;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-18T22:11:00")
@StaticMetamodel(Question.class)
public class Question_ { 

    public static volatile CollectionAttribute<Question, Anwser> anwserCollection;
    public static volatile SingularAttribute<Question, String> question;
    public static volatile SingularAttribute<Question, Integer> id;
    public static volatile SingularAttribute<Question, Questionary> questionary;

}