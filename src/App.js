import "./App.css";
import store from "./redux/store";
import AuthPage from "./pages/AuthPage";
import SearchPage from "./pages/SearchPage";
import MyCourses from "./pages/MyCourses";
import MyCertificates from "./pages/MyCertificates";
import Settings from "./pages/Settings";
import CoursePage from "./pages/CoursePage";
import { Route, Routes, BrowserRouter } from "react-router-dom";
import { Provider } from "react-redux";

const App = () => {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={<AuthPage />} />
          <Route exact path="/search" element={<SearchPage />} />
          <Route exact path="/profile/myCourses" element={<MyCourses />} />
          <Route
            exact
            path="/profile/myCertificates"
            element={<MyCertificates />}
          />
          <Route exact path="/profile/settings" element={<Settings />} />
          <Route exact path="/search/course" element={<CoursePage />} />
        </Routes>
      </BrowserRouter>
    </Provider>
  );
};

export default App;
