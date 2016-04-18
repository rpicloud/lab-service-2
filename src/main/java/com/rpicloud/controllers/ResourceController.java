package com.rpicloud.controllers;

import com.rpicloud.models.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mixmox on 18/04/16.
 */

@RestController
public class ResourceController {

    @RequestMapping(value = "/resources")
    public ResponseEntity<List<Resource>> resources() {
        List<Resource> resources = new ArrayList<>();
        resources.add(new Resource("Dummy data from service 2"));
        resources.add(new Resource("Dummy data from service 2"));
        resources.add(new Resource("Dummy data from service 2"));
        resources.add(new Resource("Dummy data from service 2"));
        resources.add(new Resource("Dummy data from service 2"));

        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
}
