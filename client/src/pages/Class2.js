import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

const Class2 = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/students/std/2');
        if (!response.ok) {
          throw new Error('network');
        }
        const data = await response.json();
        setStudents(data);
      } catch (err) {
        console.log('Error fetching data: ', err);
      }
    };
    fetchData();
  }, []);

  return (
    <div className="container mx-auto px-4 py-6 bg-gray-800">
      <h2 className="text-2xl font-bold mb-4 text-center text-white">Student List</h2>
      <table className="min-w-full bg-blue-900 shadow-md rounded-lg">
        <thead>
          <tr>
            <th className="py-2 px-4 border-b-2 border-gray-600 text-left text-white">ID</th>
            <th className="py-2 px-4 border-b-2 border-gray-600 text-left text-white">Name</th>
            <th className="py-2 px-4 border-b-2 border-gray-600 text-left text-white">Standard</th>
            <th className="py-2 px-4 border-b-2 border-gray-600 text-left text-white">Gender</th>
            <th className="py-2 px-4 border-b-2 border-gray-600 text-left text-white">Date of Birth</th>
            <th className="py-2 px-4 border-b-2 border-gray-600 text-left text-white">Actions</th>
          </tr>
        </thead>
        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td className="py-2 px-4 border-b border-gray-600 text-left text-white">{student.id}</td>
              <td className="py-2 px-4 border-b border-gray-600 text-left text-white">{student.name}</td>
              <td className="py-2 px-4 border-b border-gray-600 text-left text-white">{student.std}</td>
              <td className="py-2 px-4 border-b border-gray-600 text-left text-white">{student.gender}</td>
              <td className="py-2 px-4 border-b border-gray-600 text-left text-white">{student.dob}</td>
              <td className="py-2 px-4 border-b border-gray-600 text-left text-white">
                <Link to="/test" className="bg-green-500 hover:bg-green-600 text-white font-bold py-2 px-4 rounded">
                  View Assessment
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <div className="flex justify-center">
        <button className="mt-4 bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded">
          Add Student
        </button>
      </div>
    </div>
  );
};

export default Class2;