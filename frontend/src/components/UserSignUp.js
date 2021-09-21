import React from 'react'

const UserSignUp = () => {
    return (
        <>
            <div className="container overflow-hidden" style={{ minHeight: "100vh" }}>
                <h2 className="text-muted offset-3 mt-3">User Registration</h2>
                <form>
                    <div className="form-group row mt-3 justify-content-center">
                        <label htmlFor="username" className="col-2 col-form-label">Username</label>
                        <div className="col-5">
                            <input type="text" id="username" className="form-control" placeholder="Enter a unique username" />
                        </div>
                    </div>
                    <div className="form-group row my-3 justify-content-center">
                        <label htmlFor="firstname" className="col-2 col-form-label">First Name</label>
                        <div className="col-5">
                            <input type="text" id="firstname" className="form-control" placeholder="Enter your first name" />
                        </div>
                    </div>
                    <div className="form-group row my-3 justify-content-center">
                        <label htmlFor="lastname" className="col-2 col-form-label">Last Name</label>
                        <div className="col-5">
                            <input type="text" id="lastname" className="form-control" placeholder="Enter your last name" />
                        </div>
                    </div>
                    <div className="form-group row my-3 justify-content-center">
                        <label htmlFor="email" className="col-2 col-form-label">Email</label>
                        <div className="col-5">
                            <input type="email" id="email" className="form-control" placeholder="e.g. abc@xyz.com" />
                        </div>
                    </div>
                    <div className="form-group row my-3 justify-content-center">
                        <label htmlFor="pwd" className="col-2 col-form-label">Password</label>
                        <div className="col-5">
                            <input type="password" id="pwd" className="form-control" placeholder="Enter Password" />
                        </div>
                    </div>
                    <div className="form-group row my-3 justify-content-center">
                        <label htmlFor="dob" className="col-2 col-form-label">Date of Birth</label>
                        <div className="col-5">
                            <input type="date" id="dob" className="form-control" />
                        </div>
                    </div>
                    <div className="form-group row my-3 justify-content-center">
                        <label className="col-2 col-form-label">Gender</label>
                        <div className="col-5 d-flex justify-content-between">
                            <div><input type="radio" id="gender" name="gender" /> Male</div>
                            <div><input type="radio" id="gender" name="gender" /> Female</div>
                            <div><input type="radio" id="gender" name="gender" /> Other</div>
                        </div>
                    </div>
                    <div className="form-group row my-3 justify-content-center">
                        <label htmlFor="mob" className="col-2 col-form-label">Mobile</label>
                        <div className="col-5">
                            <input type="text" id="mob" className="form-control" placeholder="Enter your mobile number" pattern="[0-9]{10}" />
                        </div>
                    </div>
                    <div className="form-group row justify-content-center">
                        <div className="offset-9">
                            <button className="btn btn-lg btn-primary text-uppercase mt-3 mb-5">Sign Up</button>
                        </div>
                    </div>
                </form>
            </div>
        </>
    )
}

export default UserSignUp
