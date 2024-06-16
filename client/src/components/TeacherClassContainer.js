import React from 'react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate from React Router

const TeacherClassContainer = ({ std }) => {
  const navigate = useNavigate(); // Initialize the useNavigate hook

  const handleClick = () => {
    navigate(`/class${std}`);
  };

  return (
    <div className="flex justify-center items-center flex-grow p-4">
      <div 
        className="flex justify-center items-center w-56 h-56 cursor-pointer" // Added cursor-pointer for better UX
        onClick={handleClick}
      >
        <button 
          className="bg-cover bg-center bg-no-repeat bg-gray-500 text-white font-bold rounded-lg w-full h-full hover:bg-gray-700 transform hover:scale-105 transition-transform duration-300 relative"
          style={{ backgroundImage: "url('/img.png')" }}
        >
          <div className="absolute bottom-0 left-0 right-0 bg-black bg-opacity-50 p-2">
            Kaksha-{std}
          </div>
        </button>
      </div>
    </div>
  );
};

export default TeacherClassContainer;