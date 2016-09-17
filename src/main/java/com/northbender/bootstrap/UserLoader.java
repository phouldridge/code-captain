package com.northbender.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.northbender.domain.User;
import com.northbender.repositories.UserRepository;

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent>  {
	private UserRepository userRepository;

    private Logger log = Logger.getLogger(UserLoader.class);

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        User user = new User();
        user.setUsername("captain");
        user.setPassword("code");
        user.setEnabled(true);
        userRepository.save(user);

        log.info("Saved User: " + user.getUsername());
    }
}
