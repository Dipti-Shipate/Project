import React, { Component } from 'react'
import APIService from '../service/APIService';

class UserLogin extends Component {

    constructor(props) {
        super(props)

        this.state = {
            email: '',
            password: '',
            message: null
        }

        this.login = this.login.bind(this);
        this.onChange = this.onChange.bind(this);
    }

    login = e => {
        e.preventDefault();
        let user = {
            email: this.state.email,
            password: this.state.password,
        };

        APIService.userLogin(user)
            .then(response => {
                console.log(response.data);
                this.setState({ message: 'Login successful.' });
                console.log(this.state.message);
                localStorage.setItem("user",JSON.stringify(response.data));  
                
            //    this.props.history.push('/patientDashboard');
            })
            .catch(error => {
                console.error("in err ", error.response.data);
                //err.response.data => DTO on the server side : ErrorResponse
                alert(error.response.data.message);
                // this.props.history.push('/userLogin');
            });

    }

    onChange = e => this.setState({ [e.target.name]: e.target.value });

    render() {
        return (
            <>
                <div className="container overflow-hidden">
                    <h2 className="text-muted offset-3 mt-3">User Login</h2>
                    <form>
                        <div className="form-group row mt-3 justify-content-center">
                            <label htmlFor="email" className="col-1 col-form-label">Email</label>
                            <div className="col-5">
                                <input type="email" id="email" className="form-control" name="email" value={this.state.email} onChange={this.onChange} />
                            </div>
                        </div>
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="pwd" className="col-1 col-form-label">Password</label>
                            <div className="col-5">
                                <input type="password" id="pwd" className="form-control" name="password" value={this.state.password} onChange={this.onChange} />
                            </div>
                        </div>
                        <div className="form-group row justify-content-center">
                            <div className="offset-8">
                                <button className="btn btn-lg btn-primary text-uppercase mt-3" onClick={this.login}>Login</button>
                            </div>
                        </div>
                    </form>
                </div>
            </>
        )
    }
}

export default UserLogin

