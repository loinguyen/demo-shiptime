import React, { Suspense, lazy } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.js";
import NavBar from "./components/navBar/NavBar";
import Footer from "./components/Footer";
import "./assets/css/style.css";
import "./assets/css/responsive.css";
import "./App.min.css";

const CheckoutView = lazy(() => import("./views/cart/Checkout"));
const NotFoundView = lazy(() => import("./views/pages/404"));
const InternalServerErrorView = lazy(() => import("./views/pages/500"));

function App() {
  return (
    <BrowserRouter>
      <React.Fragment>
        <NavBar />
        <div style={{marginTop: "100px"}}>
        <Suspense
          fallback={
            <div className="text-white text-center mt-3">Loading...</div>
          }
        >
          <Routes>
            <Route exact path="/" element={<CheckoutView/>} />
            <Route exact path="/500" element={<InternalServerErrorView/>} />
            <Route path="*" element={<NotFoundView/>} />
          </Routes>
        </Suspense>
        </div>
        <Footer />
      </React.Fragment>
    </BrowserRouter>
  );
}

export default App;
