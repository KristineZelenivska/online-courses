import "./App.css";
import store from "./redux/store";
import AuthPage from "./pages/AuthPage";
import SearchPage from "./pages/SearchPage";
import { Route, Routes, BrowserRouter } from "react-router-dom";
import { Provider } from "react-redux";

const App = () => {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={<AuthPage />} />
          <Route exact path="/search" element={<SearchPage />} />
        </Routes>
      </BrowserRouter>
    </Provider>
  );
};

export default App;
