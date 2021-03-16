import axios from 'axios'

const request = axios.create({baseURL:'http://127.0.0.1:8045/kitchen'})
// const request = axios.create({baseURL:'http://39.99.240.33:8045/kitchen'})

// 添加请求拦截器，在请求头中加token
request.interceptors.request.use(
    config => {
        if (localStorage.getItem('Authorization')) {
            // config.headers.
            config.headers.Authorization = localStorage.getItem('Authorization');
        }
        return config;
    },
    error => {
        return Promise.reject(error);
    });


export default request