package sport.competitions.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sport.competitions.service.CompetitionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/public/rest/competitions")
public class CompetitionRestService {

    @Autowired
    private CompetitionService competitionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(competitionService.listAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        competitionService.delete(id);
    }

    @RequestMapping(value = "/{number}/{name}", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@PathVariable("number") Integer number, @PathVariable("name") String name, @PathVariable("date") String date, @PathVariable("place") String place) {
        return ResponseEntity.ok(competitionService.add(number, name, date, place));
    }
    
    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    public ResponseEntity<Object> findByNumber(@PathVariable("number") Integer number) {
        return ResponseEntity.ok(competitionService.findByNumber(number));
    }
}
