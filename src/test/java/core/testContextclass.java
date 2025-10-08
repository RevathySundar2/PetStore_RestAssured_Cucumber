package core;

import io.restassured.response.Response;

//uses pico container library - used for transfering response object across different feature files / step defns
public class testContextclass {

    Response transferingResponse;

  //  @ScenarioScoped
    public Response getTransferingResponse()
    {
        return transferingResponse;
    }

    public void setTransferingResponse(Response transferingResponse) {
        this.transferingResponse = transferingResponse;
    }

    
}

