package pt.test.webservices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import pt.test.ejbs.services.PeriodicService;

@Stateless
@Path("/interceptors")
public class InterceptorResource {

    @EJB
    private PeriodicService periodicService;

    @POST
    @Path("intercept")
    public Response runPeriodicService() {
        periodicService.executeGenerateRandomNumber();
        return Response.ok().build();
    }

}
