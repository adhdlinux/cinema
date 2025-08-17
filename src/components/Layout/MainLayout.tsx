'use client'

import { useState, useEffect } from 'react'
import { motion, AnimatePresence } from 'framer-motion'
import Sidebar from './Sidebar'
import Header from './Header'
import MobileNav from './MobileNav'
import { useMediaQuery } from 'react-responsive'

interface MainLayoutProps {
  children: React.ReactNode
}

export default function MainLayout({ children }: MainLayoutProps) {
  const [sidebarOpen, setSidebarOpen] = useState(false)
  const [mounted, setMounted] = useState(false)
  const isMobile = useMediaQuery({ maxWidth: 768 })

  useEffect(() => {
    setMounted(true)
  }, [])

  const toggleSidebar = () => setSidebarOpen(!sidebarOpen)
  const closeSidebar = () => setSidebarOpen(false)

  if (!mounted) {
    return (
      <div className="min-h-screen bg-dark-100 flex items-center justify-center">
        <div className="spinner w-8 h-8"></div>
      </div>
    )
  }

  return (
    <div className="min-h-screen bg-dark-100 flex">
      {/* Desktop Sidebar */}
      {!isMobile && (
        <motion.div
          initial={{ x: -300 }}
          animate={{ x: 0 }}
          className="hidden md:block"
        >
          <Sidebar />
        </motion.div>
      )}

      {/* Mobile Sidebar Overlay */}
      <AnimatePresence>
        {isMobile && sidebarOpen && (
          <>
            <motion.div
              initial={{ opacity: 0 }}
              animate={{ opacity: 1 }}
              exit={{ opacity: 0 }}
              className="fixed inset-0 bg-black bg-opacity-50 z-40 md:hidden"
              onClick={closeSidebar}
            />
            <motion.div
              initial={{ x: -300 }}
              animate={{ x: 0 }}
              exit={{ x: -300 }}
              transition={{ type: 'tween', duration: 0.3 }}
              className="fixed left-0 top-0 z-50 md:hidden"
            >
              <Sidebar onClose={closeSidebar} />
            </motion.div>
          </>
        )}
      </AnimatePresence>

      {/* Main Content */}
      <div className="flex-1 flex flex-col min-w-0">
        <Header onMenuClick={toggleSidebar} />
        
        <main className="flex-1 overflow-auto">
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5 }}
            className="min-h-full"
          >
            {children}
          </motion.div>
        </main>

        {/* Mobile Bottom Navigation */}
        {isMobile && <MobileNav />}
      </div>
    </div>
  )
}
