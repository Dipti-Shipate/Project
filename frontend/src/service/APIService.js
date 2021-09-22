import axios from 'axios';

const SERVER_SIDE_URL = 'http://localhost:8080';

class APIService {

    addPatient(patient){
        return axios.post(SERVER_SIDE_URL + "/patient/sign-up", patient);
    }

    userLogin(){
        
    }
}

export default new APIService();