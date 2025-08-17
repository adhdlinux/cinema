'use client'

import { useEffect, useState } from 'react'
import MainLayout from '@/components/Layout/MainLayout'
import MovieGrid from '@/components/Movies/MovieGrid'
import CategorySelector from '@/components/Navigation/CategorySelector'
import { useMovieStore } from '@/stores/movieStore'
import { CategoryEntity, CategoryType, CategorySource } from '@/types/category'
import LoadingSpinner from '@/components/UI/LoadingSpinner'
import { Helmet } from 'react-helmet-async'

export default function HomePage() {
  const [isLoading, setIsLoading] = useState(true)
  const { currentCategory, setCurrentCategory } = useMovieStore()

  useEffect(() => {
    // Initialize with default category if none set
    if (!currentCategory) {
      const defaultCategory: CategoryEntity = {
        id: 'popular',
        name: 'Popular',
        type: CategoryType.Movie,
        source: CategorySource.TMDB,
        sourceType: 'Generic',
        restricted: false
      }
      setCurrentCategory(defaultCategory)
    }
    setIsLoading(false)
  }, [currentCategory, setCurrentCategory])

  if (isLoading) {
    return (
      <MainLayout>
        <div className="flex items-center justify-center min-h-screen">
          <LoadingSpinner size="large" />
        </div>
      </MainLayout>
    )
  }

  return (
    <>
      <Helmet>
        <title>Cinema - Stream Movies & TV Shows Free</title>
        <meta name="description" content="Watch the latest movies and TV shows online for free in HD quality. No registration required." />
        <meta property="og:title" content="Cinema - Free Movie Streaming" />
        <meta property="og:description" content="Stream unlimited movies and TV shows for free in HD quality" />
        <meta property="og:type" content="website" />
      </Helmet>
      
      <MainLayout>
        <div className="p-6">
          <div className="mb-6">
            <CategorySelector />
          </div>
          
          <div className="space-y-8">
            <MovieGrid />
          </div>
        </div>
      </MainLayout>
    </>
  )
}
