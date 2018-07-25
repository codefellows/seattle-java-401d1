package server;

import com.google.gson.Gson;
import models.Mountain;
import models.MountainStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.management.MonitorInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/api/mountains")
public class MountainAPI {
    // create
    @PostMapping
    @ResponseBody
    public ModelAndView createMountain(
        @RequestParam("name") String name,
        @RequestParam("elevation") int elevation
    ) {
        Mountain mountain = new Mountain(name, elevation);
        MountainStorage.mountains.put(mountain.id, mountain);
        return new ModelAndView("redirect:/mountains");
    }

    // read all
    @GetMapping
    @ResponseBody
    public List<Mountain> getAllMountains() {
       Collection<Mountain> mountains = MountainStorage.mountains.values();
       return new ArrayList<>(mountains);
    }

    // read one
    @GetMapping("/{id}")
    @ResponseBody
    public Mountain getOneMountain(@PathVariable("id") int id) {
        Mountain result = MountainStorage.mountains.get(id);
        return result;
    }

    // update
    @PutMapping("/{id}")
    @ResponseBody
    public Mountain updateMountain(
            @PathVariable("id") int id,
            @RequestBody String body
    ) {
        Gson gson = new Gson();
        Mountain newMountain = gson.fromJson(body, Mountain.class);

        Mountain mountain = MountainStorage.mountains.get(id);
        mountain.name = newMountain.name;
        mountain.elevation = newMountain.elevation;
        return mountain;
    }

    // destroy
    @DeleteMapping("/{id}")
    @ResponseBody
    public Mountain deleteMountain(@PathVariable("id") int id) {
        Mountain mountain = MountainStorage.mountains.get(id);
        MountainStorage.mountains.remove(id);
        return mountain;
    }
}
