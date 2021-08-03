package jmsocialproject.springgateway.validator;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class RouteValidationImpl implements RouteValidation {

    private final List<String> openApi = List.of("/api/rest/auth/login", "/api/rest/auth/registration");

    private final Map<String, List<String>> mapClosedApi = Map.of("ROLE_USER", List.of("/api/user"),
            "ROLE_MODERATOR", List.of("/api/user", "/api/moderator"),
            "ROLE_ADMIN", List.of("/api/user", "/api/moderator", "/api/admin"));

    @Override
    public boolean isOpenApi(String url) {
        return openApi.contains(url);
    }

    @Override
    public boolean checkMapping(String roleName, String url) {
        return mapClosedApi.get(roleName).contains(url);
    }
}
