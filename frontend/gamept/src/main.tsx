import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { RouterProvider, createBrowserRouter } from 'react-router-dom'
import CreateGamePage from './pages/CreateGamePage.tsx';
import SinglePlay from './pages/SinglePlay.tsx'; // 새로 만든 페이지 컴포넌트를 불러옵니다.


// 라우팅 경로 지정
const router = createBrowserRouter([
  { path: '/', element: <App /> },
  { path: '/createGame', element: <CreateGamePage /> },
  { path: '/singleplay', element: <SinglePlay /> }, // 새로운 경로 추가

])

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
