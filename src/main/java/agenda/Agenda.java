package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    private ArrayList <Event> evenements = new ArrayList<>();
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        evenements.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day to test
     * @return and iterator to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> evenementsDuJour = new ArrayList<>();
        for(Event e:evenements){
            if (day.isAfter(e.getStart().toLocalDate().minusDays(1)) && day.isBefore(e.getStart().toLocalDate().plusDays(e.getDuration().toDays()).plusDays(1))){
                evenementsDuJour.add(e);
            }
        }
        return evenementsDuJour;
    }
}
