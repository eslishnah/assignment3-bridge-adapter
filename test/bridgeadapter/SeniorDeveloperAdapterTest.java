package bridgeadapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeniorDeveloperAdapterTest {

    private static class LegacyDeveloperStub
            extends LegacySeniorDeveloper {

        private final int result;

        LegacyDeveloperStub(int result) {
            this.result = result;
        }

        @Override
        public int executeOldTask(
                byte complexityLevel,
                char[] task
        ) {
            return result;
        }
    }

    @Test
    void translatesInvalidTaskError() {

        LegacySeniorDeveloper legacy =
                new LegacyDeveloperStub(
                        LegacySeniorDeveloper.INVALID_TASK
                );

        Developer adapter =
                new SeniorDeveloperAdapter(legacy);

        DevelopmentException exception =
                assertThrows(
                        DevelopmentException.class,
                        () -> adapter.develop(
                                "Some task",
                                5
                        )
                );

        assertEquals(
                "Task description is invalid.",
                exception.getMessage()
        );
    }

    @Test
    void translatesInvalidComplexityError() {

        LegacySeniorDeveloper legacy =
                new LegacyDeveloperStub(
                        LegacySeniorDeveloper.INVALID_COMPLEXITY
                );

        Developer adapter =
                new SeniorDeveloperAdapter(legacy);

        DevelopmentException exception =
                assertThrows(
                        DevelopmentException.class,
                        () -> adapter.develop(
                                "Some task",
                                5
                        )
                );

        assertEquals(
                "Task complexity is not supported.",
                exception.getMessage()
        );
    }

    @Test
    void translatesSystemError() {

        LegacySeniorDeveloper legacy =
                new LegacyDeveloperStub(
                        LegacySeniorDeveloper.SYSTEM_ERROR
                );

        Developer adapter =
                new SeniorDeveloperAdapter(legacy);

        DevelopmentException exception =
                assertThrows(
                        DevelopmentException.class,
                        () -> adapter.develop(
                                "Some task",
                                5
                        )
                );

        assertEquals(
                "Senior developer service is unavailable.",
                exception.getMessage()
        );
    }
}