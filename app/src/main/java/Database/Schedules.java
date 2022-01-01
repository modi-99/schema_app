package Database;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "schedules")
public class Schedules {
    @ElementList(name = "schedule", inline = true)
    public List<Schedule> scheduleTable;
}
