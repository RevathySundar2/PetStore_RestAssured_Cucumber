package core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class requestSpecFactory {
    public  static RequestSpecification spec;

    public static RequestSpecification get() {
        if (spec == null) {
            RequestSpecBuilder rqspec = new RequestSpecBuilder()
                    .setBaseUri(ConfigManager.FrameworkProperties().getProperty("baseuri"))
                    .setContentType(ContentType.JSON)
                    .setAccept(ContentType.JSON);

            spec = rqspec.build();
        }
        return spec;
    }
}
