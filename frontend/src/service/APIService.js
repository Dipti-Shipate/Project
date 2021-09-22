import axios from 'axios';

const USER_LOGIN_BASE_URL = 'http://localhost:8080/home/login';

class APIService {

    // addPatient(patient){
    //     return axios.post(SERVER_SIDE_URL + "/patient/sign-up", patient);
    // }

    userLogin(user){
        return axios.post(USER_LOGIN_BASE_URL,user);
    }

    // doctorLogin(doctor){
    //     return axios.post(SERVER_SIDE_URL + "/doctor/login")
    // }
}

export default new APIService();