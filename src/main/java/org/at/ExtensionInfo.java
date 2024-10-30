package org.at;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Set;

// Hay que definir el stereotype
// Se le indica al framework que reconozcla la clase y que este disponible durante el ciclo de vida de la aplicacion
@ApplicationScoped
public class ExtensionInfo {

    // Inyeccion de dependencias
    @Inject
    @RestClient
    PersonRestClient personRestClient;

    public Set<PersonRestClient.Extension> doSomething() {
        Set<PersonRestClient.Extension> restClientExtensions = personRestClient.getExtensionsById("io.quarkus:quarkus-hibernate-validator");
        restClientExtensions.forEach(extension -> {
            System.out.println("Extension ID: " + extension.id);
            System.out.println("Extension Name: " + extension.name);
        });
        return restClientExtensions;
   }

}
