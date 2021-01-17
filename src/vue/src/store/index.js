import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
export default new Vuex.Store({
  state: {
    token: '',
    userInfo:JSON.parse(sessionStorage.getItem("userInfo")),
    foodList:JSON.parse(sessionStorage.getItem("foodList"))
  },
  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
      localStorage.setItem("Authorization", token)
    },
    SET_USERINFO: (state, userInfo) => {
      state.userInfo = userInfo;
      sessionStorage.setItem("userInfo", JSON.stringify(userInfo))
    },
    REMOVE_INFO: (state) => {
      localStorage.removeItem("Authorization");
      sessionStorage.removeItem("userInfo");
      sessionStorage.removeItem("foodList");
      state.userInfo = {};
      state.foodList = {};
    },
    SET_FOODLIST:(state,foodList) => {
      state.foodList = foodList;
      sessionStorage.setItem("foodList",JSON.stringify(foodList));
    },
  },
  getters: {
    getUser: state => {
      return state.userInfo
    }
  },
  actions: {},
  modules: {}
})
