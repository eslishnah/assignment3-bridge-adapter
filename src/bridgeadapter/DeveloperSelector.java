package bridgeadapter;

public class DeveloperSelector {

    public Developer select(String level) {

        return switch (level.toLowerCase()) {

            case "junior" ->
                    new JuniorDeveloper();

            case "middle" ->
                    new MiddleDeveloper();

            case "senior" ->
                    new SeniorDeveloperAdapter();

            default ->
                    throw new IllegalArgumentException(
                            "Unknown developer level: " + level
                    );
        };
    }
}