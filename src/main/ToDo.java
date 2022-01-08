package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToDo {

  private long months;
  private long weeks;
  private long days;
  private long hours;

  public ToDo(String followUpEmail) {
    translate(followUpEmail);
  }

  public long getMonths() {
    return months;
  }

  public long getWeeks() {
    return weeks;
  }

  public long getDays() {
    return days;
  }

  public long getHours() {
    return hours;
  }

  private void translate(String followUpEmail) {

    transcribe(followUpEmail, "day");

  }

  private void transcribe(String followUpEmail, String type) {
    String premium = "((?<minutes>\\d+(?=minute)s?)|(?<hours>\\d+(?=hour)s?)|(?<days>\\d+(?=day)s?)|(?<weeks>\\d+(?=week)s?)|(?<months>\\d+(?=month)s?))";

    Pattern pattern = Pattern.compile(premium);
    Matcher matcher = pattern.matcher(followUpEmail);

    while(matcher.find()){
      if(matcher.group("days") != null)
        this.days = Long.parseLong(matcher.group("days"));
      if(matcher.group("hours") != null)
        this.hours = Long.parseLong(matcher.group("hours"));
      if(matcher.group("weeks") != null)
        this.weeks = Long.parseLong(matcher.group("weeks"));
      if(matcher.group("months") != null)
        this.months = Long.parseLong(matcher.group("months"));

    }
  }
}
