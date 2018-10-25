package API.Vhost;

import API.Backend.APIBackend;
import API.Backend.Backend;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VhostBuilder {

    private static Logger logger = LogManager.getLogger();

    private Backend db = new APIBackend();

    @RequestMapping(value = "/public/getDummyVhost", method = RequestMethod.GET)
    public Vhost getDummyVhost(){
        Vhost host = new Vhost(1 ,80, "www.sejt.dk", "www.sejt.dk", Directive.getDirectiveExample());
        return  host;
    }

    @RequestMapping(value= "/public/addVhost", method = RequestMethod.POST)
    public ResponseEntity<Vhost> addVhost(@RequestBody Vhost host) {
        logger.info(host.toString());
        this.db.addVhost(host);

        return new ResponseEntity<>(host, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/public/getAllVhosts", method = RequestMethod.GET)
    public List<Vhost> getAllVhosts(){
        return this.db.getAllVhosts();
    }

    @RequestMapping(value = "/public/getVhost", method = RequestMethod.GET)
    public Vhost getVhost(@RequestParam("ID") int id){
        return db.getVhost(id);
    }
}
