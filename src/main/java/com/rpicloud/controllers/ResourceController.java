package com.rpicloud.controllers;

import com.rpicloud.models.Resource;
import com.rpicloud.models.ServerState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mixmox on 18/04/16.
 */

@RestController
public class ResourceController {

    private ServerState state = new ServerState();

    @RequestMapping(value = "/resources")
    public ResponseEntity<List<Resource>> resources() {
        return new ResponseEntity<>(state.getResources().subList(0, state.getAmount()), HttpStatus.OK);
    }

    // Managing timeout, delay and limit
    @ModelAttribute
    public void inject() throws Exception {
        state.invoke();
    }

    @RequestMapping("/delay/{interval}")
    public String delay(@PathVariable int interval) {
        state.setDelay(interval);
        return "I will sleep for " + state.getDelay() + "ms on all requests!";
    }

    @RequestMapping("/resultset/{amount}")
    public String resultSet(@PathVariable int amount) {
        state.setAmount(amount);
        return "Amount: " + state.getAmount();
    }

//    @RequestMapping("/exceptions/{exception}")
//    public String crash(@PathVariable String exception) {
//        state.setException(exception);
//        return "I'm gonna throw a '" + state.getException() + "' next time you call me!";
//    }
}
