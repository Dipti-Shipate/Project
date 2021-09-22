import './App.css';
import LandingPage from './components/LandingPage';
import Header from './components/Header';
import Footer from './components/Footer';
import About from './components/About';
import Contact from './components/Contact';
import Login from './components/Login';
import PatientSignUp from './components/PatientSignUp';
import PatientDashboard from './components/PatientDashboard';
import AdminDashboard from './components/AdminDashboard';
import DoctorDashboard from './components/DoctorDashboard';
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
        <Route exact path="/patient-sign-up">
          <PatientSignUp />
        </Route>
        <Route exact path="/login">
          <Login />
        </Route>
        <Route exact path="/patient-dashboard">
          <PatientDashboard />
        </Route>
        <Route exact path="/admin-dashboard">
          <AdminDashboard />
        </Route>
        <Route exact path="/doctor-dashboard">
          <DoctorDashboard />
        </Route>
      </Switch>
      <Footer />
    </Router>
    </>
  );
}

export default App;
