package se331.lab.rest.entity;

import java.util.List;

public class Participant {
    Long id;
    String name;
    String telNo;
    List<Event> eventHistory;
}