import { useTranslation } from "react-i18next"
import { Link } from "react-router-dom";
import logo from "../../assets/joke.png"

export function Navbar(){
    const { t } = useTranslation();
    return (
        <nav className="navbar navbar-expand bg-body-tertiary shadow-sm">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">
            <img src={logo} width={60}></img>
           Joke
          </Link>
          <ul className="navbar-nav">
            <li className="nav-item">
              <Link className="nav-link" to="/signup">{t('signUp')}</Link>
            </li>
          </ul>
        </div>
      </nav>
    )
}