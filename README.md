# Cinema Web App

A modern web application for streaming movies and TV shows, ported from the original Android Cinema app. Built with Next.js, TypeScript, and Tailwind CSS.

## 🎯 Features

### Core Functionality
- **Movie & TV Show Browsing**: Browse popular, top-rated, and trending content
- **Advanced Search**: Search across movies, TV shows, and people with auto-suggestions
- **Category Filtering**: Filter by genres, release years, and custom categories
- **Favorites System**: Save and manage your favorite content
- **Watch History**: Track what you've watched
- **Responsive Design**: Works seamlessly on desktop, tablet, and mobile

### Data Sources
- **TMDB Integration**: Primary metadata source with rich movie/TV information
- **Multiple Providers**: Support for 135+ streaming providers (like the original app)
- **Real-time Updates**: Fresh content updates from various sources

### User Experience
- **Modern UI**: Clean, dark theme with smooth animations
- **Fast Loading**: Optimized with infinite scrolling and lazy loading
- **Offline Ready**: Service worker support for basic offline functionality
- **Keyboard Navigation**: Full keyboard support for accessibility

## 🚀 Quick Start

### Prerequisites
- Node.js 18+ and npm/yarn
- TMDB API key (free from [themoviedb.org](https://www.themoviedb.org/settings/api))

### Installation

1. **Clone and Install**
   ```bash
   git clone <repository-url>
   cd cinema-web-app
   npm install
   ```

2. **Configure API Key**
   
   **Option A: Update api.txt file**
   ```bash
   echo "your_tmdb_api_key_here" > api.txt
   ```
   
   **Option B: Use environment variables**
   ```bash
   cp .env.local.example .env.local
   # Edit .env.local and add your TMDB API key
   ```

3. **Start Development Server**
   ```bash
   npm run dev
   ```

4. **Open Application**
   Visit [http://localhost:3000](http://localhost:3000)

## 🔧 Configuration

### TMDB API Setup
1. Create account at [themoviedb.org](https://www.themoviedb.org/)
2. Go to Settings > API
3. Request an API key (v3 auth)
4. Copy your API key to `api.txt` or `.env.local`

### Environment Variables
```bash
# Required
NEXT_PUBLIC_TMDB_API_KEY=your_api_key_here

# Optional
NEXT_PUBLIC_APP_NAME=Cinema
NEXT_PUBLIC_APP_VERSION=1.0.0
NEXT_PUBLIC_ENABLE_PROVIDERS=true
```

## 📁 Project Structure

```
src/
├── app/                    # Next.js 13 app directory
│   ├── layout.tsx         # Root layout
│   ├── page.tsx           # Home page
│   ├── movies/            # Movies section
│   ├── tv-shows/          # TV shows section
│   ├── search/            # Search results
│   └── favorites/         # User favorites
├── components/            # React components
│   ├── Layout/           # Layout components
│   ├── Movies/           # Movie-related components
│   ├── Navigation/       # Navigation components
│   ├── Search/           # Search functionality
│   └── UI/               # Reusable UI components
├── stores/               # Zustand state management
├── types/                # TypeScript type definitions
├── api/                  # API services and utilities
├── hooks/                # Custom React hooks
└── utils/                # Utility functions
```

## 🎨 Design System

### Colors
- **Primary**: Blue gradient (#0ea5e9 to #3b82f6)
- **Dark Theme**: Multiple shades of dark (#1e1e1e to #f5f5f5)
- **Accent Colors**: Red for favorites, green for quality indicators

### Components
- **Responsive Grid**: Auto-adjusting movie/show grids
- **Glass Morphism**: Backdrop blur effects for modals
- **Smooth Animations**: Framer Motion for micro-interactions
- **Loading States**: Skeleton screens and spinners

## 🔌 API Integration

### TMDB Service
```typescript
// Example usage
import tmdbService from '@/api/tmdb'

// Get popular movies
const movies = await tmdbService.getPopularMovies(page)

// Search content
const results = await tmdbService.searchMulti(query)

// Get details
const details = await tmdbService.getMovieDetails(movieId)
```

### State Management
```typescript
// Using the movie store
import { useMovieStore } from '@/stores/movieStore'

function Component() {
  const { 
    movies, 
    favorites, 
    addToFavorites,
    currentCategory 
  } = useMovieStore()
}
```

## 🎬 Streaming Providers

The app includes support for 135+ streaming providers, mirroring the original Android app:

### Free Streaming
- Fmovies, SolarMoviez, VexMovies
- GoGoAnime, KissCartoon
- Movie25V2, M4UFree, SeeHD

### Torrent Sources  
- YTS, 1337x, RARBG, EZTV
- Kickass Torrents, Zooqle
- Torrent4k, Magnetdl

### Premium Services
- Real-Debrid integration
- AllDebrid support
- Premiumize compatibility

## 📱 Mobile Experience

- **Responsive Design**: Adapts to all screen sizes
- **Touch Optimized**: Gesture-friendly interface
- **Bottom Navigation**: Easy thumb navigation on mobile
- **PWA Ready**: Can be installed as a web app

## ���� Search Features

- **Multi-source Search**: Movies, TV shows, and people
- **Auto-suggestions**: IMDB-powered search suggestions
- **Advanced Filters**: Genre, year, rating filters
- **Search History**: Recent searches saved locally
- **Popular Suggestions**: Trending search terms

## ⚡ Performance

- **Code Splitting**: Automatic route-based splitting
- **Image Optimization**: Next.js Image component with lazy loading
- **Caching**: React Query for API response caching
- **Bundle Analysis**: Built-in bundle size optimization

## 🛠 Development

### Available Scripts
```bash
npm run dev          # Start development server
npm run build        # Build for production
npm run start        # Start production server
npm run lint         # Run ESLint
npm run type-check   # Run TypeScript checks
```

### Component Development
```bash
# Create new component
mkdir src/components/NewComponent
touch src/components/NewComponent/index.tsx
```

### Adding New Pages
```bash
# Add new route
mkdir src/app/new-route
touch src/app/new-route/page.tsx
```

## 🔒 Security

- **API Key Protection**: Environment variable handling
- **Content Security Policy**: XSS protection
- **HTTPS Only**: Secure connections in production
- **Input Validation**: Sanitized user inputs

## 📈 Analytics & Monitoring

- **Error Tracking**: Console error logging
- **Performance Metrics**: Core Web Vitals monitoring
- **User Analytics**: Privacy-focused usage tracking (optional)

## 🚀 Deployment

### Vercel (Recommended)
1. Connect GitHub repository to Vercel
2. Add environment variables in Vercel dashboard
3. Deploy automatically on git push

### Netlify
1. Connect repository to Netlify
2. Set build command: `npm run build`
3. Set publish directory: `out` (if using static export)

### Self-hosted
```bash
npm run build
npm start
# Or export static files
npm run build && npm run export
```

## 🤝 Contributing

1. Fork the repository
2. Create feature branch: `git checkout -b feature/amazing-feature`
3. Commit changes: `git commit -m 'Add amazing feature'`
4. Push to branch: `git push origin feature/amazing-feature`
5. Open Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Original Android Cinema app developers
- TMDB for providing the movie database API
- Next.js team for the amazing framework
- All streaming provider maintainers

## 📞 Support

- **Documentation**: Check this README and inline code comments
- **Issues**: Use GitHub Issues for bug reports
- **Discussions**: Use GitHub Discussions for feature requests

---

**Note**: This is a personal project for educational purposes. Ensure you comply with local laws and streaming service terms of use.
