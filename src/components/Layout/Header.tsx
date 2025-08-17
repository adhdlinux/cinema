'use client'

import { useState, useRef, useEffect } from 'react'
import { motion, AnimatePresence } from 'framer-motion'
import {
  Bars3Icon,
  MagnifyingGlassIcon,
  XMarkIcon,
  ServerIcon,
  TvIcon
} from '@heroicons/react/24/outline'
import SearchModal from '@/components/Search/SearchModal'
import { useMovieStore } from '@/stores/movieStore'
import { CategorySource } from '@/types/category'

interface HeaderProps {
  onMenuClick: () => void
}

export default function Header({ onMenuClick }: HeaderProps) {
  const [searchOpen, setSearchOpen] = useState(false)
  const [sourceMenuOpen, setSourceMenuOpen] = useState(false)
  const { currentCategory, setCurrentCategory } = useMovieStore()
  const sourceMenuRef = useRef<HTMLDivElement>(null)

  useEffect(() => {
    const handleClickOutside = (event: MouseEvent) => {
      if (sourceMenuRef.current && !sourceMenuRef.current.contains(event.target as Node)) {
        setSourceMenuOpen(false)
      }
    }

    document.addEventListener('mousedown', handleClickOutside)
    return () => document.removeEventListener('mousedown', handleClickOutside)
  }, [])

  const toggleSource = () => {
    if (!currentCategory) return
    
    const newSource = currentCategory.source === CategorySource.TMDB 
      ? CategorySource.TRAKT 
      : CategorySource.TMDB
    
    setCurrentCategory({
      ...currentCategory,
      source: newSource
    })
  }

  const getSourceIcon = () => {
    if (!currentCategory) return <ServerIcon className="w-5 h-5" />

    return currentCategory.source === CategorySource.TMDB
      ? <ServerIcon className="w-5 h-5" />
      : <TvIcon className="w-5 h-5" />
  }

  const getSourceName = () => {
    if (!currentCategory) return 'TMDB'
    return currentCategory.source === CategorySource.TMDB ? 'TMDB' : 'Trakt'
  }

  return (
    <>
      <header className="bg-dark-200 border-b border-dark-300 px-6 py-4">
        <div className="flex items-center justify-between">
          {/* Left Section */}
          <div className="flex items-center space-x-4">
            <button
              onClick={onMenuClick}
              className="p-2 rounded-lg hover:bg-dark-300 md:hidden"
            >
              <Bars3Icon className="w-5 h-5" />
            </button>

            <div className="hidden md:flex items-center space-x-4">
              <h2 className="text-lg font-semibold">
                {currentCategory?.name || 'Cinema'}
              </h2>
              
              {/* Source Toggle */}
              <div className="relative" ref={sourceMenuRef}>
                <button
                  onClick={toggleSource}
                  className="flex items-center space-x-2 px-3 py-1.5 bg-dark-300 hover:bg-dark-400 rounded-lg transition-colors duration-200"
                  title={`Current source: ${getSourceName()}`}
                >
                  {getSourceIcon()}
                  <span className="text-sm font-medium">{getSourceName()}</span>
                </button>
              </div>
            </div>
          </div>

          {/* Right Section */}
          <div className="flex items-center space-x-4">
            {/* Search Button */}
            <button
              onClick={() => setSearchOpen(true)}
              className="p-2 rounded-lg hover:bg-dark-300 transition-colors duration-200"
              title="Search movies and TV shows"
            >
              <MagnifyingGlassIcon className="w-5 h-5" />
            </button>

            {/* User Menu - Future Implementation */}
            <div className="w-8 h-8 bg-gradient-primary rounded-full flex items-center justify-center">
              <span className="text-sm font-bold text-white">U</span>
            </div>
          </div>
        </div>

        {/* Mobile Category Info */}
        <div className="md:hidden mt-4 flex items-center justify-between">
          <h2 className="text-lg font-semibold">
            {currentCategory?.name || 'Cinema'}
          </h2>
          
          <button
            onClick={toggleSource}
            className="flex items-center space-x-2 px-3 py-1.5 bg-dark-300 hover:bg-dark-400 rounded-lg transition-colors duration-200"
          >
            {getSourceIcon()}
            <span className="text-sm font-medium">{getSourceName()}</span>
          </button>
        </div>
      </header>

      {/* Search Modal */}
      <SearchModal 
        isOpen={searchOpen} 
        onClose={() => setSearchOpen(false)} 
      />
    </>
  )
}
