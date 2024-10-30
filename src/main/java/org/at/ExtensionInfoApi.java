package org.at;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Set;

// esto es como un controlador y aca se define el path
@Path("/extensions")
public class ExtensionInfoApi {

    @Inject
    ExtensionInfo extensionInfo;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Set<PersonRestClient.Extension> extensionInfoApi() {
        Set<PersonRestClient.Extension> extensions = extensionInfo.doSomething();
        return extensions;

    }

}
