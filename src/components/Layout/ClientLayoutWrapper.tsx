'use client'

import { HelmetProvider } from 'react-helmet-async'
import { ReactNode } from 'react'

interface ClientLayoutWrapperProps {
  children: ReactNode
}

export default function ClientLayoutWrapper({ children }: ClientLayoutWrapperProps) {
  return (
    <HelmetProvider>
      {children}
    </HelmetProvider>
  )
}
