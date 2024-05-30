import { Outlet } from "react-router-dom";
import { LanguageSelector } from "./shared/components/LanguageSelector"; 
import { useTranslation } from "react-i18next";
import { Navbar } from "./shared/components/Navbar";

function App() {
  const { t } = useTranslation();
  return (
    <>
      <Navbar></Navbar>
      <div className="container mt-3">
      <Outlet />
      <LanguageSelector></LanguageSelector>
      </div>
    </>
  );
}

export default App;
