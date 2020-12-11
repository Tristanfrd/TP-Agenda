package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    private ChronoUnit frequency;
    private ArrayList<LocalDate>exceptions = new ArrayList<>();
    
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        exceptions.add(date);
        /*if (this.frequency == ChronoUnit.DAYS){
        long j = ChronoUnit.DAYS.between(this.getStart().toLocalDate(), this.getStart().toLocalDate().plusDays(this.getDuration().toDays()));
        for(long i=0;i<j;i++){
            if (this.getStart().plusDays(i).toLocalDate() == date){
                throw new IllegalArgumentException("La date ne convient pas à un événement.");
            }}
    }
        else if (this.frequency == ChronoUnit.WEEKS){
        long j = ChronoUnit.WEEKS.between(this.getStart().toLocalDate(), this.getStart().toLocalDate().plusWeeks(this.getDuration().toDays()));
        for(long i=0;i<j;i++){
            if (this.getStart().plusWeeks(i).toLocalDate() == date){
                throw new IllegalArgumentException("La date ne convient pas à un événement.");
        }}
    }   else if (this.frequency == ChronoUnit.MONTHS){
        long j = ChronoUnit.MONTHS.between(this.getStart().toLocalDate(), this.getStart().toLocalDate().plusMonths(this.getDuration().toDays()));
        for(long i=0;i<j;i++){
            if (this.getStart().plusMonths(i).toLocalDate() == date){
                throw new IllegalArgumentException("La date ne convient pas à un événement.");
        }}
    }*/
        
    }
    
    public boolean isInDay(LocalDate aDay){
        boolean inDay = false;
        if (this.frequency == ChronoUnit.DAYS){
            if (aDay.isEqual(this.getStart().toLocalDate()) || aDay.isAfter(this.getStart().toLocalDate())){
                inDay=true;
            }}
        if (this.frequency == ChronoUnit.WEEKS){
            if (aDay.isEqual(this.getStart().toLocalDate()) || aDay.getDayOfWeek() == this.getStart().getDayOfWeek()){
                inDay=true;
        }}
        if (this.frequency == ChronoUnit.MONTHS){
            if (aDay.isEqual(this.getStart().toLocalDate()) || aDay.getDayOfMonth() == this.getStart().getDayOfMonth()){
                inDay = true;
                }}
        for (int i = 0; i< exceptions.size();i++){
            if (aDay.equals(exceptions.get(i))){
                inDay = false;
            }}
        return inDay; 
    }
    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;    
    }

}
