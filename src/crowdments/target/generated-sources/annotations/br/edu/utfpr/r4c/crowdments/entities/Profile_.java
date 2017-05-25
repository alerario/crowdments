package br.edu.utfpr.r4c.crowdments.entities;

import br.edu.utfpr.r4c.crowdments.entities.Anwserprofilequestion;
import br.edu.utfpr.r4c.crowdments.entities.Typeprofile;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-25T08:20:24")
@StaticMetamodel(Profile.class)
public class Profile_ { 

    public static volatile SingularAttribute<Profile, Typeprofile> typeprofile;
    public static volatile SingularAttribute<Profile, String> password;
    public static volatile SingularAttribute<Profile, String> mail;
    public static volatile SingularAttribute<Profile, String> city;
    public static volatile SingularAttribute<Profile, String> sex;
    public static volatile CollectionAttribute<Profile, Anwserprofilequestion> anwserprofilequestionCollection;
    public static volatile SingularAttribute<Profile, String> name;
    public static volatile SingularAttribute<Profile, String> studies;
    public static volatile SingularAttribute<Profile, Integer> id;
    public static volatile SingularAttribute<Profile, String> state;
    public static volatile SingularAttribute<Profile, String> position;
    public static volatile SingularAttribute<Profile, Integer> age;

}