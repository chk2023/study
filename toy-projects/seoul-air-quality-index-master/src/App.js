import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Layout from "./layouts/Layout";
import Main from "./pages/Main";
import LocalAirQualityIndex from "./pages/LocalAirQualityIndex";
import WeeklyAirQualityIndex from "./pages/WeeklyAirQualityIndex";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout/>}>
            <Route index element={<Main/>}/>
              <Route path="localAirQuality">
                  <Route index element={<LocalAirQualityIndex/>}/>
                  </Route>
              <Route path="weeklyAirQuality">
                  <Route index element={<WeeklyAirQualityIndex/>}/>
              </Route>
          </Route>
        </Routes>
      </BrowserRouter>
  );
}

export default App;