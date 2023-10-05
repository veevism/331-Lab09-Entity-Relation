export interface EventItem {
    id : number
    category : string
    title : string
    description : string
    location : string
    date : string
    time : string
    organizer: EventOrganizer | string
}

export interface StudentItem {
    id : number
    studentId : string
    name : string
    surname : string
    gpa : number
    image : string
    penAmount : string
    description : string
}

export interface EventOrganizer {
    id: number;
    name: string;
  }