package com.iqmsoft.springboot;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iqmsoft.springboot.service.Person;
import com.iqmsoft.springboot.service.PersonServiceRepository;

@Controller
public class MainController {
	
	@Autowired
	private PersonServiceRepository repo;
	
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		PageRequest page = new PageRequest(0, 20, new Sort(new Order(Direction.ASC, "name")));
		model.put("users", repo.findAll(page).getContent());
		return "hello";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("user") Person user) {
        if (isUserValid(user)) {
        	repo.save(user);
        }
        return "redirect:/";
    }

	private boolean isUserValid(Person user) {
		return null != user && null != user.getName() && !user.getName().isEmpty();
	}
}
