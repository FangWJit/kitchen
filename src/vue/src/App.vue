<template>
  <div id="app">
    <router-view/>
    <template>
    <el-backtop target="#app" :bottom="100" style="background-color: #e7e3e3;color:#FFFFFF;" >
      <img src="./static/image/厨阁.png" />
    </el-backtop>
    </template>
  </div>
</template>
<script>
  export default{
    data (){
      return {
        username:''
      }
    },
    mounted() {
      window.addEventListener('hashchange', () => {
        let currentPath = window.location.hash.slice(1)
        if (this.$route.path !== currentPath) {
          this.$router.push(currentPath)
        }
      }, false)
    },
    methods:{

    }
  }
</script>

<style>
  @import url("./static/css/css_index.css");
  #app {
    height: 100%;
    overflow: auto;
  }

  body,html {
    height: 100%;
  }


</style>
