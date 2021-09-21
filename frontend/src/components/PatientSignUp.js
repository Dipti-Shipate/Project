import React, { Component } from 'react';
import APIService from '../service/APIService';

class PatientSignUp extends Component {

    constructor(props) {
        super(props);

        this.state = {
            userName: '',
            firstName: '',
            lastName: '',
            email: '',
            password: '',
            dob: '',
            gender: '',
            mobileNo: '',
            message: null
        };

        this.signUp = this.signUp.bind(this);
    }

    signUp = e => {
        e.preventDefault();
        let patient = {
            userName: this.state.userName,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email,
            password: this.state.password,
            dob: this.state.dob,
            gender: this.state.gender,
            mobileNo: this.state.mobileNo
        };

        APIService.addPatient(patient)
            .then(resp => {
                console.log(resp.data); //actual response data sent by back end
                this.setState({ message: 'User added successfully.' });
                console.log(this.state.message);
                this.props.history.push('/user-dashboard');
            }).catch(err => {
                console.error("in err ", err.response.data);
                //err.response.data => DTO on the server side : ErrorResponse
                alert(err.response.data.message);
                this.props.history.push('/patient-sign-up');
            });
    }

    onChange = e =>
        this.setState({ [e.target.name]: e.target.value });

    render() {
        return (
            <>
                <div className="container overflow-hidden" style={{ minHeight: "100vh" }}>
                    <h2 className="text-muted offset-3 mt-3">User Registration</h2>
                    <form>
                        <div className="form-group row mt-3 justify-content-center">
                            <label htmlFor="userName" className="col-2 col-form-label">Username</label>
                            <div className="col-5">
                                <input type="text" id="userName" className="form-control" placeholder="Enter a unique username" name="userName" value={this.state.userName} onChange={this.onChange} />
                            </div>
                        </div>
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="firstName" className="col-2 col-form-label">First Name</label>
                            <div className="col-5">
                                <input type="text" id="firstName" className="form-control" placeholder="Enter your first name" name="firstName" value={this.state.firstName} onChange={this.onChange} />
                            </div>
                        </div>
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="lastName" className="col-2 col-form-label">Last Name</label>
                            <div className="col-5">
                                <input type="text" id="lastName" className="form-control" placeholder="Enter your last name" name="lastName" value={this.state.lastName} onChange={this.onChange} />
                            </div>
                        </div>
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="email" className="col-2 col-form-label">Email</label>
                            <div className="col-5">
                                <input type="email" id="email" className="form-control" placeholder="e.g. abc@xyz.com" name="email" value={this.state.email} onChange={this.onChange} />
                            </div>
                        </div>
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="pwd" className="col-2 col-form-label">Password</label>
                            <div className="col-5">
                                <input type="password" id="pwd" className="form-control" placeholder="Enter Password" name="password" value={this.state.password} onChange={this.onChange} />
                            </div>
                        </div>
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="dob" className="col-2 col-form-label">Date of Birth</label>
                            <div className="col-5">
                                <input type="date" id="dob" className="form-control" name="dob" value={this.state.dob} onChange={this.onChange} />
                            </div>
                        </div>
                        <div className="form-group row my-3 justify-content-center">
                            <label className="col-2 col-form-label">Gender</label>
                            <div className="col-5 d-flex justify-content-between">
                                <div><input type="radio" id="gender" name="gender" value="Male" onChange={this.onChange}/> Male</div>
                                <div><input type="radio" id="gender" name="gender" value="Female" onChange={this.onChange} /> Female</div>
                                <div><input type="radio" id="gender" name="gender" value="Other" onChange={this.onChange} /> Other</div>
                            </div>
                        </div>
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="mobileNo" className="col-2 col-form-label">Mobile</label>
                            <div className="col-5">
                                <input type="text" id="mobileNo" className="form-control" placeholder="Enter your mobile number" name="mobileNo" value={this.state.mobileNo} onChange={this.onChange} pattern="[0-9]{10}" />
                            </div>
                        </div>
                        <div className="form-group row justify-content-center">
                            <div className="offset-9">
                                <button className="btn btn-lg btn-primary text-uppercase mt-3 mb-5" onClick={this.signUp}>Sign Up</button>
                            </div>
                        </div>
                    </form>
                </div>
            </>
        )
    }
}

export default PatientSignUp

