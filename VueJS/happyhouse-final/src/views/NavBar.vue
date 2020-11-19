<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    
    <router-link to="/" class="navbar-brand"><img src="../assets/ssafyicon.jpg" alt=""></router-link>
    <!--
    <a class="navbar-brand" href="#">Navbar</a>
    -->
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <router-link to="/Home" class="nav-link">Home</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/map" class="nav-link">주택 실거래 검색</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/Board" class="nav-link">공지사항</router-link>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0">
        <input
          v-model="searchWord"
          class="form-control mr-sm-2"
          type="search"
          placeholder="Search"
          aria-label="Search"
        />
        <button @click="search" class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'NavBar',
  data() {
    //  data: function () {
    return {
      searchWord: ""
    };
  },
  methods: {
    search() {
      alert(this.searchWord);
    }
  }
};
</script>

<style>

</style>