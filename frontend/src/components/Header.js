import React from 'react';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

export default function Header(props) {
    let { title } = props;
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <div className="container-fluid">
                <div className="navbar-header">
                    <Link className="navbar-brand" to="/">{title}</Link>
                </div>
                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                    <li className="nav-item"><Link className="nav-link active" to="/">Home</Link></li>
                    <li className="nav-item"><Link className="nav-link" to="/about">About Us</Link></li>
                    <li className="nav-item"><Link className="nav-link" to="/contact">Contact</Link></li>
                </ul>
                {/* <ul className="navbar-nav navbar-right">
                    <li className="nav-item"><Link className="nav-link" to="#"> Sign Up</Link></li>
                    <li className="nav-item"><Link className="nav-link" to="#"><span className="glyphicon glyphicon-log-in"></span> Login</Link></li>
                </ul> */}
            </div>
        </nav>
    )
}

Header.defaultProps = {
    title: "Your Title Here",
}

Header.propTypes = {
    title: PropTypes.string,
}
