import { create } from 'zustand'
import { persist } from 'zustand/middleware'
import { CategoryEntity, CategoryType, CategorySource } from '@/types/category'
import { MovieEntity, TMDBMovieDetails, TVShowDetails } from '@/types/movie'

interface MovieState {
  // Current category
  currentCategory: CategoryEntity | null
  setCurrentCategory: (category: CategoryEntity) => void
  
  // Movies data
  movies: MovieEntity[]
  isLoading: boolean
  error: string | null
  page: number
  totalPages: number
  hasMore: boolean
  
  // Movie details
  currentMovie: TMDBMovieDetails | TVShowDetails | null
  
  // Favorites
  favorites: MovieEntity[]
  
  // Watch history
  watchHistory: MovieEntity[]
  
  // My lists
  myLists: {
    id: string
    name: string
    movies: MovieEntity[]
    createdAt: string
  }[]
  
  // Search
  searchQuery: string
  searchResults: MovieEntity[]
  searchLoading: boolean
  
  // Actions
  setMovies: (movies: MovieEntity[], reset?: boolean) => void
  addMovies: (movies: MovieEntity[]) => void
  setLoading: (loading: boolean) => void
  setError: (error: string | null) => void
  setPage: (page: number) => void
  setTotalPages: (totalPages: number) => void
  setHasMore: (hasMore: boolean) => void
  setCurrentMovie: (movie: TMDBMovieDetails | TVShowDetails | null) => void
  
  // Favorites
  addToFavorites: (movie: MovieEntity) => void
  removeFromFavorites: (movieId: number) => void
  isFavorite: (movieId: number) => boolean
  
  // Watch history
  addToHistory: (movie: MovieEntity) => void
  removeFromHistory: (movieId: number) => void
  clearHistory: () => void
  
  // My lists
  createList: (name: string) => void
  deleteList: (listId: string) => void
  addToList: (listId: string, movie: MovieEntity) => void
  removeFromList: (listId: string, movieId: number) => void
  
  // Search
  setSearchQuery: (query: string) => void
  setSearchResults: (results: MovieEntity[]) => void
  setSearchLoading: (loading: boolean) => void
  clearSearch: () => void
  
  // Reset
  reset: () => void
}

const initialState = {
  currentCategory: null,
  movies: [],
  isLoading: false,
  error: null,
  page: 1,
  totalPages: 1,
  hasMore: true,
  currentMovie: null,
  favorites: [],
  watchHistory: [],
  myLists: [],
  searchQuery: '',
  searchResults: [],
  searchLoading: false,
}

export const useMovieStore = create<MovieState>()(
  persist(
    (set, get) => ({
      ...initialState,
      
      setCurrentCategory: (category) => set({ currentCategory: category }),
      
      setMovies: (movies, reset = true) => 
        set({ 
          movies: reset ? movies : [...get().movies, ...movies],
          isLoading: false,
          error: null
        }),
        
      addMovies: (movies) => 
        set(state => ({ 
          movies: [...state.movies, ...movies],
          isLoading: false 
        })),
        
      setLoading: (loading) => set({ isLoading: loading }),
      setError: (error) => set({ error, isLoading: false }),
      setPage: (page) => set({ page }),
      setTotalPages: (totalPages) => set({ totalPages }),
      setHasMore: (hasMore) => set({ hasMore }),
      setCurrentMovie: (movie) => set({ currentMovie: movie }),
      
      // Favorites
      addToFavorites: (movie) => 
        set(state => ({
          favorites: state.favorites.find(m => m.id === movie.id) 
            ? state.favorites
            : [...state.favorites, { ...movie, favorited: true }]
        })),
        
      removeFromFavorites: (movieId) =>
        set(state => ({
          favorites: state.favorites.filter(m => m.id !== movieId)
        })),
        
      isFavorite: (movieId) => 
        get().favorites.some(m => m.id === movieId),
        
      // Watch history
      addToHistory: (movie) =>
        set(state => {
          const filtered = state.watchHistory.filter(m => m.id !== movie.id)
          return {
            watchHistory: [
              { ...movie, watched_at: new Date().toISOString() },
              ...filtered
            ].slice(0, 100) // Keep only last 100 items
          }
        }),
        
      removeFromHistory: (movieId) =>
        set(state => ({
          watchHistory: state.watchHistory.filter(m => m.id !== movieId)
        })),
        
      clearHistory: () => set({ watchHistory: [] }),
      
      // My lists
      createList: (name) =>
        set(state => ({
          myLists: [
            ...state.myLists,
            {
              id: Date.now().toString(),
              name,
              movies: [],
              createdAt: new Date().toISOString()
            }
          ]
        })),
        
      deleteList: (listId) =>
        set(state => ({
          myLists: state.myLists.filter(list => list.id !== listId)
        })),
        
      addToList: (listId, movie) =>
        set(state => ({
          myLists: state.myLists.map(list =>
            list.id === listId && !list.movies.find(m => m.id === movie.id)
              ? { ...list, movies: [...list.movies, movie] }
              : list
          )
        })),
        
      removeFromList: (listId, movieId) =>
        set(state => ({
          myLists: state.myLists.map(list =>
            list.id === listId
              ? { ...list, movies: list.movies.filter(m => m.id !== movieId) }
              : list
          )
        })),
      
      // Search
      setSearchQuery: (query) => set({ searchQuery: query }),
      setSearchResults: (results) => set({ searchResults: results }),
      setSearchLoading: (loading) => set({ searchLoading: loading }),
      clearSearch: () => set({ 
        searchQuery: '', 
        searchResults: [], 
        searchLoading: false 
      }),
      
      reset: () => set(initialState),
    }),
    {
      name: 'movie-store',
      partialize: (state) => ({
        favorites: state.favorites,
        watchHistory: state.watchHistory,
        myLists: state.myLists,
        currentCategory: state.currentCategory,
      }),
    }
  )
)
