package cristoffer85.exam.snofjallbywithptbackend.controller;

import cristoffer85.exam.snofjallbywithptbackend.model.User;
import cristoffer85.exam.snofjallbywithptbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String helloUserController() {
        return "User access level";
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        user.setMaxHoursSlept(user.getMaxHoursSlept());
        return userRepository.save(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/getOneUser/{username}")
    public User getOneUser(@PathVariable String username) { return userRepository.findByUsername(username).orElse(null);
    }
}
