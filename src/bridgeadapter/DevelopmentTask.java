package bridgeadapter;

public abstract class DevelopmentTask {

    protected final Developer developer;

    public DevelopmentTask(Developer developer) {
        this.developer = developer;
    }

    public abstract void developFeature(String featureName)
            throws DevelopmentException;
}