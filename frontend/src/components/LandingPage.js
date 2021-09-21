import React from 'react';
import './LandingPage.css';
import { Link } from 'react-router-dom';

// const toLogin = () => {
//     return <Link to="/login">Login</Link>
// }

const LandingPage = () => {
    return (
        <>
            <div className="container-fluid">
                <div id="carouselExampleCaptions" className="carousel slide" data-bs-ride="carousel">
                    <div className="carousel-inner">
                        <div className="carousel-item active">
                            <video className="videoStyle" autoPlay muted loop>
                                <source src="assets/doctor_appointment.mp4" type="video/mp4" />
                            </video>
                            <div className="middleLayer bg-1"></div>
                            <div className="d-flex flex-column justify-content-center align-items-center w-100 h-100 position-fixed slideContent">
                                <h4 className="text-light font-weight-bolder text-uppercase">Book Appointments</h4>
                                <div className="container w-50">
                                    <p className="display-6 text-light text-center">Book appoints on the go with best specialist doctors in your city.</p>
                                </div>
                                <div>
                                    <Link className="btn btn-link btn-lg btn-outline-light button1 text-uppercase text-decoration-none mx-3" to="/user-sign-up">Sign Up</Link>
                                    <Link className="btn btn-link btn-lg btn-light button2 text-dark text-uppercase text-decoration-none mx-3" to="/login">Login</Link>
                                </div>
                            </div>
                        </div>
                        <div className="carousel-item">
                            <video className="videoStyle" autoPlay muted loop>
                                <source src="assets/lab_test.mp4" type="video/mp4" />
                            </video>
                            <div className="middleLayer bg-2"></div>
                            <div className="d-flex flex-column justify-content-center align-items-center w-100 h-100 position-fixed slideContent">
                                <h4 className="text-light font-weight-bolder text-uppercase">Book Lab Tests</h4>
                                <div className="container w-50">
                                    <p className="display-6 text-light text-center">Book your required lab test at the pathology of your choice in your city.</p>
                                </div>
                                <div>
                                    <Link className="btn btn-link btn-lg btn-outline-light button1 text-light text-uppercase text-decoration-none mx-3" to="/user-sign-up">Sign Up</Link>
                                    <Link className="btn btn-link btn-lg btn-light button2 text-dark text-uppercase text-decoration-none mx-3" to="/login">Login</Link>
                                </div>
                            </div>
                        </div>
                        <div className="carousel-item">
                            <video className="videoStyle" autoPlay muted loop>
                                <source src="assets/blood_donation.mp4" type="video/mp4" />
                            </video>
                            <div className="middleLayer bg-3"></div>
                            <div className="d-flex flex-column justify-content-center align-items-center w-100 h-100 position-fixed slideContent">
                                <h4 className="text-light font-weight-bolder text-uppercase">Be a Blood Donor</h4>
                                <div className="container w-50">
                                    <p className="display-6 text-light text-center">Get information about blood donation centres and donate blood at time and place of your choice.</p>
                                </div>
                                <div>
                                    <Link className="btn btn-link btn-lg btn-outline-light button1 text-light text-uppercase text-decoration-none mx-3" to="/user-sign-up">Sign Up</Link>
                                    <Link className="btn btn-link btn-lg btn-light button2 text-dark text-uppercase text-decoration-none mx-3" to="/login">Login</Link>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button className="carousel-control-prev prevButtonPosition" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Previous</span>
                    </button>
                    <button className="carousel-control-next nextButtonPosition" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                        <span className="carousel-control-next-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </>
    )
}

export default LandingPage
