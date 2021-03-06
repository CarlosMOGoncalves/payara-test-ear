package pt.test.webservices;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import fish.payara.micro.cdi.Outbound;

@Stateless
@Path("/events")
public class EventResource {

    private static final Logger LOGGER = Logger.getLogger(EventResource.class.getName());

    @Inject
    @Outbound
    private Event<String> event;

    @POST
    @Path("sendevent")
    public Response runUpdateExchangeRate() {
        LOGGER.info("Sent event from webservices in EAR");
        event.fire("Ships ahoy!");
        return Response.ok().build();
    }

}
