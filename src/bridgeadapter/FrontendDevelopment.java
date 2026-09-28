package bridgeadapter;

public class FrontendDevelopment extends DevelopmentTask {

    public FrontendDevelopment(Developer developer) {
        super(developer);
    }

    @Override
    public void developFeature(String featureName)
            throws DevelopmentException {

        developer.develop(
                "Frontend feature: " + featureName,
                3
        );
    }
}