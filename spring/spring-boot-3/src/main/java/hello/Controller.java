package hello;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by navid on 2016-06-14.
 */
@RestController
public class Controller {

    @RequestMapping("/")
    public String index(){
        return "My first Spring boot app!";
    }


    @RequestMapping(value = "/score/{term}", method = RequestMethod.POST)
    ResponseEntity<String> score(@PathVariable String term, @RequestBody String text) {


        ArrayList<String> tokens = Utilities.tokenize(text);

        int occurrences = Utilities.count(tokens, term);
        double score = Utilities.score(tokens, term);
        if (occurrences > 0) {
            String response = String.valueOf(occurrences) + " Matches, Score: " + score;
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>("No match", HttpStatus.NOT_FOUND);
    }









}
