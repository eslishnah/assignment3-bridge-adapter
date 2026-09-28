package bridgeadapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeTest {

    private static class DeveloperStub implements Developer {

        String receivedTask;
        int receivedComplexity;

        @Override
        public void develop(String taskDescription, int complexity) {
            receivedTask = taskDescription;
            receivedComplexity = complexity;
        }
    }

    @Test
    void frontendDelegatesToDeveloper() throws DevelopmentException {

        DeveloperStub stub = new DeveloperStub();

        DevelopmentTask task =
                new FrontendDevelopment(stub);

        task.developFeature("Login page");

        assertEquals(
                "Frontend feature: Login page",
                stub.receivedTask
        );

        assertEquals(
                3,
                stub.receivedComplexity
        );
    }

    @Test
    void backendDelegatesToDeveloper() throws DevelopmentException {

        DeveloperStub stub = new DeveloperStub();

        DevelopmentTask task =
                new BackendDevelopment(stub);

        task.developFeature("Authentication API");

        assertEquals(
                "Backend feature: Authentication API",
                stub.receivedTask
        );

        assertEquals(
                7,
                stub.receivedComplexity
        );
    }
}