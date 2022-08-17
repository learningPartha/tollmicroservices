package com.pluralsight.tollrateservice.resource;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pluralsight.tollrateservice.model.TollRate;
import com.pluralsight.tollrateservice.model.TollRatev2;

@RestController
public class TollRateController {

    List<TollRate> tollrates;
    List<TollRatev2> tollratesv2;

    public TollRateController() {

        tollrates = new ArrayList<TollRate>();
        tollrates.add(new TollRate(1000, 0.55f, Instant.now().toString()));
        tollrates.add(new TollRate(1001, 1.05f, Instant.now().toString()));
        tollrates.add(new TollRate(1002, 0.60f, Instant.now().toString()));
        tollrates.add(new TollRate(1003, 1.00f, Instant.now().toString()));
        
        tollratesv2 = new ArrayList<TollRatev2>();
        tollratesv2.add(new TollRatev2(1000, 0.55f, Instant.now().toString(),true));
        tollratesv2.add(new TollRatev2(1001, 1.05f, Instant.now().toString(),true));
        tollratesv2.add(new TollRatev2(1002, 0.60f, Instant.now().toString(),true));
        tollratesv2.add(new TollRatev2(1003, 1.00f, Instant.now().toString(),true));
        
    }

    @RequestMapping("/tollrate/{stationId}")
    public TollRate GetTollRate(@PathVariable int stationId) {
    	System.out.println("Station requested "+stationId);
        return tollrates.stream().filter(rate -> stationId == rate.getStationId()).findAny().orElse(new TollRate());
    }
    
    @RequestMapping("/tollrateslow/{stationId}")
    public TollRate GetTollRateSlow(@PathVariable int stationId) throws InterruptedException {
    	System.out.println("Station requested "+stationId);
    	Thread.sleep(3000);
        return tollrates.stream().filter(rate -> stationId == rate.getStationId()).findAny().orElse(new TollRate());
    }
    
    @RequestMapping("/tollratev2/{stationId}")
    public TollRatev2 GetTollRatev2(@PathVariable int stationId) {
    	System.out.println("Station requested "+stationId);
        return tollratesv2.stream().filter(rate -> stationId == rate.getStationId()).findAny().orElse(new TollRatev2());
    }
    
}
