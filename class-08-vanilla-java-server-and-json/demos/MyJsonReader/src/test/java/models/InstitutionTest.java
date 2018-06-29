package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InstitutionTest {

  // Encapsulate the creation of the Code Fellows object in a method
  // that we can call over and over.
  public static Institution getInstitution() {
    String name = "Code Fellows";
    String slogan = "Learn more faster";
    List<Institution.Course> courses = new ArrayList<>();
    courses.add(new Institution.Course("Code 101", "Intro to Software"));
    courses.add(new Institution.Course("Code 102", "Intro to JavaScript"));
    courses.add(new Institution.Course("Code 201", "Foundations"));
    courses.add(new Institution.Course("Code 301", "Intermediate"));
    courses.add(new Institution.Course("Code 401", "Advanced JavaScript"));
    courses.add(new Institution.Course("Code 401", "Advanced Python"));
    courses.add(new Institution.Course("Code 401", "Advanced Java"));
    Institution codeFellows = new Institution(name, slogan, courses);
    return codeFellows;
  }

  @Test
  public void testCreateJson() {
    Institution codeFellows = getInstitution();

    // convert to JSON
    String json = codeFellows.toJson();

    // sanity checks to see that the string begins and ends with curly braces.
    assertEquals('{', json.charAt(0));
    assertEquals('}', json.charAt(json.length() - 1));

    // sanity checks to make sure the name and slogan keys are somewhere in the JSON
    assertTrue(json.contains("name\":"));
    assertTrue(json.contains("slogan\":"));
  }

  @Test
  public void testSerializeDeserialize() {
    Institution cf1 = getInstitution();
    String json = cf1.toJson();
    Institution cf2 = Institution.fromJson(json);

    assertEquals(cf1.name, cf2.name);
    assertEquals(cf1.slogan, cf2.slogan);
    assertEquals(cf1.courses.size(), cf2.courses.size());
  }

}