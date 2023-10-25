import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void SimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void SimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("мама");
        Assertions.assertFalse(actual);
    }

    @Test
    public void EpicMatches() {
        Epic epic = new Epic(5, new String[]{"Позвонить родителям"});
        boolean actual = epic.matches("Позвонить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void EpicNotMatches() {
        Epic epic = new Epic(5, new String[]{"Позвонить родителям"});
        boolean actual = epic.matches("Yfgbcfnm");
        Assertions.assertFalse(actual);
    }

    @Test
    public void MeetingNotMatches() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Приложение Локобанка");
        Assertions.assertFalse(actual);
    }

    @Test
    public void MeetingMatchesTopic() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Выкатка");
        Assertions.assertTrue(actual);
    }

    @Test
    public void MeetingMatchesProject() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean actual = meeting.matches("Приложение");
        Assertions.assertTrue(actual);
    }
}
