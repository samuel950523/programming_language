<template id="test">
    
  <!--  <v-container id="test">
        <v-layout style= "background-color :#FFFCD2">
            <v-flex xs12="xs12"  >
               <Home/>
              <Header/> 
            </v-flex>
        </v-layout>
    </v-container>
-->

  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </div>
    <router-view />
  </div>


</template>

<script>
    import Home from "./components/Home.vue"
    import Header from "./components/Header.vue"
    import Parallex from "./components/Parallax.vue";
    export default {
        components: {
            Home,
            Header,
            Parallex
        }
    }
</script>

<style>
  #test {
       background-color: "#FFFCD2";
    }
</style>