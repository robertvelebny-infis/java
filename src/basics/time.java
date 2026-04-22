package basics;

import java.time.LocalTime;

public class time {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime lessonStart = LocalTime.of(10,45);
        LocalTime nejakyNovy = LocalTime.from(lessonStart);
        LocalTime novyMinusDva = nejakyNovy.minusHours(2);

    }
}
