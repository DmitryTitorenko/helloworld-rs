package org.jboss.as.quickstarts.rshelloworld;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")

public class HelloNew {

    @Inject
    HelloService helloService;

    @GET
    @Path("/jsonNew")
    @Produces({"application/json"})
    public String getHelloWorldJSON() {
        return "{\"result\":\"" + helloService.createHelloMessage("World") + "\"}";
    }

}
