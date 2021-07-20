package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.data.JobData;
import org.launchcode.techjobsmvc.models.Job;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Locale;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
@RequestMapping(value = "results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
    ArrayList<Job> jobs;
    jobs = JobData.findByColumnAndValue(searchType.toLowerCase(Locale.ROOT), searchTerm.toLowerCase(Locale.ROOT));
        model.addAttribute("type", searchType);
        model.addAttribute("type", columnChoices);
        model.addAttribute("title", "search condition: " + columnChoices.get(searchType) + "Search Term: " + searchTerm);
        model.addAttribute("jobs", jobs);
        return "search.html";
}

}
