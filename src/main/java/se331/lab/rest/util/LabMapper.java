package se331.lab.rest.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.EventDTO;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    EventDTO getEventDto(Event event);

    List<EventDTO> getEventDto(List<Event> events);
}