'use client'

import { useState } from 'react'
import Link from 'next/link'
import { usePathname } from 'next/navigation'
import { motion } from 'framer-motion'
import {
  HomeIcon,
  FilmIcon,
  TvIcon,
  ListBulletIcon,
  HeartIcon,
  ClockIcon,
  CalendarIcon,
  ArrowDownTrayIcon,
  Cog6ToothIcon,
  ShareIcon,
  StarIcon,
  XMarkIcon
} from '@heroicons/react/24/outline'
import { NAVIGATION_ITEMS } from '@/types/category'

interface SidebarProps {
  onClose?: () => void
}

export default function Sidebar({ onClose }: SidebarProps) {
  const pathname = usePathname()
  const [expandedSection, setExpandedSection] = useState<string | null>(null)

  const navigationItems = [
    {
      id: 'home',
      label: 'Home',
      href: '/',
      icon: HomeIcon,
    },
    {
      id: 'movies',
      label: 'Movies',
      href: '/movies',
      icon: FilmIcon,
    },
    {
      id: 'tv-shows',
      label: 'TV Shows',
      href: '/tv-shows',
      icon: TvIcon,
    },
    {
      id: 'lists',
      label: 'Lists',
      href: '/lists',
      icon: ListBulletIcon,
    },
    {
      id: 'favorites',
      label: 'Favorites',
      href: '/favorites',
      icon: HeartIcon,
    },
    {
      id: 'history',
      label: 'Watch History',
      href: '/history',
      icon: ClockIcon,
    },
    {
      id: 'calendar',
      label: 'Calendar',
      href: '/calendar',
      icon: CalendarIcon,
    },
    {
      id: 'downloads',
      label: 'Downloads',
      href: '/downloads',
      icon: ArrowDownTrayIcon,
    },
  ]

  const bottomItems = [
    {
      id: 'settings',
      label: 'Settings',
      href: '/settings',
      icon: Cog6ToothIcon,
    },
    {
      id: 'share',
      label: 'Share App',
      href: '#',
      icon: ShareIcon,
      action: () => {
        if (navigator.share) {
          navigator.share({
            title: 'Cinema - Free Movies & TV Shows',
            text: 'Check out this awesome movie streaming app!',
            url: window.location.origin,
          })
        } else {
          navigator.clipboard.writeText(window.location.origin)
        }
      }
    },
    {
      id: 'rate',
      label: 'Rate App',
      href: '#',
      icon: StarIcon,
      action: () => {
        window.open('https://github.com/cinema-app', '_blank')
      }
    },
  ]

  const handleItemClick = (item: any) => {
    if (item.action) {
      item.action()
    }
    onClose?.()
  }

  return (
    <motion.div
      initial={{ x: -300 }}
      animate={{ x: 0 }}
      className="w-64 h-screen bg-dark-200 border-r border-dark-300 flex flex-col"
    >
      {/* Header */}
      <div className="p-6 border-b border-dark-300 flex items-center justify-between">
        <div className="flex items-center space-x-3">
          <div className="w-8 h-8 bg-gradient-primary rounded-lg flex items-center justify-center">
            <FilmIcon className="w-5 h-5 text-white" />
          </div>
          <div>
            <h1 className="text-xl font-bold text-gradient">Cinema</h1>
            <p className="text-xs text-dark-500">Free Movies & TV</p>
          </div>
        </div>
        
        {onClose && (
          <button
            onClick={onClose}
            className="p-1 rounded-lg hover:bg-dark-300 md:hidden"
          >
            <XMarkIcon className="w-5 h-5" />
          </button>
        )}
      </div>

      {/* Navigation */}
      <nav className="flex-1 overflow-y-auto custom-scrollbar">
        <div className="p-4 space-y-2">
          {navigationItems.map((item) => {
            const isActive = pathname === item.href
            const Icon = item.icon

            return (
              <Link
                key={item.id}
                href={item.href}
                onClick={() => onClose?.()}
                className={`flex items-center space-x-3 px-3 py-2 rounded-lg transition-colors duration-200 ${
                  isActive
                    ? 'bg-primary-600 text-white'
                    : 'text-dark-600 hover:bg-dark-300 hover:text-white'
                }`}
              >
                <Icon className="w-5 h-5" />
                <span className="font-medium">{item.label}</span>
              </Link>
            )
          })}
        </div>
      </nav>

      {/* Bottom Items */}
      <div className="p-4 border-t border-dark-300 space-y-2">
        {bottomItems.map((item) => {
          const Icon = item.icon
          const isActive = pathname === item.href

          if (item.action) {
            return (
              <button
                key={item.id}
                onClick={() => handleItemClick(item)}
                className="w-full flex items-center space-x-3 px-3 py-2 rounded-lg transition-colors duration-200 text-dark-600 hover:bg-dark-300 hover:text-white"
              >
                <Icon className="w-5 h-5" />
                <span className="font-medium">{item.label}</span>
              </button>
            )
          }

          return (
            <Link
              key={item.id}
              href={item.href}
              onClick={() => onClose?.()}
              className={`flex items-center space-x-3 px-3 py-2 rounded-lg transition-colors duration-200 ${
                isActive
                  ? 'bg-primary-600 text-white'
                  : 'text-dark-600 hover:bg-dark-300 hover:text-white'
              }`}
            >
              <Icon className="w-5 h-5" />
              <span className="font-medium">{item.label}</span>
            </Link>
          )
        })}
      </div>

      {/* Version Info */}
      <div className="p-4 border-t border-dark-300">
        <p className="text-xs text-dark-500 text-center">
          Cinema v1.0.0
        </p>
        <p className="text-xs text-dark-600 text-center mt-1">
          Made with ❤️ for movie lovers
        </p>
      </div>
    </motion.div>
  )
}
