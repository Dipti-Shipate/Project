import React, { Component } from 'react'

class PatientDashboard extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             patientId: '',
             firstName: ''
        }

        this.loadPatient = this.loadPatient.bind(this);
    }
    
    loadPatient = () => {
        let patient = JSON.parse(localStorage.getItem("user"));
        this.setState({
            patient: patient.userId,
            firstName: patient.userFirstName
        })
    }

    render() {
        this.loadPatient();
        let {patientId,firstName} = this.state;
        return (
            <div>
                This is patient dashboard
                Welcome {firstName} patiendId: {patientId}              
            </div>
        )
    }
}

export default PatientDashboard
