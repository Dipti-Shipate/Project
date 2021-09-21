import './App.css';
import LandingPage from './components/LandingPage';
import Header from './components/Header';
import Footer from './components/Footer';
import About from './components/About';
import Contact from './components/Contact';
import Login from './components/Login';
import UserSignUp from './components/UserSignUp';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from 'react-router-dom';

function App() {
  return (
    <>
    <Router>
      <Header title="AskYourDoctor" />
      <Switch>
        <Route exact path="/">
          <LandingPage />   
        </Route>
        <Route exact path="/about">
          <About />
        </Route>
        <Route exact path="/contact">
          <Contact />
        </Route>
        <Route exact path="/user-sign-up">
          <UserSignUp />
        </Route>
        <Route exact path="/login">
          <Login />
        </Route>
      </Switch>
      <Footer />
    </Router>
    </>
  );
}

export default App;
