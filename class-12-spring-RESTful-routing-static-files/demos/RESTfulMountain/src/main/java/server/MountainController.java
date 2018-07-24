package server;

import models.Mountain;
import models.MountainStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/mountains")
public class MountainController {
    // create HTML form

    // create

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

    // update HTML form

    // update

    // destroy
}
