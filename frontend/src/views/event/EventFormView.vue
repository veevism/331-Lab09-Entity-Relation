<script setup lang="ts">
import type { EventItem, EventOrganizer } from '@/type'
import { ref } from 'vue'
import EventService from '@/services/EventService';
import { useRouter } from 'vue-router'
import { useMessageStore } from '@/stores/message'
import BaseInput from '@/components/BaseInput.vue';
import OrganizerService from '@/services/OrganizerService';
import BaseSelect from '@/components/BaseSelect.vue';

const store = useMessageStore()

const router = useRouter()

const organizers = ref<EventOrganizer[]>([])
OrganizerService.getOrganizers()
    .then((response) => {
        organizers.value = response.data
    })
    .catch(() => {
        router.push({ name: 'network-error' })
    })


function saveEvent() {
    EventService.saveEvent(event.value)
        .then((response) => {
            console.log(response.data)
            router.push({
                name: 'event-detail',
                params: { id: response.data.id }
            })
            store.updateMessage('You have successfully added a new event for ' + response.data.title)
            setTimeout(() => {
                store.resetMessage()
            }, 3000)
        }).catch(() => {
            router.push({ name: 'network-error' })
        })
}

const event = ref<EventItem>({
    id: 0,
    category: '',
    title: '',
    description: '',
    location: '',
    date: '',
    time: '',
    organizer: { id: 0, name: '' }
    // organizer: EventOrganizer = {id: 0, name: ''}
})
</script>


<template>
    <div>
        <h1>Create an event</h1>
        <form @submit.prevent="saveEvent">
            <BaseInput v-model="event.category" type="text" label="Category" />

            <h3>Name & describe your event</h3>

            <BaseInput v-model="event.title" type="text" label="Title" />

            <BaseInput v-model="event.description" type="text" label="Description" />

            <h3>Where is your event?</h3>

            <BaseInput v-model="event.location" type="text" label="Location" />

            <h3>Who is your organizer?</h3>
            <label>Select an Organizer</label>
            <BaseSelect v-model="event.organizer.id" label="Organizer" :options="organizers" />
            <button type="submit">Submit</button>
        </form>

        <pre>{{ event }}</pre>
    </div>
</template>
  
<style scoped>
.events {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.pagination {
    display: flex;
    width: 290px;
}

.pagination a {
    flex: 1;
    text-decoration: none;
    color: #2c3e50;
}

#page-prev {
    text-align: left;
}

#page-next {
    text-align: right;
}
</style>