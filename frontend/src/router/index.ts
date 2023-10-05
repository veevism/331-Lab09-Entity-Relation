import { createRouter, createWebHistory } from 'vue-router'
import EventListView from '../views/EventListView.vue'
import AboutView from '../views/AboutView.vue'
import EventOrganizerView from '../views/EventOrganizerView.vue'
import StudentListView from "../views/StudentListView.vue"
import EventDetailView from "../views/event/EventDetailView.vue"
import EventEditView from "../views/event/EventEditView.vue"
import EventRegisterView from "../views/event/EventRegisterView.vue"
import EventLayoutView from "../views/event/EventLayoutView.vue"
import NotFoundView from "../views/NotFoundView.vue"
import NetworkErrorView from '../views/NetworkErrorView.vue'
import NProgress from 'nprogress'
import EventService from '@/services/EventService'
import { useEventStore } from '@/stores/event'
import EventFormView from '../views/event/EventFormView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'event-list',
      component: EventListView,
      props : (route) => ({page: parseInt(route.query?.page as string || '1'),limit: parseInt(route.query?.limit as string || '2')})
    },
    {
      path: '/about',
      name: 'about',
      component: AboutView
    },
    {
      path: '/organizer',
      name: 'organizer',
      component: EventOrganizerView
    },
    {
      path: '/student',
      name: 'student',
      component: StudentListView
    },
    {
      path: '/add-event',
      name: 'add-event',
      component : EventFormView
    },
    {
      path : '/event/:id',
      name : 'event-layout',
      component : EventLayoutView,
      props: (route) => ({ id: route.params.id }),
      beforeEnter: (to) => {
        const id: number = parseInt(to.params.id as string)
        const eventStore = useEventStore()
        return EventService.getEventById(id)
        .then((response) => {
          console.log(response.data)
          eventStore.setEvent(response.data)
        }).catch((error) => {
          console.log(error.response, error.response.status, error.response && error.response.status === 404)
          if (error.response && error.response.status === 404) {
            return {
              name : '404-resource'
              ,params: { resource : 'event'}
            }
          } else {
            return { name : 'network-error'}
          }
        })
      },
      children : [
        {
          path: '',
          name: 'event-detail',
          component: EventDetailView,
        },
        {
          path: 'edit',
          name: 'event-edit',
          component: EventEditView,
        },
        {
          path: 'register',
          name: 'event-register',
          component: EventRegisterView,
        }
      ]
    },
    {
      path : '/:catchAll(.*)'
    , name : 'not-found'
    ,component : NotFoundView
    },
    {
      path: '/404/:resource',
      name: '404-resource',
      component: NotFoundView,
      props: true
    },
    {
      path : '/network-error',
      name : 'network-error',
      component : NetworkErrorView
    }

  ],
  scrollBehavior(to, from, savedPosition) {
    console.log(savedPosition)
    if (savedPosition) {
      return savedPosition
    } else {
      return { top : 0}
    }
  }
})

router.beforeEach(() => {
NProgress.start()
})

router.afterEach(() => {
  NProgress.done()
})

export default router
