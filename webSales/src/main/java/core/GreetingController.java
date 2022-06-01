package core;

import core.domain.Sales;
import core.repos.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private SalesRepository salesRepository;
    private String name;

    @GetMapping("/")
    public String greeting( Map<String, Object> model){
        return "greeting";
    }


    @GetMapping("/login")
    public String login( Map<String, Object> model){
        return "login";
    }



    @GetMapping("/main")
    public String main(@RequestParam String text, Map<String, Object> model){
        Iterable<Sales> sales= salesRepository.findAll();
        this.name=text;
        model.put("name", this.name);
        model.put("sales", sales);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam Integer total, @RequestParam Date dateIn,
                      @RequestParam Date dateOut, Map<String, Object> model){
        Sales sale=new Sales(total, dateIn, dateOut);
        salesRepository.save(sale);
        Iterable<Sales> sales= salesRepository.findAll();
        model.put("name", this.name);
        model.put("sales", sales);
        return "main";
    }

}

