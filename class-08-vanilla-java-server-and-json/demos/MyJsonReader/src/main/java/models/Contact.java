package models;

import com.google.gson.Gson;

import java.io.Reader;
import java.util.List;

public class Contact {
  public class Address {
    String streetAddress;
    String city;
    String state;
    // notice that there's a typo here. It was an accident.
    // Leave it here because it's a good example to show
    // how JSON deserialization can fail when we double check
    // it with the unit test.
    String postcalCode;
  }

  public class PhoneNumber {
    String type;
    String number;
  }

  String firstName;
  String lastName;
  int age;
  Address address;
  List<PhoneNumber> phoneNumbers;

  public static Contact fromJson(Reader reader) {
    Gson gson = new Gson();
    Contact result =  gson.fromJson(reader, Contact.class);
    return result;
  }
}
