package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MailFollowUp {

  LocalDateTime followUpZeitpunkt (LocalDateTime now, String email){
    ToDo toDo = new ToDo(email);
    now = now.plusMonths(toDo.getMonths());
    now = now.plusWeeks(toDo.getWeeks());
    now = now.plusDays(toDo.getDays());
    now = now.plusHours(toDo.getHours());

    return now;
  }



}
