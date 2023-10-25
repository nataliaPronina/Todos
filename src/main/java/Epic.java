import java.util.Arrays;

public class Epic extends Task {
    private String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }


    public String[][] getSubtasks() {
        return new String[][]{new String[]{Arrays.toString(subtasks)}};
    }

    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;

    }
}
