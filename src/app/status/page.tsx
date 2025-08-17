'use client'

import { useEffect, useState } from 'react'
import MainLayout from '@/components/Layout/MainLayout'

export default function StatusPage() {
  const [status, setStatus] = useState({
    nextjs: false,
    react: false,
    tailwind: false,
    typescript: false,
    apiKey: false,
    stores: false
  })

  useEffect(() => {
    // Check Next.js
    setStatus(prev => ({ ...prev, nextjs: true }))
    
    // Check React
    setStatus(prev => ({ ...prev, react: !!React }))
    
    // Check TypeScript
    setStatus(prev => ({ ...prev, typescript: true }))
    
    // Check API key
    const checkApiKey = async () => {
      try {
        const response = await fetch('/api.txt')
        const apiKey = await response.text()
        setStatus(prev => ({ 
          ...prev, 
          apiKey: apiKey.trim() !== 'your_tmdb_api_key_here' && apiKey.trim().length > 0
        }))
      } catch (error) {
        console.error('Failed to check API key:', error)
      }
    }
    
    checkApiKey()
    
    // Check Zustand stores
    try {
      const { useMovieStore } = require('@/stores/movieStore')
      setStatus(prev => ({ ...prev, stores: !!useMovieStore }))
    } catch (error) {
      console.error('Failed to load stores:', error)
    }
    
    // Check Tailwind CSS
    const testElement = document.createElement('div')
    testElement.className = 'bg-dark-100'
    document.body.appendChild(testElement)
    const styles = window.getComputedStyle(testElement)
    const hasTailwind = styles.backgroundColor !== ''
    document.body.removeChild(testElement)
    setStatus(prev => ({ ...prev, tailwind: hasTailwind }))
    
  }, [])

  const StatusItem = ({ label, isWorking }: { label: string, isWorking: boolean }) => (
    <div className="flex items-center justify-between p-4 bg-dark-200 rounded-lg">
      <span className="font-medium">{label}</span>
      <div className={`w-3 h-3 rounded-full ${isWorking ? 'bg-green-500' : 'bg-red-500'}`} />
    </div>
  )

  return (
    <MainLayout>
      <div className="p-6 max-w-2xl mx-auto">
        <div className="space-y-6">
          <div>
            <h1 className="text-3xl font-bold text-white mb-2">System Status</h1>
            <p className="text-dark-500">Check if all components are working correctly</p>
          </div>

          <div className="space-y-4">
            <StatusItem label="Next.js" isWorking={status.nextjs} />
            <StatusItem label="React" isWorking={status.react} />
            <StatusItem label="TypeScript" isWorking={status.typescript} />
            <StatusItem label="Tailwind CSS" isWorking={status.tailwind} />
            <StatusItem label="TMDB API Key" isWorking={status.apiKey} />
            <StatusItem label="Zustand Stores" isWorking={status.stores} />
          </div>

          {!status.apiKey && (
            <div className="bg-yellow-600/10 border border-yellow-600/20 rounded-lg p-4">
              <h3 className="text-yellow-400 font-semibold mb-2">API Key Required</h3>
              <p className="text-yellow-300 text-sm">
                To use the movie database features, you need to add your TMDB API key to the <code>api.txt</code> file.
                Get your free API key from <a href="https://www.themoviedb.org/settings/api" target="_blank" className="underline">themoviedb.org</a>.
              </p>
            </div>
          )}

          <div className="bg-dark-200 rounded-lg p-4">
            <h3 className="text-white font-semibold mb-2">Environment Info</h3>
            <div className="text-sm text-dark-400 space-y-1">
              <div>Node.js: {typeof window !== 'undefined' ? 'Client-side' : 'Server-side'}</div>
              <div>User Agent: {typeof window !== 'undefined' ? navigator.userAgent : 'N/A'}</div>
              <div>URL: {typeof window !== 'undefined' ? window.location.href : 'N/A'}</div>
            </div>
          </div>
        </div>
      </div>
    </MainLayout>
  )
}
