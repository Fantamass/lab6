package by.bsuir.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @PostMapping(value = "/dfilter")
    public List<String> dfilter(@RequestBody List<String> input) {
        return input.stream().filter(item -> item.matches("\\d+")).collect(Collectors.toList());
    }
    
    @PostMapping(value = "/digitize")
    public List<Integer> digitize(@RequestBody List<String> input) {
        return input.stream().mapToInt(item -> Integer.parseInt(item)).boxed().collect(Collectors.toList());
    }
    
    @PostMapping(value = "/maxlen")
    public String maxlen(@RequestBody List<String> input) {
        return input.stream().max(Comparator.comparing( String::length)).get();
    }
    
}
