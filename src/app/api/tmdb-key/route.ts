import { NextResponse } from 'next/server'
import { promises as fs } from 'fs'
import path from 'path'

export async function GET() {
  try {
    // Try to read from api.txt file first
    const filePath = path.join(process.cwd(), 'api.txt')
    try {
      const apiKey = await fs.readFile(filePath, 'utf8')
      return NextResponse.json({ apiKey: apiKey.trim() })
    } catch (fileError) {
      // Fallback to public/api.txt
      const publicFilePath = path.join(process.cwd(), 'public', 'api.txt')
      try {
        const apiKey = await fs.readFile(publicFilePath, 'utf8')
        return NextResponse.json({ apiKey: apiKey.trim() })
      } catch (publicFileError) {
        // Fallback to environment variable
        const envApiKey = process.env.TMDB_API_KEY || process.env.NEXT_PUBLIC_TMDB_API_KEY
        if (envApiKey) {
          return NextResponse.json({ apiKey: envApiKey.trim() })
        }
        throw new Error('No API key found in files or environment')
      }
    }
  } catch (error) {
    console.error('Failed to load TMDB API key:', error)
    return NextResponse.json(
      { error: 'Failed to load API key' },
      { status: 500 }
    )
  }
}
