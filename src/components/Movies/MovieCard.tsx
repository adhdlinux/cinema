'use client'

import { useState } from 'react'
import Link from 'next/link'
import Image from 'next/image'
import { motion } from 'framer-motion'
import { 
  PlayIcon, 
  HeartIcon, 
  InformationCircleIcon,
  CalendarIcon,
  StarIcon
} from '@heroicons/react/24/outline'
import { HeartIcon as HeartIconSolid } from '@heroicons/react/24/solid'
import { MovieEntity } from '@/types/movie'
import { useMovieStore } from '@/stores/movieStore'
import tmdbService from '@/api/tmdb'
import { formatDistanceToNow } from 'date-fns'

interface MovieCardProps {
  movie: MovieEntity
  showDetails?: boolean
  className?: string
}

export default function MovieCard({ movie, showDetails = true, className = '' }: MovieCardProps) {
  const [imageLoaded, setImageLoaded] = useState(false)
  const [imageError, setImageError] = useState(false)
  const { addToFavorites, removeFromFavorites, isFavorite } = useMovieStore()
  
  const isFav = isFavorite(movie.id)
  const isTV = movie.media_type === 'tv' || movie.TV
  const title = movie.title || movie.original_title || movie.original_name || movie.name || 'Unknown Title'
  const releaseDate = movie.release_date || movie.first_air_date
  const year = releaseDate ? new Date(releaseDate).getFullYear() : null
  const rating = movie.vote_average ? Number(movie.vote_average.toFixed(1)) : null

  const handleFavoriteClick = (e: React.MouseEvent) => {
    e.preventDefault()
    e.stopPropagation()
    
    if (isFav) {
      removeFromFavorites(movie.id)
    } else {
      addToFavorites(movie)
    }
  }

  const getMovieUrl = () => {
    return isTV ? `/tv/${movie.id}` : `/movie/${movie.id}`
  }

  const posterUrl = movie.poster_path 
    ? tmdbService.getPosterUrl(movie.poster_path, 'w342')
    : '/placeholder-poster.jpg'

  return (
    <motion.div
      whileHover={{ scale: 1.05 }}
      whileTap={{ scale: 0.98 }}
      className={`group relative bg-dark-200 rounded-lg overflow-hidden shadow-lg hover:shadow-xl transition-all duration-300 ${className}`}
    >
      <Link href={getMovieUrl()}>
        {/* Poster Image */}
        <div className="relative aspect-poster bg-dark-300 overflow-hidden">
          {!imageError ? (
            <Image
              src={posterUrl}
              alt={title}
              fill
              className={`object-cover transition-all duration-500 ${
                imageLoaded ? 'opacity-100 scale-100' : 'opacity-0 scale-105'
              } group-hover:scale-110`}
              onLoad={() => setImageLoaded(true)}
              onError={() => setImageError(true)}
              sizes="(max-width: 640px) 50vw, (max-width: 768px) 33vw, (max-width: 1024px) 25vw, (max-width: 1280px) 20vw, 16vw"
            />
          ) : (
            <div className="w-full h-full flex items-center justify-center bg-dark-300">
              <div className="text-center space-y-2">
                <svg className="w-12 h-12 text-dark-500 mx-auto" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                  <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M7 4V2a1 1 0 011-1h8a1 1 0 011 1v2m-9 1v10a2 2 0 002 2h6a2 2 0 002-2V5H7z" />
                </svg>
                <p className="text-xs text-dark-500 px-2">No Image</p>
              </div>
            </div>
          )}

          {/* Loading shimmer */}
          {!imageLoaded && !imageError && (
            <div className="absolute inset-0 shimmer" />
          )}

          {/* Overlay */}
          <div className="absolute inset-0 bg-gradient-to-t from-black/80 via-transparent to-transparent opacity-0 group-hover:opacity-100 transition-opacity duration-300" />

          {/* Hover Actions */}
          <div className="absolute inset-0 flex items-center justify-center opacity-0 group-hover:opacity-100 transition-opacity duration-300">
            <div className="flex items-center space-x-2">
              <button className="p-2 bg-primary-600 rounded-full hover:bg-primary-700 transition-colors duration-200">
                <PlayIcon className="w-5 h-5 text-white" />
              </button>
              <button className="p-2 bg-white/20 backdrop-blur-sm rounded-full hover:bg-white/30 transition-colors duration-200">
                <InformationCircleIcon className="w-5 h-5 text-white" />
              </button>
            </div>
          </div>

          {/* Quality Badge */}
          {movie.vote_average && movie.vote_average >= 8 && (
            <div className="absolute top-2 left-2 bg-green-600 text-white text-xs px-2 py-1 rounded">
              HD
            </div>
          )}

          {/* Media Type Badge */}
          <div className="absolute top-2 right-2 bg-black/60 text-white text-xs px-2 py-1 rounded">
            {isTV ? 'TV' : 'Movie'}
          </div>

          {/* Rating */}
          {rating && rating > 0 && (
            <div className="absolute bottom-2 left-2 flex items-center space-x-1 bg-black/60 backdrop-blur-sm text-white text-xs px-2 py-1 rounded">
              <StarIcon className="w-3 h-3 text-yellow-400" />
              <span>{rating}</span>
            </div>
          )}

          {/* Favorite Button */}
          <button
            onClick={handleFavoriteClick}
            className="absolute bottom-2 right-2 p-1.5 bg-black/60 backdrop-blur-sm rounded-full hover:bg-black/80 transition-colors duration-200"
          >
            {isFav ? (
              <HeartIconSolid className="w-4 h-4 text-red-500" />
            ) : (
              <HeartIcon className="w-4 h-4 text-white" />
            )}
          </button>
        </div>

        {/* Content */}
        {showDetails && (
          <div className="p-3 space-y-2">
            <h3 className="font-semibold text-white text-sm leading-tight line-clamp-2 group-hover:text-primary-400 transition-colors duration-200">
              {title}
            </h3>
            
            <div className="flex items-center justify-between text-xs text-dark-500">
              {year && (
                <div className="flex items-center space-x-1">
                  <CalendarIcon className="w-3 h-3" />
                  <span>{year}</span>
                </div>
              )}
              
              {movie.popularity && (
                <div className="text-xs text-dark-500">
                  {Math.round(movie.popularity)} views
                </div>
              )}
            </div>

            {/* Genres */}
            {movie.genre_ids && movie.genre_ids.length > 0 && (
              <div className="flex flex-wrap gap-1">
                {movie.genre_ids.slice(0, 2).map((genreId) => (
                  <span
                    key={genreId}
                    className="text-xs bg-dark-300 text-dark-600 px-2 py-0.5 rounded"
                  >
                    Genre {genreId}
                  </span>
                ))}
              </div>
            )}
          </div>
        )}
      </Link>
    </motion.div>
  )
}
