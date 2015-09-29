import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;

/**
 * Created by pascalou on 02/09/15.
 */
@Path("/listener")
public class DPListenerResource {

    private static final Logger LOGGER = LoggerFactory.getLogger("ListenerResource");

    @GET
    @Timed
    public void sayHello(@QueryParam("name") String name) {
        LOGGER.info("Pour toi Jamal !");
    }
}
