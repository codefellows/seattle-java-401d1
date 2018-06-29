package models;

import com.google.gson.Gson;

import java.util.List;

public class Institution {
  String name;
  String slogan;
  List<Course> courses;

  public static class Course {
    String name;
    String description;

    public Course(String name, String description) {
      this.name = name;
      this.description = description;
    }
  }

  public Institution(String name, String slogan, List<Course> courses) {
    this.name = name;
    this.slogan = slogan;
    this.courses = courses;
  }

  public String toJson() {
    Gson gson = new Gson();
    String json = gson.toJson(this);
    return json;
  }

  public static Institution fromJson(String json) {
    Gson gson = new Gson();
    Institution result = gson.fromJson(json, Institution.class);
    return result;
  }
}
