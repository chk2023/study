import './style.css';
import 'react-toastify/dist/ReactToastify.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Layout from "./layouts/Layout";
import Main from "./pages/products/Main";
import CategoryMain from "./pages/products/CategoryMain";
import SearchMain from "./pages/products/SearchMain";
import ProductDetail from "./pages/products/ProductDetail";
import Signup from "./pages/member/Signup";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={ <Layout/> }>
            <Route index element={<Main/>}/>
            <Route path="product">
                <Route path="categories/:categoryCode" element={ <CategoryMain/> }/>
                <Route path="search" element={ <SearchMain/> }/>
                <Route path=":productCode" element={<ProductDetail/>}/>
            </Route>
        </Route>
          <Route path="/member">
              <Route path="signup" element={<Signup/>}>
              </Route>
          </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
