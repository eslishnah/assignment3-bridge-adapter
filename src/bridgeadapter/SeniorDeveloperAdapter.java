package bridgeadapter;

public class SeniorDeveloperAdapter implements Developer {

    private final LegacySeniorDeveloper legacyDeveloper;

    public SeniorDeveloperAdapter(
            LegacySeniorDeveloper legacyDeveloper
    ) {
        this.legacyDeveloper = legacyDeveloper;
    }

    public SeniorDeveloperAdapter() {
        this(new LegacySeniorDeveloper());
    }

    @Override
    public void develop(
            String taskDescription,
            int complexity
    ) throws DevelopmentException {

        char[] legacyTask =
                taskDescription == null
                        ? null
                        : taskDescription.toCharArray();

        if (complexity < Byte.MIN_VALUE
                || complexity > Byte.MAX_VALUE) {

            throw new DevelopmentException(
                    "Complexity value cannot be processed."
            );
        }

        byte legacyComplexity = (byte) complexity;

        int result =
                legacyDeveloper.executeOldTask(
                        legacyComplexity,
                        legacyTask
                );

        switch (result) {

            case LegacySeniorDeveloper.SUCCESS:
                break;

            case LegacySeniorDeveloper.INVALID_TASK:
                throw new DevelopmentException(
                        "Task description is invalid."
                );

            case LegacySeniorDeveloper.INVALID_COMPLEXITY:
                throw new DevelopmentException(
                        "Task complexity is not supported."
                );

            case LegacySeniorDeveloper.SYSTEM_ERROR:
                throw new DevelopmentException(
                        "Senior developer service is unavailable."
                );

            default:
                throw new DevelopmentException(
                        "Unknown developer error."
                );
        }
    }
}