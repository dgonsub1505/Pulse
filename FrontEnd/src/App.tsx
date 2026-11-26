import Home from "./pages/home/Home";
import Performance from "./components/performance/Performance";
import Processes from "./components/processes/Processes";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/home" element={<Home />}>
          <Route path="performance" element={<Performance />} />
          <Route path="processes" element={<Processes />} />
          <Route index element={<Navigate to="performance" replace />} />
        </Route>
        <Route index element={<Navigate to="/home" replace />} />
        <Route path="*" element={<Navigate to="/home" replace />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
