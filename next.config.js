/** @type {import('next').NextConfig} */
const nextConfig = {
  images: {
    domains: [
      'image.tmdb.org',
      'img.yts.mx',
      'i.imgur.com',
      'fanart.tv',
      'assets.fanart.tv',
      'artworks.thetvdb.com',
      'static.tvmaze.com',
      'm.media-amazon.com',
      'ia.media-imdb.com'
    ],
  },
  async headers() {
    return [
      {
        source: '/api/:path*',
        headers: [
          { key: 'Access-Control-Allow-Origin', value: '*' },
          { key: 'Access-Control-Allow-Methods', value: 'GET, POST, PUT, DELETE, OPTIONS' },
          { key: 'Access-Control-Allow-Headers', value: 'Content-Type, Authorization' },
        ],
      },
    ]
  },
  async rewrites() {
    return [
      {
        source: '/api/proxy/:path*',
        destination: '/:path*',
      },
    ]
  },
}

module.exports = nextConfig
