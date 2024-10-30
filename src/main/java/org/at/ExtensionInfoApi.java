package org.at;

import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Set;
import java.util.stream.Collectors;

// esto es como un controlador y aca se define el path
@Path("/extensions")
public class ExtensionInfoApi {

    // Inyectar la clase extensionInfo
    @Inject
    ExtensionInfo extensionInfo;

    // Leer valor del application.properties
    @ConfigProperty(name = "greeting")
    private String greeting;

    @GET
    @Produces(MediaType.APPLICATION_JSON) // para devolver JSON
    public Set<JsonObject> getExtensions() {
        Set<JsonObject> collect = extensionInfo.doSomething().stream().map(extension -> {
            JsonObject json = Json.createObjectBuilder()
                    .add("id", extension.id)
                    .add("name", extension.name)
                    .add("shortName", extension.shortName)
                    .add("keywords", Json.createArrayBuilder(extension.keywords))
                    .build();
            return json;
        }).collect(Collectors.toSet());
        return collect;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("custom/{name}")
    public String customHello(@PathParam("name") String name) {
        return greeting + name + " how are yo doing?";
    }

}
