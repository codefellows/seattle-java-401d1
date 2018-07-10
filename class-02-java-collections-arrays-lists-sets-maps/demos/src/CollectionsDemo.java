
import java.util.*;

public class CollectionsDemo {
  
  public static void main(String[] args){
    arrayTest();
    listTest();
    setTest();
    mapTest();
  }
  
  public static void arrayTest(){
    String[] family = {"Adam", "Amanda", "Mika"};
    
    for (String member: family) { //iterate over each role in roles array.
      System.out.println(member);
    }

    String me = family[0]; //This would assign the value of "Adam" to me.
    System.out.println(me);
    int familySize = family.length;
  }

  public static void listTest(){
    List<String> names = new ArrayList<String>();
    names.add("Adam");
    names.add("Amanda");
    
    String adam = names.get(0);
    System.out.println(adam);
    
    List<String> petNames = new LinkedList<String>();
    petNames.add("Mika");
    petNames.add("Bob");
    
    ArrayList<String> allNames = new ArrayList<String>(petNames);
    allNames.addAll(names);
    
    System.out.println(allNames);
    
    for (String name: allNames) {
      if (name == "Adam") {
        System.out.println("Hello " + name);
      }
    }
    
    if (petNames.contains("Mika")) {
      System.out.println("Mika is part of the family!");
    }
  }
  
  public static void setTest(){
    Set<Integer> set = new HashSet<Integer>();
    int[] data = {1, 100, 10, 50, 30, 1, 90, 1, 30};
    Set<Integer> uniqueValues = new TreeSet<Integer>();
    
    for(int i = 0; i < data.length; i++){
      uniqueValues.add(data[i]);
    }
    
    System.out.println(uniqueValues);

    String[] startingCategories = {"Metal","Classic Rock","Pop","Hip Hop"};
    Set<String> categories = new HashSet<String>();

    for(int i = 0; i < startingCategories.length; i++){
      categories.add(startingCategories[i]);
    }
  
    categories.add("Country");
    categories.add("Metal");
    categories.add("Electronica");
    
    System.out.println(categories);
  }
  
  public static void mapTest(){
    HashMap<String,String> playerEmails = new HashMap<String,String>();
    playerEmails.put("Adam", "adam@codefellows.com");
    playerEmails.put("Bob", "bob@bobross.com");
    playerEmails.put("Glenn", "glenn@glenpire.com");
    playerEmails.put("Brandy", "ionlydrinknice@brandy.com");
    
    String myEmail = playerEmails.get("Adam");
    
    System.out.println(playerEmails);
    System.out.println(myEmail);
    
    playerEmails.put("Adam", "adam.wallraff@gmail.com");
    
    myEmail = playerEmails.get("Adam");
    
    System.out.println(myEmail);
    
    if (!playerEmails.isEmpty()){
      for(Map.Entry<String, String> entry: playerEmails.entrySet()){
          System.out.println(entry.getKey() + " = " + entry.getValue());
      }
    }
    playerEmails.clear();
  }
}









































