import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.codahale.metrics.annotation.Timed;

/**
 * Created by pascalou on 01/09/15.
 */
@Path("/router")
public class DPRouterResource {

    @GET
    @Timed
    public void sayHello(@QueryParam("name") String name) {
    }
}
