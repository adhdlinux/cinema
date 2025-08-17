'use client'

import { useEffect } from 'react'
import MainLayout from '@/components/Layout/MainLayout'
import MovieGrid from '@/components/Movies/MovieGrid'
import CategorySelector from '@/components/Navigation/CategorySelector'
import { useMovieStore } from '@/stores/movieStore'
import { CategoryEntity, CategoryType, CategorySource } from '@/types/category'
import { Helmet } from 'react-helmet-async'

export default function TVShowsPage() {
  const { currentCategory, setCurrentCategory } = useMovieStore()

  useEffect(() => {
    // Set category to TV shows if not already set or if current is Movie
    if (!currentCategory || currentCategory.type !== CategoryType.Show) {
      const tvCategory: CategoryEntity = {
        id: 'popular',
        name: 'Popular TV Shows',
        type: CategoryType.Show,
        source: CategorySource.TMDB,
        sourceType: 'Generic',
        restricted: false
      }
      setCurrentCategory(tvCategory)
    }
  }, [currentCategory, setCurrentCategory])

  return (
    <>
      <Helmet>
        <title>TV Shows - Cinema</title>
        <meta name="description" content="Watch the latest TV shows and series. From drama to comedy, binge-watch your favorites." />
      </Helmet>
      
      <MainLayout>
        <div className="p-6">
          <div className="mb-6">
            <h1 className="text-3xl font-bold text-white mb-4">TV Shows</h1>
            <CategorySelector />
          </div>
          
          <MovieGrid />
        </div>
      </MainLayout>
    </>
  )
}
