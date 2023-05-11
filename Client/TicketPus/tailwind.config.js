/** @type {import('tailwindcss').Config} */

export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    colors: {
      'grissoft': '#2B2B2B',
      'white': 'white'
    },
    fontFamily: {
      'lilita': "lilita"
    },


    extend: {
      backgroundImage: {
        'backgroundicons': "url('../src/assets/background.jpg')",
      },
      maxWidth: {
        '1/5': '20%',
      }


    },

  },
  plugins: [],
}