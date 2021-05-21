package pt.test.webservices;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import fish.payara.micro.cdi.Outbound;

@Stateless
@Path("/users")
public class UserResource {

    @Inject
    @Outbound
    private Event<String> event;

    @POST
    @Path("sendevent")
    public Response runUpdateExchangeRate() {
        event.fire("Ships ahoy!");
        return Response.ok().build();
    }

}
