package bridgeadapter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DeveloperSelector selector =
                new DeveloperSelector();

        System.out.println(
                "Choose developer level: junior / middle / senior"
        );

        String developerLevel =
                scanner.nextLine();

        Developer developer =
                selector.select(developerLevel);

        System.out.println(
                "Choose development type: frontend / backend"
        );

        String developmentType =
                scanner.nextLine();

        System.out.println(
                "Enter feature name:"
        );

        String featureName =
                scanner.nextLine();

        DevelopmentTask task;

        if (developmentType.equalsIgnoreCase("frontend")) {

            task =
                    new FrontendDevelopment(
                            developer
                    );

        } else if (
                developmentType.equalsIgnoreCase("backend")
        ) {

            task =
                    new BackendDevelopment(
                            developer
                    );

        } else {

            System.out.println(
                    "Unknown development type."
            );

            return;
        }

        try {

            task.developFeature(featureName);

        } catch (DevelopmentException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}