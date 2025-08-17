'use client'

import { useParams } from 'next/navigation'
import { useQuery } from 'react-query'
import { motion } from 'framer-motion'
import Image from 'next/image'
import Link from 'next/link'
import { 
  PlayIcon, 
  HeartIcon, 
  ShareIcon, 
  CalendarIcon,
  StarIcon,
  ArrowLeftIcon,
  FilmIcon
} from '@heroicons/react/24/outline'
import { HeartIcon as HeartIconSolid } from '@heroicons/react/24/solid'
import tmdbService from '@/api/tmdb'
import { useMovieStore } from '@/stores/movieStore'
import LoadingSpinner from '@/components/UI/LoadingSpinner'
import ErrorMessage from '@/components/UI/ErrorMessage'

export default function TVShowDetailPage() {
  const params = useParams()
  const tvId = parseInt(params.id as string)
  const { addToFavorites, removeFromFavorites, isFavorite } = useMovieStore()

  const { data: tvShow, isLoading, isError, error } = useQuery(
    ['tv-details', tvId],
    () => tmdbService.getTVShowDetails(tvId),
    {
      enabled: !!tvId,
      staleTime: 5 * 60 * 1000,
      cacheTime: 30 * 60 * 1000,
    }
  )

  const isFav = tvShow ? isFavorite(tvShow.id) : false

  const handleFavoriteClick = () => {
    if (!tvShow) return
    
    if (isFav) {
      removeFromFavorites(tvShow.id)
    } else {
      addToFavorites(tvShow)
    }
  }

  const handleWatchClick = () => {
    // For now, just show an alert - in a real app this would open a video player
    alert(`This would play "${tvShow?.name}". Video streaming functionality would be implemented here.`)
  }

  if (isLoading) {
    return (
      <div className="min-h-screen bg-dark-100 flex items-center justify-center">
        <LoadingSpinner size="large" />
      </div>
    )
  }

  if (isError || !tvShow) {
    return (
      <div className="min-h-screen bg-dark-100 flex items-center justify-center">
        <ErrorMessage 
          title="TV Show not found"
          message={error instanceof Error ? error.message : 'This TV show could not be loaded'}
          onRetry={() => window.location.reload()}
        />
      </div>
    )
  }

  const backdropUrl = tvShow.backdrop_path 
    ? tmdbService.getBackdropUrl(tvShow.backdrop_path, 'w1280')
    : tmdbService.getPosterUrl(tvShow.poster_path, 'w780')

  const posterUrl = tvShow.poster_path 
    ? tmdbService.getPosterUrl(tvShow.poster_path, 'w500')
    : '/placeholder-poster.jpg'

  const firstAirYear = tvShow.first_air_date ? new Date(tvShow.first_air_date).getFullYear() : null
  const lastAirYear = tvShow.last_air_date ? new Date(tvShow.last_air_date).getFullYear() : null
  const rating = tvShow.vote_average ? Number(tvShow.vote_average.toFixed(1)) : null

  return (
    <div className="min-h-screen bg-dark-100">
      {/* Back Button */}
      <div className="fixed top-4 left-4 z-50">
        <Link
          href="/"
          className="flex items-center space-x-2 bg-black/60 backdrop-blur-sm text-white px-4 py-2 rounded-lg hover:bg-black/80 transition-colors duration-200"
        >
          <ArrowLeftIcon className="w-5 h-5" />
          <span>Back</span>
        </Link>
      </div>

      {/* Hero Section */}
      <div className="relative h-screen">
        {/* Background Image */}
        <div className="absolute inset-0">
          <Image
            src={backdropUrl}
            alt={tvShow.name}
            fill
            className="object-cover"
            priority
          />
          <div className="absolute inset-0 bg-gradient-to-t from-dark-100 via-dark-100/80 to-transparent" />
          <div className="absolute inset-0 bg-gradient-to-r from-dark-100/90 via-transparent to-transparent" />
        </div>

        {/* Content */}
        <div className="relative z-10 h-full flex items-center">
          <div className="container mx-auto px-6 grid grid-cols-1 lg:grid-cols-3 gap-8 max-w-7xl">
            {/* Poster */}
            <div className="flex justify-center lg:justify-start">
              <motion.div
                initial={{ opacity: 0, y: 50 }}
                animate={{ opacity: 1, y: 0 }}
                transition={{ duration: 0.8 }}
                className="relative w-80 aspect-poster"
              >
                <Image
                  src={posterUrl}
                  alt={tvShow.name}
                  fill
                  className="object-cover rounded-lg shadow-2xl"
                />
              </motion.div>
            </div>

            {/* TV Show Info */}
            <div className="lg:col-span-2 space-y-6 text-center lg:text-left">
              <motion.div
                initial={{ opacity: 0, y: 30 }}
                animate={{ opacity: 1, y: 0 }}
                transition={{ duration: 0.8, delay: 0.2 }}
              >
                <h1 className="text-4xl md:text-6xl font-bold text-white mb-4">
                  {tvShow.name}
                </h1>
                
                {tvShow.tagline && (
                  <p className="text-xl text-dark-400 italic mb-6">
                    "{tvShow.tagline}"
                  </p>
                )}

                <div className="flex flex-wrap items-center justify-center lg:justify-start gap-4 mb-6 text-sm text-dark-400">
                  {firstAirYear && (
                    <div className="flex items-center space-x-1">
                      <CalendarIcon className="w-4 h-4" />
                      <span>
                        {firstAirYear}{lastAirYear && lastAirYear !== firstAirYear ? ` - ${lastAirYear}` : ''}
                      </span>
                    </div>
                  )}
                  
                  {tvShow.number_of_seasons && (
                    <div className="flex items-center space-x-1">
                      <FilmIcon className="w-4 h-4" />
                      <span>{tvShow.number_of_seasons} Season{tvShow.number_of_seasons > 1 ? 's' : ''}</span>
                    </div>
                  )}
                  
                  {rating && (
                    <div className="flex items-center space-x-1">
                      <StarIcon className="w-4 h-4 text-yellow-400" />
                      <span className="text-white font-semibold">{rating}</span>
                      <span>({tvShow.vote_count?.toLocaleString()} votes)</span>
                    </div>
                  )}
                </div>

                {/* Genres */}
                {tvShow.genres && tvShow.genres.length > 0 && (
                  <div className="flex flex-wrap justify-center lg:justify-start gap-2 mb-6">
                    {tvShow.genres.map((genre) => (
                      <span
                        key={genre.id}
                        className="bg-primary-600/20 text-primary-400 px-3 py-1 rounded-full text-sm"
                      >
                        {genre.name}
                      </span>
                    ))}
                  </div>
                )}

                {/* Overview */}
                <p className="text-lg text-dark-300 leading-relaxed mb-8 max-w-3xl">
                  {tvShow.overview}
                </p>

                {/* Action Buttons */}
                <div className="flex flex-wrap justify-center lg:justify-start gap-4">
                  <button
                    onClick={handleWatchClick}
                    className="flex items-center space-x-2 bg-primary-600 hover:bg-primary-700 text-white px-8 py-3 rounded-lg font-semibold transition-colors duration-200"
                  >
                    <PlayIcon className="w-5 h-5" />
                    <span>Watch Now</span>
                  </button>

                  <button
                    onClick={handleFavoriteClick}
                    className="flex items-center space-x-2 bg-dark-300 hover:bg-dark-400 text-white px-6 py-3 rounded-lg transition-colors duration-200"
                  >
                    {isFav ? (
                      <HeartIconSolid className="w-5 h-5 text-red-500" />
                    ) : (
                      <HeartIcon className="w-5 h-5" />
                    )}
                    <span>{isFav ? 'Remove from Favorites' : 'Add to Favorites'}</span>
                  </button>

                  <button className="flex items-center space-x-2 bg-dark-300 hover:bg-dark-400 text-white px-6 py-3 rounded-lg transition-colors duration-200">
                    <ShareIcon className="w-5 h-5" />
                    <span>Share</span>
                  </button>
                </div>
              </motion.div>
            </div>
          </div>
        </div>
      </div>

      {/* Additional Info Section */}
      <div className="container mx-auto px-6 py-12 max-w-7xl">
        <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
          {/* Cast & Crew */}
          {tvShow.credits?.cast && tvShow.credits.cast.length > 0 && (
            <div className="lg:col-span-2">
              <h2 className="text-2xl font-bold text-white mb-6">Cast</h2>
              <div className="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
                {tvShow.credits.cast.slice(0, 8).map((actor) => (
                  <div key={actor.id} className="text-center">
                    <div className="w-20 h-20 mx-auto mb-2 bg-dark-300 rounded-full overflow-hidden">
                      {actor.profile_path && (
                        <Image
                          src={tmdbService.getProfileUrl(actor.profile_path, 'w185')}
                          alt={actor.name}
                          width={80}
                          height={80}
                          className="object-cover w-full h-full"
                        />
                      )}
                    </div>
                    <p className="text-white text-sm font-semibold">{actor.name}</p>
                    <p className="text-dark-400 text-xs">{actor.character}</p>
                  </div>
                ))}
              </div>
            </div>
          )}

          {/* TV Show Details */}
          <div>
            <h2 className="text-2xl font-bold text-white mb-6">Details</h2>
            <div className="space-y-4">
              {tvShow.episode_run_time && tvShow.episode_run_time.length > 0 && (
                <div>
                  <h3 className="text-dark-400 text-sm">Episode Runtime</h3>
                  <p className="text-white">{tvShow.episode_run_time[0]} minutes</p>
                </div>
              )}
              
              {tvShow.number_of_episodes && (
                <div>
                  <h3 className="text-dark-400 text-sm">Total Episodes</h3>
                  <p className="text-white">{tvShow.number_of_episodes} episodes</p>
                </div>
              )}
              
              {tvShow.status && (
                <div>
                  <h3 className="text-dark-400 text-sm">Status</h3>
                  <p className="text-white">{tvShow.status}</p>
                </div>
              )}
              
              {tvShow.networks && tvShow.networks.length > 0 && (
                <div>
                  <h3 className="text-dark-400 text-sm">Networks</h3>
                  <p className="text-white">
                    {tvShow.networks.map(network => network.name).join(', ')}
                  </p>
                </div>
              )}
              
              {tvShow.production_companies && tvShow.production_companies.length > 0 && (
                <div>
                  <h3 className="text-dark-400 text-sm">Production Companies</h3>
                  <p className="text-white">
                    {tvShow.production_companies.map(company => company.name).join(', ')}
                  </p>
                </div>
              )}
              
              {tvShow.spoken_languages && tvShow.spoken_languages.length > 0 && (
                <div>
                  <h3 className="text-dark-400 text-sm">Languages</h3>
                  <p className="text-white">
                    {tvShow.spoken_languages.map(lang => lang.english_name).join(', ')}
                  </p>
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}
