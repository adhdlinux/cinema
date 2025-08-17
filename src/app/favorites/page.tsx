'use client'

import { motion } from 'framer-motion'
import MainLayout from '@/components/Layout/MainLayout'
import MovieCard from '@/components/Movies/MovieCard'
import { useMovieStore } from '@/stores/movieStore'
import { HeartIcon } from '@heroicons/react/24/outline'
import { Helmet } from 'react-helmet-async'

export default function FavoritesPage() {
  const { favorites, removeFromFavorites } = useMovieStore()

  const handleRemoveFromFavorites = (movieId: number) => {
    removeFromFavorites(movieId)
  }

  return (
    <>
      <Helmet>
        <title>My Favorites - Cinema</title>
        <meta name="description" content="Your favorite movies and TV shows collection. Never lose track of what you love." />
      </Helmet>
      
      <MainLayout>
        <div className="p-6">
          <div className="mb-6">
            <div className="flex items-center space-x-3 mb-4">
              <HeartIcon className="w-8 h-8 text-red-500" />
              <h1 className="text-3xl font-bold text-white">My Favorites</h1>
            </div>
            <p className="text-dark-500">
              {favorites.length} favorite{favorites.length !== 1 ? 's' : ''} saved
            </p>
          </div>

          {favorites.length === 0 ? (
            <div className="flex flex-col items-center justify-center py-16">
              <div className="text-center space-y-4">
                <div className="w-24 h-24 bg-dark-300 rounded-full flex items-center justify-center mx-auto">
                  <HeartIcon className="w-12 h-12 text-dark-500" />
                </div>
                <h3 className="text-xl font-semibold text-white">No favorites yet</h3>
                <p className="text-dark-500 max-w-md">
                  Start building your collection by clicking the heart icon on movies and TV shows you love.
                </p>
                <div className="pt-4">
                  <a
                    href="/"
                    className="btn-primary inline-flex items-center"
                  >
                    Browse Movies & TV Shows
                  </a>
                </div>
              </div>
            </div>
          ) : (
            <motion.div
              initial={{ opacity: 0 }}
              animate={{ opacity: 1 }}
              className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-5 xl:grid-cols-6 gap-4 md:gap-6"
            >
              {favorites.map((movie, index) => (
                <motion.div
                  key={movie.id}
                  initial={{ opacity: 0, y: 20 }}
                  animate={{ opacity: 1, y: 0 }}
                  transition={{ duration: 0.3, delay: index * 0.05 }}
                >
                  <MovieCard movie={movie} />
                </motion.div>
              ))}
            </motion.div>
          )}
        </div>
      </MainLayout>
    </>
  )
}
