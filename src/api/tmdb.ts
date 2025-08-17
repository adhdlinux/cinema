import axios from 'axios'
import { 
  MovieEntity, 
  TMDBMovieResponse, 
  TMDBMovieDetails, 
  TVShowDetails,
  SearchResult,
  Genre,
  Season 
} from '@/types/movie'
import { CategoryEntity, CategoryType, CategorySource } from '@/types/category'

const TMDB_BASE_URL = 'https://api.themoviedb.org/3'
const TMDB_IMAGE_BASE = 'https://image.tmdb.org/t/p'

// Read API key from api.txt file
let TMDB_API_KEY = ''
let apiKeyInitialized = false

// Initialize API key
async function initializeApiKey() {
  if (apiKeyInitialized) return TMDB_API_KEY

  try {
    // Try API route first
    const response = await fetch('/api/tmdb-key')
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`)
    }
    const data = await response.json()
    if (data.apiKey) {
      TMDB_API_KEY = data.apiKey.trim()
      apiKeyInitialized = true
      console.log('TMDB API key loaded successfully via API route')
      return TMDB_API_KEY
    }
    throw new Error('No API key in response')
  } catch (error) {
    console.error('Failed to load TMDB API key via API route:', error)

    // Fallback to direct file access
    try {
      const response = await fetch('/api.txt')
      if (response.ok) {
        const apiKey = await response.text()
        TMDB_API_KEY = apiKey.trim()
        apiKeyInitialized = true
        console.log('TMDB API key loaded successfully from public file')
        return TMDB_API_KEY
      }
    } catch (fileError) {
      console.error('Failed to load from public file:', fileError)
    }

    // Final fallback to environment variable
    TMDB_API_KEY = process.env.NEXT_PUBLIC_TMDB_API_KEY || ''
    if (TMDB_API_KEY) {
      apiKeyInitialized = true
      console.log('Using TMDB API key from environment variable')
      return TMDB_API_KEY
    }

    throw new Error('No TMDB API key found. Please check api.txt file or environment variables.')
  }
}

const tmdbApi = axios.create({
  baseURL: TMDB_BASE_URL,
  timeout: 10000, // 10 seconds timeout
})

// Request interceptor to ensure API key is set
tmdbApi.interceptors.request.use(async (config) => {
  try {
    const apiKey = await initializeApiKey()
    config.params = { ...config.params, api_key: apiKey }
    return config
  } catch (error) {
    console.error('Failed to initialize API key:', error)
    throw error
  }
})

// Response interceptor for better error handling
tmdbApi.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401) {
      console.error('TMDB API authentication failed. Please check your API key.')
    } else if (error.response?.status === 404) {
      console.error('TMDB API endpoint not found.')
    } else if (error.code === 'NETWORK_ERROR' || !error.response) {
      console.error('Network error occurred. Please check your connection.')
    }
    return Promise.reject(error)
  }
)

export const tmdbService = {
  // Configuration
  async getConfiguration() {
    const response = await tmdbApi.get('/configuration')
    return response.data
  },

  // Discover movies
  async discoverMovies(params: {
    sort_by?: string
    page?: number
    with_genres?: string
    primary_release_year?: number
    vote_average_gte?: number
    vote_count_gte?: number
  } = {}) {
    const response = await tmdbApi.get<TMDBMovieResponse>('/discover/movie', {
      params: {
        sort_by: 'popularity.desc',
        page: 1,
        ...params,
      },
    })
    return response.data
  },

  // Discover TV shows
  async discoverTVShows(params: {
    sort_by?: string
    page?: number
    with_genres?: string
    first_air_date_year?: number
    vote_average_gte?: number
    vote_count_gte?: number
  } = {}) {
    const response = await tmdbApi.get<TMDBMovieResponse>('/discover/tv', {
      params: {
        sort_by: 'popularity.desc',
        page: 1,
        ...params,
      },
    })
    return response.data
  },

  // Get popular movies
  async getPopularMovies(page = 1) {
    const response = await tmdbApi.get<TMDBMovieResponse>('/movie/popular', {
      params: { page },
    })
    return response.data
  },

  // Get popular TV shows
  async getPopularTVShows(page = 1) {
    const response = await tmdbApi.get<TMDBMovieResponse>('/tv/popular', {
      params: { page },
    })
    return response.data
  },

  // Get top rated movies
  async getTopRatedMovies(page = 1) {
    const response = await tmdbApi.get<TMDBMovieResponse>('/movie/top_rated', {
      params: { page },
    })
    return response.data
  },

  // Get top rated TV shows
  async getTopRatedTVShows(page = 1) {
    const response = await tmdbApi.get<TMDBMovieResponse>('/tv/top_rated', {
      params: { page },
    })
    return response.data
  },

  // Get now playing movies
  async getNowPlayingMovies(page = 1) {
    const response = await tmdbApi.get<TMDBMovieResponse>('/movie/now_playing', {
      params: { page },
    })
    return response.data
  },

  // Get upcoming movies
  async getUpcomingMovies(page = 1) {
    const response = await tmdbApi.get<TMDBMovieResponse>('/movie/upcoming', {
      params: { page },
    })
    return response.data
  },

  // Get on the air TV shows
  async getOnTheAirTVShows(page = 1) {
    const response = await tmdbApi.get<TMDBMovieResponse>('/tv/on_the_air', {
      params: { page },
    })
    return response.data
  },

  // Get airing today TV shows
  async getAiringTodayTVShows(page = 1) {
    const response = await tmdbApi.get<TMDBMovieResponse>('/tv/airing_today', {
      params: { page },
    })
    return response.data
  },

  // Search multi
  async searchMulti(query: string, page = 1) {
    const response = await tmdbApi.get<SearchResult>('/search/multi', {
      params: { query, page },
    })
    return response.data
  },

  // Search movies
  async searchMovies(query: string, page = 1) {
    const response = await tmdbApi.get<SearchResult>('/search/movie', {
      params: { query, page },
    })
    return response.data
  },

  // Search TV shows
  async searchTVShows(query: string, page = 1) {
    const response = await tmdbApi.get<SearchResult>('/search/tv', {
      params: { query, page },
    })
    return response.data
  },

  // Get movie details
  async getMovieDetails(movieId: number) {
    const response = await tmdbApi.get<TMDBMovieDetails>(`/movie/${movieId}`, {
      params: {
        append_to_response: 'credits,videos,external_ids,recommendations,similar',
      },
    })
    return response.data
  },

  // Get TV show details
  async getTVShowDetails(tvId: number) {
    const response = await tmdbApi.get<TVShowDetails>(`/tv/${tvId}`, {
      params: {
        append_to_response: 'credits,videos,external_ids,recommendations,similar',
      },
    })
    return response.data
  },

  // Get season details
  async getSeasonDetails(tvId: number, seasonNumber: number) {
    const response = await tmdbApi.get<Season>(`/tv/${tvId}/season/${seasonNumber}`)
    return response.data
  },

  // Get external IDs
  async getMovieExternalIds(movieId: number) {
    const response = await tmdbApi.get(`/movie/${movieId}/external_ids`)
    return response.data
  },

  async getTVExternalIds(tvId: number) {
    const response = await tmdbApi.get(`/tv/${tvId}/external_ids`)
    return response.data
  },

  // Find by external ID (IMDB)
  async findByImdbId(imdbId: string) {
    const response = await tmdbApi.get(`/find/${imdbId}`, {
      params: { external_source: 'imdb_id' },
    })
    return response.data
  },

  // Get genres
  async getMovieGenres() {
    const response = await tmdbApi.get<{ genres: Genre[] }>('/genre/movie/list')
    return response.data.genres
  },

  async getTVGenres() {
    const response = await tmdbApi.get<{ genres: Genre[] }>('/genre/tv/list')
    return response.data.genres
  },

  // Get trending
  async getTrending(mediaType: 'movie' | 'tv' | 'all' = 'all', timeWindow: 'day' | 'week' = 'week', page = 1) {
    const response = await tmdbApi.get<TMDBMovieResponse>(`/trending/${mediaType}/${timeWindow}`, {
      params: { page },
    })
    return response.data
  },

  // Get lists by category
  async getMoviesByCategory(category: CategoryEntity, page = 1) {
    const isTV = category.type === CategoryType.Show
    const endpoint = isTV ? '/tv' : '/movie'

    switch (category.id) {
      case 'popular':
        return isTV ? this.getPopularTVShows(page) : this.getPopularMovies(page)
      case 'top_rated':
        return isTV ? this.getTopRatedTVShows(page) : this.getTopRatedMovies(page)
      case 'now_playing':
        return this.getNowPlayingMovies(page)
      case 'upcoming':
        return this.getUpcomingMovies(page)
      case 'on_the_air':
        return this.getOnTheAirTVShows(page)
      case 'airing_today':
        return this.getAiringTodayTVShows(page)
      case 'trending':
        return this.getTrending(isTV ? 'tv' : 'movie', 'week', page)
      default:
        if (category.sourceType === 'Genre' && category.genreId) {
          const params = {
            with_genres: category.genreId.toString(),
            page,
          }
          return isTV ? this.discoverTVShows(params) : this.discoverMovies(params)
        }
        if (category.sourceType === 'Search' && category.query) {
          return this.searchMulti(category.query, page)
        }
        return isTV ? this.getPopularTVShows(page) : this.getPopularMovies(page)
    }
  },

  // Image helpers
  getImageUrl(path: string, size: string = 'w500') {
    if (!path) return '/placeholder-poster.jpg'
    return `${TMDB_IMAGE_BASE}/${size}${path}`
  },

  getPosterUrl(path: string, size: 'w92' | 'w154' | 'w185' | 'w342' | 'w500' | 'w780' | 'original' = 'w500') {
    return this.getImageUrl(path, size)
  },

  getBackdropUrl(path: string, size: 'w300' | 'w780' | 'w1280' | 'original' = 'w1280') {
    return this.getImageUrl(path, size)
  },

  getProfileUrl(path: string, size: 'w45' | 'w185' | 'h632' | 'original' = 'w185') {
    return this.getImageUrl(path, size)
  },

  // Test API connection
  async testConnection() {
    try {
      await this.getConfiguration()
      return { success: true, message: 'TMDB API connection successful' }
    } catch (error) {
      return { 
        success: false, 
        message: error instanceof Error ? error.message : 'Unknown error occurred' 
      }
    }
  },

  // Set API key manually if needed
  setApiKey(apiKey: string) {
    TMDB_API_KEY = apiKey
    apiKeyInitialized = true
  },

  // Get current API key status
  getApiKeyStatus() {
    return {
      hasApiKey: !!TMDB_API_KEY,
      initialized: apiKeyInitialized,
      keyLength: TMDB_API_KEY.length
    }
  }
}

export default tmdbService
