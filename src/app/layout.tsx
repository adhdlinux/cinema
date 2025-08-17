import './globals.css'
import { Inter } from 'next/font/google'
import { Toaster } from 'react-hot-toast'
import Providers from './providers'
import ClientLayoutWrapper from '@/components/Layout/ClientLayoutWrapper'

const inter = Inter({ subsets: ['latin'] })

export const metadata = {
  title: 'Cinema - Free Movies & TV Shows',
  description: 'Stream the latest movies and TV shows for free with Cinema. Unlimited entertainment with HD quality.',
  keywords: 'movies, tv shows, streaming, free, cinema, entertainment, hd',
  authors: [{ name: 'Cinema Team' }],
  viewport: 'width=device-width, initial-scale=1',
  themeColor: '#0ea5e9',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en" className="dark">
      <head>
        <link rel="icon" href="/favicon.ico" />
        <meta name="theme-color" content="#0ea5e9" />
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="default" />
        <meta name="apple-mobile-web-app-title" content="Cinema" />
      </head>
      <body className={`${inter.className} bg-dark-100 text-white min-h-screen`}>
        <ClientLayoutWrapper>
          <Providers>
            {children}
            <Toaster
              position="bottom-right"
              toastOptions={{
                duration: 3000,
                style: {
                  background: '#2d2d2d',
                  color: '#fff',
                  border: '1px solid #404040',
                },
              }}
            />
          </Providers>
        </ClientLayoutWrapper>
      </body>
    </html>
  )
}
