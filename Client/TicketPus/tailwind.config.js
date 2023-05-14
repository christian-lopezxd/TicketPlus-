/** @type {import('tailwindcss').Config} */

export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    colors: {
      'grissoft': '#2B2B2B',
      'white': 'white',
      'softblack' : '#131313',
      'newpink' : '#FC5C65',
      'newblue' : '#4064E3',
      'darkblue' : '#19376D',
      'darkwhite' : '#86868B',
    },
    fontFamily: {
      'lilita': "lilita",
      'montserrat': "montserrat"
    },
    screens: {
      '2xl': {'max': '1535px'},
      // => @media (max-width: 1535px) { ... }

      'xl': {'max': '1279px'},
      // => @media (max-width: 1279px) { ... }

      'sm': {'max': '1023px'},
      // => @media (max-width: 767px) { ... }

      'md': {'max': '639px'},
      // => @media (max-width: 639px) { ... }
    },


    extend: {
      backgroundImage: {
        'backgroundicons': "url('../src/assets/background.jpg')",
      },
      maxWidth: {
        '1/5': '20%',
        '1/3': '25%',
        '1/2' : '50%',
        '4/5' : "80vh",

      }


    },

  },
  plugins: [],
}