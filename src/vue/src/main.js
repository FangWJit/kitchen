import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"
import request from "./http"
import moment from 'moment'
import vHeader from './components/head/Header'

Vue.prototype.$request = request
Vue.prototype.$moment = moment
Vue.prototype.$store = store
Vue.use(Element)
Vue.config.productionTip = false
Vue.component('vHeader',vHeader)

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
