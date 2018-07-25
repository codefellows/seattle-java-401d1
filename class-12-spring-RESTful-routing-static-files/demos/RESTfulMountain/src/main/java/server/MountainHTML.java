package server;

import com.google.gson.Gson;
import models.Mountain;
import models.MountainStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.management.MonitorInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/mountains")
public class MountainHTML {
    // list all mountains page
    @GetMapping
    public String showAllMountains(Model model) {
        Collection<Mountain> mountains = MountainStorage.mountains.values();
        List<Mountain> list = new ArrayList<>(mountains);

        model.addAttribute("mountains", mountains);
        return "all_mountains";
    }

    // create HTML form
    @GetMapping("/new")
    public String createMountainForm() {
        return "create_mountain";
    }

    // update HTML form
    @GetMapping("/{id}/edit")
    public String editMountainForm(
            @PathVariable("id") int id,
            Model model
    ) {
        Mountain mountain = MountainStorage.mountains.get(id);

        model.addAttribute("id", mountain.id);
        model.addAttribute("name", mountain.name);
        model.addAttribute("elevation", mountain.elevation);

        return "edit_mountain";
    }
}
