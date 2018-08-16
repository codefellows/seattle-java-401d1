package com.example.moonmayor.androidlists.starfleet;

import java.util.ArrayList;
import java.util.List;

public class StarfleetData {
    private static StarfleetData mSingleton;
    private List<StarfleetPersonnel> users;

    // make the default constructor private so no one else can make one
    private StarfleetData() {
        users = new ArrayList<>();
        users.add(new StarfleetPersonnel("Kirk", "Captain", "James Tiberius \"Jim\" Kirk was a male Human Starfleet officer in the 23rd century. He was arguably one of the most famous and highly decorated starship captains in the history of Starfleet. As the commanding officer of the Constitution-class starships USS Enterprise and USS Enterprise-A, Kirk served United Federation of Planets interests as an explorer, soldier, time-traveler, and diplomat."));
        users.add(new StarfleetPersonnel("Picard", "Captain", "Jean-Luc Picard was a celebrated Starfleet officer, archaeologist and diplomat who served during the latter two thirds of the 24th century. The highlights of his career were centered around assignments as commanding officer of the Federation starships: USS Stargazer, USS Enterprise-D, and the USS Enterprise-E. In these roles, Picard not only witnessed the major turning points of recent galactic history, but played a key role in them also, from making first contact as captain of the Federation's flagship with no fewer than 27 alien species, including the Ferengi and the Borg."));
        users.add(new StarfleetPersonnel("Janeway", "Captain", "Kathryn Janeway was a 24th century Starfleet officer, most noted for her service as captain of the starship USS Voyager. She became the first Federation captain to successfully traverse the Delta Quadrant, encountering dozens of new planets and civilizations over the course of seven years. While there, she and her crew also survived numerous encounters with the Borg. By 2379, she was a Vice Admiral at Starfleet Command."));
        users.add(new StarfleetPersonnel("Geordi La Forge", "Lieutenant Commander", "Geordi La Forge was a Human male Starfleet officer who originally was the helmsman of the USS Enterprise-D during 2364, with the rank of lieutenant junior grade. He was promoted to lieutenant and later lieutenant commander and became the chief engineer of the Enterprise-D and later USS Enterprise-E, both under Captain Jean-Luc Picard."));
        users.add(new StarfleetPersonnel("Data", "Lieutenant Commander", "Lieutenant Commander Data was a Soong-type android, the first and only such being to ever enter Starfleet. Data was created some time in the 2330s and was killed in 2379, sacrificing himself to save the crew of the USS Enterprise-E. "));
        users.add(new StarfleetPersonnel("Neelix", "Ambassador", "Neelix was a mainly Talaxian hybrid (he was one-eighth Mylean) who lived in the 24th century. He joined the USS Voyager when it was pulled into the Delta Quadrant by the Caretaker's array in 2371. While Voyager made a seven-year journey through the Delta Quadrant, he served as the ship's chef, morale officer, \"ambassador to the Delta Quadrant\" and navigator, in addition to forming close personal friendships with many crew members and becoming a valuable member of the stranded Starfleet crew."));
        users.add(new StarfleetPersonnel("Hugh", "Civilian", "Hugh, formerly Third of Five, was a former Borg drone who was rescued by the USS Enterprise-D in 2368."));
        users.add(new StarfleetPersonnel("B'Elanna Torres", "Lieutenant junior grade", "B'Elanna Torres was a Klingon-Human hybrid and former Maquis who served as chief engineer on the Federation starship USS Voyager under Captain Kathryn Janeway."));
        users.add(new StarfleetPersonnel("William T. Riker", "First Officer", "William Thomas \"Will\" Riker was a noted Starfleet officer, perhaps best known for his long assignment as first officer under Captain Jean-Luc Picard aboard the USS Enterprise-D and later the USS Enterprise-E. In 2379 he finally accepted a promotion as captain of the USS Titan."));
        users.add(new StarfleetPersonnel("Spot", "Cat", "Spot was a female cat and Data's pet in the 2360s and 2370s. She lived with him while he served aboard the USS Enterprise-D and -E. She had a litter of kittens with one of the other cats on the Enterprise-D. Data once wrote a poem about Spot, entitled \"Ode to Spot\"."));
        users.add(new StarfleetPersonnel("Worf", "Lieutenant Commander", "Worf – son of Mogh, of the Klingon House of Martok, of the Human family Rozhenko; mate to K'Ehleyr, father to Alexander Rozhenko, and husband to Jadzia Dax; Starfleet officer and soldier of the Empire; bane of the House of Duras; slayer of Gowron; Federation ambassador to Qo'noS – was one of the most influential Klingons of the latter half of the 24th century. "));
        users.add(new StarfleetPersonnel("Chakotay", "Commander", "Chakotay was a 24th century Human Starfleet officer and former Maquis member, best known as first officer under Captain Kathryn Janeway aboard the USS Voyager. Before serving as Voyager's first officer, he had resigned from Starfleet after years of service in order to join the Maquis to defend his home colony against the Cardassians."));
        users.add(new StarfleetPersonnel("Tuvok", "Lieutenant Commander", "Tuvok was a 24th century Vulcan Starfleet officer. He entered Starfleet Academy in 2289. Upon graduation from the Academy, he served under Captain Hikaru Sulu on the USS Excelsior in 2293. Upon leaving and then later rejoining Starfleet in 2349, he served on board the USS Wyoming before becoming tactical officer and security officer, as well as second officer on the USS Voyager under Captain Kathryn Janeway during its seven-year journey through the Delta Quadrant."));
    }

    public static StarfleetData get() {
        if (mSingleton == null) {
            mSingleton = new StarfleetData();
        }
        return mSingleton;
    }

    // create a getter to prevent others from reassigning the list to null or another list.
    public List<StarfleetPersonnel> users() {
        return users;
    }

    public static List<StarfleetPersonnel> search(String filter) {
        List<StarfleetPersonnel> results = new ArrayList<>();

        for (StarfleetPersonnel person : get().users()) {
            if (person.name.toLowerCase().contains(filter)) {
                results.add(person);
            } else if (person.rank.toLowerCase().contains(filter)) {
                results.add(person);
            }
        }

        return results;
    }
}
