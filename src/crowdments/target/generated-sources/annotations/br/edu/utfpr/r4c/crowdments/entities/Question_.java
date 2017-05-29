package br.edu.utfpr.r4c.crowdments.entities;

import br.edu.utfpr.r4c.crowdments.entities.Anwserprofilequestion;
import br.edu.utfpr.r4c.crowdments.entities.Questionary;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T23:12:43")
@StaticMetamodel(Question.class)
public class Question_ { 

    public static volatile SingularAttribute<Question, String> question;
    public static volatile CollectionAttribute<Question, Anwserprofilequestion> anwserprofilequestionCollection;
    public static volatile SingularAttribute<Question, Integer> id;
    public static volatile SingularAttribute<Question, Questionary> questionary;

}