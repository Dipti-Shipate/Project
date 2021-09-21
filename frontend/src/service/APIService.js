import axios from 'axios';

const SERVER_SIDE_URL = 'http://localhost:8080';

class APIService {

    addPatient(user){
        return axios.post(SERVER_SIDE_URL + "/patient-sign-up", user);
    }
}

export default new APIService();