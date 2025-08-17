'use client'

import { motion } from 'framer-motion'

interface LoadingSpinnerProps {
  size?: 'small' | 'medium' | 'large'
  className?: string
  color?: 'primary' | 'white' | 'gray'
}

export default function LoadingSpinner({ 
  size = 'medium', 
  className = '',
  color = 'primary'
}: LoadingSpinnerProps) {
  const sizeClasses = {
    small: 'w-4 h-4',
    medium: 'w-8 h-8', 
    large: 'w-12 h-12'
  }

  const colorClasses = {
    primary: 'border-primary-500',
    white: 'border-white',
    gray: 'border-gray-400'
  }

  return (
    <div className={`flex items-center justify-center ${className}`}>
      <motion.div
        animate={{ rotate: 360 }}
        transition={{
          duration: 1,
          repeat: Infinity,
          ease: "linear"
        }}
        className={`
          ${sizeClasses[size]} 
          border-2 border-transparent border-t-current
          ${colorClasses[color]}
          rounded-full
        `}
      />
    </div>
  )
}

// Alternative dot spinner
export function DotSpinner({ className = '' }: { className?: string }) {
  return (
    <div className={`flex items-center space-x-1 ${className}`}>
      {[0, 1, 2].map((index) => (
        <motion.div
          key={index}
          animate={{
            scale: [1, 1.5, 1],
            opacity: [0.5, 1, 0.5]
          }}
          transition={{
            duration: 0.6,
            repeat: Infinity,
            delay: index * 0.2
          }}
          className="w-2 h-2 bg-primary-500 rounded-full"
        />
      ))}
    </div>
  )
}

// Pulse spinner
export function PulseSpinner({ 
  size = 'medium',
  className = '' 
}: { 
  size?: 'small' | 'medium' | 'large'
  className?: string 
}) {
  const sizeClasses = {
    small: 'w-4 h-4',
    medium: 'w-8 h-8',
    large: 'w-12 h-12'
  }

  return (
    <div className={`flex items-center justify-center ${className}`}>
      <motion.div
        animate={{
          scale: [1, 1.2, 1],
          opacity: [0.5, 1, 0.5]
        }}
        transition={{
          duration: 1.5,
          repeat: Infinity,
          ease: "easeInOut"
        }}
        className={`
          ${sizeClasses[size]} 
          bg-primary-500 
          rounded-full
        `}
      />
    </div>
  )
}
