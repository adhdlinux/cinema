'use client'

import { useState, useEffect } from 'react'
import { motion, AnimatePresence } from 'framer-motion'
import { ChevronDownIcon } from '@heroicons/react/24/outline'
import { useMovieStore } from '@/stores/movieStore'
import { CategoryEntity, CategoryType, CategorySource, CategoryGeneric } from '@/types/category'
import { useQuery } from 'react-query'
import tmdbService from '@/api/tmdb'

export default function CategorySelector() {
  const { currentCategory, setCurrentCategory } = useMovieStore()
  const [isOpen, setIsOpen] = useState(false)
  const [selectedType, setSelectedType] = useState<CategoryType>(CategoryType.Movie)

  // Fetch genres for the selected type
  const { data: genres = [] } = useQuery(
    ['genres', selectedType],
    () => selectedType === CategoryType.Movie 
      ? tmdbService.getMovieGenres() 
      : tmdbService.getTVGenres(),
    {
      staleTime: 30 * 60 * 1000, // 30 minutes
    }
  )

  useEffect(() => {
    if (currentCategory) {
      setSelectedType(currentCategory.type)
    }
  }, [currentCategory])

  const predefinedCategories: CategoryEntity[] = [
    {
      id: CategoryGeneric.Popular,
      name: 'Popular',
      type: selectedType,
      source: CategorySource.TMDB,
      sourceType: 'Generic'
    },
    {
      id: CategoryGeneric.TopRated,
      name: 'Top Rated',
      type: selectedType,
      source: CategorySource.TMDB,
      sourceType: 'Generic'
    },
    ...(selectedType === CategoryType.Movie ? [
      {
        id: CategoryGeneric.NowPlaying,
        name: 'Now Playing',
        type: selectedType,
        source: CategorySource.TMDB,
        sourceType: 'Generic'
      },
      {
        id: CategoryGeneric.Upcoming,
        name: 'Upcoming',
        type: selectedType,
        source: CategorySource.TMDB,
        sourceType: 'Generic'
      }
    ] : [
      {
        id: CategoryGeneric.OnTheAir,
        name: 'On The Air',
        type: selectedType,
        source: CategorySource.TMDB,
        sourceType: 'Generic'
      },
      {
        id: CategoryGeneric.AiringToday,
        name: 'Airing Today',
        type: selectedType,
        source: CategorySource.TMDB,
        sourceType: 'Generic'
      }
    ]),
    {
      id: 'trending',
      name: 'Trending',
      type: selectedType,
      source: CategorySource.TMDB,
      sourceType: 'Generic'
    }
  ]

  const genreCategories: CategoryEntity[] = genres.map(genre => ({
    id: genre.id,
    name: genre.name,
    type: selectedType,
    source: CategorySource.TMDB,
    sourceType: 'Genre',
    genreId: genre.id
  }))

  const allCategories = [...predefinedCategories, ...genreCategories]

  const handleCategorySelect = (category: CategoryEntity) => {
    setCurrentCategory(category)
    setIsOpen(false)
  }

  const handleTypeChange = (type: CategoryType) => {
    setSelectedType(type)
    // Select the first category of the new type
    const firstCategory = {
      id: CategoryGeneric.Popular,
      name: 'Popular',
      type,
      source: CategorySource.TMDB,
      sourceType: 'Generic' as const
    }
    setCurrentCategory(firstCategory)
  }

  return (
    <div className="space-y-4">
      {/* Type Selector */}
      <div className="flex space-x-2">
        <button
          onClick={() => handleTypeChange(CategoryType.Movie)}
          className={`px-4 py-2 rounded-lg font-medium transition-colors duration-200 ${
            selectedType === CategoryType.Movie
              ? 'bg-primary-600 text-white'
              : 'bg-dark-300 text-dark-600 hover:bg-dark-400 hover:text-white'
          }`}
        >
          Movies
        </button>
        <button
          onClick={() => handleTypeChange(CategoryType.Show)}
          className={`px-4 py-2 rounded-lg font-medium transition-colors duration-200 ${
            selectedType === CategoryType.Show
              ? 'bg-primary-600 text-white'
              : 'bg-dark-300 text-dark-600 hover:bg-dark-400 hover:text-white'
          }`}
        >
          TV Shows
        </button>
      </div>

      {/* Category Dropdown */}
      <div className="relative">
        <button
          onClick={() => setIsOpen(!isOpen)}
          className="w-full md:w-auto flex items-center justify-between space-x-3 px-4 py-3 bg-dark-200 border border-dark-300 rounded-lg hover:bg-dark-300 transition-colors duration-200"
        >
          <div className="flex items-center space-x-2">
            <span className="font-medium text-white">
              {currentCategory?.name || 'Select Category'}
            </span>
            {currentCategory?.source && (
              <span className="text-xs bg-dark-400 text-dark-600 px-2 py-0.5 rounded">
                {currentCategory.source}
              </span>
            )}
          </div>
          <ChevronDownIcon 
            className={`w-5 h-5 text-dark-500 transition-transform duration-200 ${
              isOpen ? 'rotate-180' : ''
            }`} 
          />
        </button>

        <AnimatePresence>
          {isOpen && (
            <motion.div
              initial={{ opacity: 0, y: -10 }}
              animate={{ opacity: 1, y: 0 }}
              exit={{ opacity: 0, y: -10 }}
              transition={{ duration: 0.2 }}
              className="absolute top-full left-0 right-0 mt-2 bg-dark-200 border border-dark-300 rounded-lg shadow-lg z-50 max-h-80 overflow-y-auto custom-scrollbar"
            >
              {/* Predefined Categories */}
              <div className="p-2">
                <div className="text-xs text-dark-500 uppercase font-semibold px-3 py-2">
                  Categories
                </div>
                {predefinedCategories.map((category) => (
                  <button
                    key={category.id}
                    onClick={() => handleCategorySelect(category)}
                    className={`w-full text-left px-3 py-2 rounded-lg transition-colors duration-200 ${
                      currentCategory?.id === category.id
                        ? 'bg-primary-600 text-white'
                        : 'text-dark-600 hover:bg-dark-300 hover:text-white'
                    }`}
                  >
                    {category.name}
                  </button>
                ))}
              </div>

              {/* Genre Categories */}
              {genreCategories.length > 0 && (
                <div className="border-t border-dark-300 p-2">
                  <div className="text-xs text-dark-500 uppercase font-semibold px-3 py-2">
                    Genres
                  </div>
                  <div className="grid grid-cols-1 md:grid-cols-2 gap-1">
                    {genreCategories.map((category) => (
                      <button
                        key={category.id}
                        onClick={() => handleCategorySelect(category)}
                        className={`text-left px-3 py-2 rounded-lg transition-colors duration-200 text-sm ${
                          currentCategory?.id === category.id
                            ? 'bg-primary-600 text-white'
                            : 'text-dark-600 hover:bg-dark-300 hover:text-white'
                        }`}
                      >
                        {category.name}
                      </button>
                    ))}
                  </div>
                </div>
              )}
            </motion.div>
          )}
        </AnimatePresence>
      </div>
    </div>
  )
}
