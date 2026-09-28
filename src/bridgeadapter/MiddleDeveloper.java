package bridgeadapter;

public class MiddleDeveloper implements Developer {

    @Override
    public void develop(String taskDescription, int complexity)
            throws DevelopmentException {

        if (taskDescription == null || taskDescription.isBlank()) {
            throw new DevelopmentException(
                    "Task description cannot be empty."
            );
        }

        System.out.println(
                "Middle developer works on: "
                        + taskDescription
                        + " | Complexity: "
                        + complexity
        );
    }
}