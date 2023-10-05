package se331.lab.rest.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.EventDTO;
import se331.lab.rest.entity.EventOrganizerDTO;
import se331.lab.rest.entity.Organizer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-05T11:04:02+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public EventDTO getEventDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDTO.EventDTOBuilder eventDTO = EventDTO.builder();

        eventDTO.category( event.getCategory() );
        eventDTO.date( event.getDate() );
        eventDTO.description( event.getDescription() );
        eventDTO.id( event.getId() );
        eventDTO.location( event.getLocation() );
        eventDTO.organizer( organizerToEventOrganizerDTO( event.getOrganizer() ) );
        eventDTO.petAllowed( event.getPetAllowed() );
        eventDTO.time( event.getTime() );
        eventDTO.title( event.getTitle() );

        return eventDTO.build();
    }

    @Override
    public List<EventDTO> getEventDto(List<Event> events) {
        if ( events == null ) {
            return null;
        }

        List<EventDTO> list = new ArrayList<EventDTO>( events.size() );
        for ( Event event : events ) {
            list.add( getEventDto( event ) );
        }

        return list;
    }

    protected EventOrganizerDTO organizerToEventOrganizerDTO(Organizer organizer) {
        if ( organizer == null ) {
            return null;
        }

        EventOrganizerDTO.EventOrganizerDTOBuilder eventOrganizerDTO = EventOrganizerDTO.builder();

        eventOrganizerDTO.id( organizer.getId() );
        eventOrganizerDTO.name( organizer.getName() );

        return eventOrganizerDTO.build();
    }
}
