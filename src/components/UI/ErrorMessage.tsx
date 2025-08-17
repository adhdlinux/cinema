'use client'

import { motion } from 'framer-motion'
import { 
  ExclamationTriangleIcon, 
  ArrowPathIcon,
  XMarkIcon 
} from '@heroicons/react/24/outline'

interface ErrorMessageProps {
  title?: string
  message: string
  onRetry?: () => void
  onDismiss?: () => void
  type?: 'error' | 'warning' | 'info'
  className?: string
}

export default function ErrorMessage({
  title,
  message,
  onRetry,
  onDismiss,
  type = 'error',
  className = ''
}: ErrorMessageProps) {
  const getIconAndColors = () => {
    switch (type) {
      case 'warning':
        return {
          icon: ExclamationTriangleIcon,
          bgColor: 'bg-yellow-600/10',
          borderColor: 'border-yellow-600/20',
          iconColor: 'text-yellow-500',
          titleColor: 'text-yellow-400'
        }
      case 'info':
        return {
          icon: ExclamationTriangleIcon,
          bgColor: 'bg-blue-600/10',
          borderColor: 'border-blue-600/20',
          iconColor: 'text-blue-500',
          titleColor: 'text-blue-400'
        }
      default:
        return {
          icon: ExclamationTriangleIcon,
          bgColor: 'bg-red-600/10',
          borderColor: 'border-red-600/20',
          iconColor: 'text-red-500',
          titleColor: 'text-red-400'
        }
    }
  }

  const { icon: Icon, bgColor, borderColor, iconColor, titleColor } = getIconAndColors()

  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      exit={{ opacity: 0, y: -20 }}
      className={`
        relative rounded-lg border p-6 
        ${bgColor} ${borderColor}
        ${className}
      `}
    >
      {/* Dismiss Button */}
      {onDismiss && (
        <button
          onClick={onDismiss}
          className="absolute top-4 right-4 p-1 rounded-lg hover:bg-black/10 transition-colors duration-200"
        >
          <XMarkIcon className="w-4 h-4 text-dark-500" />
        </button>
      )}

      <div className="flex items-start space-x-4">
        {/* Icon */}
        <div className={`flex-shrink-0 ${iconColor}`}>
          <Icon className="w-6 h-6" />
        </div>

        {/* Content */}
        <div className="flex-1 min-w-0">
          {title && (
            <h3 className={`text-lg font-semibold mb-2 ${titleColor}`}>
              {title}
            </h3>
          )}
          
          <p className="text-dark-300 text-sm leading-relaxed">
            {message}
          </p>

          {/* Action Buttons */}
          {onRetry && (
            <div className="mt-4 flex items-center space-x-3">
              <button
                onClick={onRetry}
                className="inline-flex items-center space-x-2 px-4 py-2 bg-primary-600 hover:bg-primary-700 text-white text-sm font-medium rounded-lg transition-colors duration-200"
              >
                <ArrowPathIcon className="w-4 h-4" />
                <span>Try Again</span>
              </button>
            </div>
          )}
        </div>
      </div>
    </motion.div>
  )
}

// Inline error component for forms
export function InlineError({ 
  message, 
  className = '' 
}: { 
  message: string
  className?: string 
}) {
  return (
    <motion.div
      initial={{ opacity: 0, height: 0 }}
      animate={{ opacity: 1, height: 'auto' }}
      exit={{ opacity: 0, height: 0 }}
      className={`flex items-center space-x-2 text-red-400 text-sm mt-1 ${className}`}
    >
      <ExclamationTriangleIcon className="w-4 h-4 flex-shrink-0" />
      <span>{message}</span>
    </motion.div>
  )
}

// Success message component
export function SuccessMessage({ 
  message, 
  onDismiss,
  className = '' 
}: { 
  message: string
  onDismiss?: () => void
  className?: string 
}) {
  return (
    <motion.div
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      exit={{ opacity: 0, y: -20 }}
      className={`
        relative rounded-lg border p-4 
        bg-green-600/10 border-green-600/20
        ${className}
      `}
    >
      {onDismiss && (
        <button
          onClick={onDismiss}
          className="absolute top-3 right-3 p-1 rounded-lg hover:bg-black/10 transition-colors duration-200"
        >
          <XMarkIcon className="w-4 h-4 text-dark-500" />
        </button>
      )}

      <div className="flex items-center space-x-3">
        <div className="text-green-500">
          <svg className="w-5 h-5" fill="currentColor" viewBox="0 0 20 20">
            <path fillRule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clipRule="evenodd" />
          </svg>
        </div>
        <p className="text-green-400 text-sm font-medium">
          {message}
        </p>
      </div>
    </motion.div>
  )
}
