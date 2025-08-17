export enum CategoryType {
  Movie = 'Movie',
  Show = 'Show',
  MIX = 'MIX'
}

export enum CategorySource {
  TMDB = 'TMDB',
  TRAKT = 'TRAKT'
}

export enum CategoryGeneric {
  Popular = 'popular',
  TopRated = 'top_rated',
  Latest = 'latest',
  Upcoming = 'upcoming',
  NowPlaying = 'now_playing',
  OnTheAir = 'on_the_air',
  AiringToday = 'airing_today'
}

export interface CategoryEntity {
  id: string | number
  name: string
  type: CategoryType
  source: CategorySource
  sourceType: 'Generic' | 'Genre' | 'Search' | 'List'
  restricted?: boolean
  genreId?: number
  query?: string
}

export interface Genre {
  id: number
  name: string
}

export const NAVIGATION_ITEMS = {
  NAV_MOVIE: { id: 1, label: 'Movies' },
  NAV_TV_SHOW: { id: 2, label: 'TV Shows' },
  NAV_LISTS: { id: 3, label: 'Lists' },
  NAV_MY_LIST: { id: 4, label: 'My List' },
  NAV_FAVORITE: { id: 5, label: 'Favorites' },
  NAV_HISTORY: { id: 6, label: 'History' },
  NAV_CALENDAR: { id: 7, label: 'Calendar' },
  NAV_TORRENT_MANAGER: { id: 8, label: 'Downloads' },
  NAV_SETTING: { id: 9, label: 'Settings' },
  NAV_SHARE: { id: 10, label: 'Share' },
  NAV_RATE: { id: 11, label: 'Rate App' },
  NAV_DOWNLOAD: { id: 12, label: 'Downloads' }
} as const

export type NavigationId = keyof typeof NAVIGATION_ITEMS
