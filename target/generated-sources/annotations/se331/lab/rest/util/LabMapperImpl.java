package se331.lab.rest.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.EventDTO;
import se331.lab.rest.entity.EventOrganizerDTO;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.OrganizerDTO;
import se331.lab.rest.entity.OrganizerOwnEventsDTO;
import se331.lab.rest.entity.Participant;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-06T11:50:52+0700",
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

    @Override
    public OrganizerDTO getOrganizerDTO(Organizer organizer) {
        if ( organizer == null ) {
            return null;
        }

        OrganizerDTO.OrganizerDTOBuilder organizerDTO = OrganizerDTO.builder();

        organizerDTO.id( organizer.getId() );
        organizerDTO.name( organizer.getName() );
        organizerDTO.ownEvents( eventListToOrganizerOwnEventsDTOList( organizer.getOwnEvents() ) );

        return organizerDTO.build();
    }

    @Override
    public List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers) {
        if ( organizers == null ) {
            return null;
        }

        List<OrganizerDTO> list = new ArrayList<OrganizerDTO>( organizers.size() );
        for ( Organizer organizer : organizers ) {
            list.add( getOrganizerDTO( organizer ) );
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

    protected OrganizerOwnEventsDTO eventToOrganizerOwnEventsDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        OrganizerOwnEventsDTO.OrganizerOwnEventsDTOBuilder organizerOwnEventsDTO = OrganizerOwnEventsDTO.builder();

        organizerOwnEventsDTO.category( event.getCategory() );
        organizerOwnEventsDTO.date( event.getDate() );
        organizerOwnEventsDTO.description( event.getDescription() );
        organizerOwnEventsDTO.id( event.getId() );
        organizerOwnEventsDTO.location( event.getLocation() );
        List<Participant> list = event.getParticipants();
        if ( list != null ) {
            organizerOwnEventsDTO.participants( new ArrayList<Participant>( list ) );
        }
        organizerOwnEventsDTO.petAllowed( event.getPetAllowed() );
        organizerOwnEventsDTO.time( event.getTime() );
        organizerOwnEventsDTO.title( event.getTitle() );

        return organizerOwnEventsDTO.build();
    }

    protected List<OrganizerOwnEventsDTO> eventListToOrganizerOwnEventsDTOList(List<Event> list) {
        if ( list == null ) {
            return null;
        }

        List<OrganizerOwnEventsDTO> list1 = new ArrayList<OrganizerOwnEventsDTO>( list.size() );
        for ( Event event : list ) {
            list1.add( eventToOrganizerOwnEventsDTO( event ) );
        }

        return list1;
    }
}
