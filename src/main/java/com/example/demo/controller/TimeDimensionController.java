package com.example.demo.controller;

import com.example.demo.domain.TimeDimension;
import com.example.demo.service.TimeDimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Package: com.example.demo.controller
 * @Author:
 * @Email:
 * @CreateDate: 2019-05-23 13:40
 * @Description:
 */
@RestController
@RequestMapping("/timeDimension")
public class TimeDimensionController {
    private TimeDimensionService timeDimensionService;

    @Autowired
    public TimeDimensionController(TimeDimensionService timeDimensionService) {
        this.timeDimensionService = timeDimensionService;
    }

    @GetMapping
    public List<TimeDimension> findAllTimeDimension() {
        return timeDimensionService.findAllTimeDimension();
    }

    @GetMapping("/{id}")
    public TimeDimension findTimeDimensionById(@PathVariable("id") Integer id) {
        return timeDimensionService.findTimeDimensionById(id);
    }

    @PostMapping("/event")
    public void updateTimeDimension(@RequestParam("id") Integer id, @RequestParam("event") String event) {
        Integer effectRow = timeDimensionService.updateTimeDimension(id, event);
        System.out.println("effectRow:" + effectRow);
    }
}
