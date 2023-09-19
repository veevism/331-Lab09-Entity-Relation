package se331.lab.rest.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import se331.lab.rest.entity.Event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import se331.lab.rest.entity.Event;

@Repository
@Profile("manual")
public class EventDaoImpl implements EventDao {
        List<Event> eventList;

        @PostConstruct
        public void init() {
                eventList = new ArrayList<>();
                eventList.add(Event.builder()
                                .id(123L)
                                .category("animal welfare")
                                .title("Cat Adoption Day")
                                .description("Find your new feline friend at this event.")
                                .location("Meow Town")
                                .date("January 28, 2022")
                                .time("12:00")
                                .petAllowed(true)
                                .organizer("Kat Laydee")
                                .build());

                eventList.add(Event.builder()
                                .id(456L)
                                .category("food")
                                .title("Community Gardening")
                                .description("Join us as we tend to the community edible plants.")
                                .location("Flora City")
                                .date("March 14, 2022")
                                .time("10:00")
                                .petAllowed(true)
                                .organizer("Fern Pollin")
                                .build());

                eventList.add(Event.builder()
                                .id(789L)
                                .category("music")
                                .title("Summer Music Festival")
                                .description("Enjoy a day of live music performances under the sun.")
                                .location("Sunshine Park")
                                .date("July 30, 2022")
                                .time("14:00")
                                .petAllowed(false)
                                .organizer("Melody Maestro")
                                .build());

                eventList.add(Event.builder()
                                .id(1011L)
                                .category("sports")
                                .title("Basketball Tournament")
                                .description("Cheer for your favorite teams in this exciting basketball tournament.")
                                .location("Sports Arena")
                                .date("April 18, 2022")
                                .time("09:30")
                                .petAllowed(false)
                                .organizer("Hoops League")
                                .build());

                eventList.add(Event.builder()
                                .id(1314L)
                                .category("art")
                                .title("Art Exhibition")
                                .description("Explore the world of art through various exhibitions.")
                                .location("Art Gallery")
                                .date("May 25, 2022")
                                .time("11:00")
                                .petAllowed(true)
                                .organizer("Artistic Expressions")
                                .build());

                eventList.add(Event.builder()
                                .id(1516L)
                                .category("technology")
                                .title("Tech Conference")
                                .description("Stay updated with the latest technology trends and innovations.")
                                .location("Tech Center")
                                .date("September 10, 2022")
                                .time("13:30")
                                .petAllowed(false)
                                .organizer("TechConnect")
                                .build());
        }

        @Override
        public Integer getEventSize() {
                return eventList.size();
        }

        @Override
        public Page<Event> getEvents(Integer pageSize, Integer page) {
                pageSize = pageSize == null ? eventList.size() : pageSize;
                page = page == null ? 1 : page;
                int firstIndex = (page - 1) * pageSize;
                return new PageImpl<Event>(eventList.subList(firstIndex, firstIndex + pageSize),
                                PageRequest.of(page, pageSize), eventList.size());
        }

        @Override
        public Event getEvent(Long id) {
                return eventList.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);
        }

        @Override
        public Event save(Event event) {
                event.setId(eventList.get(eventList.size() - 1).getId() + 1);
                eventList.add(event);
                return event;
        }
}