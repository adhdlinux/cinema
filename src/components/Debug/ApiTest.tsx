'use client'

import { useState, useEffect } from 'react'
import tmdbService from '@/api/tmdb'

export default function ApiTest() {
  const [status, setStatus] = useState<{
    apiKey: boolean
    connection: boolean
    error?: string
  }>({ apiKey: false, connection: false })

  useEffect(() => {
    async function testApi() {
      try {
        // Check API key status
        const keyStatus = tmdbService.getApiKeyStatus()
        console.log('API Key Status:', keyStatus)
        
        // Test connection
        const connectionTest = await tmdbService.testConnection()
        console.log('Connection Test:', connectionTest)
        
        setStatus({
          apiKey: keyStatus.hasApiKey,
          connection: connectionTest.success,
          error: connectionTest.success ? undefined : connectionTest.message
        })
      } catch (error) {
        console.error('API Test Error:', error)
        setStatus({
          apiKey: false,
          connection: false,
          error: error instanceof Error ? error.message : 'Unknown error'
        })
      }
    }

    testApi()
  }, [])

  return (
    <div className="fixed bottom-4 right-4 bg-dark-200 border border-dark-300 rounded-lg p-4 text-sm">
      <h3 className="font-semibold mb-2">API Status</h3>
      <div className="space-y-1">
        <div className="flex items-center space-x-2">
          <div className={`w-2 h-2 rounded-full ${status.apiKey ? 'bg-green-500' : 'bg-red-500'}`} />
          <span>API Key: {status.apiKey ? 'Loaded' : 'Missing'}</span>
        </div>
        <div className="flex items-center space-x-2">
          <div className={`w-2 h-2 rounded-full ${status.connection ? 'bg-green-500' : 'bg-red-500'}`} />
          <span>Connection: {status.connection ? 'OK' : 'Failed'}</span>
        </div>
        {status.error && (
          <div className="text-red-400 text-xs mt-2">
            Error: {status.error}
          </div>
        )}
      </div>
    </div>
  )
}
