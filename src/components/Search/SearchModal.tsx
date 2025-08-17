'use client'

import { useState, useEffect, useRef } from 'react'
import { motion, AnimatePresence } from 'framer-motion'
import { MagnifyingGlassIcon, XMarkIcon } from '@heroicons/react/24/outline'
import { useQuery } from 'react-query'
import { useDebounce } from '@/hooks/useDebounce'
import tmdbService from '@/api/tmdb'
import { useMovieStore } from '@/stores/movieStore'
import MovieCard from '@/components/Movies/MovieCard'
import LoadingSpinner from '@/components/UI/LoadingSpinner'

interface SearchModalProps {
  isOpen: boolean
  onClose: () => void
}

export default function SearchModal({ isOpen, onClose }: SearchModalProps) {
  const [query, setQuery] = useState('')
  const debouncedQuery = useDebounce(query, 500)
  const inputRef = useRef<HTMLInputElement>(null)
  const { setSearchQuery, setSearchResults, searchResults } = useMovieStore()

  // Search query
  const { data, isLoading, isError } = useQuery(
    ['search', debouncedQuery],
    () => tmdbService.searchMulti(debouncedQuery),
    {
      enabled: debouncedQuery.length >= 2,
      staleTime: 5 * 60 * 1000,
    }
  )

  useEffect(() => {
    if (isOpen && inputRef.current) {
      inputRef.current.focus()
    }
  }, [isOpen])

  useEffect(() => {
    if (data?.results) {
      setSearchResults(data.results)
    }
  }, [data, setSearchResults])

  const handleClose = () => {
    setQuery('')
    setSearchQuery('')
    onClose()
  }

  const handleKeyDown = (e: React.KeyboardEvent) => {
    if (e.key === 'Escape') {
      handleClose()
    }
  }

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault()
    if (query.trim()) {
      setSearchQuery(query.trim())
      // Navigate to search results page
      window.location.href = `/search?q=${encodeURIComponent(query.trim())}`
      handleClose()
    }
  }

  const popularSuggestions = [
    'Marvel',
    'Breaking Bad',
    'The Office',
    'Game of Thrones',
    'Stranger Things',
    'Friends',
    'The Avengers',
    'The Dark Knight'
  ]

  const recentSearches = [
    // This would come from local storage or user preferences
    'Inception',
    'The Matrix',
    'Interstellar'
  ]

  return (
    <AnimatePresence>
      {isOpen && (
        <>
          {/* Backdrop */}
          <motion.div
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            exit={{ opacity: 0 }}
            className="fixed inset-0 bg-black/60 backdrop-blur-sm z-50"
            onClick={handleClose}
          />

          {/* Modal */}
          <motion.div
            initial={{ opacity: 0, scale: 0.95, y: -20 }}
            animate={{ opacity: 1, scale: 1, y: 0 }}
            exit={{ opacity: 0, scale: 0.95, y: -20 }}
            className="fixed inset-x-4 top-4 md:inset-x-auto md:left-1/2 md:transform md:-translate-x-1/2 md:w-full md:max-w-3xl bg-dark-200 rounded-lg shadow-xl z-50 max-h-[90vh] overflow-hidden"
          >
            {/* Header */}
            <div className="p-4 border-b border-dark-300">
              <form onSubmit={handleSubmit} className="flex items-center space-x-4">
                <div className="flex-1 relative">
                  <MagnifyingGlassIcon className="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-dark-500" />
                  <input
                    ref={inputRef}
                    type="text"
                    value={query}
                    onChange={(e) => setQuery(e.target.value)}
                    onKeyDown={handleKeyDown}
                    placeholder="Search movies, TV shows, people..."
                    className="w-full pl-10 pr-4 py-3 bg-dark-300 border border-dark-400 rounded-lg text-white placeholder-dark-500 focus:outline-none focus:ring-2 focus:ring-primary-500 focus:border-transparent"
                  />
                </div>
                <button
                  type="button"
                  onClick={handleClose}
                  className="p-2 rounded-lg hover:bg-dark-300 transition-colors duration-200"
                >
                  <XMarkIcon className="w-5 h-5 text-dark-500" />
                </button>
              </form>
            </div>

            {/* Content */}
            <div className="p-4 overflow-y-auto max-h-[calc(90vh-120px)] custom-scrollbar">
              {!query && (
                <div className="space-y-6">
                  {/* Recent Searches */}
                  {recentSearches.length > 0 && (
                    <div>
                      <h3 className="text-sm font-semibold text-dark-500 uppercase mb-3">
                        Recent Searches
                      </h3>
                      <div className="flex flex-wrap gap-2">
                        {recentSearches.map((search) => (
                          <button
                            key={search}
                            onClick={() => setQuery(search)}
                            className="px-3 py-1.5 bg-dark-300 hover:bg-dark-400 rounded-lg text-sm text-dark-600 hover:text-white transition-colors duration-200"
                          >
                            {search}
                          </button>
                        ))}
                      </div>
                    </div>
                  )}

                  {/* Popular Suggestions */}
                  <div>
                    <h3 className="text-sm font-semibold text-dark-500 uppercase mb-3">
                      Popular Searches
                    </h3>
                    <div className="flex flex-wrap gap-2">
                      {popularSuggestions.map((suggestion) => (
                        <button
                          key={suggestion}
                          onClick={() => setQuery(suggestion)}
                          className="px-3 py-1.5 bg-dark-300 hover:bg-dark-400 rounded-lg text-sm text-dark-600 hover:text-white transition-colors duration-200"
                        >
                          {suggestion}
                        </button>
                      ))}
                    </div>
                  </div>
                </div>
              )}

              {query && query.length < 2 && (
                <div className="text-center py-8">
                  <p className="text-dark-500">Type at least 2 characters to search</p>
                </div>
              )}

              {query && query.length >= 2 && (
                <div>
                  {isLoading && (
                    <div className="flex justify-center py-8">
                      <LoadingSpinner size="medium" />
                    </div>
                  )}

                  {isError && (
                    <div className="text-center py-8">
                      <p className="text-red-400">Failed to search. Please try again.</p>
                    </div>
                  )}

                  {data && !isLoading && (
                    <div>
                      {data.results.length === 0 ? (
                        <div className="text-center py-8">
                          <p className="text-dark-500">No results found for "{query}"</p>
                        </div>
                      ) : (
                        <div>
                          <div className="flex items-center justify-between mb-4">
                            <h3 className="text-white font-semibold">
                              Search Results ({data.total_results.toLocaleString()})
                            </h3>
                            <button
                              onClick={() => {
                                setSearchQuery(query)
                                window.location.href = `/search?q=${encodeURIComponent(query)}`
                                handleClose()
                              }}
                              className="text-sm text-primary-400 hover:text-primary-300"
                            >
                              View all
                            </button>
                          </div>
                          
                          <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 gap-4">
                            {data.results.slice(0, 8).map((item) => (
                              <div key={item.id} onClick={handleClose}>
                                <MovieCard movie={item} showDetails={false} />
                              </div>
                            ))}
                          </div>
                        </div>
                      )}
                    </div>
                  )}
                </div>
              )}
            </div>
          </motion.div>
        </>
      )}
    </AnimatePresence>
  )
}
