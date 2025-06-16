/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
    "./public/index.html"
  ],
  theme: {
    extend: {
      maxWidth: {
        '2xl': '1440px',
      },
      colors: {
        brand: {
          500: '#3B82F6',
          600: '#2563EB',
        },
        gray: {
          100: '#f5f5f5',
          800: '#1f2937',
        },
      },
      fontFamily: {
        sans: ['Inter', 'sans-serif'],
      },
    },
  },
  plugins: [],
};
