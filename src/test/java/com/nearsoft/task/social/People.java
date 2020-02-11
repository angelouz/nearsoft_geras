package com.nearsoft.task.social;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nearsoft.task.socialnetwork.Person;
import com.nearsoft.task.socialnetwork.PersonBuilder;
import com.nearsoft.task.socialnetwork.PersonRepository;
import com.nearsoft.task.socialnetwork.SocialNetwork;

@RunWith(SpringRunner.class)
@DataJpaTest
public class People {

    private static Person a, b, c, d;
    private static SocialNetwork socialNetwork;
    private static Connection connection;

	private static Connection getConnection() {
		return null;
	}

    @BeforeAll
    public static void setup() {
        socialNetwork = SocialNetwork.getInstance();
        //connection = getConnection();

        a = new PersonBuilder()
                .setName("Jane Doe")
                .setEmail("jane1990@gmail.com")
                .setAboutMe("")
                .setPhone("663-654-4456")
                .build();

        b = new PersonBuilder()
                .setName("Jhon Doe")
                .setEmail("jhon_doe@gmail.com")
                .setAboutMe("A man, a plan, a canal: Panama.")
                .setPhone("663-654-4422")
                .build();

        c = new PersonBuilder()
                .setName("Lord Voldemort")
                .setEmail("lord666@gmail.com")
                .setAboutMe("Dammit, I'm mad!")
                .setPhone("666-666-0000")
                .build();

        d = new PersonBuilder()
                .setName("Harry Potter")
                .setEmail("hpotter@hogwarts.com")
                .setAboutMe("just me")
                .setPhone("180-654-5323")
                .build();


        socialNetwork.addPerson(a);
        socialNetwork.addPerson(b);
        socialNetwork.addPerson(c);
        socialNetwork.addPerson(d);

    }

    @Test
    public void checkAddPersonValidations() {

        // should only contain persons with
        // palindrome 'about me' descriptions
        // and valid email addresses

        Assert.assertTrue(socialNetwork.getPeople().contains(a));
        Assert.assertTrue(socialNetwork.getPeople().contains(b));
        Assert.assertTrue(socialNetwork.getPeople().contains(c));
        Assert.assertFalse(socialNetwork.getPeople().contains(d));
    }

    
    public void checkAddedPeople() {
        PersonRepository repository = new PersonRepository();
        List<Person> people = repository.getPeople();

        Assert.assertEquals(people.size(), socialNetwork.size());

        Assert.assertTrue(socialNetwork.getPeople().stream().allMatch(p -> people.stream().anyMatch(x -> x.equals(p))));

        Assert.assertEquals(people.get(0), socialNetwork.getPeople().get(0));
        Assert.assertEquals(people.get(1), socialNetwork.getPeople().get(1));
        Assert.assertEquals(people.get(2), socialNetwork.getPeople().get(2));
    }

    /*
    @Test(expected = PhoneFormatException.class)
    public void checkPhoneFormat() {
        new PersonBuilder()
                .setName("Ron Weasley")
                .setEmail("rweasley@hogwarts.com")
                .setAboutMe("")
                .setPhone("1806545323")
                .build();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void checkUnmodifiableList() {
        socialNetwork.getPeople().add(new Person());
    }

    @Test
    public void checkSingleton() {
        Assert.assertEquals(SocialNetwork.getInstance(), SocialNetwork.getInstance());
        Assert.assertEquals(SocialNetwork.getInstance().hashCode(), SocialNetwork.getInstance().hashCode());
    }

    @Test
    public void checkSingletonConstructor() {
        Constructor a[] = SocialNetwork.class.getDeclaredConstructors();
        Assert.assertEquals(1, a.length);
        Assert.assertTrue(Modifier.isPrivate(a[0].getModifiers()));
    }
    */
}
