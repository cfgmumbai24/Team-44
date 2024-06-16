import React from 'react';
import TeacherClassContainer from '../components/TeacherClassContainer';

const TeacherDash = ({std}) => {
  const classes = [1, 2, 3];

  return (
    <div className="flex flex-col min-h-screen  items-center justify-center bg-gray-600">
      {/* Navigation Bar */}
      <nav className="bg-gray-800 w-full">
        <div className="max-w-6xl mx-auto px-4 py-4 flex justify-center">
          <div className="text-white text-xl font-bold">EDUMATE</div>
        </div>
      </nav>

      {/* Main Content */}

      <section id="teachers" className=" flex-1 w-full max-w-6xl px-4 sm:px-6 lg:px-8 py-8">
        <h2 className="text-3xl font-bold text-gray-100 mb-8 text-center">Classes</h2>
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-8">
          {classes.map((std) => (
            <div key={std} className="bg-gray-400 rounded-lg shadow-lg overflow-hidden">
              <div className="p-4">
                <TeacherClassContainer std={std} />
              </div>
            </div>
          ))}
        </div>
      </section>


      {/* Footer */}
      <footer className="bg-gray-800 text-gray-300 py-4 w-full">
        <div className="max-w-6xl mx-auto px-4">
          <div className="flex justify-center">
            <div>©️ 2024 EDUMATE. All rights reserved.</div>
          </div>
        </div>
      </footer>
    </div>
  );
};

export default TeacherDash;