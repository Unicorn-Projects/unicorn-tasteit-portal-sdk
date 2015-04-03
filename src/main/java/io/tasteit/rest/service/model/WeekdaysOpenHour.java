package io.tasteit.rest.service.model;

import java.util.List;

public class WeekdaysOpenHour {

    private List<Integer> weekdays;
    private String startTime;
    private String endTime;
    
    public List<Integer> getWeekdays() {
        return weekdays;
    }
    public void setWeekdays(List<Integer> weekdays) {
        this.weekdays = weekdays;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result
                + ((startTime == null) ? 0 : startTime.hashCode());
        result = prime * result
                + ((weekdays == null) ? 0 : weekdays.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WeekdaysOpenHour other = (WeekdaysOpenHour) obj;
        if (endTime == null) {
            if (other.endTime != null)
                return false;
        } else if (!endTime.equals(other.endTime))
            return false;
        if (startTime == null) {
            if (other.startTime != null)
                return false;
        } else if (!startTime.equals(other.startTime))
            return false;
        if (weekdays == null) {
            if (other.weekdays != null)
                return false;
        } else if (!weekdays.equals(other.weekdays))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "WeekdayOpenHours [weekdays=" + weekdays + ", startTime="
                + startTime + ", endTime=" + endTime + "]";
    }
}
