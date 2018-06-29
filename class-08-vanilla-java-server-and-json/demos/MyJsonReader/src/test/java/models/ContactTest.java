package models;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.*;

public class ContactTest {
  @Test
  public void testParse() throws FileNotFoundException {
    FileReader reader = new FileReader("john.json");
    Contact john = Contact.fromJson(reader);

    assertEquals("John", john.firstName);
    assertEquals("Smith", john.lastName);
    assertEquals(25, john.age);

    assertEquals("21 2nd Street", john.address.streetAddress);
    assertEquals("New York", john.address.city);
    assertEquals("NY", john.address.state);
    assertEquals("10021", john.address.postcalCode);

    assertEquals(2, john.phoneNumbers.size());
    assertEquals("home", john.phoneNumbers.get(0).type);
    assertEquals("212 555-1234", john.phoneNumbers.get(0).number);
    assertEquals("fax", john.phoneNumbers.get(1).type);
    assertEquals("646 555-4567", john.phoneNumbers.get(1).number);
  }

}