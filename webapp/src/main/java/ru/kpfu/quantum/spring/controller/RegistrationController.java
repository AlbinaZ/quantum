package ru.kpfu.quantum.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.quantum.spring.domain.RegistrationBean;
import ru.kpfu.quantum.spring.domain.RegistrationBeanValidator;
import ru.kpfu.quantum.spring.entities.User;
import ru.kpfu.quantum.spring.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author sala
 */
@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RegistrationBeanValidator registrationBeanValidator;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String renderRegistration(ModelMap modelMap) {
        modelMap.addAttribute("registrationBean", new RegistrationBean());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String processRegistration(HttpServletRequest httpServletRequest,
                                      @Valid @ModelAttribute RegistrationBean registrationBean,
                                      BindingResult bindingResult) {
        User user = new User(registrationBean.getFirstname(),
                             registrationBean.getLastname(),
                             registrationBean.getUserEmail(), registrationBean.getUserLog(), registrationBean.getPassw());
        registrationBeanValidator.validate(registrationBean, bindingResult);
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        userRepository.save(user);
        return "registration/registrationSuccessful";
    }
}
