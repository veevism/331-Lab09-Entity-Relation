import axios from 'axios'
import type { AxiosInstance, AxiosResponse } from 'axios'
import type { EventOrganizer } from '@/type'

const apiClient: AxiosInstance = axios.create({
  baseURL: "http://localhost:8080",
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  }
})

export default {
  getOrganizers(): Promise<AxiosResponse<EventOrganizer[]>> {
    return apiClient.get<EventOrganizer[]>(`/organizers`)
  }
}