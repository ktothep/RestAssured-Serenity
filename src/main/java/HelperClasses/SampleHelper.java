package HelperClasses;

import CommonComponents.API;
import net.thucydides.core.annotations.Steps;

public class SampleHelper {
    @Steps
    API api;

    public void intitalise()
    {
        api.switchURL("http://dummy.restapiexample.com/api/v1").initRequest().get("/employees");
    }
}
