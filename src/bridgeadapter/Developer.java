package bridgeadapter;

public interface Developer {

    void develop(String taskDescription, int complexity)
            throws DevelopmentException;
}