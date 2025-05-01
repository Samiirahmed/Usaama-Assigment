package demo.Wakiiki.Controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/responsible")
public class Repository {

    @GetMapping("/success")
    public ResponseEntity<String> Successfully (){
        HttpHeaders header = new HttpHeaders();
        header.add("Success Header","Successfully Achieved");
        return new ResponseEntity<>("Successfully Saved", header , HttpStatus.OK);
    }

    @GetMapping("/not-found")
    public ResponseEntity<Map<String, String>> Not_found (){
        HttpHeaders myheader = new HttpHeaders();
        myheader.add("Error Header","Not founded");

        Map<String,String> not_found = new HashMap<>();
        not_found.put("Error","Something Wrong");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(myheader).body(not_found);
    }
}
