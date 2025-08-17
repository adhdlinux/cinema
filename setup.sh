#!/bin/bash

# Cinema Web App Setup Script
echo "🎬 Setting up Cinema Web App..."

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Check if Node.js is installed
if ! command -v node &> /dev/null; then
    echo -e "${RED}❌ Node.js is not installed. Please install Node.js 18+ and try again.${NC}"
    exit 1
fi

# Check Node.js version
NODE_VERSION=$(node -v | cut -d'v' -f2 | cut -d'.' -f1)
if [ "$NODE_VERSION" -lt 18 ]; then
    echo -e "${RED}❌ Node.js version 18+ required. Current version: $(node -v)${NC}"
    exit 1
fi

echo -e "${GREEN}✅ Node.js $(node -v) detected${NC}"

# Check if npm is available
if ! command -v npm &> /dev/null; then
    echo -e "${RED}❌ npm is not available${NC}"
    exit 1
fi

# Install dependencies
echo -e "${BLUE}📦 Installing dependencies...${NC}"
npm install

if [ $? -ne 0 ]; then
    echo -e "${RED}❌ Failed to install dependencies${NC}"
    exit 1
fi

echo -e "${GREEN}✅ Dependencies installed successfully${NC}"

# Check for TMDB API key
echo -e "${YELLOW}🔑 TMDB API Key Configuration${NC}"

if [ ! -f "api.txt" ] || [ "$(cat api.txt)" = "your_tmdb_api_key_here" ]; then
    echo -e "${YELLOW}⚠️  TMDB API key not configured${NC}"
    echo ""
    echo "To get your free TMDB API key:"
    echo "1. Go to https://www.themoviedb.org/settings/api"
    echo "2. Create an account if you don't have one"
    echo "3. Request an API key (v3 auth)"
    echo "4. Copy your API key"
    echo ""
    read -p "Enter your TMDB API key (or press Enter to skip): " api_key
    
    if [ ! -z "$api_key" ]; then
        echo "$api_key" > api.txt
        echo -e "${GREEN}✅ API key saved to api.txt${NC}"
    else
        echo -e "${YELLOW}⚠️  You can add your API key later to api.txt${NC}"
    fi
else
    echo -e "${GREEN}✅ TMDB API key found in api.txt${NC}"
fi

# Create placeholder images directory
mkdir -p public
echo -e "${BLUE}📁 Created public directory for assets${NC}"

# Build the application to check for errors
echo -e "${BLUE}🔨 Building application...${NC}"
npm run build

if [ $? -ne 0 ]; then
    echo -e "${RED}❌ Build failed. Please check the errors above.${NC}"
    exit 1
fi

echo -e "${GREEN}✅ Build successful${NC}"

# Setup complete
echo ""
echo -e "${GREEN}🎉 Setup completed successfully!${NC}"
echo ""
echo "To start the development server:"
echo -e "${BLUE}  npm run dev${NC}"
echo ""
echo "To start the production server:"
echo -e "${BLUE}  npm run start${NC}"
echo ""
echo "The application will be available at:"
echo -e "${BLUE}  http://localhost:3000${NC}"
echo ""
echo "For more information, check the README.md file"
echo ""

# Check if TMDB API key is configured
if [ ! -f "api.txt" ] || [ "$(cat api.txt)" = "your_tmdb_api_key_here" ]; then
    echo -e "${YELLOW}⚠️  Remember to configure your TMDB API key in api.txt before starting!${NC}"
fi
