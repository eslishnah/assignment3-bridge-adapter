package bridgeadapter;

public class LegacySeniorDeveloper {

    public static final int SUCCESS = 0;
    public static final int INVALID_TASK = -1;
    public static final int INVALID_COMPLEXITY = -2;
    public static final int SYSTEM_ERROR = -3;

    public int executeOldTask(
            byte complexityLevel,
            char[] task
    ) {

        if (task == null || task.length == 0) {
            return INVALID_TASK;
        }

        if (complexityLevel < 1 || complexityLevel > 10) {
            return INVALID_COMPLEXITY;
        }

        String taskText = new String(task);

        if (taskText.contains("SYSTEM_FAIL")) {
            return SYSTEM_ERROR;
        }

        System.out.println(
                "Legacy senior developer works on: "
                        + taskText
                        + " | Legacy complexity: "
                        + complexityLevel
        );

        return SUCCESS;
    }
}