package pt.test.webservices;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import fish.payara.micro.cdi.Outbound;
import pt.test.jsonb.ClientApp;
import pt.test.jsonb.JsonbConverter;

@Stateless
@Path("/users")
public class UserResource {

    @Inject
    @Outbound
    private Event<String> event;

    @Inject
    private JsonbConverter jsonbConverter;

    @POST
    @Path("sendevent")
    public Response runUpdateExchangeRate() {
        event.fire("Ships ahoy!");
        return Response.ok().build();
    }

    @GET
    public Response testPair() {

        ClientApp json = jsonbConverter.convertFromJson("{\"appName\":\"Payara\",\"appVersion\":\"5\"}", ClientApp.class);

        return Response.ok(json).build();
    }
}
