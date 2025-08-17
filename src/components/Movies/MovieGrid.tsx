'use client'

import { useEffect, useCallback } from 'react'
import { useInView } from 'react-intersection-observer'
import { useQuery, useInfiniteQuery } from 'react-query'
import { motion } from 'framer-motion'
import { useMovieStore } from '@/stores/movieStore'
import tmdbService from '@/api/tmdb'
import MovieCard from './MovieCard'
import LoadingSpinner from '@/components/UI/LoadingSpinner'
import ErrorMessage from '@/components/UI/ErrorMessage'
import { MovieEntity } from '@/types/movie'

export default function MovieGrid() {
  const { currentCategory } = useMovieStore()
  const { ref: loadMoreRef, inView } = useInView({
    threshold: 0.1,
    triggerOnce: false,
  })

  const {
    data,
    fetchNextPage,
    hasNextPage,
    isFetchingNextPage,
    isLoading,
    isError,
    error,
  } = useInfiniteQuery(
    ['movies', currentCategory?.id, currentCategory?.source, currentCategory?.type],
    async ({ pageParam = 1 }) => {
      if (!currentCategory) throw new Error('No category selected')
      return await tmdbService.getMoviesByCategory(currentCategory, pageParam)
    },
    {
      enabled: !!currentCategory,
      getNextPageParam: (lastPage, allPages) => {
        return lastPage.page < lastPage.total_pages ? lastPage.page + 1 : undefined
      },
      staleTime: 5 * 60 * 1000, // 5 minutes
      cacheTime: 10 * 60 * 1000, // 10 minutes
    }
  )

  // Auto-fetch next page when scrolled to bottom
  useEffect(() => {
    if (inView && hasNextPage && !isFetchingNextPage) {
      fetchNextPage()
    }
  }, [inView, hasNextPage, isFetchingNextPage, fetchNextPage])

  const movies = data?.pages.flatMap(page => page.results) || []

  if (isLoading) {
    return (
      <div className="space-y-6">
        <MovieGridSkeleton />
      </div>
    )
  }

  if (isError) {
    return (
      <ErrorMessage 
        title="Failed to load movies"
        message={error instanceof Error ? error.message : 'Something went wrong'}
        onRetry={() => window.location.reload()}
      />
    )
  }

  if (movies.length === 0) {
    return (
      <div className="flex flex-col items-center justify-center py-12">
        <div className="text-center space-y-4">
          <div className="w-24 h-24 bg-dark-300 rounded-full flex items-center justify-center mx-auto">
            <svg className="w-12 h-12 text-dark-500" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M7 4V2a1 1 0 011-1h8a1 1 0 011 1v2m-9 1v10a2 2 0 002 2h6a2 2 0 002-2V5H7z" />
            </svg>
          </div>
          <h3 className="text-xl font-semibold text-white">No content found</h3>
          <p className="text-dark-500 max-w-md">
            We couldn't find any {currentCategory?.type.toLowerCase()}s for this category. 
            Try selecting a different category or check back later.
          </p>
        </div>
      </div>
    )
  }

  return (
    <div className="space-y-6">
      {/* Category Header */}
      <div className="flex items-center justify-between">
        <div>
          <h2 className="text-2xl font-bold text-white">
            {currentCategory?.name}
          </h2>
          <p className="text-dark-500 mt-1">
            {data?.pages[0]?.total_results?.toLocaleString()} results found
          </p>
        </div>
      </div>

      {/* Movie Grid */}
      <motion.div
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ duration: 0.5 }}
        className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-5 xl:grid-cols-6 gap-4 md:gap-6"
      >
        {movies.map((movie, index) => (
          <motion.div
            key={`${movie.id}-${index}`}
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.3, delay: index * 0.05 }}
          >
            <MovieCard movie={movie} />
          </motion.div>
        ))}
      </motion.div>

      {/* Load More Trigger */}
      {hasNextPage && (
        <div ref={loadMoreRef} className="flex justify-center py-8">
          {isFetchingNextPage ? (
            <LoadingSpinner size="medium" />
          ) : (
            <div className="text-dark-500">Scroll for more...</div>
          )}
        </div>
      )}

      {/* End of Results */}
      {!hasNextPage && movies.length > 0 && (
        <div className="text-center py-8">
          <p className="text-dark-500">You've reached the end of the results</p>
        </div>
      )}
    </div>
  )
}

// Loading skeleton component
function MovieGridSkeleton() {
  return (
    <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-5 xl:grid-cols-6 gap-4 md:gap-6">
      {Array.from({ length: 20 }).map((_, index) => (
        <div key={index} className="space-y-3">
          <div className="aspect-poster bg-dark-300 rounded-lg shimmer" />
          <div className="space-y-2">
            <div className="h-4 bg-dark-300 rounded shimmer" />
            <div className="h-3 bg-dark-300 rounded shimmer w-3/4" />
          </div>
        </div>
      ))}
    </div>
  )
}
