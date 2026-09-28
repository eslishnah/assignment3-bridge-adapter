package bridgeadapter;

public class BackendDevelopment extends DevelopmentTask {

    public BackendDevelopment(Developer developer) {
        super(developer);
    }

    @Override
    public void developFeature(String featureName)
            throws DevelopmentException {

        developer.develop(
                "Backend feature: " + featureName,
                7
        );
    }
}