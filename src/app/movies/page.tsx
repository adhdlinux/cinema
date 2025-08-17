'use client'

import { useEffect } from 'react'
import MainLayout from '@/components/Layout/MainLayout'
import MovieGrid from '@/components/Movies/MovieGrid'
import CategorySelector from '@/components/Navigation/CategorySelector'
import { useMovieStore } from '@/stores/movieStore'
import { CategoryEntity, CategoryType, CategorySource } from '@/types/category'
import { Helmet } from 'react-helmet-async'

export default function MoviesPage() {
  const { currentCategory, setCurrentCategory } = useMovieStore()

  useEffect(() => {
    // Set category to movies if not already set or if current is TV
    if (!currentCategory || currentCategory.type !== CategoryType.Movie) {
      const movieCategory: CategoryEntity = {
        id: 'popular',
        name: 'Popular Movies',
        type: CategoryType.Movie,
        source: CategorySource.TMDB,
        sourceType: 'Generic',
        restricted: false
      }
      setCurrentCategory(movieCategory)
    }
  }, [currentCategory, setCurrentCategory])

  return (
    <>
      <Helmet>
        <title>Movies - Cinema</title>
        <meta name="description" content="Browse and stream the latest movies in HD quality. From blockbusters to indie films." />
      </Helmet>
      
      <MainLayout>
        <div className="p-6">
          <div className="mb-6">
            <h1 className="text-3xl font-bold text-white mb-4">Movies</h1>
            <CategorySelector />
          </div>
          
          <MovieGrid />
        </div>
      </MainLayout>
    </>
  )
}
