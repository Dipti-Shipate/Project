import React, { Component } from 'react'

class Login extends Component {
    render() {
        return (
            <>
                <div className="container overflow-hidden">
                    <h2 className="text-muted offset-3 mt-3">User Login</h2>
                    <form>
                        <div className="form-group row mt-3 justify-content-center">
                            <label htmlFor="email" className="col-1 col-form-label">Email</label>
                            <div className="col-5">
                                <input type="email" id="email" className="form-control" placeholder="abc@xyz.com" />
                            </div>
                        </div>
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="pwd" className="col-1 col-form-label">Password</label>
                            <div className="col-5">
                                <input type="password" id="pwd" className="form-control" placeholder="Enter Password" />
                            </div>
                        </div>
                        <div className="form-group row justify-content-center">
                            <div className="offset-8">
                                <button className="btn btn-lg btn-primary text-uppercase mt-3">Login</button>
                            </div>
                        </div>
                    </form>
                </div>
            </>
        )
    }
}

export default Login

