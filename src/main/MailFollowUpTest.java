package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MailFollowUpTest {

  MailFollowUp mailFollowUp;
  ToDo toDo;

  @BeforeEach
  void setUp() {
    mailFollowUp = new MailFollowUp();
  }

@Test
  void followUpOnlyDays(){
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime actual = mailFollowUp.followUpZeitpunkt(now, "7days@followup.cc");
    LocalDateTime expected = now.plusDays(7);

    assertEquals(expected, actual, "7days@followup.cc konnte nicht korrekt übersetzt werden");

  }

  @Test
  void followUpOnlyHours(){
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime actual = mailFollowUp.followUpZeitpunkt(now, "12hours@followup.cc");
    LocalDateTime expected = now.plusHours(12);

    assertEquals(expected, actual, "12hours@followup.cc konnte nicht korrekt übersetzt werden");
  }

  @Test
  void followUpMonthsWeeksDaysAndHOurs(){
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime actual = mailFollowUp.followUpZeitpunkt(now, "2months3week5days16hours@followup.cc\n");
    LocalDateTime expected = now.plusMonths(2);
    expected = expected.plusWeeks(3);
    expected = expected.plusDays(5);
    expected = expected.plusHours(16);


    assertEquals(expected, actual, "2months3week5days16hours@followup.cc konnte nicht korrekt übersetzt werden");
  }

  @Test
  void translateDays(){
    String email = "7days@followup.cc";
    toDo = new ToDo(email);

    assertEquals(7L, toDo.getDays());
  }

  @Test
  void translateHours(){
    String email = "7hours@followup.cc";
    toDo = new ToDo(email);

    assertEquals(7L, toDo.getHours());
  }

  @Test
  void translateWeeks(){
    String email = "7weeks@followup.cc";
    toDo = new ToDo(email);

    assertEquals(7L, toDo.getWeeks());
  }

  @Test
  void translateMonths(){
    String email = "7months@followup.cc";
    toDo = new ToDo(email);

    assertEquals(7L, toDo.getMonths());
  }

  @Test
  void translateWeeksDaysAndHours(){
    String email = "1week3days5hours@followup.cc";
    toDo = new ToDo(email);

    assertEquals(1L, toDo.getWeeks());
    assertEquals(3L, toDo.getDays());
    assertEquals(5L, toDo.getHours());
  }






}