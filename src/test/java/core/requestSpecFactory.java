package core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class requestSpecFactory {
    public  static RequestSpecification spec;

    public static RequestSpecification get() {
        RequestSpecBuilder rqspec = null;
        if (spec == null) {

            rqspec = new RequestSpecBuilder()
                    .setBaseUri(ConfigManager.FrameworkProperties().getProperty("baseuri"))
                    .setContentType(ContentType.JSON)
                    .setAccept(ContentType.JSON);

        }
        assert rqspec != null;
        spec = rqspec.build();
        return spec;
    }
}
