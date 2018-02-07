package net.emisia.svn2git.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.emisia.svn2git.model.SynchronizationEntity;
import net.emisia.svn2git.service.SynchronizationService;

@Controller
@RequestMapping("/index")
public class Svn2GitController {

    @Autowired
    private SynchronizationService _synchronizationService;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteEntry(@RequestParam String name) {
	List<SynchronizationEntity> newList = getSynchronizationService().deleteEntry(name);
	ModelAndView model = new ModelAndView("index");
	model.addObject("list", newList);
	return "redirect:/index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam String name) {
	ModelAndView modelAndView = new ModelAndView("edit");
	modelAndView.addObject("model", getSynchronizationService().findByName(name));
	return modelAndView;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index() {
	ModelAndView model = new ModelAndView("index");
	model.addObject("list", getSynchronizationService().listAllEntries());
	return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView newEntryRegister(SynchronizationEntity newModel) {
	ModelAndView modelAndView = new ModelAndView("index");
	if (!newModel.getName().isEmpty()) {
	    if (getSynchronizationService().entityExistsInXml(newModel)) {
		modelAndView.addObject("list", getSynchronizationService().listAllEntries());
		modelAndView.addObject("error", "You entered name that already exists");
	    } else {
		getSynchronizationService().saveEntry(newModel);
		modelAndView = new ModelAndView("redirect:/index");
	    }
	}
	return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(SynchronizationEntity newModel) {
	ModelAndView modelAndView = new ModelAndView("index");
	if (getSynchronizationService().entityExistsInXml(newModel)) {
	    modelAndView.addObject("list", getSynchronizationService().listAllEntries());
	    modelAndView.addObject("error", "You can't edit name becuse that value already exists");
	} else {
	    getSynchronizationService().updateEntry(newModel);
	    modelAndView = new ModelAndView("redirect:/index");
	}
	return modelAndView;
    }

    private SynchronizationService getSynchronizationService() {
	return _synchronizationService;
    }

}