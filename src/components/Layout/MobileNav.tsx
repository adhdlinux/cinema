'use client'

import Link from 'next/link'
import { usePathname } from 'next/navigation'
import {
  HomeIcon,
  FilmIcon,
  TvIcon,
  HeartIcon,
  Cog6ToothIcon
} from '@heroicons/react/24/outline'
import {
  HomeIcon as HomeIconSolid,
  FilmIcon as FilmIconSolid,
  TvIcon as TvIconSolid,
  HeartIcon as HeartIconSolid,
  Cog6ToothIcon as CogIconSolid
} from '@heroicons/react/24/solid'

export default function MobileNav() {
  const pathname = usePathname()

  const navItems = [
    {
      id: 'home',
      label: 'Home',
      href: '/',
      icon: HomeIcon,
      activeIcon: HomeIconSolid,
    },
    {
      id: 'movies',
      label: 'Movies',
      href: '/movies',
      icon: FilmIcon,
      activeIcon: FilmIconSolid,
    },
    {
      id: 'tv-shows',
      label: 'TV Shows',
      href: '/tv-shows',
      icon: TvIcon,
      activeIcon: TvIconSolid,
    },
    {
      id: 'favorites',
      label: 'Favorites',
      href: '/favorites',
      icon: HeartIcon,
      activeIcon: HeartIconSolid,
    },
    {
      id: 'settings',
      label: 'Settings',
      href: '/settings',
      icon: Cog6ToothIcon,
      activeIcon: CogIconSolid,
    },
  ]

  return (
    <nav className="bg-dark-200 border-t border-dark-300 px-4 py-2 md:hidden">
      <div className="flex items-center justify-around">
        {navItems.map((item) => {
          const isActive = pathname === item.href
          const Icon = isActive ? item.activeIcon : item.icon

          return (
            <Link
              key={item.id}
              href={item.href}
              className={`flex flex-col items-center space-y-1 px-3 py-2 rounded-lg transition-colors duration-200 ${
                isActive
                  ? 'text-primary-500'
                  : 'text-dark-500 hover:text-white'
              }`}
            >
              <Icon className="w-5 h-5" />
              <span className="text-xs font-medium">{item.label}</span>
            </Link>
          )
        })}
      </div>
    </nav>
  )
}
