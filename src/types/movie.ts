export interface MovieInfo {
  name: string
  year: string
  session?: string
  eps?: string
  sessionYear?: string
  tempStreamLink?: string
  extension?: string
  fileSizeString?: string
  subtileLink?: string
  fileName?: string
  epsCount?: number
  tmdbID: number
  imdbIDStr?: string
  tvdbID?: number
  traktID?: number
  cinemaID?: number
  genres?: string[]
}

export interface MovieEntity {
  id: number
  tmdbID: number
  imdbIDStr?: string
  traktID?: number
  tvdbID?: number
  title: string
  overview?: string
  poster_path?: string
  backdrop_path?: string
  release_date?: string
  first_air_date?: string
  vote_average?: number
  vote_count?: number
  popularity?: number
  genre_ids?: number[]
  original_language?: string
  original_title?: string
  original_name?: string
  adult?: boolean
  video?: boolean
  TV?: boolean
  media_type?: 'movie' | 'tv' | 'person'
  
  // Watch tracking
  position?: number
  duration?: number
  watched_at?: string
  collected_at?: string
  favorited?: boolean
}

export interface TMDBMovieResponse {
  page: number
  results: MovieEntity[]
  total_pages: number
  total_results: number
}

export interface TMDBMovieDetails extends MovieEntity {
  budget?: number
  revenue?: number
  runtime?: number
  status?: string
  tagline?: string
  homepage?: string
  belongs_to_collection?: {
    id: number
    name: string
    poster_path?: string
    backdrop_path?: string
  }
  production_companies?: {
    id: number
    name: string
    logo_path?: string
    origin_country: string
  }[]
  production_countries?: {
    iso_3166_1: string
    name: string
  }[]
  spoken_languages?: {
    iso_639_1: string
    name: string
  }[]
  external_ids?: {
    imdb_id?: string
    facebook_id?: string
    instagram_id?: string
    twitter_id?: string
  }
  videos?: {
    results: {
      id: string
      key: string
      name: string
      site: string
      type: string
      official: boolean
    }[]
  }
  credits?: {
    cast: {
      id: number
      name: string
      character: string
      profile_path?: string
    }[]
    crew: {
      id: number
      name: string
      job: string
      department: string
      profile_path?: string
    }[]
  }
}

export interface TVShowDetails extends MovieEntity {
  number_of_episodes?: number
  number_of_seasons?: number
  episode_run_time?: number[]
  in_production?: boolean
  last_air_date?: string
  networks?: {
    id: number
    name: string
    logo_path?: string
    origin_country: string
  }[]
  seasons?: {
    id: number
    season_number: number
    episode_count: number
    name: string
    overview?: string
    poster_path?: string
    air_date?: string
  }[]
  created_by?: {
    id: number
    name: string
    profile_path?: string
  }[]
  last_episode_to_air?: {
    id: number
    name: string
    overview?: string
    episode_number: number
    season_number: number
    air_date?: string
    still_path?: string
  }
  next_episode_to_air?: {
    id: number
    name: string
    overview?: string
    episode_number: number
    season_number: number
    air_date?: string
    still_path?: string
  }
}

export interface Episode {
  id: number
  episode_number: number
  season_number: number
  name: string
  overview?: string
  air_date?: string
  still_path?: string
  vote_average?: number
  vote_count?: number
  runtime?: number
  crew?: {
    id: number
    name: string
    job: string
    department: string
    profile_path?: string
  }[]
  guest_stars?: {
    id: number
    name: string
    character: string
    profile_path?: string
  }[]
}

export interface Season {
  id: number
  season_number: number
  episode_count: number
  name: string
  overview?: string
  poster_path?: string
  air_date?: string
  episodes?: Episode[]
}

export interface SearchResult {
  page: number
  results: MovieEntity[]
  total_pages: number
  total_results: number
}

export interface Genre {
  id: number
  name: string
}

export interface MediaSource {
  id: string
  quality: string
  size?: string
  url: string
  source: string
  isHLS?: boolean
  isNeedToSync?: boolean
  isCachedLink?: boolean
  originalLink?: string
  playHeader?: any
  provider?: string
  torrent?: boolean
}

export interface StreamingLinks {
  sources: MediaSource[]
  subtitles?: {
    url: string
    lang: string
    label: string
  }[]
}
