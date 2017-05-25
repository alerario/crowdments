package br.edu.utfpr.r4c.crowdments.entities;

import br.edu.utfpr.r4c.crowdments.entities.Profile;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-25T08:20:24")
@StaticMetamodel(Typeprofile.class)
public class Typeprofile_ { 

    public static volatile SingularAttribute<Typeprofile, Integer> level;
    public static volatile SingularAttribute<Typeprofile, String> name;
    public static volatile SingularAttribute<Typeprofile, Boolean> active;
    public static volatile SingularAttribute<Typeprofile, String> description;
    public static volatile SingularAttribute<Typeprofile, Integer> id;
    public static volatile CollectionAttribute<Typeprofile, Profile> profileCollection;

}