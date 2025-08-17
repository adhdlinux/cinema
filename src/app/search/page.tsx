'use client'

import { useEffect, useState } from 'react'
import { useSearchParams } from 'next/navigation'
import { useQuery } from 'react-query'
import { motion } from 'framer-motion'
import MainLayout from '@/components/Layout/MainLayout'
import MovieCard from '@/components/Movies/MovieCard'
import LoadingSpinner from '@/components/UI/LoadingSpinner'
import ErrorMessage from '@/components/UI/ErrorMessage'
import tmdbService from '@/api/tmdb'
import { MagnifyingGlassIcon } from '@heroicons/react/24/outline'
import { Helmet } from 'react-helmet-async'

export default function SearchPage() {
  const searchParams = useSearchParams()
  const query = searchParams.get('q') || ''
  const [page, setPage] = useState(1)

  const { data, isLoading, isError, error } = useQuery(
    ['search-results', query, page],
    () => tmdbService.searchMulti(query, page),
    {
      enabled: !!query,
      keepPreviousData: true,
    }
  )

  useEffect(() => {
    setPage(1)
  }, [query])

  const loadMore = () => {
    if (data && page < data.total_pages) {
      setPage(prev => prev + 1)
    }
  }

  return (
    <>
      <Helmet>
        <title>{query ? `Search: ${query} - Cinema` : 'Search - Cinema'}</title>
        <meta name="description" content={`Search results for "${query}". Find movies, TV shows and more.`} />
      </Helmet>
      
      <MainLayout>
        <div className="p-6">
          <div className="mb-6">
            <div className="flex items-center space-x-3 mb-4">
              <MagnifyingGlassIcon className="w-8 h-8 text-primary-500" />
              <h1 className="text-3xl font-bold text-white">Search Results</h1>
            </div>
            
            {query && (
              <div className="flex items-center space-x-4 text-dark-500">
                <span>Searching for: <span className="text-white font-medium">"{query}"</span></span>
                {data && (
                  <span>
                    {data.total_results.toLocaleString()} results found
                  </span>
                )}
              </div>
            )}
          </div>

          {!query ? (
            <div className="flex flex-col items-center justify-center py-16">
              <div className="text-center space-y-4">
                <div className="w-24 h-24 bg-dark-300 rounded-full flex items-center justify-center mx-auto">
                  <MagnifyingGlassIcon className="w-12 h-12 text-dark-500" />
                </div>
                <h3 className="text-xl font-semibold text-white">No search query</h3>
                <p className="text-dark-500 max-w-md">
                  Enter a search term to find movies, TV shows, and more.
                </p>
              </div>
            </div>
          ) : isLoading && page === 1 ? (
            <div className="flex justify-center py-16">
              <LoadingSpinner size="large" />
            </div>
          ) : isError ? (
            <ErrorMessage
              title="Search Failed"
              message={error instanceof Error ? error.message : 'Failed to search. Please try again.'}
              onRetry={() => window.location.reload()}
            />
          ) : data?.results.length === 0 ? (
            <div className="flex flex-col items-center justify-center py-16">
              <div className="text-center space-y-4">
                <div className="w-24 h-24 bg-dark-300 rounded-full flex items-center justify-center mx-auto">
                  <MagnifyingGlassIcon className="w-12 h-12 text-dark-500" />
                </div>
                <h3 className="text-xl font-semibold text-white">No results found</h3>
                <p className="text-dark-500 max-w-md">
                  We couldn't find anything matching "{query}". Try different keywords or check for typos.
                </p>
              </div>
            </div>
          ) : (
            <div className="space-y-6">
              <motion.div
                initial={{ opacity: 0 }}
                animate={{ opacity: 1 }}
                className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-5 xl:grid-cols-6 gap-4 md:gap-6"
              >
                {data?.results.map((item, index) => (
                  <motion.div
                    key={`${item.id}-${index}`}
                    initial={{ opacity: 0, y: 20 }}
                    animate={{ opacity: 1, y: 0 }}
                    transition={{ duration: 0.3, delay: index * 0.05 }}
                  >
                    <MovieCard movie={item} />
                  </motion.div>
                ))}
              </motion.div>

              {/* Load More */}
              {data && page < data.total_pages && (
                <div className="flex justify-center pt-8">
                  <button
                    onClick={loadMore}
                    disabled={isLoading}
                    className="btn-primary flex items-center space-x-2 disabled:opacity-50 disabled:cursor-not-allowed"
                  >
                    {isLoading ? (
                      <>
                        <LoadingSpinner size="small" color="white" />
                        <span>Loading...</span>
                      </>
                    ) : (
                      <span>Load More</span>
                    )}
                  </button>
                </div>
              )}
            </div>
          )}
        </div>
      </MainLayout>
    </>
  )
}
